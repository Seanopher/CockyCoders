package projectCode;
import java.util.ArrayList;

/**
 * @author Cocky Coders
 * it allows for the creation and removal of columns
 */
public class Columns {

    private ArrayList<Task> tasks;
    private String title;
    private ArrayList<String> titles;

    /**
     * this is the parameter constructor method
     * it takes in title for the arraylist that it wants
     * @param title the parameter
     */
    public Columns(String title) {
        this.tasks = new ArrayList<>();
        this.title = title;
        this.titles = new ArrayList<>();
    }

    /**
     * getters and setters
     * ArrayList<Task> tasks
     * String title
     * ArrayList<String> titles
     */
    public ArrayList<Task> getTasks()
    {
        return tasks;
    }
    public void setTasks(ArrayList<Task> tasks){
        this.tasks = tasks;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public ArrayList<String> getTitles(){
        return titles;
    }
    public void setTitles(ArrayList<String> titles){
        this.titles = titles;
    }

    /**
     * it checks to see if the column exists
     * if it exists it adds a number to the back of it
     * 
     * adds the new title to the array list of titles
     * 
     * @param title takes in user input and tests it
     * @return the instance of this
     */
    public Columns createColumn(String title){
        this.titles.add(title);
        return this;
    }

    /**
     * finds the location of the column by its title name
     * deletes the column
     * @param title taken in from user to see if it exists then deletes it
     * @return the instance of this
     */
    public Columns removeColumn(String title){
        int loc = this.titles.indexOf(title);
        this.titles.remove(loc);

        return this;
    }

    /**
     * moves task from one column to another
     * @param columnFrom where the task is
     * @param columnTo where they want to move the task to
     * @param task the task they are moveing
     * @return instance
     */
    public Columns changeColumn(Columns columnFrom, Columns columnTo, Task task){
        int loc = columnFrom.getTasks().indexOf(task);
        columnTo.getTasks().add(task);
        columnFrom.getTasks().remove(loc);
        
        return this;
    }

    /**
     * finds the task that they want to remove
     * then removes if true and returns true or returns false
     * @param task user input
     * @return if true or false
     */
    public boolean addTasks(Task task){
        if(task !=null){
            tasks.add(task);
            return true;
        }
        return false;
    }

    /**
     * finds the task that they want to remove
     * then removes if true and returns true or returns false
     * @param task user input
     * @return if true or false
     */
    public boolean removeTasks(Task task){
        if(tasks.contains(task)){
        tasks.remove(task);
        return true;
        }
        return false;
    }

    public String displayTasks(Task task){
        ArrayList<String> taskList = new ArrayList<String>();
        taskList.add(title + "\n");
        for(int i = 0; i < tasks.size(); ++i)
        {
            taskList.add(tasks.get(i).getName() + ": "+ tasks.get(i).getDescription() + "\n " +task.getAssignedUser().getFirstName()
            +" "+task.getAssignedUser().getLastName()+"\n"+tasks.get(i).displayComments(task));
        }
        return taskList.toString().replace("[", "").replace("]", "").replace(",", "");
    }
}
