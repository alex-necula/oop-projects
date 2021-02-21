package entities;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public final class Contract {
    private final PropertyChangeSupport support;
    private final int price;
    private final Consumer consumer;
    private final Distributor distributor;
    private int remainingMonths;
    private boolean suspended;
    // A contract is suspended if the consumer cannot pay the penalty

    public Contract(final Consumer consumer, final Distributor distributor) {
        support = new PropertyChangeSupport(this);
        this.price = distributor.getContractPrice();
        this.consumer = consumer;
        this.distributor = distributor;
        this.remainingMonths = distributor.getContractLength();
        this.suspended = false;
    }

    /**
     * Adds an observer
     *
     * @param pcl PropertyChangeListener object
     */
    public void addPropertyChangeListener(final PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public int getConsumerId() {
        return consumer.getId();
    }

    public int getPrice() {
        return price;
    }

    @JsonGetter("remainedContractMonths")
    public int getRemainingMonths() {
        return remainingMonths;
    }

    /**
     * Updates remaining months after a month has passed and notifies observer
     */
    public void updateRemainingMonths() {
        support.firePropertyChange("remainingMonths", remainingMonths, --remainingMonths);
    }

    @JsonIgnore
    public Consumer getConsumer() {
        return consumer;
    }

    @JsonIgnore
    public Distributor getDistributor() {
        return distributor;
    }

    @JsonIgnore
    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended(final boolean suspended) {
        this.suspended = suspended;
    }
}
