package instagram;

import java.util.ArrayList;
import java.util.List;

public class Post { // this class is important
    private String id;
    private String userId;
    private String content;
    private List<String> likes;
    private List<Comment> comments;

    public Post(String id, String userId, String content) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.likes = new ArrayList<>(); // this is imp
        this.comments = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public List<String> getLikes() {
        return likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addLike(String userId) {
        likes.add(userId);
    }

    public void removeLike(String userId) {
        likes.remove(userId);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                ", likes=" + likes.size() +
                ", comments=" + comments.size() +
                '}';
    }
}

