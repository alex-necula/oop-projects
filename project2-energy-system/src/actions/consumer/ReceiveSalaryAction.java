package actions.consumer;

import actions.AbstractAction;
import fileio.Database;

public final class ReceiveSalaryAction extends AbstractAction {

    public ReceiveSalaryAction(final Database activeEntities) {
        super(activeEntities);
    }

    @Override
    public void run() {
        for (var consumer : getActiveEntities().getConsumers()) {
            consumer.getPaid(consumer.getMonthlyIncome());
        }
    }
}
