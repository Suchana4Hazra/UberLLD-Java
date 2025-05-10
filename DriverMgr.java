import java.util.HashMap;

public class DriverMgr {
    private static DriverMgr driverMgrInstance;
    public static HashMap<String, Driver> driversMap = new HashMap<>();

    private DriverMgr() {}

    public static synchronized DriverMgr getDriverMgr() {
        if (driverMgrInstance == null) {
            driverMgrInstance = new DriverMgr();
        }
        return driverMgrInstance;
    }

    public void addDriver(String name, Driver driver) {
        driversMap.put(name, driver);
    }

    public Driver getDriver(String name) {
        return driversMap.get(name);
    }
}
