package strategies;

import entities.Distributor;
import entities.Producer;

import java.util.Comparator;
import java.util.List;

public final class QuantityStrategy implements EnergyChoiceStrategy {
    @Override
    public void chooseProducers(final Distributor distributor,
                                final List<Producer> allProducers) {
        allProducers.sort(Comparator.comparing(Producer::getEnergyPerDistributor).reversed()
                .thenComparing(Producer::getId));
        associate(distributor, allProducers);
    }
}
