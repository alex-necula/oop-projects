package dataprocessing.observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public final class ConsoleLogger implements PropertyChangeListener {
    @Override
    public void propertyChange(final PropertyChangeEvent evt) {
        System.out.println("Sensor data was added " + evt.getNewValue().toString());
    }
}
