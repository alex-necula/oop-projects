package strategies;

public final class EnergyChoiceStrategyFactory {
    private static final EnergyChoiceStrategyFactory INSTANCE = new EnergyChoiceStrategyFactory();

    private EnergyChoiceStrategyFactory() {
    }

    public static EnergyChoiceStrategyFactory getInstance() {
        return INSTANCE;
    }

    /**
     * @param type of strategy
     * @return corresponding strategy object
     */
    public EnergyChoiceStrategy createStrategy(final EnergyChoiceStrategyType type) {
        return switch (type) {
            case QUANTITY -> new QuantityStrategy();
            case GREEN -> new GreenStrategy();
            case PRICE -> new PriceStrategy();
        };
    }
}
