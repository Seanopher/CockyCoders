package projectCode;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

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
		DataWriter.saveProjects(projectList);
	}
	
    /**
     * After each test projects clears
     */
	@AfterEach
	public void tearDown() {
		projects.getInstance().getProjects().clear();
		DataWriter.saveProjects(projectList);
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
