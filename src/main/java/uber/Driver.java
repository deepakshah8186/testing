package uber;

public class Driver {
    private String driverId;
    private String name;
    private String phoneNumber;
    private boolean isAvailable;

    public Driver(String driverId, String name, String phoneNumber) {
        this.driverId = driverId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isAvailable = true;
    }

    public String getDriverId() {
        return driverId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

