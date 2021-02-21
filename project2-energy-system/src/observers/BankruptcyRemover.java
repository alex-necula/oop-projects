package observers;

import entities.AbstractFinancialEntity;
import entities.Consumer;
import entities.Contract;
import entities.Distributor;
import fileio.Database;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Observer that removes a bankrupt entity from the database
 */
public final class BankruptcyRemover implements PropertyChangeListener {
    private final Database activeEntities;

    public BankruptcyRemover(final Database activeEntities) {
        this.activeEntities = activeEntities;
    }

    @Override
    public void propertyChange(final PropertyChangeEvent evt) {
        AbstractFinancialEntity bankruptEntity = (AbstractFinancialEntity) evt.getSource();
        if (bankruptEntity instanceof Consumer) {
            Contract removedContract = ((Consumer) bankruptEntity).getContract();
            removedContract.setSuspended(true);
            activeEntities.getConsumers().remove(bankruptEntity);

        } else if (bankruptEntity instanceof Distributor) {
            activeEntities.getDistributors().remove(bankruptEntity);
            for (var contract : ((Distributor) bankruptEntity).getContracts()) {
                contract.getConsumer().removeContract();
            }
            for (var producer : ((Distributor) bankruptEntity).getProducers().keySet()) {
                producer.getDistributors().remove(bankruptEntity);
            }
        }
    }
}
