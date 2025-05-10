
import java.util.HashMap;

public class RiderMgr {
    private static RiderMgr instance = null;
    public HashMap<String, Rider> ridersMap;

    private RiderMgr() {
        
        ridersMap = new HashMap<>();
    }

    public static RiderMgr getRiderMgr() {
        if (instance == null) {
            instance = new RiderMgr();
        }
        return instance;
    }
    public void addRider(String pRiderName, Rider rider) {
        if (ridersMap.containsKey(pRiderName)) {
            System.out.println("Rider already exists");
            return;
        }
        ridersMap.put(pRiderName, rider);
    }
    public Rider getRider(String pRiderName) {
        if (ridersMap.containsKey(pRiderName)) {
            System.out.println("Rider found: " + ridersMap.get(pRiderName).getRiderName());
            return ridersMap.get(pRiderName);
        } else {
            System.out.println("Rider not found");
            return null;
        }
    }
}