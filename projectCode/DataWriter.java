package projectCode;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants{
    public boolean saveUsers(){
        User users = User.getInstance();
		ArrayList<User> addUsers = users.getUser();
		JSONArray jsonUsers = new JSONArray();
		
		//creating all the json objects
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
		ArrayList<User> addProject = projects.getProject();
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

		projectDetails.put(PROJECT_NAME, project.getProjectName());
		projectDetails.put(PROJECT_USERS, project.getUsers());
		projectDetails.put(PROJECT_COLUMNS, project.getColumns());
        
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

        // Add these values for Class: Task, for the "save" method.
        // Since the above do not encompass all of the varibles in the Task
        // Class. 
        // Need help with making these
        /* 
        taskDetails.put("taskID", task.taskID.toString());
        taskDetails.put("taskName", task.taskName);
        taskDetails.put("description", task.description);
        taskDetails.put("assignedUser", task.assignedUser.getUsername());
        */
        
        return taskDetails;
	}
}
