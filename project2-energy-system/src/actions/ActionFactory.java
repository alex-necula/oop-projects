package actions;

import actions.consumer.AddConsumersAction;
import actions.consumer.ChooseContractsAction;
import actions.consumer.PayContractsAction;
import actions.consumer.ReceiveSalaryAction;
import actions.distributor.ChooseProducersAction;
import actions.distributor.ComputeContractPricesAction;
import actions.distributor.ComputeProductionCostAction;
import actions.distributor.PayExpensesAction;
import actions.distributor.RemoveExpiredContracts;
import actions.distributor.UpdateContractsAction;
import actions.distributor.UpdateDistributorsAction;
import actions.producer.CreateMonthlyStatAction;
import actions.producer.UpdateProducersAction;
import fileio.Database;
import updates.MonthlyUpdate;

public final class ActionFactory {
    private static final ActionFactory INSTANCE = new ActionFactory();

    private ActionFactory() {
    }

    public static ActionFactory getInstance() {
        return INSTANCE;
    }

    /**
     * @param actionType     from defined enum
     * @param allEntities    database of all entities
     * @param activeEntities database of non-bankrupt entities
     * @param monthlyUpdate  updates for database
     * @param currentMonth   of the simulation
     * @return a runnable action according to actionType
     */
    public Runnable createAction(final ActionType actionType,
                                 final Database allEntities,
                                 final Database activeEntities,
                                 final MonthlyUpdate monthlyUpdate,
                                 final int currentMonth) {
        switch (actionType) {
            case ADD_CONSUMERS -> {
                return new AddConsumersAction(allEntities, activeEntities, monthlyUpdate);
            }
            case UPDATE_DISTRIBUTORS -> {
                return new UpdateDistributorsAction(activeEntities, monthlyUpdate);
            }
            case UPDATE_PRODUCERS -> {
                return new UpdateProducersAction(activeEntities, monthlyUpdate);
            }
            case RECEIVE_SALARY -> {
                return new ReceiveSalaryAction(activeEntities);
            }
            case CHOOSE_PRODUCERS -> {
                return new ChooseProducersAction(activeEntities);
            }
            case COMPUTE_PRODUCTION_COST -> {
                return new ComputeProductionCostAction(activeEntities);
            }
            case COMPUTE_CONTRACT_PRICES -> {
                return new ComputeContractPricesAction(activeEntities);
            }
            case REMOVE_EXPIRED_CONTRACTS -> {
                return new RemoveExpiredContracts(activeEntities);
            }
            case CHOOSE_CONTRACTS -> {
                return new ChooseContractsAction(activeEntities);
            }
            case PAY_CONTRACTS -> {
                return new PayContractsAction(activeEntities);
            }
            case PAY_EXPENSES -> {
                return new PayExpensesAction(activeEntities);
            }
            case UPDATE_CONTRACTS -> {
                return new UpdateContractsAction(activeEntities);
            }
            case CREATE_MONTHLY_STAT -> {
                return new CreateMonthlyStatAction(activeEntities, currentMonth);
            }
            default -> throw new IllegalStateException("Unexpected value: " + actionType);
        }
    }
}
