package actions.distributor;

import actions.AbstractAction;
import entities.Contract;
import fileio.Database;

import java.util.List;

/**
 * Removes suspended contracts after paying expenses and updates remaining months
 */
public final class UpdateContractsAction extends AbstractAction {
    public UpdateContractsAction(final Database activeEntities) {
        super(activeEntities);
    }

    @Override
    public void run() {
        for (var distributor : getActiveEntities().getDistributors()) {

            List<Contract> contracts = distributor.getContracts();
            contracts.removeIf(Contract::isSuspended);

            for (var contract : contracts) {
                contract.updateRemainingMonths();
            }
        }
    }
}
