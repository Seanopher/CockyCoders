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
    


    public Project(String name, UUID projectID, UserList users)
    {
        if(name != null && projectID != null && users != null)
        {
            this.name = name;
            this.pID = projectID.toString();
            this.users = UserList.getInstance();
        }
    }
    public boolean saveProject(Project project){
        return DataWriter.saveProject();
    }
    public static getInstance(String name, String projectID, UserList users){
        if(project == null){
            project = new Project();
        }
    }
    
    
}   
