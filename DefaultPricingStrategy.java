public class DefaultPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(TripMetaData tripMetaData) {
        // Flat rate example
        return 100.0;
    }
}
