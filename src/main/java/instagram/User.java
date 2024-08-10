package instagram;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String id;
    private String username;
    private Set<String> followers;
    private Set<String> following;

    public User(String id, String username) {
        this.id = id;
        this.username = username;
        this.followers = new HashSet<>();
        this.following = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Set<String> getFollowers() {
        return followers;
    }

    public Set<String> getFollowing() {
        return following;
    }

    public void addFollower(String userId) {
        followers.add(userId);
    }

    public void addFollowing(String userId) {
        following.add(userId);
    }

    public void removeFollower(String userId) {
        followers.remove(userId);
    }

    public void removeFollowing(String userId) {
        following.remove(userId);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", followers=" + followers.size() +
                ", following=" + following.size() +
                '}';
    }
}

