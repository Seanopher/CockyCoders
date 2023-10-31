package projectCode;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader extends DataConstants{
    public ArrayList<User> loadUsers(){
        ArrayList<User> users = new ArrayList<User>();
        
        try{
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < usersJSON.size(); i++) {
				JSONObject userJSON = (JSONObject)usersJSON.get(i);
                
				String firstName = (String)userJSON.get(USER_FIRST_NAME);
				String lastName = (String)userJSON.get(USER_LAST_NAME);
                String userID = (String)userJSON.get(USER);
				String password = (String)userJSON.get(USER_PASSWORD);
                String username = (String)userJSON.get(USER_USERNAME);
				String userType = (String)userJSON.get(USER_USERTYPE);
                String projects = (String)userJSON.get(USER_PROJECTS);

				User user = new User(userID, firstName, lastName, password, username, userType);
				users.add(user);
                return users;
			} //String userID, String firstName, String lastName, String password, UserType userType
        } catch (Exception e) {
			e.printStackTrace();
        }
        return null;
    }


    
    public boolean loadProjects(){
        ArrayList<Project> projects = new ArrayList<Project>();

        try{
            FileReader reader = new FileReader(PROJECT_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray projectsJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < projectsJSON.size(); i++) {
				JSONObject projectJSON = (JSONObject)projectsJSON.get(i);
				String name = (String)projectJSON.get(PROJECT_NAME);
				String users = (String)projectJSON.get(PROJECT_USERS);
				String columns = (String)projectJSON.get(PROJECT_COLUMNS);
				
				projects.add(new Project(name, users, columns));
			}
            return true;
        } catch (Exception e) {
			e.printStackTrace();
        }
        return false;
    }

    public boolean loadTasks(){
        ArrayList<Task> tasks = new ArrayList<Task>();

        try{
            FileReader reader = new FileReader(TASK_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray tasksJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < tasksJSON.size(); i++) {
				JSONObject taskJSON = (JSONObject)tasksJSON.get(i);
				String name = (String)taskJSON.get(TASK_NAME);
				String description = (String)taskJSON.get(TASK_DESCRIPTION);
				String assignedUser = (String)taskJSON.get(TASK_ASSIGNED_USER);
                String taskDate = (String)taskJSON.get(TASK_DATE);
				String dueDate = (String)taskJSON.get(TASK_DUE_DATE);
                String document = (String)taskJSON.get(TASK_DOCUMENT);
				String taskType = (String)taskJSON.get(TASK_TYPE);
                String comments = (String)taskJSON.get(TASK_COMMENTS);
				String history = (String)taskJSON.get(TASK_HISTORY);
				
				tasks.add(new Task(name, description, assignedUser ,taskDate, dueDate, document, taskType, comments,history));
			}
            return true;
        } catch (Exception e) {
			e.printStackTrace();
        }
        return false;
    }

    public boolean loadColumns(){
        //do we need to load columns since we don't have a JSON file for it? 
        return false;
    }

    public boolean loadComments(){
        //do we need to load comments since we don't have a JSON file for it? 
        return true;
    }
}
