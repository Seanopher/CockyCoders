package projectCode;

import java.util.Date;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Cocky Coders
 * the facade of what the user will see so they can not see or interact with the code directly
 */
public class ProjectFacade {
    
    /**
     * Instance Fields
     */
    private User user;
    private UserList userList;
    private Columns column;
    private Task task;
    private Comment comment;
    private TaskList taskList;
    private Project project;

    /**
     * log-in function
     * check if the username and password matches what the program already has
     * @param userName input from user
     * @param password input from user
     * @return true or false
     */
    public boolean login(String userName, String password){
        if(userName != null && password !=null){
            if(userList.login(userName, password)!=null)
                return true;
            else
                return false;
        }
        else
            return false;
    }

    /**
     * calls data writer to log out and saves the log out
     * @param user user to log out
     * @return true for log out
     */
    public boolean Logout(User user){
        return true;
    }
    
    /**
     * creates a new user 
     * makes a new user with user attributes and tests if null or not
     * @param userID uuid
     * @param firstName user first name
     * @param lastName user last name
     * @param password user password
     * @param username user username
     * @param userType user type
     * @return the user or null
     */
    public User createUser(UUID userID, String firstName, String lastName, String password, String username, String userType){
        user = new User(userType, firstName, lastName, password, username, userType);
        if(userID != null && firstName != null && lastName != null && password != null && userType != null)
            return user;
        else
            return null;
    }

    /**
     * changes the user's type (admin or user)
     * @param user the user from User class
     * @return true or false
     */
    public boolean changeType(User user){
        if(user!=null){
            if(user.changeType(user)==true)
                return true;
            else
                return false;
        }
        else
            return false;
    }

    /**
     * creates a project
     * @param projectID takes in the projects unique ID
     * @return the project
     */
    public Project project(String projectID){
        return project(projectID);
    }
    
    /**
     * adds a user to the project
     * @param project project being joined
     * @param user user joining
     * @return true or false
     */
    public boolean joinProject(Project project, User user){
        if(user.joinProject(project)==true)
            return true;
        else
            return false;
    }
    
    /**
     * removes a user from a project
     * @param project the project going to be left
     * @param user user leaving 
     * @return true of false
     */
    public boolean leaveProject(Project project, User user){
        if(user.leaveProject(project)==true)
            return true;
        else 
            return false;
    }
    
    /**
     * creates a column
     * creates new instance and tests if title is null
     * @param title column title
     * @return creates new column or returns null
     */
    public Columns createColumn(String title){
        Columns column = new Columns(title);
        if (title!=null)
            return column.createColumn(title);
        else
            return null;
    }
    
    /**
     * removes a column
     * tests if column and title are null then removes
     * else it will do nothing
     * @param column from column class
     * @param title column title
     */
    public void removeColumn(Columns column, String title){
        if(column != null && title !=null )
            column.removeColumn(title);
    }
    
    /**
     * moves a task from a column to a new column
     * @param columnFrom where the task is located
     * @param columnsTo where its being moved to
     * @param task the task being moved
     * @return runs the moving of column
     */
    public Columns changeColumn(Columns columnFrom, Columns columnsTo, Task task){
        if(columnFrom != null && columnsTo != null && task != null)
            return columnFrom.changeColumn(columnFrom, columnsTo, task);
        else
            return null;
    }

    /**
     * adds a task to a column
     * @param column from columns class
     * @param task from task class
     * @return true or false
     */
    public boolean addTask(Columns column, Task task){
        if(column.addTasks(task)==true)
            return true;
        else
            return false;
    }

    /**
     * adds a comment to a task
     * @param comment message
     * @param user user that wrote message
     * @param date date of comment
     * @param task task its commenting on
     * @return temp
     */
    public Comment addComment(String comment, User user, Date date, Task task){
        Comment temp = new Comment(comment, user, date);
        task.comment(temp);
        return temp;
    }

    /**
     * adds a task
     * @param task from task class
     * @return adds task
     */
    public Columns addTask(Task task){
        return addTask(task);
    }

    /**
     * removes a task
     * @param task from task class
     * @return removes the task
     */
    public Columns removeTask(Task task){
        return removeTask(task);
    }

    /**
     * Display methods
     * displayUserProjects takes in a user, creates an array, then returns the projects owned by the user
     * displayColumns takes in a project and task, creates an array, then returns the columns
     */
    public ArrayList<String> displayUserProjects(User user) {
        ArrayList<String> userProjects = user.displayProjects(user);
        return userProjects;
    }
    public ArrayList<String> displayColumns(Project project, Task task){
        ArrayList<String> columns = project.displayColumns(task);
        return columns;
    }

    /**
     * saves the task
     * @param task from task
     * @return saves task
     */
    public Task save(Task task){
        return save(task);
    }
}
