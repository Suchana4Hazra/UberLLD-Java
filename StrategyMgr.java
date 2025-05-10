public class StrategyMgr{

    public static StrategyMgr instance = null;

    private StrategyMgr() {
        // Constructor is private to prevent instantiation
    }
    public static synchronized StrategyMgr getStrategyMgr() {
        if (instance == null) {
            instance = new StrategyMgr();
        }
        return instance;
    }
    public PricingStrategy determinePricingStrategy(TripMetaData pTripMetaData) {
        // Example logic to determine pricing strategy based on trip metadata
        if (pTripMetaData.getRiderRating() == RATING.FIVE_STAR && pTripMetaData.getDriverRating() == RATING.FIVE_STAR) {
            return new RatingBasedPricingStrategy();
        } else {
            return new DefaultPricingStrategy();
        }
    }

    DriverMatchingStrategy determineMatchingStrategy(TripMetaData pTripMetaData) {
        
        return new LeastTimeBasedMatchingStrategy();
    }
}