package dataprocessing.strategies;

import main.Utils;
import storage.DataRepository;
import storage.SensorData;


public final class BasicStepCountStrategy implements StepCountStrategy {
    private final DataRepository dataRepository;

    public BasicStepCountStrategy(final DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public int getTotalSteps() {
        return dataRepository.getDataRecords().stream().mapToInt(SensorData::getStepsCount).sum();
    }

    @Override
    public String getStrategyDescription() {
        return Utils.BASIC_STRATEGY;
    }
}
