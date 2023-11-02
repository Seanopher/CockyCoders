package projectCode;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Date;
/**
 * @author Hughes
 * a comments class that creates a list of comments and adds them to a list
 */
public class Comment {
    public String comment;
    public User user;
    public Date date;
    private List<Comment> comments;
    /**
     * Creates instances of the varibles associated with comment
     * @param comment the object
     * @param user the person writing the comment
     * @param date the date the comment is written
     */
    public Comment(String comment, User user, Date date){
        this.comment = comment;
        this.user = user;
        this.date = date;
        this.comments = new ArrayList<>();
    }
    /**
     * Adds more comments to arraylist
     * @param comment the comment itself
     * @param user the user that is writing the comment
     * @param date the date it is being made
     */
    public void addComment(String comment, User user, Date date) {
        Comment newComment = new Comment(comment, user, date);
        comments.add(newComment);
    }
    /**
     * 
     * @return
     */
    public List<Comment> getComments() {
        return comments;
    }
}
