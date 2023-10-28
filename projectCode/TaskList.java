package projectCode;
import java.util.ArrayList;
public class TaskList {
    private static TaskList taskList;
    private ArrayList<Task> tasks;

    private TaskList()
    {
        tasks = new ArrayList<>();
    }
    public static TaskList getInstance()
    {
        if(taskList == null)
        {
            taskList = new TaskList();
        }
        return taskList;
    }

    public Task getTask(String taskName)
    {
        for(Task task : tasks)
        {
            if(task.getName().equalsIgnoreCase(taskName))
            {
                return task;
            }

        }
        return null;
    }
}
