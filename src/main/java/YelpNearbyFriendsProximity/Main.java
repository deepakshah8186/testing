package YelpNearbyFriendsProximity;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create services
        NearbyService nearbyService = new NearbyService();
        ReviewService reviewService = new ReviewService();
        UserService userService = new UserService();

        // Create some places
        Place place1 = new Place("1", "Joe's Coffee", "123 Main St", new Location(40.7128, -74.0060));
        Place place2 = new Place("2", "Pizza Palace", "456 Elm St", new Location(40.7127, -74.0059));
        Place place3 = new Place("3","California Pizza","5533 Edward E Horton",new Location(35,40));
        nearbyService.addPlace(place1);
        nearbyService.addPlace(place2);
        nearbyService.addPlace(place3);

        // Create some users
        User user1 = new User("1", "Alice", new Location(40.7128, -74.0050));
        User user2 = new User("2", "Bob", new Location(40.7130, -74.0065));
        userService.addUser(user1);
        userService.addUser(user2);

        // Add some reviews
        Review review1 = new Review("1", "1", 5, "Great coffee!");
        Review review2 = new Review("2", "2", 4, "Nice pizza!");
        reviewService.addReview(review1);
        reviewService.addReview(review2);

        // Find nearby places for user1 within 1 km radius
        List<Place> nearbyPlaces = nearbyService.findNearbyPlaces(user1.getLocation(), 1);
        System.out.println("Nearby places for user1:");
        for (Place place : nearbyPlaces) {
            System.out.println(place);
        }

        // Get reviews for place1
        List<Review> place1Reviews = reviewService.getReviewsForPlace("1");
        System.out.println("Reviews for Joe's Coffee:");
        for (Review review : place1Reviews) {
            System.out.println(review);
        }

        // Update user2's location
        userService.updateUserLocation("2", new Location(40.7131, -74.0067));
        System.out.println("Updated location for user2:");
        System.out.println(userService.getUser("2"));
    }
}
