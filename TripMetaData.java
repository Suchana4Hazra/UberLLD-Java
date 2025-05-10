public class TripMetaData{

    private RATING rideRating;
    private RATING driverRating;
    private Location srcLoc;
    private Location destLoc;

    public TripMetaData(RATING rideRating, RATING driverRating, Location srcLoc, Location destLoc) {
        this.rideRating = rideRating;
        this.driverRating = driverRating;
        this.srcLoc = srcLoc;
        this.destLoc = destLoc;
    }

    public RATING getRiderRating() {
        return rideRating;
    }
    public RATING getDriverRating() {
        return driverRating;
    }
    public void setDriverRating(RATING driverRating) {
        this.driverRating = driverRating;
    }
}