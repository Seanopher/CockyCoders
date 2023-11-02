package projectCode;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Driver {
    private ProjectFacade facade;
    private Project electric_Missles;
    private Project soap_Free_Washers;
    private Project air_Computers;
    private User atticus;
    private ArrayList<Project> projects;



    Driver(){
        facade = new ProjectFacade();
        atticus = new User("01", "Atticus", "Madden", "Madden23", "AMadden", "ADMIN");
        electric_Missles = new Project("Electric Missles", "01", null);
        soap_Free_Washers = new Project("Soap Free Washers", "02", null);
        air_Computers = new Project("Air Computers", "03", null);
        
    }
    public void run(){
        scenario();
    }

    public void scenario(){
        System.out.println("************** Code Mission Possible **************");
        

        System.out.println("Atticus Madden is logged in.");

        facade.joinProject(electric_Missles, atticus);
        facade.joinProject(soap_Free_Washers, atticus);
        facade.joinProject(air_Computers, atticus);
        Columns toDo = new Columns("To-Do");
        Columns doing = new Columns("Doing");
        Columns done = new Columns("Done");
        facade.createColumn("To-Do");
        facade.createColumn("Doing");
        facade.createColumn("Done");

        /* Add a new task "Initialize super algorithm to detonate at warp speed". Assign the task to Jeff Goldblum. */
        Task initialize = new Task();
        User jeff = facade.createUser(UUID.randomUUID(), "John", "Goldblum", "Goldblum41", "JGoldblum", "USER");
        initialize = facade.newTask("Initialize super algorithm to detonate at warp speed.", "Description", jeff, "Document", TaskType.CODE);


        /* Add a comment to the task "Avoid civilians Jeff!" */
        Date date = new Date();
        facade.addComment("Avoid civilians Jeff!", jeff, date.toString(), initialize);

        /* Move the existing task of "Curve the metal to make a cylindrical shape" to the 'Doing' column. */
        /* This task has the existing comments of "Not cylindrical enough" - by Jeff, and "What's a cylinder" by Atticus Finch. */
        /* Reply to Jeff's comment and say "How about you do it jeff", and re-assign the task from yourself to Jeff. */
        Task curve = new Task();
        curve = facade.newTask("Curve the metal to make a cylindrical shape", "Description", jeff, "Document", TaskType.CODE);
        facade.addTask(toDo, curve);
        facade.changeColumn(toDo, doing, curve);
        facade.addComment("Not cylindrical enough", jeff, date.toString(), curve);
        facade.addComment("What's a cylinder", atticus, date.toString(), curve);

        facade.createColumn("Abandoned");
        Columns abandoned = new Columns("Abandoned");

        Task burger = new Task();
        burger = facade.newTask("Make impossible burger possible.", "Description", jeff, "Document", TaskType.CODE);

        facade.addTask(toDo, burger);
        facade.changeColumn(toDo, abandoned, burger);


        System.out.println("ToDo - "+toDo.getTasks());
        System.out.println("Doing -"+doing.getTasks());
        System.out.println("Doing comments -"+curve.getComments());
        System.out.println("Done -"+done.getTasks());
        System.out.println("Abandoned - "+abandoned.getTasks());
    }

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.run();
    }
}
