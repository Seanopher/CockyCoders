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

    public Task newTask(String taskName, String description, String assignedUser, String document, Task taskType){
        return newTask(taskName, description, assignedUser, document, taskType);
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



    /* 
    //Taking out this method
    public void addPoint(User user){

    }
    */



    
    public Columns changeColumn(Columns columnFrom, Columns columnsTo, Task task, Columns title){
        if (columnFrom.hash_map.containsKey(task)) {

            task.put(columnFrom, column.get(columnsTo));
            //task.put(columnTo, column.put() );

            // Remove the task from the source column
            //columnFrom.remove(task);
    
            // Add the task to the destination column (columnTo)
            //columnsTo.add(task);
        }
        //return changeColumn(columnFrom, columnsTo, task);
        else 
            return changeColumn(columnsTo, columnsTo, task);
    } 
    
    

    //changed to a void (was String) to only change 
    public void comment(String comment){
        Comment newComment = new Comment();
        comments.add(newComment);
    }

/* 
//These methods might be impemented later 

    // changed to void from "Task". 
    public void save(Task task){
        JSONObject taskJSON = DataWriter.getTaskJSON(this);

        try (FileWriter file = new FileWriter(DataConstants.TASK_FILE_NAME)) {
            file.write(taskJSON.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Task accessHistory(Task task, User user){
        return accessHistory(task, user);
    }
*/
    



}
