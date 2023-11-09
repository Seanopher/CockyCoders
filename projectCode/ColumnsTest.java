package projectCode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ColumnsTest {

    private Columns columns;

    /**
     * setup methhod that creates the "To Do" Column
     */
    @BeforeEach
	public void setup() {
		columns = new Columns("To Do");
	}

    /**
     * CreateColumns Tests
     * creates the column
     * 
     * -assertion tests-
     * assert equals: expect a 0 when testing the column size
     * assertTrue: expecting the first column to be there
     * assert equals: expect a 1 when testing the column size
     * assertTrue: expecting the second column to be there
     */
    @Test
    void testCreateColumnHasSize0() {
        assertEquals(0, columns.getTitles().size());
    }
    @Test
    void testCreateColumnContainsFirstColumnTitle() {
        columns.createColumn("In Progress");

        assertTrue(columns.getTitles().contains("To Do"));
    }
    @Test
    void testCreateColumnHasSize1() {
        columns.createColumn("In Progress");

        assertEquals(1, columns.getTitles().size());
    }
    @Test
    void testCreateColumnContainsSecondColumnTitle() {
        columns.createColumn("In Progress");

        assertTrue(columns.getTitles().contains("In Progress"));
    }

    /**
     * RemoveColumns Tests
     * creates the column
     * remove the column
     * 
     * -assertion tests-
     * assert equals: expect a 2 when testing the column size
     * assert equals: expect a 1 when testing the column size
     * assertTrue: expecting the second column to not be there
     * assertTrue: expecting the first column to not be there
     */
    @Test
    void testRemoveColumnHasSize2() {
        columns.createColumn("In Progress");

        assertEquals(2, columns.getTitles().size());
    }
    @Test
    void testRemoveColumnHasSize1() {
        columns.createColumn("In Progress");
        columns.removeColumn("In Progress");

        assertEquals(1, columns.getTitles().size());
    }
    @Test
    void testRemoveColumnNotContainTitle2() {
        columns.createColumn("In Progress");
        columns.removeColumn("In Progress");

        assertFalse(columns.getTitles().contains("In Progress"));
    }
    @Test
    void testRemoveColumnNotContainTitle1() {
        columns.createColumn("In Progress");
        columns.removeColumn("To Do");

        assertFalse(columns.getTitles().contains("To Do"));
    }

    /**
     * ChangeColumn Tests
     * equals columns value to columnFrom
     * declare and initialize columnTo
     * creates a task
     * adds the task to the To Do column
     * moves the task to "In Progress Column"
     * 
     * -assertion tests-
     * assert equals: expect a 1 when testing the column size
     * assert equals: expect a 0 when testing the column size
     */
    @Test
    void testChangeColumnHasSize1() {
        Columns columnFrom = columns;
        Columns columnTo = new Columns("In Progress");
        Task task = new Task(null, "Task Title", "Task Description", null, null, null, null, null);
        columnFrom.addTasks(task);
        columnFrom.changeColumn(columnFrom, columnTo, task);

        assertEquals(1, columnTo.getTasks().size());
    }
    @Test
    void testChangeColumnHasSize0() {
        Columns columnFrom = columns;
        Columns columnTo = new Columns("In Progress");
        Task task = new Task(null, "Task Title", "Task Description", null, null, null, null, null);
        columnFrom.addTasks(task);
        columnFrom.changeColumn(columnFrom, columnTo, task);

        assertEquals(0, columnFrom.getTasks().size());
    }

    /**
     * AddTask Tests
     * declare and initialize a new Task
     * adds the task
     * 
     * -assertion tests-
     * assert true: expect task added
     * assert equals: expect a 1 when testing the column tasks size
     */
    @Test
    void testAddTasksTrue() {
        Task task = new Task(null, "Task Title", "Task Description", null, null, null, null, null);

        assertTrue(columns.addTasks(task));
    }
    @Test
    void testAddTasksHasSize1() {
        Task task = new Task(null, "Task Title", "Task Description", null, null, null, null, null);
        columns.addTasks(task);

        assertEquals(1, columns.getTasks().size());
    }

    /**
     * RemoveTask Tests
     * declare and initialize a new Task
     * adds the task
     * 
     * -assertion tests-
     * assert true: expect task removed
     * assert equals: expect a 0 when testing the column tasks size
     */
    @Test
    void testRemoveTasksTrue() {
        Task task = new Task(null, "Task Title", "Task Description", null, null, null, null, null);
        columns.addTasks(task);

        assertTrue(columns.removeTasks(task));
    }
    @Test
    void testRemoveTasksHasSize0() {
        Task task = new Task(null, "Task Title", "Task Description", null, null, null, null, null);
        columns.addTasks(task);

        assertEquals(0, columns.getTasks().size());
    }

    /**
     * DisplayTasks Test
     * declare and initialize a new Task
     * adds the task
     * 
     * -assertion tests-
     * assert equals: expect displayTasks is the same as the expected display
     */
    @Test
    void testDisplayTasks() {
        Task task = new Task(null, "Task Title", "Task Description", null, null, null, null, null);
        columns.addTasks(task);

        assertEquals("To Do\nTask Title: Task Description\n", columns.displayTasks(task));
    }
}
