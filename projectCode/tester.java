package projectCode;

import java.util.ArrayList;
import java.util.List;

public class tester {
    public static void main(String[] args) {
        // Testing TaskList
        TaskList taskList = TaskList.getInstance();
        ArrayList<Task> tasks = taskList.getTasks();

        System.out.println("Tasks:");
        for (Task task : tasks) {
            System.out.println("Task Name: " + task.getName());
        }

        // Testing ProjectList
        ProjectList projectList = ProjectList.getInstance();
        ArrayList<Project> projects = projectList.getProjects();

        System.out.println("\nProjects:");
        for (Project project : projects) {
            System.out.println("Project ID: " + project.getProjectID());
        }

        // Testing UserList
        UserList userList = UserList.getInstance();
        ArrayList<User> users = userList.getUsers();

        System.out.println("\nUsers:");
        for (User user : users) {
            System.out.println("Username: " + user.getUsername());
        }

        // Example login and logout
        User loggedInUser = userList.login("MrJohnDoe221", "testerPassword1");
        if (loggedInUser != null) {
            System.out.println("\nLogged in as: " + loggedInUser.getUsername());
            boolean loggedOut = userList.Logout(loggedInUser);
            if (loggedOut) {
                System.out.println("Logged out successfully.");
            }
        } else {
            System.out.println("\nLogin failed. User not found.");
        }
    }
}
