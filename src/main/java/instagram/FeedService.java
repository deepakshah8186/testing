package instagram;

import java.util.ArrayList;
import java.util.List;

public class FeedService {
    private PostService postService;
    private UserService userService;

    public FeedService(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    public List<Post> getFeedForUser(String userId) {
        User user = userService.getUser(userId);
        List<Post> feed = new ArrayList<>();
        for (String followeeId : user.getFollowing()) {
            feed.addAll(postService.getPostsByUser(followeeId));
        }
        return feed;
    }
    // this feedService will have post service and user service attached together. First we will get the user from the userService.
    // then get all the people who he follows. then loop through and get post of all the people who he followed.In this way
    // he will be able to get the feed.
    // So the post service is very imp.It is having two maps. One map will containc pstid,post and the other map will ocntain userid and List<Post>
    // There are 3 kinds of services which we are going to use
}

