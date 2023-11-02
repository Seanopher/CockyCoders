package projectCode;
import java.util.UUID;
import java.util.ArrayList;
public class Project 
{
    public String name;
    public String pID;
    protected UUID projectID;
    protected ArrayList<User> users;
    protected ArrayList<Columns> column;
    private static Project project;
    

    /*
     * Takes in name, project id, and a userlist, just a default constructor
     */
    public Project(String name, String projectID, ArrayList<User> users)
    {
        if(name != null && projectID != null)
        {
            this.name = name;
            this.pID = projectID.toString();
            
        }
        this.users = users;
        this.column = new ArrayList<Columns>();
    }

    /*
     * Takes in a name, projectID, and users
     */
    public static Project getInstance(String name, String projectID, ArrayList<User> users){
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
    public ArrayList<User> getUsers() {
        return users;
    }


    public void displayUsers()
    {
        for(int i = 0; i < users.size(); ++i)
        {
            System.out.println(users.get(i).getUsername());
        }
    }
    

    public void addColumns(Columns newColumn)
    {
        column.add(newColumn);
    }
    public ArrayList<Columns> getColumns()
    {
        return column;
    }
    public void displayColumns()
    {
        for(int i = 0; i < column.size(); ++i)
        {
            column.get(i).displayColumns();
        }
    }
 
}   
