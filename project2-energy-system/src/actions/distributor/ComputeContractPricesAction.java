package actions.distributor;

import actions.AbstractAction;
import entities.Contract;
import fileio.Database;

import java.util.List;

public final class ComputeContractPricesAction extends AbstractAction {
    private static final double PROFIT_MARGIN = 0.2;

    public ComputeContractPricesAction(final Database activeEntities) {
        super(activeEntities);
    }

    @Override
    public void run() {
        for (var distributor : getActiveEntities().getDistributors()) {
            int profit = (int) Math.round(
                    Math.floor(PROFIT_MARGIN * distributor.getProductionCost()));
            List<Contract> contracts = distributor.getContracts();

            if (contracts.isEmpty()) {
                distributor.setContractPrice(distributor.getInfrastructureCost()
                        + distributor.getProductionCost() + profit);
            } else {
                distributor.setContractPrice(
                        (distributor.getInfrastructureCost() / contracts.size())
                                + distributor.getProductionCost() + profit);
            }
        }
    }
}
