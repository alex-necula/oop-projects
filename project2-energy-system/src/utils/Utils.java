package utils;

import entities.EnergyType;
import strategies.EnergyChoiceStrategyType;

/**
 * The class contains static methods that help with parsing.
 */
public final class Utils {
    private Utils() {
    }

    /**
     * @param producerStrategy from input
     * @return corresponding enum
     */
    public static EnergyChoiceStrategyType stringToStrategy(final String producerStrategy) {
        return switch (producerStrategy) {
            case "GREEN" -> EnergyChoiceStrategyType.GREEN;
            case "PRICE" -> EnergyChoiceStrategyType.PRICE;
            case "QUANTITY" -> EnergyChoiceStrategyType.QUANTITY;
            default -> throw new IllegalStateException("Unexpected value: " + producerStrategy);
        };
    }

    /**
     * @param energyType from input
     * @return corresponding enum
     */
    public static EnergyType stringToEnergyType(final String energyType) {
        return switch (energyType) {
            case "WIND" -> EnergyType.WIND;
            case "SOLAR" -> EnergyType.SOLAR;
            case "HYDRO" -> EnergyType.HYDRO;
            case "COAL" -> EnergyType.COAL;
            case "NUCLEAR" -> EnergyType.NUCLEAR;
            default -> throw new IllegalStateException("Unexpected value: " + energyType);
        };
    }
}
