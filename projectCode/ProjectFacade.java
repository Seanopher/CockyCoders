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
    public boolean joinProject(Project project, User user)
    {
        if(user.joinProject(project)==true)
        {
            return true;
        }
        else
            return false;
    }
    /* removes user from project */
    public boolean leaveProject(Project project, User user)
    {
        if(user.leaveProject(project)==true)
        {
            return true;
        }
        else 
            return false;
    }
    
    /* creates new colun */
    public Columns createColumn(String title)
    {
        if (title!=null)
        {
            return createColumn(title);
        }
        else
            return null;
        
        
    }
    /* removes pre-existing column */
    public void removeColumn(Columns column, String title)
    {
        if(column != null && title !=null )
        {
            column.removeColumn(title);
        }
    }
    
    /* changes tasks location in columns */
    public Columns changeColumn(Columns columnFrom, Columns columnsTo, Task task){
        if(columnFrom != null && columnsTo != null && task != null)
            return columnFrom.changeColumn(columnFrom, columnsTo, task);
        else
            return null;
    }

    /* creates new task */
    public Task newTask(String taskName, String description, User assignedUser, String document, TaskType taskType)
    {
        Task temp = new Task();
        temp.newTask(taskName, description, assignedUser, document, taskType);
        return temp;
    }
    /* adds task to column */
    public boolean addTask(Columns column, Task task)
    {
        if(column.addTasks(task)==true)
        {
            return true;
        }
        else
            return false;
    }

    public Comment addComment(String comment, User user, String date, Task task)
    {
        Comment temp = new Comment(comment, user, date);
        task.comment(temp);
        return temp;
    }


    public Columns addTask(Task task)
    {
        return addTask(task);
    }

    public Columns removeTask(Task task)
    {
        return removeTask(task);
    }

    public Task save(Task task){
        return save(task);
    }
}
