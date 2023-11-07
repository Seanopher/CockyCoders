package projectCode;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * @author Cocky Coders
 * runs the project with a testing scenario
 */
public class Driver {

    /**
     * Instance Fields
     */
    private ProjectFacade facade;
    private Project electric_Missles;
    private Project soap_Free_Washers;
    private Project air_Computers;
    private User atticus, none, finch;
    private ArrayList<Project> projects;

    /**
     * initializes the instance fields
     * creates the facade
     * creates 3 Users
     * creates 3 Projects
     */
    Driver(){
        facade = new ProjectFacade();
        atticus = new User("01", "Atticus", "Madden", "Madden23", "AMadden", "ADMIN");
        none = new User("02", "Me", "", "noUser", "Seanopher", "USER");
        finch = new User("03", "Atticus", "Finch", "FinchMan", "AtticusFinch25", "USER");
        electric_Missles = new Project("\t--------=ELECTRIC MISSILES=--------", "01", null);
        soap_Free_Washers = new Project("Soap Free Washers", "02", null);
        air_Computers = new Project("Air Computers", "03", null);   
    }

    /**
     * runs the scenario
     */
    public void run(){
        scenario();
    }

    /**
     * accesses facade class and allows atticus to access the 3 projects
     * accesses columns class to create 3 columns
     * accesses facade class to create 3 columns
     * 
     * creates a new user with user attributes
     * creates a new task with a task attributes then adds the new task
     * 
     * creates new date then add the new comment
     * 
     * creates new instance of task with task attributes then adds the new task
     * moves the task to new column
     * add 3 comments to task
     * 
     * creates new column then adds new column to a project
     * 
     * creates new task then adds task to column
     * move task to new column
     * 
     * in the try and catch:
     * creates new instances of projects, names it, makes a new file, then adds columns to the project
     * it will then write to the file
     */
    public void scenario(){
        facade.joinProject(electric_Missles, atticus);
        facade.joinProject(soap_Free_Washers, atticus);
        facade.joinProject(air_Computers, atticus);
        Columns toDo = new Columns("         --------= TO-DO =--------");
        Columns doing = new Columns("        --------= DOING =--------");
        Columns done = new Columns("         --------= DONE =--------");
        electric_Missles.addColumns(toDo);
        electric_Missles.addColumns(doing);
        electric_Missles.addColumns(done);
        facade.createColumn("To-Do");
        facade.createColumn("Doing");
        facade.createColumn("Done");

        User jeff = facade.createUser(UUID.randomUUID(), "Jeff", "Goldblum", "Goldblum41", "JGoldblum", "USER");
        Task initialize = new Task("Task: Initialize super algorithm to detonate at warp speed", "\n Description: MAKE SURE TO DETONATE AT WARP SPEED", jeff, "Document", TaskType.CODE);
        facade.addTask(toDo, initialize);
        Date date = new Date();
        facade.addComment("Avoid civilians Jeff!", atticus, date, initialize);

        Task curve = new Task("Task: Curve the metal to make a cylindrical shape", "\n Description: MAKE SURE TO WEAR GLOVES WHEN CURVING METAL", jeff, "Document", TaskType.CODE);
        facade.addTask(toDo, curve);
        facade.changeColumn(toDo, doing, curve);
        facade.addComment("Not cylindrical enough", jeff, date, curve);
        facade.addComment("What's a cylinder", finch, date, curve);
        facade.addComment("How about you do it jeff", atticus, date, curve);

        facade.createColumn("Abandoned");
        Columns abandoned = new Columns("       --------= ABANDONED =--------");
        electric_Missles.addColumns(abandoned);
        
        Task burger = new Task("Task: Make impossible burger possible", "\n Description: IS IT POSSIBLE?", none, "Document", TaskType.CODE);
        facade.addTask(toDo, burger);
        facade.changeColumn(toDo, abandoned, burger);
            
        try {
            ArrayList<String> atticusProjects = facade.displayUserProjects(atticus);
            String project1 = atticusProjects.get(0);
            FileWriter writer = new FileWriter("output.txt");
            ArrayList<String> columns = facade.displayColumns(electric_Missles, initialize);
            
            writer.write("  ************** CODE MISSION POSSIBLE **************"+"\n");
            writer.write(project1+"\n");
            for(int i=0; i<columns.size(); i++)
            {
                writer.write(columns.get(i) +" \n");
            }
            writer.close();
        }
        
        catch(Exception e) {
            e.getStackTrace();
        }
    }

    // main method that runs the project
    // public static void main(String[] args) {
    //     Driver driver = new Driver();
    //     driver.run();
    // }
}
