package uber;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UberSystem {
    private List<User> users;
    private List<Driver> drivers;
    private List<Ride> rides;

    public UberSystem() {
        this.users = new ArrayList<>();
        this.drivers = new ArrayList<>();
        this.rides = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public Ride requestRide(String userId, String pickupLocation, String dropLocation) {
        User user = getUserById(userId);
        if (user == null) {
            System.out.println("User not found");
            return null;
        }

        Driver availableDriver = findAvailableDriver();
        if (availableDriver == null) {
            System.out.println("No available drivers at the moment");
            return null;
        }

        String rideId = UUID.randomUUID().toString();
        Ride ride = new Ride(rideId, user, availableDriver, pickupLocation, dropLocation);
        rides.add(ride);
        availableDriver.setAvailable(false);
        return ride;
    }

    public void startRide(String rideId) {
        Ride ride = getRideById(rideId);
        if (ride != null) {
            ride.startRide();
        }
    }

    public void endRide(String rideId) {
        Ride ride = getRideById(rideId);
        if (ride != null) {
            ride.endRide();
        }
    }

    private User getUserById(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    private Driver findAvailableDriver() {
        for (Driver driver : drivers) {
            if (driver.isAvailable()) {
                return driver;
            }
        }
        return null;
    }

    private Ride getRideById(String rideId) {
        for (Ride ride : rides) {
            if (ride.getRideId().equals(rideId)) {
                return ride;
            }
        }
        return null;
    }
}

