
import java.util.HashMap;

public class TripMgr{

    private static final TripMgr INSTANCE = null;
    private RiderMgr riderMgr;
    private DriverMgr driverMgr;
    private HashMap<Integer, TripMetaData> tripMetaDataInfo;
    public HashMap<Integer, Trip> tripsInfo;

    private TripMgr() {
        riderMgr = riderMgr.getRiderMgr();
        driverMgr = DriverMgr.getDriverMgr();
        tripMetaDataInfo = new HashMap<>();
        tripsInfo = new HashMap<>();
    }
    public static synchronized TripMgr getTripMgr() {
        if (INSTANCE == null) {
            return new TripMgr();
        }
        return INSTANCE;
    }

    public Trip createTrip(Rider pRider, Driver pDriver, Location pSrcLoc, Location pDestLoc) {
        TripMetaData tripMetaData = new TripMetaData(pRider.getRating(), pDriver.getRating(), pSrcLoc, pDestLoc);
        Trip trip = new Trip(pRider, pDriver, pSrcLoc, pDestLoc);
        tripsInfo.put(trip.getTripId(), trip);
        tripMetaDataInfo.put(trip.getTripId(), tripMetaData);
        return trip;
    }

    public HashMap<Integer, Trip> getTripsInfo() {
        return tripsInfo;
    }
   
}