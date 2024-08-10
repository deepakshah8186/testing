package YelpNearbyFriendsProximity;

public class Review {
    private String userId;
    private String placeId;
    private int rating;
    private String comment;

    public Review(String userId, String placeId, int rating, String comment) {
        this.userId = userId;
        this.placeId = placeId;
        this.rating = rating;
        this.comment = comment;
    }

    public String getUserId() {
        return userId;
    }

    public String getPlaceId() {
        return placeId;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "userId='" + userId + '\'' +
                ", placeId='" + placeId + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}

