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

    
}
