package projectCode;

import java.util.ArrayList;
import java.util.List;
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
    private ArrayList<Comment> replies;
    private ArrayList<Comment> commentThread;
    private List<Comment> comments = new ArrayList<>();

    /**
     * Parameter Constructor classes
     * Creates instances of the varibles associated with comment
     * @param comment the message from the user
     * @param user the person writing the comment
     * @param date the date the comment is written
     */

    // Constructor for a top-level comment
    public Comment(String comment, User user, Date date) {
        this.comment = comment;
        this.user = user;
        this.date = date;
        this.commentThread = new ArrayList<>();
        this.replies = new ArrayList<>();
    }

    // Constructor for a reply to a comment
    public Comment(String comment, User user, Date date, ArrayList<Comment> commentThread) {
        this.comment = comment;
        this.user = user;
        this.date = date;
        this.commentThread = commentThread;
        this.replies = new ArrayList<>();
    }


    /**
     * creates the new comment
     * @param comment message from the user
     * @param user comment writer
     * @param date when the comment was written
     * @param parentComment he list of comments off the comment
     */
    public Comment createNewComment(String comment, User user, Date date, Comment parentComment) {
        Comment newComment;
        if (parentComment == null) {
            // This is a top-level comment
            newComment = new Comment(comment, user, date);
        } else {
            // This is a reply to an existing comment
            ArrayList<Comment> commentThread = parentComment.getCommentThread();
            Comment replyComment = new Comment(comment, user, date);
            commentThread.add(replyComment);
            newComment = new Comment(comment, user, date, commentThread);
        }
        // Add the new comment to its parent's replies (or the top-level comments list if it's a top-level comment)
        if (parentComment == null) {
            comments.add(newComment);
        } else {
            parentComment.getReplies().add(newComment);
        }

        return newComment;
    }

    
    /**
     * Getters
     * List<Comment> comments
     * String comment
     * String user (from User class from getUserName method)
     * String date (from Date class from toString method)
     */

    public String getComment(){
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser(){
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date = date;
    }

    public ArrayList<Comment> getCommentThread() {
        return commentThread;
    }

    public void setCommentThread(ArrayList<Comment> commentThread) {
        this.commentThread = commentThread;
    }

    public ArrayList<Comment> getReplies() {
        return replies;
    }
    public void setReplies(ArrayList<Comment> replies) {
        this.replies = replies;
    }

}

