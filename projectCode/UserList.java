package projectCode;
import java.util.ArrayList;
public class UserList {
    private UserList userList;
    private ArrayList<User> users;
    private UserList(){

    }

    public UserList getInstance(){
        return getInstance();
    }

    public User getUser(String userID){
        return getUser(userID);
    }

    public User login(String userName, String password){
        return login(userName, password);
    }
    public boolean Logout(User user){
        return true;
    }
}
