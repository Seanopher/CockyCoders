package projectCode;

import java.util.ArrayList;

/**
 * @author Cocky Coders
 * Project list class that creates and holds the List of projects
 */
public class ProjectList {

    /**
     * Instance Fields
     */
    private static ProjectList projectList;
    private ArrayList<Project> projects;
    private DataLoader dataLoader;

    /**
     * constructor class
     * sets the data loader and projects
     */
    private ProjectList(){
        dataLoader = new DataLoader(); 
        projects = dataLoader.loadProjects();
    }

    /**
     * Getters
     * Instance: tests if null and sets then returns the projects list
     * Project: loops through projects, checks id IDs match, then returns the project that matches or null
     */
    public static ProjectList getInstance(){
        if(projectList == null)
            projectList = new ProjectList();

        return projectList;
    }


    public Project getProject(String projectID){
        for (Project project : projects){
            if (project.getProjectID().equals(projectID))
                return project;
        }

        return null;
    }


}
