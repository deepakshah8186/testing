package instagram;

public class Like {
    private String userId;
    private String postId;

    public Like(String userId, String postId) {
        this.userId = userId;
        this.postId = postId;
    }

    public String getUserId() {
        return userId;
    }

    public String getPostId() {
        return postId;
    }

    @Override
    public String toString() {
        return "Like{" +
                "userId='" + userId + '\'' +
                ", postId='" + postId + '\'' +
                '}';
    }
}

