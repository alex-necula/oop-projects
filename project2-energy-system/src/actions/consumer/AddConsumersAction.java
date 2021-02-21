package actions.consumer;

import actions.AbstractUpdateAction;
import entities.Consumer;
import fileio.Database;
import observers.BankruptcyRemover;
import updates.MonthlyUpdate;

import java.util.List;

public final class AddConsumersAction extends AbstractUpdateAction {
    private final Database allEntities;

    public AddConsumersAction(final Database allEntities,
                              final Database activeEntities,
                              final MonthlyUpdate monthlyUpdate) {
        super(activeEntities, monthlyUpdate);
        this.allEntities = allEntities;
    }

    @Override
    public void run() {
        List<Consumer> newConsumers = getMonthlyUpdate().getNewConsumers();

        BankruptcyRemover bankruptcyRemover = new BankruptcyRemover(getActiveEntities());
        for (var consumer : newConsumers) {
            consumer.addPropertyChangeListener(bankruptcyRemover);
        }

        allEntities.getConsumers().addAll(newConsumers);
        getActiveEntities().getConsumers().addAll(newConsumers);
    }
}
