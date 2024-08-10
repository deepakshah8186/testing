package instagram;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> users; // imp there will be many users

    public UserService() {
        this.users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public void followUser(String followerId, String followeeId) {
        User follower = users.get(followerId);
        User followee = users.get(followeeId);
        if (follower != null && followee != null) {
            follower.addFollowing(followeeId);
            followee.addFollower(followerId);
        }
    }

    public void unfollowUser(String followerId, String followeeId) {
        User follower = users.get(followerId);
        User followee = users.get(followeeId);
        if (follower != null && followee != null) {
            follower.removeFollowing(followeeId);
            followee.removeFollower(followerId);
        }
    }
}

