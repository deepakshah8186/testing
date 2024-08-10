package instagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostService {
    private Map<String, List<Post>> userPosts; // very imp
    private Map<String, Post> posts; // very imp

    public PostService() {
        this.userPosts = new HashMap<>();
        this.posts = new HashMap<>();
    }

    public void addPost(Post post) {
        posts.put(post.getId(), post);
        userPosts.putIfAbsent(post.getUserId(), new ArrayList<>());
        userPosts.get(post.getUserId()).add(post);
    }

    public Post getPost(String postId) {
        return posts.get(postId);
    }

    public List<Post> getPostsByUser(String userId) {
        return userPosts.getOrDefault(userId, new ArrayList<>());
    }

    public void addLike(String postId, String userId) {
        Post post = posts.get(postId);
        if (post != null) {
            post.addLike(userId);
        }
    }

    public void addComment(String postId, Comment comment) {
        Post post = posts.get(postId);
        if (post != null) {
            post.addComment(comment);
        }
    }
}
