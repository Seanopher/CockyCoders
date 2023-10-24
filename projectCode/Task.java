package projectCode;
import java.util.ArrayList;
import java.util.UUID;
//added more imports statements
import java.io.IOException;
import java.io.FileWriter;
import org.json.simple.JSONObject;


public class Task {
    protected UUID taskID;
    public String taskName;
    public String description;
    public User assignedUser;
    public ArrayList<String> backLog;
    public String date;
    public String document;
    public ArrayList<Comment> comments;
    public TaskType taskType;
    private ArrayList<Task> history;

    public Task newTask(String taskName, String description, String assignedUser, String document, Task taskType){
        return newTask(taskName, description, assignedUser, document, taskType);
    }

    /* 
    //Taking out this method
    public void addPoint(User user){

    }
    */
    
    public Columns changeColumn(Columns columnFrom, Columns columnsTo){
        return changeColumn(columnFrom, columnsTo);
    }

    //changed to a void (was String) to only change 
    public void comment(String comment){
        Comment newComment = new Comment();
        comments.add(newComment);
    }

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

    
}
