package projectCode;
import java.util.ArrayList;
public class User {
    private String firstName;
    private String lastName; 
    private String userName;
    private int UUID;
    private String password;
    private ArrayList<Project> projects;


    public void User(String firstName, String lastName, String userName, String password, int userId){
         
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
}
