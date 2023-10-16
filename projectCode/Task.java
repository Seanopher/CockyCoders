package projectCode;
import java.util.ArrayList;
import java.util.UUID;
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

    public void addPoint(User user){

    }

    public Columns changeColumn(Columns columnFrom, Columns columnsTo){
        return changeColumn(columnFrom, columnsTo);
    }

    public String comment(String comment){
        return comment;
    }

    public Task save(Task task){
        return save(task);
    }

    public Task accessHistory(Task task, User user){
        return accessHistory(task, user);
    }

    
}
