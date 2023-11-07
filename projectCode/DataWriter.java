package projectCode;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

    /**
     * Saving Users
     * Gets UserJSON and writes to the JSON User file
     * 
     * @return boolean
     */
    public boolean saveUsers() {
        // Intializing the UserList and getting the Users
        UserList userList = UserList.getInstance();
        ArrayList<User> addUsers = userList.getUsers();
        JSONArray jsonUsers = new JSONArray();

        // Creating all the JSON
        for (User user : addUsers) {
            jsonUsers.add(getUserJSON(user));
        }

        // Write JSON file
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Saving Tasks
     * Gets TaskJSON and writes to the JSON Task file
     * 
     * @return boolean
     */
    public boolean saveTasks() {
        // Intializing
        TaskList taskList = TaskList.getInstance();
        ArrayList<Task> addTask = taskList.getTasks();
        JSONArray jsonTasks = new JSONArray();

        // Adds each JSON task to the JSONArray from getTaskJSON
        for (Task task : addTask) {
            jsonTasks.add(getTaskJSON(task));
        }

        // Writes the JSONArray Tasks to the JSON file
        try (FileWriter file = new FileWriter(TASK_FILE_NAME)) {

            file.write(jsonTasks.toJSONString());
            file.flush();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Saving Projects
     * Gets ProjectJSON and writes to the JSON Project file
     * 
     * @return boolean
     */
    public boolean saveProject() {
        ProjectList projectList = ProjectList.getInstance();
        ArrayList<Project> addProject = projectList.getProjects();
        JSONArray jsonProjects = new JSONArray();

        // creating all the json objects
        for (Project project : addProject) {
            jsonProjects.add(getProjectJSON(project));
        }

        // Write JSON file
        try (FileWriter file = new FileWriter(PROJECT_FILE_NAME)) {
            file.write(jsonProjects.toJSONString());
            file.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Saving Users
     * Gets UserJSON and writes to the JSON User file
     * 
     * @return boolean
     */
    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();

        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_USERNAME, user.getUsername());
        userDetails.put(USER_PASSWORD, user.getPassword());
        userDetails.put(USER_USERTYPE, user.getUserType());

        JSONArray projectArray = new JSONArray();
        ArrayList<Project> userProjects = user.getProjects();
        for (Project project : userProjects) {
            String projectId = project.getProjectID();
            projectArray.add(projectId);
        }
        userDetails.put(USER_PROJECTS, projectArray);

        return userDetails;
    }
    public static void main(String[] args) {
        User user = new User("userId", "kaylee", "walz", "password123", "kaywalz", "user");
        getUserJSON(user);
    }

    // String userID, String firstName, String lastName, String password, String username, String userType

    /**
     * Saving Users
     * Gets UserJSON and writes to the JSON User file
     * 
     * @return boolean
     */
    public static JSONObject getProjectJSON(Project project) {
        JSONObject projectDetails = new JSONObject();

        projectDetails.put(PROJECT_ID, project.getProjectID());
        
        projectDetails.put(PROJECT_USERS, project.getUsers());
        projectDetails.put(PROJECT_COLUMNS, project.getColumns());

        return projectDetails;
    }

    // {
    //     "project": {
    //         "id":"uuid",
    //         "name": "project1",
    //         "users": [
    //             "507f1f77bcf86cd799439011",
    //             "00000020f51bb4362eee2a4d",
    //             "75hadhwjaapvl09234bbcadw"
    //         ],
    //         "columns": [
    //             {"title": "column1", "taskTitles": ["title1", "title2", "title3"]},
    //             {"title": "column2", "taskTitles": ["title4", "title5", "title6"]},
    //             {"title": "column3", "taskTitles": ["title7", "title8", "title9"]}
    //         ]
    //     }
    // }







    /**
     * Saving Users
     * Gets UserJSON and writes to the JSON User file
     * 
     * @return boolean
     */
    public static JSONObject getTaskJSON(Task task) {
        JSONObject taskDetails = new JSONObject();

        taskDetails.put(TASK_NAME, task.getName());
        taskDetails.put(TASK_DESCRIPTION, task.getDescription());
        taskDetails.put(TASK_ASSIGNED_USER, task.getAssignedUser());
        taskDetails.put(TASK_DATE, task.getDate());
        taskDetails.put(TASK_DUE_DATE, task.getDueDate());
        taskDetails.put(TASK_DOCUMENT, task.getDocument());
        taskDetails.put(TASK_TYPE, task.getTaskType());
        taskDetails.put(TASK_COMMENTS, task.getComments());
        taskDetails.put(TASK_HISTORY, task.getHistory());

        // Add these values for Class: Task, for the "save" method.
        // Since the above do not encompass all of the varibles in the Task
        // Class.
        // Need help with making these
        /*
         * taskDetails.put("taskID", task.taskID.toString());
         * taskDetails.put("taskName", task.taskName);
         * taskDetails.put("description", task.description);
         * taskDetails.put("assignedUser", task.assignedUser.getUsername());
         */

        return taskDetails;
    }
}
