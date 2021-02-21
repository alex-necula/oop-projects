package dataprocessing.observers;

import communication.ServerMessage;
import main.Utils;
import storage.SensorData;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public final class ServerCommunicationController implements PropertyChangeListener {
    @Override
    public void propertyChange(final PropertyChangeEvent evt) {
        SensorData dataRecord = (SensorData) evt.getNewValue();
        ServerMessage serverMessage = new ServerMessage(dataRecord.getStepsCount(),
                Utils.getClientId(), dataRecord.getTimestamp());
        System.out.println(serverMessage.toString());
    }
}
