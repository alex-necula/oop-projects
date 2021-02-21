package observers;

import entities.Producer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public final class ProducerUpdateObserver implements PropertyChangeListener {
    @Override
    public void propertyChange(final PropertyChangeEvent evt) {
        Producer producer = (Producer) evt.getSource();
        for (var distributor : producer.getDistributors()) {
            distributor.setProducerUpdate(true);
        }
    }
}
