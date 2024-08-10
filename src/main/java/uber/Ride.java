package uber;

import java.time.LocalDateTime;

public class Ride {
    private String rideId;
    private User user;
    private Driver driver;
    private String pickupLocation;
    private String dropLocation;
    private LocalDateTime requestTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Ride(String rideId, User user, Driver driver, String pickupLocation, String dropLocation) {
        this.rideId = rideId;
        this.user = user;
        this.driver = driver;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.requestTime = LocalDateTime.now();
    }

    public String getRideId() {
        return rideId;
    }

    public User getUser() {
        return user;
    }

    public Driver getDriver() {
        return driver;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public LocalDateTime getRequestTime() {
        return requestTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void startRide() {
        this.startTime = LocalDateTime.now();
        this.driver.setAvailable(false);
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void endRide() {
        this.endTime = LocalDateTime.now();
        this.driver.setAvailable(true);
    }
}

