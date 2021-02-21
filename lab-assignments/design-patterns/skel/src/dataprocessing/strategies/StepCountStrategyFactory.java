package dataprocessing.strategies;

import main.Utils;
import storage.DataRepository;

public final class StepCountStrategyFactory {
    private StepCountStrategyFactory() { }
    public static StepCountStrategy createStrategy(final String strategyType,
                                                   final DataRepository dataRepository) {
        switch (strategyType) {
            case Utils.BASIC_STRATEGY -> {
                return new BasicStepCountStrategy(dataRepository);
            }
            case Utils.FILTERED_STRATEGY -> {
                return new FilteredStepCountStrategy(dataRepository);
            }
            default -> {
                return null;
            }
        }
    }
}
