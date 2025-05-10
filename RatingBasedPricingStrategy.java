public class RatingBasedPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(TripMetaData tripMetaData) {
        double basePrice = 100.0;
        double multiplier = 1.0;

        if (tripMetaData.getDriverRating().getValue() < 3.0 || tripMetaData.getRiderRating().getValue() < 3.0) {
            multiplier = 1.5; // Increase price for low ratings
        }

        return basePrice * multiplier;
    }
}
