package projectCode;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
    /**
     * @Author Kaylee Walz
     * Testing ProjectList class
     */
public class ProjectListTest {
    
    private ProjectList projects = ProjectList.getInstance();
	private ArrayList<Project> projectList = projects.getProjects();
	

    /**
     * Setup for testing, runs before each test
     */
	@BeforeEach
	public void setup() {
		projectList.clear();
        String uuid = UUID.randomUUID().toString();
		ArrayList<User> users = null;
		projectList.add(new Project(uuid, "project1", users));
		projectList.add(new Project(uuid, "project2", users));
		DataWriter.saveProjects(projects);
	}
	
    /**
     * After each test projects clears
     */
	@AfterEach
	public void tearDown() {
		projects.getInstance().getProjects().clear();
		DataWriter.saveProjects();
	}
	
	
	@Test
	void testHaveTaskValidFirstItem() {
		Project hasProject1Project = projects.getProject("project1");
		assertNotNull(hasProject1Project);
	}
	
	@Test
	void testHaveTaskValidLastItem() {
		Project hasProject2Project = projects.getProject("project2");
		assertNotNull(hasProject2Project);
	}
	
	@Test
	void testHaveTaskInValid() {
		Project hasInvaildProject = projects.getProject("invaildprojectname");
		assertNull(hasInvaildProject);
	}
	
	@Test
	void testHaveTaskEmpty() {
		Project hasEmpty = projects.getProject("");
		assertNull(hasEmpty);
	}
	

}
