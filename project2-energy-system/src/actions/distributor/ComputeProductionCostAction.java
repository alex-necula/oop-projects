package actions.distributor;

import actions.AbstractAction;
import fileio.Database;

public final class ComputeProductionCostAction extends AbstractAction {
    private static final int COST_DIVISOR = 10;

    public ComputeProductionCostAction(final Database activeEntities) {
        super(activeEntities);
    }

    @Override
    public void run() {
        for (var distributor : getActiveEntities().getDistributors()) {
            double cost = 0;
            for (var entry : distributor.getProducers().entrySet()) {
                cost += entry.getKey().getPriceKW() * entry.getValue();
            }
            distributor.setProductionCost((int) Math.round(Math.floor(cost / COST_DIVISOR)));
        }
    }
}
