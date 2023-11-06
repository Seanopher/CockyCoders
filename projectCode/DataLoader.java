package projectCode;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.text.ParseException;
import java.util.Date;

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

                User user = newUser(userID, firstName, lastName, password, username, userType, projectList);
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

            //Intializing task and user lists
            TaskList taskList = TaskList.getInstance();
            UserList userList = UserList.getInstance();


            //Looping through each Project in the JSON file
            for (Object projectObj : projectArray) 
            {
                //Creating a JSON object for each project in the json file
                JSONObject projectDetails = (JSONObject) obj.get("project");//might be projectObj

                //Adding details to Project object
                String id = (String) projectDetails.get(PROJECT_ID);
                String name = (String) projectDetails.get(PROJECT_NAME);

                //Adding Users detail to Project object
                JSONArray projectUserIDs = (JSONArray) projectDetails.get(PROJECT_USERS);
                ArrayList<User> users = new ArrayList<>();
                for (Object user : projectUserIDs) 
                {
                    if(user instanceof String) {
                        String userString = (String) user;
                        UUID userUUID = UUID.fromString(userString);
                        User userlist = userList.getUser(userUUID);
                        users.add(userlist);
                    }
                    
                }
                
                //Adding Columns detail to Project Object
                JSONArray columnsArray = (JSONArray) projectDetails.get("columns");
                ArrayList<Columns> columns = new ArrayList<>();
                ArrayList<Task> objTaskList = new ArrayList<>();
                

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
    public ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<Task>();

        try {
            
            //Reading the JSON file by creating a general JSON Object
            //then adding an array of Tasks to the general Object
            FileReader reader = new FileReader(TASK_FILE_NAME);
            JSONObject obj = (JSONObject) new JSONParser().parse(reader);
            JSONArray taskArray = (JSONArray) obj.get("task");
            
            //Looping through each Task in the JSON file
            for (Object taskObj : taskArray) {
                JSONObject taskDetails = (JSONObject) taskObj;

                //Adding details to the Task object
                UUID taskID = UUID.fromString((String) taskDetails.get(TASK_ID));
                String taskName = (String) taskDetails.get(TASK_NAME);
                String description = (String) taskDetails.get(TASK_DESCRIPTION);
                String document = (String) taskDetails.get(TASK_DOCUMENT);

                //Adding the ArrayList<User> to the Task Object
                JSONArray assignedUser = (JSONArray) taskDetails.get(TASK_ASSIGNED_USER);
                ArrayList<User> assignedUsers = new ArrayList<>();
                for (Object user : assignedUser) 
                {
                    if(user instanceof String) {
                        String userString = (String) user;
                        UUID userUUID = UUID.fromString(userString);
                        User userlist = UserList.getInstance().getUser(userUUID);
                        assignedUsers.add(userlist);
                    }
                }

                //Adding date to the Task Object 
                //Parsing the String into a Date
                String date = (String) taskDetails.get(TASK_DATE); 
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date taskDate = dateFormat.parse(date);

                //Adding TaskType to the Task Object 
                //Parsing the String into a TaskType
                String taskTypeString = (String) taskDetails.get(TASK_TYPE); //turn into the task type? 
                TaskType taskType = TaskType.valueOf(taskTypeString);

                //Comments will need the same as the columns
                JSONArray commentsArray = (JSONArray) taskDetails.get(TASK_COMMENTS);
                ArrayList<Comment> comments = new ArrayList<>();
                
                for (Object commentObj : commentsArray) 
                {
                    //Creating a JSONObject for the Comment
                    JSONObject commentDetails = (JSONObject) commentObj;

                    //Adding the String Comment to the Comment Object
                    String comment = (String) commentDetails.get("comment");
                    
                    //Adding the User to the Comment Object
                    String userIDString = (String) commentDetails.get("userID");
                    UUID userUUID = UUID.fromString(userIDString);
                    User userlist = UserList.getInstance().getUser(userUUID);

                    //Adding the ArrayList of Comments (thread) detail into the Comment Object
                    JSONArray commentThreadArray = (JSONArray) commentDetails.get("comments");
                    ArrayList<String> commentThread = new ArrayList<>();
                    
                    for(Object commentThreadObj : commentThreadArray){
                        String threadComment = (String) commentThreadObj;
                        commentThread.add(threadComment);
                    }

                    comments.add(new newComment(comment, userlist, commentThread));
                }

                tasks.add(new Task(taskID, taskName, description, assignedUsers, document, taskType, comments));
            } 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}