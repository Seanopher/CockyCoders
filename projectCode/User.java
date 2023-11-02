package projectCode;
import java.util.ArrayList;
import java.util.UUID;

/** 
 * @author Cocky Coders
 * creates new user,
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
            User temp = new User(userType, firstName, lastName, password, username, userType);
            this.UUID = userID;
            this.userID = userID.toString();
            this.firstName = firstName;
            this.lastName = lastName;
            this.password = password;
            this.username = username;
            this.userType = userType;
            return temp;
        }
        return null;

    }
    
    /*
     * method that you call when you have already created a user and are just looking to return the user.
     * takes in their UUID, firstname, lastName, password, 
         * and user type
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

    /*
     * takes in a project and removes it from the users projectList
     */
    /**
     * 
     * @param project
     * @return
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
    /*
     * takes in a user and changes their type
     */
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
