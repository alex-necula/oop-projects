package dataprocessing.observers;

import dataprocessing.strategies.StepCountStrategy;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public final class DataAggregator implements PropertyChangeListener {
    private final StepCountStrategy strategy;

    public DataAggregator(final StepCountStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void propertyChange(final PropertyChangeEvent evt) {
        System.out.println(strategy.getStrategyDescription()
                + " total steps: " + strategy.getTotalSteps());
    }
}
