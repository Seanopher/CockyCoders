package projectCode;
import java.util.ArrayList;
//add the built in date function
import java.util.Date;
import java.util.UUID;
//added more imports statements
import java.io.IOException;
import java.io.FileWriter;
import org.json.simple.JSONObject;
import java.util.HashMap;
import java.util.List;

public class Task {
    protected UUID taskID;
    public String taskName;
    public String description;
    public User assignedUser;
    public ArrayList<String> backLog;
    public Date date;
    public String document;
    public ArrayList<Comment> comments;
    public TaskType taskType;
    private ArrayList<Task> history;

    public Task newTask(String taskName, String description, User assignedUser, String document, TaskType taskType){
        if ( taskName != null && description != null && assignedUser != null && document != null && taskType != null){
            this.taskName = taskName;
            this.description = description;
            this.assignedUser = assignedUser;
            this.document = document;
            this.taskType = taskType;
            return newTask(taskName, description, assignedUser, document, taskType);
        }
        return null;
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

    //is not included ??? 
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
    
    //changed to a void (was String) to only change 
    public void comment(String comment){
        Comment newComment = new Comment();
        comments.add(newComment);
    }
}
