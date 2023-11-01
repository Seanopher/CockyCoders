package projectCode;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Comment {
    public String comment;
    public User user;
    public String date;
    private List<Comment> comments;

    public Comment(String comment, User user, String date){
        this.comment = comment;
        this.user = user;
        this.date = date;
        this.comments = new ArrayList<>();
    }

    public void addComment(String comment, User user, String date) {
        Comment newComment = new Comment(comment, user, date);
        comments.add(newComment);
    }
    public List<Comment> getComments() {
        return comments;
    }
}
