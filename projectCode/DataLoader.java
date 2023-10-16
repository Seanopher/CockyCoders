package projectCode;

import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader extends DataConstants{
    public boolean loadUsers(){
        ArrayList<User> users = new ArrayList<User>();

        try{
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < usersJSON.size(); i++) {
				JSONObject userJSON = (JSONObject)usersJSON.get(i);
				String firstName = (String)userJSON.get(USER_FIRST_NAME);
				String lastName = (String)userJSON.get(USER_LAST_NAME);
				String password = (String)userJSON.get(USER_PASSWORD);
                String username = (String)userJSON.get(USER_USERNAME);
				String userType = (String)userJSON.get(USER_USERTYPE);
                String projects = (String)userJSON.get(USER_PROJECTS);
				String points = (String)userJSON.get(USER_POINTS);
				
				users.add(new User(firstName, lastName, password ,username, userType, projects, points));
			}


        }
        return true;
    }

    public boolean loadProjects(){
        return true;
    }

    public boolean loadTasks(){
        return true;
    }

    public boolean loadColumns(){
        return true;
    }

    public boolean loadComments(){
        return true;
    }
}
