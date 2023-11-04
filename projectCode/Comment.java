package projectCode;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Date;
/**
 * @author Cocky Coders
 * a comments class that creates a list of comments and adds them to a list
 */
public class Comment {

    /*
     * Instance Variables
     */
    public String comment;
    public User user;
    public Date date;
    private ArrayList<Comment> comments;

    /**
     * Constructor class
     * Creates instances of the varibles associated with comment
     * @param comment teh message from the user
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
     * creates the new comment
     * @param comment mesage from the user
     * @param user comment writer
     * @param date when the comment was written
     * @param comments he list of comments off the comment
     */
    public void newComment(String comment, User user, Date date, ArrayList<Comment> comments){
        this.comment = comment;
        this.user = user;
        this.date = date;
        this.comments = comments;
    }

    /**
     * Adds more comments to arraylist
     * @param comment the comment itself
     * @param user the user that is writing the comment
     * @param date the date it is being made
     * 
     * creates the new comment
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
    public String getComment(){
        return comment;
    }
    public String getUser(){
        return user.getUsername();
    }

    public String getDate()
    {
        return date.toString();
    }
}

