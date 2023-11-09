package projectCode;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Cocky Coders
 * The collection of method used to write to the JSON files which store 
 * the data used in the program. Thes methods allow additions to stored data 
 * and the writing of JSON files with new information to be used (loaded) for
 * later use. 
 */
public class DataWriter extends DataConstants {
    /**
     * These are short cuts to be used to for putting information into the json
     * files. 
     */
   //private static final String USER_JSON_FILE = "projectCode/json/users.json"; // JSON file to save user data
   //private static final String PROJECT_JSON_FILE = "projectCode/json/Project.json";
   //private static final String TASK_JSON_FILE = "projectCode/json/Task.json";

    /**
     * The saveComments method takes objects from comments and uses the 
     * information stored at the getters to place in the key section of
     * the json files.
     * The method goes through a loop for every object, putting every
     * value for the object that is called
     * @param commentsList The list of comment objects being used for 
     * the method.
     * @return The values for the sections within the json file. In
     * this case it returns the comment, UserID, data, and the nested
     * comments assocated with the orginal comment (in a last in first
     * out order).
     * This information is printed out to a file with a JSON format 
     * with the keys splitting the sections.
     */
    public static JSONArray saveComment (List<Comment> commentsList) {
        //List<Comment> commentList = comment.getComment
        JSONArray commentsJSON = new JSONArray();
        for (Comment comment : commentsList) {
            JSONObject commentObject = new JSONObject();
            commentObject.put("comment", comment.getComment());
            commentObject.put("UserID", comment.getUserName());
            commentObject.put("date", comment.getDate());
            JSONArray nestedComments = saveComment(comment.getCommentThread());
            commentObject.put("comments", nestedComments);
            commentsJSON.add(commentObject);

        }
        try (FileWriter file = new FileWriter("projectCode/json/output.json")) {
            file.write(commentsJSON.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return commentsJSON;
    }
    /**
     * The saveProjects method takes objects from project and uses the 
     * information stored at the getters to place in the key section of
     * the json files.
     * The method goes through a loop for every object, putting every
     * value for the object that is called
     * @param projectsList The list of project objects being used for
     * the method
     * @return The values for the sections within the json files. In
     * the case of this method it return the id, name, and users for 
     * project to be stored in the JSON file.
     * This information is printed and stored in the JSON file in 
     * the Json format.
     */
    public static JSONArray saveProjects(List<Project> projectsList) {
        //JSONObject mainObject = new JSONObject();
        JSONArray projectList = new JSONArray();
        for (Project project: projectsList) {
            JSONObject projectObject = new JSONObject();
            projectObject.put("id", project.getProjectID());
            projectObject.put("name", project.getProjectName());
            projectObject.put("users", project.getUsers()); //could also be getUsers or getUserName()
            projectList.add(projectObject);
            //JSONArray nestedColumns = saveProjects(project.getColumns());
        }
        try (FileWriter file = new FileWriter("projectCode/json/output.json")) {
            file.write(projectList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return projectList;
    }
    /**
     * The saveColumns method takes objects from column class and uses the 
     * information stored at the getters to place in the key section of
     * the json files.
     * The method goes through a loop for every object, putting every
     * value for the object that is called
     * @param columnsList The list of column objects being used for
     * the method to gather data
     * @return The values for the section within the json files. In 
     * this method the return is only the titles of the columns.
     * This information will be printed and stored into a JSON file in
     * the JSON format.
     */
    public static JSONArray saveColumns(List<Columns> columnsList){
        JSONArray columnList =new JSONArray();
        for (Columns column : columnsList){
            JSONObject columnObject = new JSONObject();
             columnObject.put("titles", column.getTitle());
             columnList.add(columnObject);
       }
       try (FileWriter file = new FileWriter("projectCode/json/output.json")) {
        file.write(columnList.toJSONString());
        file.flush();
    } catch (IOException e) {
        e.printStackTrace();
    }
       return columnList;
  }
  /**
   * this method was created for the saveColumns method, it is meant
   * to work with this function.
   * The saveTaskTitle method takes objects from task class and uses the 
   * information stored at the getters to place in the key section of
   * the json files.
   * The method goes through a loop for every object, putting every
   * value for the object that is called
   * @param taskList The list of task objects that is used by 
   * the method to search for the needed values.
   * @return The values for the section within the JSON files. This 
   * method only takes one section and value to be stored in the JSON 
   * file. It takes the taskTitles section and associated value.
   * This information is printed and saved in a file, styled in 
   * the JSON data base format.
   */
  public static JSONArray saveTaskTitle(List<Task> taskList){
    JSONArray tasksList =new JSONArray();
    for (Task task : taskList){
        JSONObject taskObject = new JSONObject();
         taskObject.put("taskTitles", task.getName());
         tasksList.add(taskObject);
   }
   try (FileWriter file = new FileWriter("projectCode/json/output.json")) {
    file.write(tasksList.toJSONString());
    file.flush();
} catch (IOException e) {
    e.printStackTrace();
}
   return tasksList;
}
 /**
  * The saveTask method takes objects from task class and uses the 
     * information stored at the getters to place in the key section of
     * the json files.
     * The method goes through a loop for every object, putting every
     * value for the object that is called
  * @param taskList The list of task objects that is used by 
  * the method to search for the needed values.
  * @return The values for the sections within the JSON files. This
  * method takes a section and value to be stored in the JSON 
  * file. It takes the values values assocatied with the sections 
  * id, taskName, description, assignedUser, document, and taskType.
  * it then orders the information gather by the getters into the 
  * sections within the JSON file. This information is printed in
  * a JSON file format using JSON functions and then using
  * the file writer funcitons are then moved into a JSON file to be stored.
  */
public static JSONArray saveTask(List<Task> taskList) {
    //JSONObject mainObject = new JSONObject();
    JSONArray tasksList = new JSONArray();
    for(Task task : taskList){
        JSONObject taskObject = new JSONObject();
        taskObject.put("id", task.getID());
        taskObject.put("taskName", task.getName());
        taskObject.put("description",task.getDescription());
        taskObject.put("assignedUser", task.getAssignedUsers());
        taskObject.put("document",task.getDocument());
        taskObject.put("taskType", task.getTaskType());
        tasksList.add(taskObject);
    }
    try (FileWriter file = new FileWriter("projectCode/json/output.json")) {
        file.write(tasksList.toJSONString());
        file.flush();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return tasksList;
}
/**
 * The saveUser method takes objects from user class and uses the 
     * information stored at the getters to place in the key section of
     * the json files.
     * The method goes through a loop for every object, putting every
     * value for the object that is called
 * @param userList The list of user objects that will be used to 
 * gather information for the sorting of data for the JSON file.
 * @return The values for the sections within the JSON files.
 * This method takes a section and value to be stored in the JSON
 * file. It takes the values assocatied with the sections userID,
 * firstName, lastName, username, password, userType, and 
 * projects. These values are accessed by refrencing the user class
 * and then using getters to accesses the values for printing.
 * This informaiton is printed in a JSON file in the Json format
 * using filewriting functions and the JSON functions to format.
 */
public static JSONArray saveUsers(List<User> userList){
    JSONArray usersList =new JSONArray();
    for (User user : userList){
        JSONObject userObject = new JSONObject();
         userObject.put("userID", user.getUUID());
         userObject.put("firstName", user.getFirstName());
         userObject.put("lastName", user.getLastName());
         userObject.put("username", user.getUsername());
         userObject.put("password", user.getPassword());
         userObject.put("userType", user.getUserType());
         userObject.put("projects", user.getProjects());
         usersList.add(userObject);
   }
   try (FileWriter file = new FileWriter("projectCode/json/output.json")) {
    file.write(usersList.toJSONString());
    file.flush();
} catch (IOException e) {
    e.printStackTrace();
}
   return usersList;
}
}