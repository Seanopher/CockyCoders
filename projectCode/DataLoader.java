package projectCode;

import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*
 * Taking in the JSON file and parsing it into objects
 * Returns an arraylist of Users for UserList 
 */
public class DataLoader extends DataConstants {

    public ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(PROJECT_FILE_NAME);
            //JSONObject obj = (JSONObject) new JSONParser().parse(reader);
            JSONArray userArray = (JSONArray) new JSONParser().parse(reader);
            // ArrayList<Project> projectList = new ArrayList<Project>();

            for (Object userObj : userArray) {
                JSONObject userDetails = (JSONObject) userObj;

                String firstName = (String) userDetails.get(USER_FIRST_NAME);
                String lastName = (String) userDetails.get(USER_LAST_NAME);
                String userID = (String) userDetails.get(USER);
                String password = (String) userDetails.get(USER_PASSWORD);
                String username = (String) userDetails.get(USER_USERNAME);
                String userType = (String) userDetails.get(USER_USERTYPE);
                // String projects = (String) userJSON.get(USER_PROJECTS);

                User user = new User(
                        userID,
                        firstName,
                        lastName,
                        password,
                        username,
                        userType);
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

        try {
            FileReader reader = new FileReader(PROJECT_FILE_NAME);
            //JSONObject obj = (JSONObject) new JSONParser().parse(reader);
            JSONArray projectArray = (JSONArray) new JSONParser().parse(reader);
            //JSONArray projectArray = (JSONArray) obj.get("project");

            TaskList taskList = TaskList.getInstance();
            UserList userList = UserList.getInstance();

            for (int i = 0; i < projectArray.size(); i++) {
                JSONObject projectDetails = (JSONObject) projectArray.get(i);

                String id = (String) projectDetails.get(PROJECT_ID);
                String name = (String) projectDetails.get(PROJECT_NAME);

                JSONArray projectUserIDs = (JSONArray) projectDetails.get(
                        PROJECT_USERS);
                ArrayList<User> users = new ArrayList<>();
                for (Object user : projectUserIDs) {
                    if (user instanceof String) {
                        String userString = (String) user;
                        UUID userUUID = UUID.fromString(userString);
                        User userlist = userList.getUser(userUUID);
                        users.add(userlist);
                    }
                }

                JSONArray columnsArray = (JSONArray) projectDetails.get("columns");
                ArrayList<Columns> columns = new ArrayList<>();
                ArrayList<Task> objTaskList = new ArrayList<>();
                ArrayList<String> columnTitlesList = new ArrayList<>();

                for (Object columnObj : columnsArray) {
                    JSONObject columnDetails = (JSONObject) columnObj;

                    String columnTitle = (String) columnDetails.get("title");
                    columnTitlesList.add(columnTitle);
                    JSONArray taskTitlesArray = (JSONArray) columnDetails.get(
                            "taskTitles");

                    for (Object taskTitle : taskTitlesArray) {
                        Task task = taskList.getTask((String) taskTitle);
                        objTaskList.add(task);
                    }
                    Columns columnsInstance = new Columns(columnTitle);
                    columns.add(
                            columnsInstance.newColumns(
                                    objTaskList,
                                    columnTitle,
                                    columnTitlesList));
                }
                Project projectInstance = new Project(name, id, users);
                projects.add(projectInstance.newProject(name, id, users, columns));
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
            FileReader reader = new FileReader(TASK_FILE_NAME);
            //JSONObject obj = (JSONObject) new JSONParser().parse(reader);
            JSONArray taskArray = (JSONArray) new JSONParser().parse(reader);

           // JSONArray taskArray = (JSONArray) obj.get("task");

            for (Object taskObj : taskArray) {
                JSONObject taskDetails = (JSONObject) taskObj;

                String taskIDString = (String) taskDetails.get(TASK_ID);
                UUID taskID = UUID.fromString(taskIDString);
                String taskName = (String) taskDetails.get(TASK_NAME);
                String description = (String) taskDetails.get(TASK_DESCRIPTION);
                String document = (String) taskDetails.get(TASK_DOCUMENT);

                JSONArray assignedUser = (JSONArray) taskDetails.get(TASK_ASSIGNED_USER);
                List<UUID> assignedUsers = new ArrayList<>();
                for (Object user : assignedUser) {
                    if (user instanceof String) {
                        String userString = (String) user;
                        UUID userUUID = UUID.fromString(userString);
                        assignedUsers.add(userUUID);
                    }
                }

                String date = (String) taskDetails.get(TASK_DATE);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date taskDate = dateFormat.parse(date);

                String taskTypeString = (String) taskDetails.get(TASK_TYPE); // turn into the task type?
                TaskType taskType = TaskType.valueOf(taskTypeString);

                JSONArray commentsArray = (JSONArray) taskDetails.get("comments");
                ArrayList<Comment> comments = parseComments(commentsArray, dateFormat);

                tasks.add(
                        new Task(
                                taskID,
                                taskName,
                                description,
                                assignedUsers,
                                document,
                                taskDate,
                                taskType,
                                comments));

            }
            return tasks;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private ArrayList<Comment> parseComments(JSONArray commentsArray, SimpleDateFormat dateFormat)
            throws ParseException {
        ArrayList<Comment> comments = new ArrayList<>();

        if (commentsArray != null) {
            for (Object commentObj : commentsArray) {
                JSONObject commentDetails = (JSONObject) commentObj;
                String comment = (String) commentDetails.get("comment");
                String userIDString = (String) commentDetails.get("userID");
                ;
                UUID userUUID = UUID.fromString(userIDString);
                User user = UserList.getInstance().getUser(userUUID);
                String commentDateString = (String) commentDetails.get("date");
                Date commentDate = dateFormat.parse(commentDateString);
                JSONArray replyArray = (JSONArray) commentDetails.get("replies");
                ArrayList<Comment> replies = parseComments(replyArray, dateFormat);

                Comment commentInstance = new Comment(comment, user, commentDate);
                commentInstance.setReplies(replies);
                comments.add(commentInstance);
            }
        }

        return comments;
    }
}
