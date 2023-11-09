package projectCode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
/* 
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
*/
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// tested by Sean Nary (Seanopher)

public class ProjectFacadeTest {
    ProjectFacade facade = new ProjectFacade();

    /*
     * login test
     * 
     * creates new user
     * creates user login input (username, password)
     * checks result
     * 
     * -assertion tests-
     * assertTrue: expects user to login
     * assertFalse: expects invalid user 
     */
    
    @Test
    public void testValidLogin()
    {
        User user = new User("01", "Atticus", "Madden", "Madden23", "AMadden", "ADMIN");
        String userName = "AMadden";
        String password = "Madden23";

        assertTrue(facade.login(userName, password));
    }

    @Test
    public void testInvalidLogin()
    {
        User user = new User("01", "Atticus", "Madden", "Madden23", "AMadden", "ADMIN");
        String userName = "Seanopher";
        String password = "Berserk1";

        assertFalse(facade.login(userName, password));
    }


    /* 
     * createUser tests
     * 
     * attemps to create new user and returns result from facade
     * 
     * -assertion tests-
     * assertNotNull: checks if new User is created
     * assertNull: checks if new User is NOT created
     */

    @Test
    public void testCreateUser()
    {
        assertNotNull(facade.createUser(UUID.randomUUID(), "Atticus", "Madden", "Madden25", "AMadden", "ADMIN"));
    }

    @Test
    public void testCreateInvalidUser()
    {
        assertNull(facade.createUser(UUID.randomUUID(), null, "Madden", "Madden25", "AMadden", "ADMIN"));
    }


    /*
     * changeType test
     * 
     * -assertion tests-
     * assertTrue: expects user to change type
     * assertFalse: expects user unable to change type
     * 
     */

    @Test 
    public void testChangeUserType()
    {
      User user = new User("01", "Atticus", "Madden", "Madden23", "AMadden", "ADMIN");
       
      assertTrue(facade.changeType(user));
    }

    @Test 
    public void testChangeInvalidUserType()
    {
      User user = null;
       
      assertFalse(facade.changeType(user));
    }


    /*
     * joinProject test
     * 
     * -assertion tests-
     * assertTrue: expects user to join project
     * assertFalse: expects user unable to join project
     */

      @Test
      public void testJoinProject()
      {
        Project testProject = new Project("testProject", "01", null);
        User user = new User("01", "Atticus", "Madden", "Madden23", "AMadden", "ADMIN");

        assertTrue(facade.joinProject(testProject, user));
      }

      @Test
      public void testJoinInvalidProject()
      {
        Project testProject = null;
        User user = new User("01", "Atticus", "Madden", "Madden23", "AMadden", "ADMIN");

        assertFalse(facade.joinProject(testProject, user));
      }


      /* 
       * leaveProject test
       * 
       * -assertion tests-
       * assertTrue: expects user to leave project
       * assertFalse: expects user unable to leave project
       */

       @Test
       public void testLeaveProject()
       {
        Project testProject = new Project("testProject", "01", null);
        User user = new User("01", "Atticus", "Madden", "Madden23", "AMadden", "ADMIN");
        facade.joinProject(testProject, user);
        
        assertTrue(facade.leaveProject(testProject, user));
       }

       @Test
       public void testInvalidLeaveProject()
       {
        Project testProject = null;
        User user = new User("01", "Atticus", "Madden", "Madden23", "AMadden", "ADMIN");

        assertFalse(facade.leaveProject(testProject, user));
       }


       /*
        * createColumn test
        *
        *
        * -assertion tests-
        * assertNotNull: expects column to be created
        * assertNull: expects column not to be created due to duplicate name
        */

        @Test
        public void testCreateColumn()
        {
            assertNotNull(facade.createColumn("testColumn"));
        }

        @Test 
        public void testCreateDuplicateColumn()
        {
            facade.createColumn("testColumn");
            assertNull(facade.createColumn("testColumn"));
        }


        /*
         * removeColumn test
         * 
         * 
         * -assertion tests-
         * assertDoesNotThrow: expects column to be removed without error
         */

        @Test
        public void testRemoveColumn()
        {
            // !!! not able to test method because does not return a value. change in next sprint.
            Columns testColumn = new Columns("testColumn");
            facade.createColumn("testColumn");
            // assertDoesNotThrow(facade.removeColumn(testColumn, "testColumn"));
        }


        /*
         * changeColumn test
         * 
         * -assertion test-
         * assertNotNull: expects column to be changed and valid return value
         * assertNull: expects null return due to invalid params
         */

        @Test
        public void testChangeColumn()
        {
            Columns columnFrom = new Columns("columnFrom");
            Columns columnTo = new Columns("columnTo");
            User user = new User("01", "Atticus", "Madden", "Madden23", "AMadden", "ADMIN");
            Task task = new Task(null, null, null, null, null, null, null, null);

            assertNotNull(facade.changeColumn(columnFrom, columnTo, task));
        }

        @Test
        public void testChangeInvalidColumn()
        {
            Columns columnFrom = new Columns("columnFrom");
            Columns columnTo = new Columns("columnTo");
            User user = new User("01", "Atticus", "Madden", "Madden23", "AMadden", "ADMIN");
            Task task = new Task(null, null, null, null, null, null, null, null);

            assertNull(facade.changeColumn(columnFrom, columnTo, task));
        }


        /*
         * addTask test
         * 
         * -assertions-
         * assertTrue: expects true return after task is added to a column
         * assertFalse: expects false return due to invalid params
         */

        @Test
        public void testAddTask()
        {
           List<UUID> list = new ArrayList<UUID>();
           List<Comment> comments = new ArrayList<Comment>();
           Date date = new Date(0);
           User user = new User("01", "Atticus", "Madden", "Madden23", "AMadden", "ADMIN");
           Columns column = new Columns("testColumn");
           Task test = new Task(UUID.randomUUID(),"TaskName", "\n Description: MAKE SURE TO DETONATE AT WARP SPEED", list, "Document", date, TaskType.CODE, comments);

           assertTrue(facade.addTask(column, test));
        } 

        @Test
        public void testInvalidAddTask()
        {
           List<UUID> list = new ArrayList<UUID>();
           List<Comment> comments = new ArrayList<Comment>();
           Date date = new Date(0);
           User user = new User("01", "Atticus", "Madden", "Madden23", "AMadden", "ADMIN");
           Columns column = null;
           Task test = new Task(UUID.randomUUID(),"TaskName", "\n Description: MAKE SURE TO DETONATE AT WARP SPEED", list, "Document", date, TaskType.CODE, comments);

           assertFalse(facade.addTask(column, test));
        } 


        /*
         * removeTask test
         * 
         * -assertions-
         * assertNotNull: expects return value for properly removed task
         * assertNull: expects null for unexisting tasks 
         */

        @Test 
        public void removeTaskTest()
        {
           List<UUID> list = new ArrayList<UUID>();
           List<Comment> comments = new ArrayList<Comment>();
           Date date = new Date(0);
           Task test = new Task(UUID.randomUUID(),"TaskName", "\n Description: MAKE SURE TO DETONATE AT WARP SPEED", list, "Document", date, TaskType.CODE, comments);

           assertNotNull(facade.removeTask(test));
        }

        @Test
        public void removeInvalidTaskTest()
        {
           Task test = null;

           assertNull(facade.removeTask(test));
        }


        /* 
         * addComment test
         * 
         * -assertions-
         * assertNotNull: expects new comment to be returned
         */

        @Test 
        public void testAddComment()
        {
            List<UUID> list = new ArrayList<UUID>();
            List<Comment> comments = new ArrayList<Comment>();
            User user = new User("01", "Atticus", "Madden", "Madden23", "AMadden", "ADMIN");
            Date date = new Date(0);
            Task initialize = new Task(UUID.randomUUID(),"TaskName", "\n Description: MAKE SURE TO DETONATE AT WARP SPEED", list, "Document", date, TaskType.CODE, comments);
            
            assertNotNull(facade.addComment("This is my comment", user, date, initialize));
        } 


        /*
         * displayUserProjects test
         * 
         * -assertions-
         * assertNotNull: expects users projects to be returned
         */

        @Test
        public void testDisplayUserProjects()
        {
            User user = new User("01", "Atticus", "Madden", "Madden23", "AMadden", "ADMIN");

            assertNotNull(facade.displayUserProjects(user));
        }


        /*
         * displayColumns test
         * 
         * -assertions-
         * assertNotNull: expects projects columns to be displayed
         */

        @Test
        public void testDisplayColumns()
        {
            List<UUID> list = new ArrayList<UUID>();
            List<Comment> comments = new ArrayList<Comment>();
            Date date = new Date(0);
            Task initialize = new Task(UUID.randomUUID(),"TaskName", "\n Description: MAKE SURE TO DETONATE AT WARP SPEED", list, "Document", date, TaskType.CODE, comments);
            Project testProj = new Project("testProj", "02", null);

            assertNotNull(facade.displayColumns(testProj, initialize));
        }

    
}

