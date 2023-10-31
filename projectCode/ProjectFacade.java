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

    public boolean Logout(User user)
    {
        return true;

    }
    /* utilizes user class to create new user */
    public User createUser(UUID userID, String firstName, String lastName, String password, String username, UserType userType)
    {
        if(userID != null && firstName != null && lastName != null && password != null && userType != null)
        {
            return user.newUser(userID, firstName, lastName, password, username, userType);
        }
        else
            return null;
    }

    public Project project(String name){
        return project(name);

    }

    public boolean joinProject(Project project){
    }

    public boolean leaveProject(Project project){
    }

    public void removePermission(User user, UserType type){

    }

    public void addPermission(User user, UserType type){

    }
    
    public Task newTask(Task task){
        return newTask(task);
    }

    public Columns createColumn(Columns column, String title){
        return column;
    }

    public Columns removeColumn(Columns column, String title){
        return column;
    }
    
    public Comment addComment(String comment, User user, Task task){
        return addComment(comment, user, task);
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
