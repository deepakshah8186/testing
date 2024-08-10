package instagram;

public class Follow {
    private String followerId;
    private String followeeId;

    public Follow(String followerId, String followeeId) {
        this.followerId = followerId;
        this.followeeId = followeeId;
    }

    public String getFollowerId() {
        return followerId;
    }

    public String getFolloweeId() {
        return followeeId;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "followerId='" + followerId + '\'' +
                ", followeeId='" + followeeId + '\'' +
                '}';
    }
}

