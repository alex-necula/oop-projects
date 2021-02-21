package actions.distributor;

import actions.AbstractAction;
import entities.Distributor;
import fileio.Database;

import java.util.ArrayList;
import java.util.List;

public final class PayExpensesAction extends AbstractAction {
    public PayExpensesAction(final Database activeEntities) {
        super(activeEntities);
    }

    @Override
    public void run() {
        List<Distributor> distributors = new ArrayList<>(getActiveEntities().getDistributors());

        for (var distributor : distributors) {
            int sum = distributor.getInfrastructureCost()
                    + distributor.getContracts().size() * distributor.getProductionCost();
            distributor.pay(sum);
        }
    }
}
