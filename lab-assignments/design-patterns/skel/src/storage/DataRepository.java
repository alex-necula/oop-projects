package storage;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

/**
 * Persists sensor data. Observable, its observers are notified when data is added it to.
 */
public final class DataRepository {

    // Since Observable and Observer are deprecated, I decided to use PropertyChangeListener instead
    private final PropertyChangeSupport support;
    private final List<SensorData> dataRecords;

    public DataRepository() {
        support = new PropertyChangeSupport(this);
        dataRecords = new ArrayList<>();
    }

    public void addPropertyChangeListener(final PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void addData(final SensorData dataRecord) {
        dataRecords.add(dataRecord);
        support.firePropertyChange("dataRecords", null, dataRecord);
    }

    public List<SensorData> getDataRecords() {
        return dataRecords;
    }
}


