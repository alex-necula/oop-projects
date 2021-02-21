package strategies;

import entities.Distributor;
import entities.Producer;

import java.util.Comparator;
import java.util.List;

public final class PriceStrategy implements EnergyChoiceStrategy {
    @Override
    public void chooseProducers(final Distributor distributor,
                                final List<Producer> allProducers) {
        allProducers.sort(Comparator.comparing(Producer::getPriceKW)
                .thenComparing(Producer::getEnergyPerDistributor, Comparator.reverseOrder())
                .thenComparing(Producer::getId));
        associate(distributor, allProducers);
    }
}
