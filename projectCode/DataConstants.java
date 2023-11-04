package projectCode;

/**
 * allows for the calling of the variables in the json files
 */
public abstract class DataConstants {
    protected static final String USER_FILE_NAME = "User.json";
    protected static final String USER = "userID";
    protected static final String USER_FIRST_NAME = "firstName";
    protected static final String USER_LAST_NAME = "lastName";
    protected static final String USER_USERNAME = "username";
    protected static final String USER_PASSWORD = "password";
    protected static final String USER_USERTYPE = "userType";
    protected static final String USER_PROJECTS = "projects";

    protected static final String TASK_FILE_NAME = "Task.json";
    protected static final String TASK_NAME = "taskName";
    protected static final String TASK_DESCRIPTION = "description";
    protected static final String TASK_ASSIGNED_USER = "assignedUser";
    protected static final String TASK_DATE = "date";
    protected static final String TASK_DOCUMENT = "document";
    protected static final String TASK_TYPE = "taskType";
    protected static final String TASK_COMMENTS = "comments";

    protected static final String PROJECT_FILE_NAME = "Project.json";
    protected static final String PROJECT_ID = "id";
    protected static final String PROJECT_NAME = "name";
    protected static final String PROJECT_USERS = "users";
    protected static final String PROJECT_COLUMNS = "columns";
}
