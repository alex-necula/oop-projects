package actions.distributor;

import actions.AbstractUpdateAction;
import entities.Distributor;
import entities.EntityFinder;
import entities.EntityType;
import fileio.Database;
import updates.MonthlyUpdate;

import java.util.Objects;

public final class UpdateDistributorsAction extends AbstractUpdateAction {

    public UpdateDistributorsAction(final Database activeEntities,
                                    final MonthlyUpdate monthlyUpdate) {
        super(activeEntities, monthlyUpdate);
    }

    @Override
    public void run() {
        for (var update : getMonthlyUpdate().getDistributorChanges()) {
            Distributor distributor = (Distributor) EntityFinder.findEntity(
                    EntityType.DISTRIBUTOR, update.getId(), getActiveEntities());

            if (Objects.nonNull(distributor)) {
                distributor.setInfrastructureCost(update.getInfrastructureCost());
            }
        }
    }
}
