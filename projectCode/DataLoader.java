package projectCode;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*
 * Taking in the JSON file and parsing it into objects
 * Returns an arraylist of Users for UserList
 */
public class DataLoader extends DataConstants {

    public ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONArray usersJSON = (JSONArray) new JSONParser().parse(reader);
            // ArrayList<Project> projectList = new ArrayList<Project>();

            for (int i = 0; i < usersJSON.size(); i++) {
                JSONObject userJSON = (JSONObject) usersJSON.get(i);

                String firstName = (String) userJSON.get(USER_FIRST_NAME);
                String lastName = (String) userJSON.get(USER_LAST_NAME);
                String userID = (String) userJSON.get(USER);
                String password = (String) userJSON.get(USER_PASSWORD);
                String username = (String) userJSON.get(USER_USERNAME);
                String userType = (String) userJSON.get(USER_USERTYPE);
                // String projects = (String)userJSON.get(USER_PROJECTS);

                User user = newUser(
                        userID,
                        firstName,
                        lastName,
                        password,
                        username,
                        userType,
                        projectList);
                users.add(user);
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * Taking in the JSON file and parsing it into objects
     * Returns an arraylist of Projects for ProjectList
     */
    public ArrayList<Project> loadProjects() {
        ArrayList<Project> projects = new ArrayList<Project>();

        try 
        { 
            //Reading the JSON file by creating a general JSON Object
            //then adding an array of Projects to the general Object
            FileReader reader = new FileReader(PROJECT_FILE_NAME);
            JSONObject obj = (JSONObject) new JSONParser().parse(reader);
            JSONArray projectArray = (JSONArray) obj.get("project");

            //Looping through each Project in the JSON file
            for (Object projectObj : projectArray) 
            {
                //creating a JSON object for each project in the json file
                JSONObject projectDetails = (JSONObject) obj.get("project");

                //Adding details to Project object
                String id = (String) projectDetails.get(PROJECT_ID);
                String name = (String) projectDetails.get(PROJECT_NAME);

                //Adding Users detail to Project object
                JSONArray projectUserIDs = (JSONArray) projectDetails.get(PROJECT_USERS);
                ArrayList<User> users = new ArrayList<>();
                for (Object user : projectUserIDs) 
                {
                    User userlist = UserList.getUser((String) user);
                    users.add((String) user);
                }

                //Adding Columns detail to Project Object
                JSONArray columnsArray = (JSONArray) projectDetails.get("columns");
                ArrayList<Columns> columns = new ArrayList<>();
                ArrayList<Task> objTaskList = new ArrayList<>();
                TaskList taskList = TaskList.getInstance();

                for (Object columnObj : columnsArray) 
                {
                    //Creating a JSONObject for the Column
                    JSONObject columnDetails = (JSONObject) columnObj;

                    //Adding the details to the Column Object
                    String columnTitle = (String) columnDetails.get("title");
                    JSONArray taskTitlesArray = (JSONArray) columnDetails.get("taskTitles");

                    //Adding the ArrayList of Tasks detail into the Column Object
                    ArrayList<String> taskTitles = new ArrayList<>();
                    for (Object taskTitle : taskTitlesArray) 
                    {
                        //Finding the Task in the TaskList then parsing into a String
                        Task task = taskList.getTask((String) taskTitle);
                        objTaskList.add(task);
                    }

                    columns.add(new newColumns(columnTitle, taskTitles));
                }

                projects.add(Project.newProject(name, id, users, columns));
            }
            return projects;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * Taking in the JSON file and parsing it into objects
     * Returns an arraylist of Tasks for TaskList
     */
    public boolean loadTasks() {
        ArrayList<Task> tasks = new ArrayList<Task>();

        try {
            FileReader reader = new FileReader(TASK_FILE_NAME);
            JSONObject obj = (JSONObject) new JSONParser().parse(reader);
            JSONObject taskDetails = (JSONObject) obj.get("task");

            for (int i = 0; i < tasksJSON.size(); i++) {
                JSONObject taskJSON = (JSONObject) tasksJSON.get(i);
                String taskName = (String) taskJSON.get(TASK_NAME);
                String description = (String) taskJSON.get(TASK_DESCRIPTION);
                String assignedUser = (String) taskJSON.get(TASK_ASSIGNED_USER); // will need to search the userList and
                                                                                 // return arraylist, same as columns
                String taskDate = (String) taskJSON.get(TASK_DATE); // turn into type date
                String document = (String) taskJSON.get(TASK_DOCUMENT);
                String taskType = (String) taskJSON.get(TASK_TYPE);

                // comments will need the same as the columns
                String comments = (String) taskJSON.get(TASK_COMMENTS);

                tasks.add(
                        new Task(taskName, description, assignedUser, document, taskType));
            } // String taskName, String description, User assignedUser, String document,
              // TaskType taskType
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
