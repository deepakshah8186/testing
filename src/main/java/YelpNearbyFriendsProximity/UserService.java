package YelpNearbyFriendsProximity;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> users;

    public UserService() { // mug it up
        this.users = new HashMap<>();
    }

    public void addUser(User user) { // the service will have add/get/update and delete
        users.put(user.getId(), user);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public void updateUserLocation(String userId, Location newLocation) {
        User user = users.get(userId);
        if (user != null) {
            user.updateLocation(newLocation);
        }
    }
}

