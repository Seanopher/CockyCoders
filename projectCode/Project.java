package projectCode;

import java.util.UUID;
import java.util.ArrayList;

/**
 * @author Cocky Coders
 * project class that will encase the columns, tasks, comments, and the users associated to the project
 */
public class Project {

    /**
     * Instance Fields
     */
    public String name;
    public String pID;
    protected UUID projectID;
    protected ArrayList<User> users;
    protected ArrayList<Columns> column;
    private static Project project;
    public User user;
    
    /**
     * parameter constructor 
     * checks to see if the name and project are null then sets them
     * sets the user and column variable
     * @param name project name 
     * @param projectID unique id of project
     * @param users user on the project
     */
    public Project(String name, String projectID, ArrayList<User> users){
        if(name != null && projectID != null){
            this.name = name;
            this.pID = projectID.toString();
            
        }
        this.users = users;
        this.column = new ArrayList<Columns>();
    }

    /**
     * creates a new project
     * @param name
     * @param projectID
     * @param users
     * @param column
     */
    // public void newProject(String name, String projectID, ArrayList<User> users, ArrayList<Columns> column){
    //     this.name = name;
    //     this.pID = projectID;
    //     this.users = users;
    //     this.column = column;
    // } newProject(String, String, ArrayList<User>, ArrayList<Columns>)

    public Project newProject(String name, String projectID, ArrayList<User> users, ArrayList<Columns> column){
        Project project = new Project(name, projectID, users);
        project.setColumns(column);
        return project;
    }



    /**
     * Getters
     * String name (projectName)
     * String pID (projectID)
     */
    public String getProjectName(){
        return name;
    }
    public String getProjectID(){
        return pID;
    }
    public ArrayList<User> getUsers(){
        return users;
    }
    public String getUserName(){
        return user.getUsername();
    }
    
    public ArrayList<Columns> getColumns(){
        return column;
    }
    

    /**
     * Setters
     * @param column
     */
    public void setColumns(ArrayList<Columns> column){
        this.column = column;
    }

    /**
     * prints out the users in the project
     */
    public void displayUsers(){
        for(int i = 0; i < users.size(); ++i){
            System.out.println(users.get(i).getUsername());
        }
    }
    
    /**
     * adds a new column to the column list
     * @param newColumn
     */
    public void addColumns(Columns newColumn){
        column.add(newColumn);
    }
    
    /**
     * sends how the columns will look to the driver
     * @param task from Task class
     * @return column list
     */
    public ArrayList<String> displayColumns(Task task){
        ArrayList<String> columnList = new ArrayList<String>();
        for(int i = 0; i < column.size(); ++i)
        {
            columnList.add(column.get(i).displayTasks(task));
        }

        return columnList;
    }
 
}   
