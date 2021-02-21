package actions.distributor;

import actions.AbstractAction;
import entities.Distributor;
import fileio.Database;
import strategies.EnergyChoiceStrategy;
import strategies.EnergyChoiceStrategyFactory;

import java.util.Comparator;

public final class ChooseProducersAction extends AbstractAction {
    public ChooseProducersAction(final Database activeEntities) {
        super(activeEntities);
    }

    @Override
    public void run() {
        EnergyChoiceStrategyFactory factory = EnergyChoiceStrategyFactory.getInstance();
        getActiveEntities().getDistributors().sort(Comparator.comparing(Distributor::getId));

        for (var distributor : getActiveEntities().getDistributors()) {
            if (distributor.needsProducers()) {
                for (var producer : distributor.getProducers().keySet()) {
                    producer.getDistributors().remove(distributor);
                }
                distributor.getProducers().clear();

                EnergyChoiceStrategy strategy =
                        factory.createStrategy(distributor.getProducerStrategy());
                strategy.chooseProducers(distributor, getActiveEntities().getProducers());
                distributor.setProducerUpdate(false);
            }
        }
    }
}
