package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import utils.Utils;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public final class Producer extends AbstractEntity {
    private final PropertyChangeSupport support;
    private final List<MonthlyStat> monthlyStats;
    private final List<Distributor> distributors;
    private EnergyType energyType;
    private int maxDistributors;
    private double priceKW;
    private int energyPerDistributor;

    public Producer() {
        support = new PropertyChangeSupport(this);
        monthlyStats = new ArrayList<>();
        distributors = new ArrayList<>();
    }

    public EnergyType getEnergyType() {
        return energyType;
    }

    public void setEnergyType(final String energyType) {
        this.energyType = Utils.stringToEnergyType(energyType);
    }

    public int getMaxDistributors() {
        return maxDistributors;
    }

    public void setMaxDistributors(final int maxDistributors) {
        this.maxDistributors = maxDistributors;
    }

    public double getPriceKW() {
        return priceKW;
    }

    public void setPriceKW(final double priceKW) {
        this.priceKW = priceKW;
    }

    public int getEnergyPerDistributor() {
        return energyPerDistributor;
    }

    /**
     * Sets new energy value and notifies observers
     *
     * @param energyPerDistributor from input
     */
    public void setEnergyPerDistributor(final int energyPerDistributor) {
        support.firePropertyChange("energyPerDistributor", this.energyPerDistributor,
                energyPerDistributor);
        this.energyPerDistributor = energyPerDistributor;
    }

    @JsonIgnore
    public List<Distributor> getDistributors() {
        return distributors;
    }

    public List<MonthlyStat> getMonthlyStats() {
        return monthlyStats;
    }

    /**
     * Adds distributor to the list
     *
     * @param distributor to be added
     */
    public void addDistributor(final Distributor distributor) {
        distributors.add(distributor);
    }

    /**
     * Adds monthlyStat to the list
     *
     * @param monthlyStat to be added
     */
    public void addMonthlyStat(final MonthlyStat monthlyStat) {
        monthlyStats.add(monthlyStat);
    }

    /**
     * Adds a new observer
     */
    public void addPropertyChangeListener(final PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }
}
