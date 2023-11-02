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
			} 
            return users;
        } catch (Exception e) {
			e.printStackTrace();
        }
        return null;
    }


    
    public ArrayList<Project> loadProjects(){
        ArrayList<Project> projects = new ArrayList<Project>();

        try{
            FileReader reader = new FileReader(PROJECT_FILE_NAME);
            JSONObject obj = (JSONObject) new JSONParser().parse(reader)
            JSONArray projectsJSON = (JSONArray)obj.get("Projects")
            UserList userList = UserList.getInstance();
            ArrayList<User> users;
            for(Object object: projectsJSON) 
            {
				JSONObject projectJSON = (JSONObject) object;

				String id = (String)projectJSON.get(PROJECT_ID);
                String name = (String)projectJSON.get(PROJECT_NAME);
                
                JSONArray projectUserIDs = (JSONArray)projectJSON.get(PROJECT_USERS);
                for(int j=0; j < projectUserIDs.size(); j++){
                    String userID = (String)projectUserIDs.get(j);
                    UUID userUUID = UUID.fromString(userID); 
                    User user = userList.getUser(userUUID);

                    if(user != null){
                        users.add(user);
                    }



                    
                }
                
                String columns = (String) projectJSON.get(PROJECT_COLUMNS);

				//go through user list to find users based on userID and add them to an a arraylist 
                //because users in project JSON is the userID
				projects.add(new Project(id, name, users, columns));
			}
            return projects;
        } catch (Exception e) {
			e.printStackTrace();
        }
        return null;
    }


    public boolean loadTasks(){
        ArrayList<Task> tasks = new ArrayList<Task>();

        try{
            FileReader reader = new FileReader(TASK_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray tasksJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < tasksJSON.size(); i++) {
				JSONObject taskJSON = (JSONObject)tasksJSON.get(i);
				String taskName = (String)taskJSON.get(TASK_NAME);
				String description = (String)taskJSON.get(TASK_DESCRIPTION);


				String assignedUser = (String)taskJSON.get(TASK_ASSIGNED_USER);
                String taskDate = (String)taskJSON.get(TASK_DATE);
                String document = (String)taskJSON.get(TASK_DOCUMENT);
				String taskType = (String)taskJSON.get(TASK_TYPE);


                String comments = (String)taskJSON.get(TASK_COMMENTS);
				
				tasks.add(new Task(taskName, description, assignedUser, document, taskType));
			}//String taskName, String description, User assignedUser, String document, TaskType taskType
            return true;
        } catch (Exception e) {
			e.printStackTrace();
        }
        return false;
    }
}
