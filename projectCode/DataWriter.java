package projectCode;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants{
    public boolean saveUsers(){
        UserList users = UserList.getInstance();
		UserList.getUsers();
		JSONArray jsonUsers = new JSONArray();
		
		//Creating all the JSON 
		for(int i=0; i< addUsers.size(); i++) {
			jsonUsers.add(getUserJSON(addUsers.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
 
            file.write(jsonUsers.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean saveTasks(){
        Task tasks = Task.getInstance();
		ArrayList<Task> addTask = tasks.getTask();
		JSONArray jsonTasks = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< addTask.size(); i++) {
			jsonTasks.add(getTaskJSON(addTask.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(TASK_FILE_NAME)) {
 
            file.write(jsonTasks.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean saveProject(){
        Project projects = Project.getInstance();
		ArrayList<Project> addProject = projects.getProject();
		JSONArray jsonProjects = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< addProject.size(); i++) {
			jsonProjects.add(getUserJSON(addProject.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(PROJECT_FILE_NAME)) {
 
            file.write(jsonProjects.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean saveColumns(){
        //no JSON file?
        return true;
    }

    public boolean saveComments(){
        //no JSON file?
        return true;
    }
    public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();

		userDetails.put(USER_FIRST_NAME, user.getFirstName());
		userDetails.put(USER_LAST_NAME, user.getLastName());
		userDetails.put(USER_USERNAME, user.getUsername());
        userDetails.put(USER_PASSWORD, user.getPassword());
		userDetails.put(USER_USERTYPE, user.getUserType());
        userDetails.put(USER_PROJECTS, user.getProjects());
		userDetails.put(USER_POINTS, user.getPoints());
        
        return userDetails;
	}

    public static JSONObject getProjectJSON(Project project) {
		JSONObject projectDetails = new JSONObject();

		projectDetails.put(PROJECT_NAME, project.getFirstName());
		projectDetails.put(PROJECT_USERS, project.getLastName());
		projectDetails.put(PROJECT_COLUMNS, project.getUsername());
        
        return projectDetails;
	}

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
        
        return taskDetails;
	}
}
