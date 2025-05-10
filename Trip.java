public class Trip {

    private static int tripIdCounter = 1;
    private final int tripId;
    private Rider rider;
    private Driver driver;
    private Location srcLoc;
    private Location destLoc;
    private TRIPSTATUS status;
    private double price;
    private PricingStrategy pricingStrategy;
    private DriverMatchingStrategy driverMatchingStrategy;

    public Trip(Rider rider, Driver driver, Location srcLoc, Location destLoc) {
        tripId = tripIdCounter++;
        this.rider = rider;
        this.driver = driver;
        this.srcLoc = srcLoc;
        this.destLoc = destLoc;
        // this.status = status;
        // this.price = price;
        // this.pricingStrategy = pricingStrategy;
        // this.driverMatchingStrategy = driverMatchingStrategy;
    }

    public int getTripId() {
        return tripId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(TRIPSTATUS status) {
        this.status = status;
    }

    public void displayTripDetails() {
        System.out.println("Trip ID: " + tripId);
        System.out.println("Rider: " + rider.getRiderName());
        System.out.println("Driver: " + driver.getDriverName());
        System.out.println("Source Location: (" + srcLoc.latitude + ", " + srcLoc.longitude + ")");
        System.out.println("Destination Location: (" + destLoc.latitude + ", " + destLoc.longitude + ")");
        System.out.println("Status: " + status);
        System.out.println("Price: $" + price);
    }
}