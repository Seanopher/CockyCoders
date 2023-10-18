package projectCode;
import java.util.ArrayList;
import java.util.UUID;

public class User {
    private String firstName;
    private String lastName; 
    private UUID UUID;
    private String userID;
    private String password;
    private UserType userType;
    private ArrayList<Project> projects;
    


        //ask if order matters on JSON files. If so change order to match JSON
        /*
         * creates a new user takes in a UUID, their firstname, their lastName, their password, 
         * and their user type, use when need to make a new user
         */
    public User newUser(UUID userID, String firstName, String lastName, String password, UserType userType)
    {
        if(userID != null && firstName != null && lastName != null && password != null && userType != null){
            this.UUID = userID;
            this.userID = userID.toString();
            this.firstName = firstName;
            this.lastName = lastName;
            this.password = password;
            this.userType = userType;
            return newUser(userID, firstName, lastName, password, userType);
        }
        return null;

    }
    /*
     * method that you call when you have already created a user and are just looking to return the user.
     * takes in their UUID, firstname, lastName, password, 
         * and user type
     */
    public User(String userID, String firstName, String lastName, String password, UserType userType)
    {
        if(userID != null && firstName != null && lastName != null && password != null && userType != null)
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;

    }
    /*
     * basic getters.
     */
    public String getUUID()
    {
        return userID;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getPassword()
    {
        return password;
    }
    public UserType getUserType()
    {
        return userType;
    }
    
    /*
     * takes in a project and adds it to the users ProjectList
     */
    public boolean joinProject(Project project)
    {
        if(project != null){
            projects.add(project);
            return true;
        }
        return false;
    }
    /*
     * takes in a project and removes it from the users projectList
     */
    public boolean leaveProject(Project project)
    {
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
    public boolean changeType(User user)
    {
        if(user.userType == UserType.ADMIN){
            user.userType = UserType.USER;
            return true;
        }
        else if(user.userType == UserType.USER){
            user.userType = UserType.ADMIN;
            return true;
        }
        return false;
        }
}
