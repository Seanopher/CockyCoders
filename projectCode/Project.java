package projectCode;
import java.util.UUID;
import java.util.ArrayList;
import java.util.HashMap;
public class Project 
{
    public String name;
    public String pID;
    protected UUID projectID;
    protected UserList users;
    protected ArrayList<Columns> column;
    protected HashMap<String, TaskList> columns;
    private static Project project;
    

    /*
     * Takes in name, project id, and a userlist, just a default constructor
     */
    public Project(String name, String projectID, UserList users)
    {
        if(name != null && projectID != null && users != null)
        {
            this.name = name;
            this.pID = projectID.toString();
            this.users = UserList.getInstance();
        }
    }

    /*
     * Takes in a name, projectID, and users
     */
    public static Project getInstance(String name, String projectID, UserList users){
        if(project == null){
            project = new Project(name, projectID, users);
            return project;
        }
        return null;
    }



    //Basic getters
    public String getProjectName(){
        return name;
    }

    public String getProjectID(){
        return pID;
    }


//These bottom two are set to null as placeholders 
    public UserList getUsers() {
        return users;
    }
    public String getColumns(){
        return null;//columns;
    }
 
}   
