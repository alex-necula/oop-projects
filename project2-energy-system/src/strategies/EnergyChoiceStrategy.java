package strategies;

import entities.Distributor;
import entities.Producer;

import java.util.List;

public interface EnergyChoiceStrategy {
    /**
     * Sorts producers according to strategy
     *
     * @param distributor  that needs to choose producers
     * @param allProducers list of unsorted producers
     */
    void chooseProducers(Distributor distributor, List<Producer> allProducers);

    /**
     * Chooses producers according to distributor's needs and updates lists
     *
     * @param distributor     that needs to choose producers
     * @param sortedProducers list of sorted producers
     */
    default void associate(Distributor distributor, List<Producer> sortedProducers) {
        int providedEnergy = 0;
        for (Producer producer : sortedProducers) {
            if (producer.getMaxDistributors() == producer.getDistributors().size()) {
                continue;
            }
            int producerEnergy = producer.getEnergyPerDistributor();
            if (providedEnergy < distributor.getEnergyNeededKW()) {
                distributor.addProducer(producer, producerEnergy);
                producer.addDistributor(distributor);
                providedEnergy += producerEnergy;
            } else {
                break;
            }
        }
    }
}
