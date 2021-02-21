package entities;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class AbstractFinancialEntity extends AbstractEntity implements Payer, Payee {
    private final PropertyChangeSupport support;
    private boolean isBankrupt = false;
    private int budget;

    public AbstractFinancialEntity() {
        support = new PropertyChangeSupport(this);
    }

    /**
     * Adds an observer
     *
     * @param pcl PropertyChangeListener object
     */
    public final void addPropertyChangeListener(final PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    @JsonGetter("budget")
    public final int getBudget() {
        return budget;
    }

    @JsonSetter("initialBudget")
    public final void setBudget(final int budget) {
        this.budget = budget;
    }

    @JsonGetter("isBankrupt")
    public final boolean isBankrupt() {
        return isBankrupt;
    }

    /**
     * Makes entity bankrupt and notifies observers
     */
    public final void becomeBankrupt() {
        support.firePropertyChange("isBankrupt", isBankrupt, true);
        isBankrupt = true;
    }

    @Override
    public final void getPaid(final int sum) {
        budget += sum;
    }

    /**
     * Pays sum to a payee
     * Can be overridden to allow penalties
     */
    @Override
    public void pay(final Payee payee, final int sum) {
        pay(sum);
        payee.getPaid(sum);
    }
}
