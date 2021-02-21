package actions.distributor;

import actions.AbstractAction;
import fileio.Database;

/**
 * Removes expired contracts after computing the new contract's price
 */
public final class RemoveExpiredContracts extends AbstractAction {
    public RemoveExpiredContracts(final Database activeEntities) {
        super(activeEntities);
    }

    @Override
    public void run() {
        for (var distributor : getActiveEntities().getDistributors()) {
            distributor.getContracts().removeIf(contract -> contract.getRemainingMonths() == 0);
        }
    }
}
