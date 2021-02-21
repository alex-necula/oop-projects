package observers;

import entities.Contract;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Observer that removes a contract from consumer once it expires
 */
public final class ContractExpiredRemover implements PropertyChangeListener {
    @Override
    public void propertyChange(final PropertyChangeEvent evt) {
        Contract contract = (Contract) evt.getSource();
        int remainingMonths = (int) evt.getNewValue();
        if (remainingMonths == 0) {
            contract.getConsumer().removeContract();
        }
    }
}
