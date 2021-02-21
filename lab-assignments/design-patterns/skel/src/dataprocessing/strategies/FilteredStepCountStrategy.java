package dataprocessing.strategies;

import main.Utils;
import storage.DataRepository;
import storage.SensorData;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class FilteredStepCountStrategy implements StepCountStrategy {
    private final DataRepository dataRepository;
    private static final int MAX_DIFF_STEPS_CONSECUTIVE_RECORDS = 1000;
    private static final long TIME_FOR_MAX_DIFF = TimeUnit.SECONDS.toMillis(1);

    public FilteredStepCountStrategy(final DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public int getTotalSteps() {
        int sum = 0;
        List<SensorData> dataRecords = dataRepository.getDataRecords();
        dataRecords.sort(Comparator.comparingLong(SensorData::getTimestamp));

        long previousTimestamp = dataRecords.get(0).getTimestamp();
        int initialSteps = dataRecords.get(0).getStepsCount();
        if (initialSteps > 0) {
            sum += initialSteps; // special case for first entry
        }

        long currentTimestamp;
        for (int i = 1; i < dataRecords.size(); i++) {
            int currentSteps = dataRecords.get(i).getStepsCount();
            currentTimestamp = dataRecords.get(i).getTimestamp();
            if (currentTimestamp - previousTimestamp < TIME_FOR_MAX_DIFF
                    && currentSteps > MAX_DIFF_STEPS_CONSECUTIVE_RECORDS) {
                continue;
            } else if (currentSteps > 0) {
                sum += currentSteps;
            }
            previousTimestamp = currentTimestamp;
        }

        return sum;
    }

    @Override
    public String getStrategyDescription() {
        return Utils.FILTERED_STRATEGY;
    }
}
