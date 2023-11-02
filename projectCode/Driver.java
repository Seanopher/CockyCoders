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
        Task initialize = new Task();
        User jeff = facade.createUser(UUID.randomUUID(), "John", "Goldblum", "Goldblum41", "JGoldblum", "USER");
        initialize = facade.newTask("Initialize super algorithm to detonate at warp speed.", " Description", jeff, "Document", TaskType.CODE);
        Date date = new Date();
        facade.addComment("Avoid civilians Jeff!", jeff, date.toString(), initialize);
    }
}
