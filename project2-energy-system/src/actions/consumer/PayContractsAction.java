package actions.consumer;

import actions.AbstractAction;
import entities.Consumer;
import entities.Payee;
import fileio.Database;

import java.util.ArrayList;
import java.util.List;

public final class PayContractsAction extends AbstractAction {

    public PayContractsAction(final Database activeEntities) {
        super(activeEntities);
    }

    @Override
    public void run() {
        List<Consumer> consumers = new ArrayList<>(getActiveEntities().getConsumers());

        for (Consumer consumer : consumers) {
            int contractPrice = consumer.getContract().getPrice();
            Payee currentDistributor = consumer.getContract().getDistributor();

            if (consumer.hasPenalty()) {
                int penaltyPrice = consumer.getPenalty().getSum();
                Payee penaltyDistributor = consumer.getPenalty().getPayee();

                if (contractPrice + penaltyPrice > consumer.getBudget()) {
                    consumer.becomeBankrupt();
                    continue;
                }

                consumer.pay(penaltyDistributor, penaltyPrice);
            }

            consumer.pay(currentDistributor, contractPrice);
        }
    }
}
