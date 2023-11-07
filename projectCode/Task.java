package projectCode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Cocky Coders
 * Creates the object task and assigns user varibles to the task
 */
public class Task {

    /**
     * Instance Fields
     */
    protected UUID taskID;
    public String taskName;
    public String description;
    private List<UUID> assignedUserIDs;
    private Date taskDate;
    public String document;
    public List<Comment> comments;
    public TaskType taskType;
    //private ArrayList<Task> history; never used

    /**
     * Creates a new task
     * @param taskName The name of the task
     * @param description The descriotion that will be held by task
     * @param assignedUser The user that is being assigned the task
     * @param document The document being used by task
     * @param taskType The type of the task, so it can be idenified by the user
     * @return a new task
     */

    public Task(UUID taskID, String taskName, String description, List<UUID> assignedUserIDs, String document, Date taskDate, TaskType taskType, List<Comment> comments) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.description = description;
        this.assignedUserIDs = assignedUserIDs;
        this.document = document;
        this.taskDate = taskDate;
        this.taskType = taskType;
        this.comments = comments;
    }

    /**
     * getters
     */
    public String getName(){
        return taskName;
    }
    public UUID getID(){
        return taskID;
    }
    public String getDescription(){
        return description;
    }
    public List<UUID> getAssignedUsers(){
        return assignedUserIDs;
    }
    public Date getDate(){
        return taskDate;
    }
    public String getDueDate(){
        return null;
    }
    public String getDocument(){
        return document;
    }
    public TaskType getTaskType(){
        return taskType;
    }
    public List<Comment> getComments(){
        return comments;
    }

    /** 
    * changed to a void (was String) to only change
    * @param Comment uses comment to call the class and method
    */
    public void comment(Comment comment){
        comments.add(comment);
    }

    /**
     * adds comments
     * @param comment
     * @param user
     * @param date
     */
    public void addComment(String comment, User user, Date date) {
        Comment newComment = new Comment(comment, user, date);
        comments.add(newComment);
    }

    /**
     * displays comments
     * @param task
     * @return concatination of comments
     */
    public String displayComments(Task task){
       ArrayList<String> commentList = new ArrayList<String>();
       String concat = "";
        for(int i = 0; i < comments.size(); ++i){
            commentList.add(comments.get(i).getComment() + " ("+comments.get(i).getUser()+")  |"+comments.get(i).getDate()+"|");
            concat += "     -" + commentList.get(i) + "\n";
        }
        return concat;
    }
}
