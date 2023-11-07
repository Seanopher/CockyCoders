package projectCode;

import java.util.ArrayList;

/**
 * @author Cocky Coders
 * a task list class that creates a list of tasks and adds them to a list
 */
public class TaskList {

    /**
     * Instance Fields
     */
    private static TaskList taskList;
    private ArrayList<Task> tasks;
    private DataLoader dataLoader;

    /**
     * constructor method
     */
    private TaskList(){
        dataLoader = new DataLoader(); 
        tasks = dataLoader.loadTasks();
    }

    /**
     * Getters
     * Instance: tests if task list is null then returns the task list
     * Returns the ArrayList of Tasks
     * task: takes in task name runs through list and tests if the name is the same as the task name
     */
    public static TaskList getInstance(){
        if(taskList == null)
            taskList = new TaskList();
        return taskList;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public Task getTask(String taskName){
        for(Task task : tasks){
            if(task.getName().equalsIgnoreCase(taskName))
                return task;
        }

        return null;
    }
}


