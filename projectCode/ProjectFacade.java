package projectCode;
import java.util.ArrayList;
import java.util.UUID;
public class ProjectFacade {
    private User user;
    private UserList userList;
    private TaskList taskList;
    private Project project;

    /* login method to check if user is valid user via username & password */
    public boolean login(String userName, String password)
    {
        if(userName != null && password !=null)
        {
            if(userList.login(userName, password)!=null)
            {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    
    }

    /* not sure how to logout */
    public boolean Logout(User user)
    {
        return true;

    }
    /* utilizes user class to create new user */
    public User createUser(UUID userID, String firstName, String lastName, String password, String username, String userType)
    {
        if(userID != null && firstName != null && lastName != null && password != null && userType != null)
        {
            return user.newUser(userID, firstName, lastName, password, username, userType);
        }
        else
            return null;
    }

    /* changes user type */
    public boolean changeType(User user)
    {
        if(user!=null)
        {
            if(user.changeType(user)==true)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
            return false;
    }

    /* not sure what this method is for? */
    public Project project(String projectID){
        return project(projectID);

    }
    
    /* adds user to project */
    public boolean joinProject(Project project)
    {
        if(user.joinProject(project)==true)
        {
            return true;
        }
        else
            return false;
    }
    /* removes user from project */
    public boolean leaveProject(Project project)
    {
        if(user.leaveProject(project)==true)
        {
            return true;
        }
        else 
            return false;
    }
    
    /* creates new colun */
    public Columns createColumn(Columns column, String title)
    {
        if(column != null && title != null)
        {
            return column.createColumn(column, title);
        }
        else
            return null;
        
    }
    /* removes pre-existing column */
    public void removeColumn(Columns column, String title)
    {
        if(column != null && title !=null )
        {
            column.removeColumn(column, title);
        }
    }
    
    /* changes tasks location in columns */
    public Columns changeColumn(Columns columnFrom, Columns columnsTo, Task task){
        if(columnFrom != null && columnsTo != null && task != null)
            return columnFrom.changeColumn(columnFrom, columnsTo, task);
        else
            return null;
    }

    public Task newTask(Task task){
        
        return newTask(task);
    }

    public Task newTask(String taskName, String description, String assignedUser, String document, TaskType type)
    {
        return 
    }

    public Comment addComment(String comment, User user, Task task){
        return addComment(comment, user, task);
    }

    public Task save(Task task){
        return save(task);
    }
}
