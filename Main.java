import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        RiderMgr riderMgr = RiderMgr.getRiderMgr();
        DriverMgr driverMgr = DriverMgr.getDriverMgr();
        StrategyMgr strategyMgr = StrategyMgr.getStrategyMgr();
        TripMgr tripMgr = TripMgr.getTripMgr();

        while (true) {
            printMenu();
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addRider(riderMgr);
                case 2 -> addDriver(driverMgr);
                case 3 -> deleteRider(riderMgr);
                case 4 -> deleteDriver(driverMgr);
                // case 5 -> modifyMetaData(tripMgr);
                case 6 -> bookTrip(riderMgr, driverMgr, strategyMgr, tripMgr);
                case 7 -> viewTrips(tripMgr);
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n===== Uber System Menu =====");
        System.out.println("1. Add Rider");
        System.out.println("2. Add Driver");
        System.out.println("3. Delete Rider");
        System.out.println("4. Delete Driver");
        // System.out.println("5. Modify Trip MetaData");
        System.out.println("6. Book Trip");
        System.out.println("7. View All Trips");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private static void addRider(RiderMgr riderMgr) {
        System.out.print("Enter Rider Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Rating (1-5): ");
        int ratingVal = sc.nextInt();
        sc.nextLine(); // consume newline

        RATING rating = RATING.fromValue(ratingVal); // ✅ converts int to enum
        riderMgr.addRider(name, new Rider(name, rating));
        System.out.println("Rider added.");
   }


    private static void addDriver(DriverMgr driverMgr) {
        System.out.print("Enter Driver Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Rating(1-5): ");
        int ratingVal = sc.nextInt();
        sc.nextLine(); // consume newline

        RATING rating = RATING.fromValue(ratingVal); // ✅ converts int to enum
        driverMgr.addDriver(name, new Driver(name, true, rating));
        System.out.println("Rider added.");
    }

    private static void deleteRider(RiderMgr riderMgr) {
        System.out.print("Enter Rider Name to delete: ");
        String name = sc.nextLine();
        riderMgr.ridersMap.remove(name);
        System.out.println("Rider removed.");
    }

    private static void deleteDriver(DriverMgr driverMgr) {
        System.out.print("Enter Driver Name to delete: ");
        String name = sc.nextLine();
        driverMgr.driversMap.remove(name);
        System.out.println("Driver removed.");
    }

    // private static void modifyMetaData(TripMgr tripMgr) {
    //     System.out.print("Enter Trip ID to modify metadata: ");
    //     int id = sc.nextInt();
    //     sc.nextLine();
    //     TripMetaData meta = tripMgr.getMetaDataMap().get(id);
    //     if (meta != null) {
    //         System.out.print("Enter new rider rating: ");
    //         meta.setRiderRating(sc.nextDouble());
    //         System.out.print("Enter new driver rating: ");
    //         meta.setDriverRating(sc.nextDouble());
    //         sc.nextLine();
    //         System.out.println("Metadata updated.");
    //     } else {
    //         System.out.println("Trip ID not found.");
    //     }
    // }

    private static void bookTrip(RiderMgr riderMgr, DriverMgr driverMgr,
                                 StrategyMgr strategyMgr, TripMgr tripMgr) {
        System.out.print("Enter Rider Name: ");
        String riderName = sc.nextLine();
        Rider rider = (Rider) riderMgr.getRider(riderName);
        if (rider == null) {
            System.out.println("Rider not found.");
            return;
        }

        // Match driver
        DriverMatchingStrategy dms; // null for now
        dms = (DriverMatchingStrategy) strategyMgr.determineMatchingStrategy(null);
     
        Location source = new Location(22.5726, 88.3639); // example: Kolkata
        Location dest = new Location(22.3072, 73.1812);   // example: Vadodara

        RATING riderRating = rider.getRating();          // already a RATING enum
        RATING driverRating = RATING.fromValue(5);       // or get from driver object

        TripMetaData meta;
        meta = new TripMetaData(riderRating, driverRating , source, dest);

        Driver driver = dms.matchDriver(meta);
        if (driver == null) {
            System.out.println("No driver available.");
            return;
        }

        // Determine price
        TripMetaData meta2 = new TripMetaData(riderRating, driverRating, source, dest);
        PricingStrategy ps = strategyMgr.determinePricingStrategy(meta2);
        double price = ps.calculatePrice(meta2);

        Trip trip;
        trip = tripMgr.createTrip(rider, driver, source, dest);
        trip.setPrice(price);
        trip.setStatus(TRIPSTATUS.BOOKED);
        System.out.println("Trip Booked:");
        trip.displayTripDetails();
    }

    private static void viewTrips(TripMgr tripMgr) {
        for (Trip trip : tripMgr.tripsInfo.values()) {
            trip.displayTripDetails();
            System.out.println("------------------------");
        }
    }
}
