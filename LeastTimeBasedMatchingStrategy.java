public class LeastTimeBasedMatchingStrategy implements DriverMatchingStrategy {
    @Override
    public Driver matchDriver(TripMetaData tripMetaData) {
// Placeholder logic: choose first available driver
            for (Driver driver : DriverMgr.driversMap.values()) {
            if (driver.isAvail()) {
                return driver;
            }
        }
        return null; // No available driver
    }
}
