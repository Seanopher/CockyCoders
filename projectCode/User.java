package projectCode;
import java.util.ArrayList;
import java.util.UUID;

/** 
 * @author Cocky Coders
 * creates new user, allowsusers in and out of projects, and sets the user type
 */
public class User {
    private String firstName;
    private String lastName; 
    private UUID UUID;
    private String username;
    private String userID;
    private String password;
    private String userType;
    private ArrayList<Project> projects;
    protected UserList userList;

    /**
     * user constructor
     * @param userID
     * @param firstName
     * @param lastName
     * @param password
     * @param username
     * @param userType
     */
    public User(String userID, String firstName, String lastName, String password, String username, String userType)
    {
        if(userID != null && firstName != null && lastName != null && password != null && userType != null)
        {

        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.username = username;
        }
    }

    /**
     * creates a new user by taking in parameters
     * @param userID
     * @param firstName
     * @param lastName
     * @param password
     * @param username
     * @param userType
     * @return
     */
    public User newUser(UUID userID, String firstName, String lastName, String password, String username, String userType)
    {
        if(userID != null && firstName != null && lastName != null && password != null && userType != null)
        {
            this.UUID = userID;
            this.userID = userID.toString();
            this.firstName = firstName;
            this.lastName = lastName;
            this.password = password;
            this.username = username;
            this.userType = userType;
            return newUser(userID, firstName, lastName, password, username, userType);
        }
        return null;

    }
    
    /**
     * Getters
     */
    public User getUser(UUID userID){
        return userList.getUser(UUID);
    }
    public String getUUID(){
        return userID;
    }
    public String getUsername(){
        return username;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getPassword(){
        return password;
    }
    public String getUserType(){
        return userType;
    }
    
    /*
     * takes in a project and adds it to the users ProjectList
     */
    public boolean joinProject(Project project){
        if(project != null){
            projects.add(project);
            return true;
        }
        return false;
    }

    /**
     * boolean that verifies if the user is a part of the project or not
     * user leaves a project by removing it from their project list
     * @param project user input
     * @return true or false
     */
    public boolean leaveProject(Project project){
        for(int i = 0; i < projects.size(); i++){
            if(project.name.equalsIgnoreCase(projects.get(i).name)){
                projects.remove(i);
                return true;
            }
        }
        return false;
    }
    
    /**
     * changes a user type and returns a boolean
     * @param user user input
     * @return if true or false
     */
    public boolean changeType(User user){
        if(user.userType.equalsIgnoreCase("admin")){
            user.userType = "user";
            return true;
        }
        else if(user.userType.equalsIgnoreCase("user")){
            user.userType = "admin";
            return true;
        }
        return false;
    }
}
