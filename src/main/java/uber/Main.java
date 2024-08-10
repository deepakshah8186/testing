package uber;

public class Main {
    public static void main(String[] args) {
        UberSystem uberSystem = new UberSystem();

        User user1 = new User("1", "John Doe", "1234567890");
        Driver driver1 = new Driver("1", "Jane Smith", "0987654321");

        uberSystem.addUser(user1);
        uberSystem.addDriver(driver1);

        Ride ride = uberSystem.requestRide(user1.getUserId(), "123 Main St", "456 Elm St");
        if (ride != null) {
            System.out.println("Ride requested: " + ride.getRideId());
            uberSystem.startRide(ride.getRideId());
            System.out.println("Ride started");
            uberSystem.endRide(ride.getRideId());
            System.out.println("Ride ended");
        }
    }
}

