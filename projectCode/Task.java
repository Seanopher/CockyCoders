package projectCode;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
/**
 * @author Hughes
 * Creates the object task and assigns user varibles to the task
 */
public class Task {
    protected UUID taskID;
    public String taskName;
    public String description;
    public User assignedUser;
    //public ArrayList<String> backLog;
    public Date date;
    public String document;
    public ArrayList<Comment> comments;
    public TaskType taskType;
    //private ArrayList<Task> history;
    /**
     * Creates a new task
     * @param taskName The name of the task
     * @param description The descriotion that will be held by task
     * @param assignedUser The user that is being assigned the task
     * @param document The document being used by task
     * @param taskType The type of the task, so it can be idenified by the user
     * @return a new task
     */

    public void newTask(String taskName, String description, User assignedUser, String document, TaskType taskType, ArrayList<Comment> comments){
        if ( taskName != null && description != null && assignedUser != null && document != null && taskType != null){
            
            this.taskName = taskName;
            this.description = description;
            this.assignedUser = assignedUser;
            this.document = document;
            this.taskType = taskType;
            this.comments = new ArrayList<>();
            
        }
        
    }

    public Task(String taskName, String description, User assignedUser, String document, TaskType taskType)
    {
        if(taskName != null && description != null && assignedUser != null && document != null && taskType != null)
        {
        this.comments = new ArrayList<Comment>();
        this.taskName = taskName;
        this.description = description;
        this.assignedUser = assignedUser;
        this.document = document;
        this.taskType = taskType;
        }
    }


    //Basic getters
    public String getName(){
        return taskName;
    }
    public String getDescription(){
        return description;
    }
    public User getAssignedUser(){
        return assignedUser;
    }
    public Date getDate(){
        return date;
    }
    //Adding here to satisfy DataWriter
    public String getDueDate(){
        return null;
    }
    public String getDocument(){
        return document;
    }
    public TaskType getTaskType(){
        return taskType;
    }
    public ArrayList<Comment> getComments(){
        return comments;
    }
    /** 
    * changed to a void (was String) to only change
    * @param Comment uses comment to call the class and method
    */
    public void comment(Comment comment){
        comments.add(comment);
    }
    public void addComment(String comment, User user, Date date) {
        Comment newComment = new Comment(comment, user, date);
        comments.add(newComment);
    }
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
