package projectCode;
import java.util.UUID;
import java.util.ArrayList;
public class Project 
{
    public String name;
    protected UUID projectID;
    protected ArrayList<User> users;
    


    public Project(String name, UUID projectID, ArrayList<User> users)
    {
        if(name != null && projectID != null && users != null)
        {
            this.name = name;
            this.projectID = projectID;
            this.users = users;
        }
    }
    
    public Columns createColumn(Columns column, String title){
        return column;
    }

    public Columns removeColumn(Columns column, String title){
        return column;
    }
    
}   
