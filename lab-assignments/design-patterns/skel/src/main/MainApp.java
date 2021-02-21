package main;

import dataprocessing.observers.ConsoleLogger;
import dataprocessing.observers.DataAggregator;
import dataprocessing.strategies.StepCountStrategy;
import dataprocessing.strategies.StepCountStrategyFactory;
import storage.DataRepository;
import dataprocessing.observers.ServerCommunicationController;
import storage.SensorData;

import java.util.Scanner;

public final class MainApp {
    private MainApp() { }

    public static void main(final String[] args) {

        System.out.println("Choose a strategy: type 'basic or 'filtered'");
        Scanner scanner = new Scanner(System.in);
        String strategyType = scanner.next();
        scanner.close();

        DataRepository dataRepository = new DataRepository();
        StepCountStrategy strategy = StepCountStrategyFactory.createStrategy(
                strategyType, dataRepository);

        dataRepository.addPropertyChangeListener(new ConsoleLogger());
        dataRepository.addPropertyChangeListener(new ServerCommunicationController());
        dataRepository.addPropertyChangeListener(new DataAggregator(strategy));

        long baseTimestamp = System.currentTimeMillis();

        dataRepository.addData(new SensorData(10, baseTimestamp + 1));
        System.out.println();

        dataRepository.addData(new SensorData(20, baseTimestamp + 2));
        System.out.println();

        dataRepository.addData(new SensorData(30, baseTimestamp + 3));
        System.out.println();

        dataRepository.addData(new SensorData(4000, baseTimestamp + 4));
        System.out.println();

        dataRepository.addData(new SensorData(50, baseTimestamp + 5));
        System.out.println();

        dataRepository.addData(new SensorData(-100, baseTimestamp + 6));
        System.out.println();

        dataRepository.addData(new SensorData(500, baseTimestamp + 600));
        System.out.println();
    }
}
