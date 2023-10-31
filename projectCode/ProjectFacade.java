package projectCode;
import java.util.ArrayList;
public class ProjectFacade {
    private User user;
    private UserList userList;
    private TaskList taskList;
    private Project project;

    public User login(String userName, String password){
        return login(userName, password);
    }
    public boolean Logout(User user){
        return true;

    }

    public User createUser(String firstName, String lastName, String userName, String password, int userId){
        return createUser(firstName, lastName, userName, password, userId);
    }
    public Project project(String name){
        return project(name);

    }

    public Project joinProject(Project project){
        return project;
    }

    public void leaveProject(Project project){

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
