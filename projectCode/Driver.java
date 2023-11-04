package projectCode;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Driver {
    private ProjectFacade facade;
    private Project electric_Missles;
    private Project soap_Free_Washers;
    private Project air_Computers;
    private User atticus, none;
    private ArrayList<Project> projects;



    Driver(){
        facade = new ProjectFacade();
        atticus = new User("01", "Atticus", "Madden", "Madden23", "AMadden", "ADMIN");
        none = new User("02", "Unassigned", "", "noUser", "unAssigned", "USER");
        electric_Missles = new Project("\t--------=ELECTRIC MISSILES=--------", "01", null);
        soap_Free_Washers = new Project("Soap Free Washers", "02", null);
        air_Computers = new Project("Air Computers", "03", null);
        
    }
    public void run(){
        scenario();
    }

    public void scenario(){
        

        //System.out.println(atticus.getFirstName() + " " + atticus.getLastName() + " is logged in");


        facade.joinProject(electric_Missles, atticus);
        facade.joinProject(soap_Free_Washers, atticus);
        facade.joinProject(air_Computers, atticus);
        Columns toDo = new Columns("\t \t---= TO-DO =---");
        Columns doing = new Columns("\t \t---= DOING =---");
        Columns done = new Columns("\t \t---= DONE =---");
        electric_Missles.addColumns(toDo);
        electric_Missles.addColumns(doing);
        electric_Missles.addColumns(done);
        facade.createColumn("To-Do");
        facade.createColumn("Doing");
        facade.createColumn("Done");

        /* Add a new task "Initialize super algorithm to detonate at warp speed". Assign the task to Jeff Goldblum. */
        User jeff = facade.createUser(UUID.randomUUID(), "John", "Goldblum", "Goldblum41", "JGoldblum", "USER");
        Task initialize = new Task("*Initialize super algorithm to detonate at warp speed.", "Description", jeff, "Document", TaskType.CODE);
        facade.addTask(toDo, initialize);
        /* Add a comment to the task "Avoid civilians Jeff!" */
        Date date = new Date();
        facade.addComment("Avoid civilians Jeff!", jeff, date, initialize);

        /* Move the existing task of "Curve the metal to make a cylindrical shape" to the 'Doing' column. */
        /* This task has the existing comments of "Not cylindrical enough" - by Jeff, and "What's a cylinder" by Atticus Finch. */
        /* Reply to Jeff's comment and say "How about you do it jeff", and re-assign the task from yourself to Jeff. */
        Task curve = new Task("*Curve the metal to make a cylindrical shape", "Description", jeff, "Document", TaskType.CODE);
        facade.addTask(toDo, curve);
        facade.changeColumn(toDo, doing, curve);
        facade.addComment("Not cylindrical enough", jeff, date, curve);
        facade.addComment("What's a cylinder", atticus, date, curve);
        facade.addComment("How about you do it jeff", atticus, date, curve);

        /* Add a new column called "Abandoned"
        Move an existing task "Make impossible burger possible" which doesn't really relate to the project purpose to "Abandoned" */
        facade.createColumn("Abandoned");
        Columns abandoned = new Columns("\t \t---= ABANDONED =---");
        electric_Missles.addColumns(abandoned);
        
        Task burger = new Task("*Make impossible burger possible.", "Description", none, "Document", TaskType.CODE);
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

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.run();
    }
}
