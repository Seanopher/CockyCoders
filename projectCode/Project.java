package projectCode;
import java.util.UUID;
import java.util.ArrayList;
public class Project {
    public String name;
    protected UUID projectID;
    protected ArrayList<User> users;


    public void Project(String name, UUID projectid, ArrayList<User> users){

    }
    
    public Columns createColumn(Columns column, String title){
        return column;
    }

    public Columns removeColumn(Columns column, String title){
        return column;
    }
    


//Basic getters
public String getProjectName(){
    return name;
}


//These bottom two are set to null as placeholders 
public ArrayList<User> getUsers() {
    return users;
}
public String getColumns(){
    return null;//columns;
}
 
}   
