package projectCode;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

	/**
     * @Author Kaylee Walz
     * Testing TaskList class
     */
	
public class TaskListTest {
    private TaskList tasks = TaskList.getInstance();
	private ArrayList<Task> taskList = tasks.getTasks();
	
	@BeforeEach
	public void setup() {
		taskList.clear();
        UUID uuid = UUID.randomUUID();
		taskList.add(new Task(uuid, "taskname1", "description3", "doc1.pdf", "2023-08-28", "CODE"));
		taskList.add(new Task(uuid, "taskname2", "description2", "password321", "2023-08-28", "BUG"));
		DataWriter.saveTask(taskList);
	}
	
	@AfterEach
	public void tearDown() {
		tasks.getInstance().getTasks().clear();
		DataWriter.saveTask(taskList);
	}
	
	
	@Test
	void testHaveTaskValidFirstItem() {
		Task hasSamuelUser = tasks.getTask("taskname1");
		assertNotNull(hasSamuelUser);
	}
	
	@Test
	void testHaveTaskValidLastItem() {
		Task hasAshtonUser = tasks.getTask("taskname2");
		assertNotNull(hasAshtonUser);
	}
	
	@Test
	void testHaveTaskInValid() {
		Task hasInvaildTask = tasks.getTask("invaildtaskname");
		assertNull(hasInvaildTask);
	}
	
	@Test
	void testHaveTaskEmpty() {
		Task hasEmpty = tasks.getTask("");
		assertNull(hasEmpty);
	}
	
}