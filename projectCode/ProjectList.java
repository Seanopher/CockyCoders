package projectCode;

import java.util.ArrayList;

public class ProjectList {
    private static ProjectList projectList;
    private ArrayList<Project> projects;
    private DataLoader dataLoader;

    /*
     * calls DataLoader to load the Arraylist
     * returns an ArrayList from loadProjects
     */
    private ProjectList()
    {
        dataLoader = new DataLoader(); 
        projects = dataLoader.loadProjects();
    }


    /*
     * gets instance of ProjectList
     */
    public static ProjectList getInstance()
    {
        if(projectList == null)
        {
            projectList = new ProjectList();
        }
        return projectList;
    }


    public Project getProject(String projectID)
    {
        for (Project project : projects)
        {
            if (project.getProjectID().equals(projectID)) //checks if projectID matches
            {
                return project; //returns a project matching the projectID
            }
        }
            /*
            * project is not found
            */
        return null;
    }


}
