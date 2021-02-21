import actions.ActionExecutor;
import actions.ActionFactory;
import actions.ActionType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import fileio.Database;
import fileio.Input;
import observers.BankruptcyRemover;
import observers.ProducerUpdateObserver;
import updates.MonthlyUpdate;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Entry point to the simulation
 */
public final class Main {

    private Main() {
    }

    private static List<Runnable> createActions(final List<ActionType> actionTypes,
                                                final Database allEntities,
                                                final Database activeEntities,
                                                final MonthlyUpdate monthlyUpdate,
                                                final int currentMonth) {
        List<Runnable> actions = new ArrayList<>();
        ActionFactory actionFactory = ActionFactory.getInstance();
        for (var actionType : actionTypes) {
            actions.add(actionFactory.createAction(actionType, allEntities, activeEntities,
                    monthlyUpdate, currentMonth));
        }
        return actions;
    }

    private static void runActions(final List<Runnable> actions) {
        ActionExecutor actionExecutor = ActionExecutor.getInstance();
        for (var action : actions) {
            actionExecutor.executeAction(Objects.requireNonNull(action));
        }
    }

    private static void addObserver(final Database activeEntities) {
        BankruptcyRemover bankruptcyRemover = new BankruptcyRemover(activeEntities);
        ProducerUpdateObserver producerUpdateObserver = new ProducerUpdateObserver();
        for (var consumer : activeEntities.getConsumers()) {
            consumer.addPropertyChangeListener(bankruptcyRemover);
        }
        for (var distributor : activeEntities.getDistributors()) {
            distributor.addPropertyChangeListener(bankruptcyRemover);
        }
        for (var producer : activeEntities.getProducers()) {
            producer.addPropertyChangeListener(producerUpdateObserver);
        }
    }

    /**
     * Main function which reads the input file and starts simulation
     *
     * @param args input and output files
     * @throws Exception might error when reading/writing/opening files, parsing JSON
     */
    public static void main(final String[] args) throws Exception {
        Path inputPath = Path.of(args[0]);
        String inputJSON = Files.readString(inputPath);

        // Read input
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        Input input = objectMapper.readValue(inputJSON, Input.class);

        Database allEntities = input.getDatabase();
        Database activeEntities = new Database(input.getDatabase());
        addObserver(activeEntities);

        List<ActionType> initialRoundActionTypes = new ArrayList<>();
        initialRoundActionTypes.add(ActionType.RECEIVE_SALARY);
        initialRoundActionTypes.add(ActionType.CHOOSE_PRODUCERS);
        initialRoundActionTypes.add(ActionType.COMPUTE_PRODUCTION_COST);
        initialRoundActionTypes.add(ActionType.COMPUTE_CONTRACT_PRICES);
        initialRoundActionTypes.add(ActionType.REMOVE_EXPIRED_CONTRACTS);
        initialRoundActionTypes.add(ActionType.CHOOSE_CONTRACTS);
        initialRoundActionTypes.add(ActionType.PAY_CONTRACTS);
        initialRoundActionTypes.add(ActionType.PAY_EXPENSES);
        initialRoundActionTypes.add(ActionType.UPDATE_CONTRACTS);

        runActions(createActions(initialRoundActionTypes,
                null, activeEntities, null, 0));

        for (int i = 0; i < input.getNumberOfTurns(); i++) {
            List<ActionType> monthlyActionTypes = new ArrayList<>();

            monthlyActionTypes.add(ActionType.ADD_CONSUMERS);
            monthlyActionTypes.add(ActionType.UPDATE_DISTRIBUTORS);
            initialRoundActionTypes.remove(ActionType.CHOOSE_PRODUCERS);
            monthlyActionTypes.addAll(initialRoundActionTypes);
            monthlyActionTypes.add(ActionType.UPDATE_PRODUCERS);
            monthlyActionTypes.add(ActionType.CHOOSE_PRODUCERS);
            monthlyActionTypes.add(ActionType.CREATE_MONTHLY_STAT);

            runActions(createActions(monthlyActionTypes, allEntities, activeEntities,
                    input.getMonthlyUpdates().get(i), i + 1));

            if (activeEntities.getDistributors().isEmpty()) {
                break;
            }
        }

        // Write output
        objectMapper.writeValue(new File(args[1]), allEntities);
    }
}
