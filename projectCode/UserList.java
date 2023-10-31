package projectCode;
import java.util.ArrayList;
import java.util.UUID;
public class UserList {
    private static UserList userList;
    private ArrayList<User> users;

    private UserList()
    {
        users = new ArrayList<>();
    }


    /*
     * gets instance of UserList
     */
    public static UserList getInstance()
    {
        if(userList == null)
        {
            userList = new UserList();
        }
        return userList;
    }


    public User getUser(UUID userID)
    {
        String userUUIDtoString = userID.toString(); //changes the UUID into a String
        for (User user : users)
        {
            if (user.getUUID().equals(userUUIDtoString)) //checks if userId matches
            {
                return user; //returns a user matching the userUUID
            }
        }
            /*
            * User is not found
            */
        return null;
    }


    /*
     * logs in user by calling DataLoader for Users and
     * searching list for specific User
     */
    public User login(String userName, String password)
    {
        DataLoader dataLoader = new DataLoader();
        
        users = dataLoader.loadUsers(); //loads the users in dataLoader
        
       try
       {
            /*
            * Searches Users using their username and password 
            * Returns the user if found 
            */
            for(User user: users)
            {
                if(user.getUsername().equals(userName) & user.getPassword().equals(password))
                {
                    String UUID = user.getUUID();
                    String uuidString = UUID.toString();
                    User loggedInUser = User(userName); //uses the userId to call the getUser method and gets the correct user
                    return loggedInUser;
                }
            }
        }
           /*
            * User is not found
            */
        catch (Exception e)
        {
        e.printStackTrace();
        }
        return null;
    }
    
    public boolean Logout(User user)
    { //not sure how to log user out
        return true;
    }
}








