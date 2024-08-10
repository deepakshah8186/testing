package instagram;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create services
        UserService userService = new UserService();
        PostService postService = new PostService();
        FeedService feedService = new FeedService(postService, userService);

        // Create users
        User user1 = new User("1", "alice");
        User user2 = new User("2", "bob");
        userService.addUser(user1);
        userService.addUser(user2);

        // User1 follows User2
        userService.followUser("1", "2");

        // Create posts
        Post post1 = new Post("1", "2", "Hello world!");
        postService.addPost(post1);

        // Add comments
        Comment comment1 = new Comment("1", "1", "1", "Nice post!");
        postService.addComment("1", comment1);

        // Add likes
        postService.addLike("1", "1");

        // Get feed for User1
        List<Post> feed = feedService.getFeedForUser("1");
        System.out.println("Feed for User1:");
        for (Post post : feed) {
            System.out.println(post);
        }

        // Display posts and comments
        System.out.println("Posts and comments:");
        Post post = postService.getPost("1");
        System.out.println(post);
        for (Comment comment : post.getComments()) {
            System.out.println(comment);
        }
    }
}

