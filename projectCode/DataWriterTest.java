package projectCode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {
    private DataLoader dataLoader;
    private DataWriter dataWriter;
    private UserList userList;


   private ProjectList projectList = ProjectList.getInstance();
   private ArrayList<Project> projectsList = projectList.getProjects();

    @BeforeEach
    public void setup() {
        projectList = ProjectList.getInstance();
        dataLoader = new DataLoader();
        dataWriter = new DataWriter();
        userList = UserList.getInstance();

        
        projectList.getProjects().clear();
        dataWriter.saveProjects(projectList.getProjects());
        dataWriter.saveUsers(userList.getUsers());


    }
    /**
     * it is important to note that this is commented out to allow the user
     * to check the output class. The dataWriter has a output to a wrong file 
     * which is causing some false negatives
     */
    @AfterEach
    public void tearDown() {
        projectList.getProjects().clear();
        //dataWriter.saveProjects(projectList.getProjects());

    }


    @Test
    void testSaveZeroProjects() {
        dataWriter.saveProjects(projectList.getProjects());
        assertEquals(0, dataLoader.loadProjects().size());
    }

    @Test
    public void testSaveOneProject() {
        Project project = new Project("Sample Project", "1", new ArrayList<>());
        projectList.getProjects().add(project);

        dataWriter.saveProjects(projectList.getProjects());
        Project savedProject = dataLoader.loadProjects().get(0);

        assertEquals("Sample Project", savedProject.getProjectName());
    }
    @Test
    void testSaveFiveProjects() {
        for (int i = 1; i <= 5; i++) {
            Project project = new Project("Project " + i, String.valueOf(i), new ArrayList<>());
            projectList.getProjects().add(project);
        }

        dataWriter.saveProjects(projectList.getProjects());
        Project savedProject = dataLoader.loadProjects().get(4);

        assertEquals("Project 5", savedProject.getProjectName());
    }
    @Test
    public void testSaveEmptyProject(){
        Project emptyProject = new Project("", "1", new ArrayList<>());
        projectList.getProjects().add(emptyProject);

        dataWriter.saveProjects(projectList.getProjects());
        Project savedProject = dataLoader.loadProjects().get(0);

        assertEquals("", savedProject.getProjectName());
    }

    @Test
    public void testSaveNullProject() {
        Project nullProject = new Project(null, "1", new ArrayList<>());
        projectList.getProjects().add(nullProject);

        dataWriter.saveProjects(projectList.getProjects());
        Project savedProject = dataLoader.loadProjects().get(0);

        assertNull(savedProject.getProjectName());
    
    }

    // private Project columnsList = Project.getColumn();
    /**
     * Columns can not be tested because they can not be collected 
     * due to a lack of an instance from their list. This needs to be added.
     * other wise the only way to test is by printing them into a file
     */

    @Test
    public void testSaveZeroColumns() {
        dataWriter.saveProjects(projectList.getProjects());
        assertEquals(0, dataLoader.loadProjects().size());
        
    }
    @Test
    public void testSaveOneColumn() {
        Project project = new Project("Sample Project", "1", new ArrayList<>());
        projectList.getProjects().add(project);
    
       // dataWriter.saveProjects(projectList.getProjects());
        //dataWriter.saveColumns(columnsList.getColumns());

        Project savedColumn = dataLoader.loadProjects().get(0);
    
        assertEquals(0, savedColumn.getColumns().size());

        assertEquals("Sample Column", savedColumn.getColumns());
    }
    @Test
    public void testSaveFiveColumns(){
        Project project = new Project("Sample Project", "1", new ArrayList<>());
        for (int i = 1; i <= 5; i++) {
            Columns column = new Columns("Column " + i);
            project.getColumns().add(column);
        }
        projectList.getProjects().add(project);

       // dataWriter.saveProjects(projectList.getProjects());
       // dataWriter.saveColumns(columnsList.getColumns());

        //assertTrue(projectList.getProjects().size() == 1);
        Project savedProject = dataLoader.loadProjects().get(0);

       // assertTrue(savedProject.getColumns().size() >= 5);
        assertEquals("Column 5", savedProject.getColumns().get(4).getTitle());
    }
    @Test
    public void testSaveEmptyColumn(){
        Project project = new Project("Sample Project", "1", new ArrayList<>());
        Columns emptyColumn = new Columns("");
        project.getColumns().add(emptyColumn);
        projectList.getProjects().add(project);

       // dataWriter.saveProjects(projectList.getProjects());
        //dataWriter.saveColumns(columnsList.getColumns());

        Project savedProject = dataLoader.loadProjects().get(0);
        Columns savedColumn = savedProject.getColumns().get(0);

        assertEquals("", savedColumn.getTitle());
    }
    @Test
    public void testSaveNullColumn(){
        Project project = new Project("Sample Project", "1", new ArrayList<>());
        Columns nullColumn = new Columns(null);
        project.getColumns().add(nullColumn);
        projectList.getProjects().add(project);

      //  dataWriter.saveProjects(projectList.getProjects());
     //   dataWriter.saveColumns(columnsList.getColumns());

        Project savedProject = dataLoader.loadProjects().get(0);
        Columns savedColumn = savedProject.getColumns().get(0);

        assertNull(savedColumn.getTitle());

    }

    /**
     * End of column TESTING
     */

     /**
      * Start of TaskTitle Testing
      */



    private TaskList taskList = TaskList.getInstance();

    @Test
    public void testSaveZeroTaskTitle(){
       // Task task = new Task(null, "TaskNameTEST", "TESTnull", null, "TESTDOC", new Date(), null, null);
      // dataWriter.saveProjects(projectList.getProjects());

       //taskList.getTasks().add(task);

       // dataWriter.saveProjects(projectList.getProjects());
        dataWriter.saveTaskTitle(taskList.getTasks());
       // Project savedProject = dataLoader.loadProjects().get(0);
        assertEquals(0, dataLoader.loadProjects().size());
    }
    
    @Test
    public void testSaveFiveTaskTitle(){
       // Task task = new Task(null, "TaskNameTEST", "TESTnull", null, "TESTDOC", new Date(), null, null);

        for (int i = 1; i <= 5; i++) {
            Task task = new Task(null, "TaskNameTEST" +i , "TESTnull", null, "TESTDOC", new Date(), null, null);
            taskList.getTasks().add(task);
        }
       // projectList.getProjects().add(project);

        dataWriter.saveTaskTitle(taskList.getTasks());
       // assertTrue(projectList.getProjects().size() == 1);
        Project savedProject = dataLoader.loadProjects().get(0);

        //assertTrue(savedProject.getTasks().size() >= 5);
        assertEquals("Column 5", savedProject.getColumns().get(4).getTitle());

    }

    /**
     * TESTING TASK
     */
@Test
    public void testSaveZeroTask(){
        ArrayList<Task> taskList = TaskList.getInstance().getTasks();
        dataWriter.saveTask(taskList);
        ArrayList<Task> loadedTasks = dataLoader.loadTasks();
        assertEquals(0, loadedTasks.size());
    }

    @Test
    public void testSaveFiveTask(){
        ArrayList<Task> taskList = TaskList.getInstance().getTasks();

    // Add five sample tasks to the list
    for (int i = 0; i < 5; i++) {
        UUID taskId = UUID.randomUUID();
        String taskName = "Task" + i;
        String description = "Description" + i;
        List<UUID> assignedUserIDs = new ArrayList<>();
        String document = "Document" + i;
        Date taskDate = new Date();
        TaskType taskType = TaskType.BUG;
        List<Comment> comments = new ArrayList<>();

        Task task = new Task(taskId, taskName, description, assignedUserIDs, document, taskDate, taskType, comments);
        taskList.add(task);
    }

    dataWriter.saveTask(taskList);
    ArrayList<Task> loadedTasks = dataLoader.loadTasks();
    assertEquals(5, loadedTasks.size());

    }

    @Test
    public void testSaveEmptyTask(){
        ArrayList<Task> taskList = TaskList.getInstance().getTasks();

    // Add an empty task to the list
    UUID taskId = UUID.randomUUID();
    String taskName = "";
    String description = "";
    List<UUID> assignedUserIDs = new ArrayList<>();
    String document = "";
    Date taskDate = new Date();
    TaskType taskType = TaskType.BUG;
    List<Comment> comments = new ArrayList<>();
        Task emptyTask = new Task(taskId, taskName, description, assignedUserIDs, document, taskDate, taskType, comments);
    taskList.add(emptyTask);

    dataWriter.saveTask(taskList);
    ArrayList<Task> loadedTasks = dataLoader.loadTasks();
    assertEquals(1, loadedTasks.size());
    assertEquals("", loadedTasks.get(0).getName());
    }


    @Test
    public void testSaveNullTask() {
        ArrayList<Task> taskList = TaskList.getInstance().getTasks();
    // Add a task with a null task name to the list
    UUID taskId = UUID.randomUUID();
    String taskName = null; // Setting taskName to null
    String description = "Description";
    List<UUID> assignedUserIDs = new ArrayList<>();
    String document = "Document";
    Date taskDate = new Date();
    TaskType taskType = TaskType.BUG;
    List<Comment> comments = new ArrayList<>();

    Task nullTask = new Task(taskId, taskName, description, assignedUserIDs, document, taskDate, taskType, comments);
    taskList.add(nullTask);

    dataWriter.saveTask(taskList);
    ArrayList<Task> loadedTasks = dataLoader.loadTasks();
    assertEquals(1, loadedTasks.size());
    assertNull(loadedTasks.get(0).getName());
    }

    
    /**
     * TESTING USERS 
     */
    @Test
    public void testSaveZeroUsers(){
        ArrayList<User> users = userList.getUsers();
        dataWriter.saveUsers(users);
        ArrayList<User> loadedUsers = new DataLoader().loadUsers();
        assertEquals(0, loadedUsers.size());
    }
    @Test
    public void testSaveFiveUsers(){
        ArrayList<User> users = userList.getUsers();

        // Add five sample users to the list
        for (int i = 0; i < 5; i++) {
            UUID userId = UUID.randomUUID();
            String username = "User" + i;
            String firstName = "First" + i;
            String lastName = "Last" + i;
            String password = "Password" + i;
            String userType = "UserType" + i;

            User user = new User(userId.toString(), firstName, lastName, password, username, userType);
            users.add(user);
        }

        dataWriter.saveUsers(users);
        ArrayList<User> loadedUsers = new DataLoader().loadUsers();
        assertEquals(5, loadedUsers.size());
    }
    @Test
    public void testSaveEmptyUsers(){
        ArrayList<User> users = userList.getUsers();

        // Add an empty user to the list
        UUID userId = UUID.randomUUID();
        String username = "";
        String firstName = "";
        String lastName = "";
        String password = "";
        String userType = "";

        User emptyUser = new User(userId.toString(), firstName, lastName, password, username, userType);
        users.add(emptyUser);

        dataWriter.saveUsers(users);
        ArrayList<User> loadedUsers = new DataLoader().loadUsers();
        assertEquals(1, loadedUsers.size());
        assertEquals("", loadedUsers.get(0).getUsername());
    }
    @Test
    public void testSaveNullUsers() {
        ArrayList<User> users = userList.getUsers();

        // Add a user with a null username to the list
        UUID userId = UUID.randomUUID();
        String username = null; // Setting username to null
        String firstName = "First";
        String lastName = "Last";
        String password = "Password";
        String userType = "UserType";

        User nullUser = new User(userId.toString(), firstName, lastName, password, username, userType);
        users.add(nullUser);

        dataWriter.saveUsers(users);
        ArrayList<User> loadedUsers = new DataLoader().loadUsers();
        assertEquals(1, loadedUsers.size());
        assertNull(loadedUsers.get(0).getUsername());
        
    }

}
