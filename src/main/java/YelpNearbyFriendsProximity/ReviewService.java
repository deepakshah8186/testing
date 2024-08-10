package YelpNearbyFriendsProximity;

import java.util.ArrayList;
import java.util.List;

public class ReviewService {
    private List<Review> reviews;

    public ReviewService() {
        this.reviews = new ArrayList<>();
    }

    public void addReview(Review review) { // all the service will have add/update/delete
        reviews.add(review);
    }

    public List<Review> getReviewsForPlace(String placeId) {
        List<Review> placeReviews = new ArrayList<>();
        for (Review review : reviews) { // mog it up
            if (review.getPlaceId().equals(placeId)) {
                placeReviews.add(review);
            }
        }
        return placeReviews;
    }
}

