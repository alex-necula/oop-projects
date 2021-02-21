package actions.producer;

import actions.AbstractUpdateAction;
import entities.EntityFinder;
import entities.EntityType;
import entities.Producer;
import fileio.Database;
import updates.MonthlyUpdate;

import java.util.Objects;

public final class UpdateProducersAction extends AbstractUpdateAction {
    public UpdateProducersAction(final Database activeEntities,
                                 final MonthlyUpdate monthlyUpdate) {
        super(activeEntities, monthlyUpdate);
    }

    @Override
    public void run() {
        for (var update : getMonthlyUpdate().getProducerChanges()) {
            Producer producer = (Producer) EntityFinder.findEntity(
                    EntityType.PRODUCER, update.getId(), getActiveEntities());

            if (Objects.nonNull(producer)) {
                producer.setEnergyPerDistributor(update.getEnergyPerDistributor());
            }
        }
    }
}
