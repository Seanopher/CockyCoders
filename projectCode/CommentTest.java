package projectCode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

/* 
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
*/
import org.junit.jupiter.api.Test;

public class CommentTest {
/* 
    @BeforeClass
    public static void oneTimeSetup(){

    }

    @AfterClass
    public static void oneTimeTearDown(){

    }

    
    @BeforeEach
	public static void setup() {
		//runs before each test
	}
	
	@AfterEach
	public static void tearDown() {
		//runs after each test
	}
*/

    /**
     * creates and instance of comments
     * adds the comment ino the array of comments
     * calls getComment 
     * 
     * -assertion tests-
     * assert equals: expect a 2 when testing th comment size
     * assertTrue: expecting the first comment to be there
     * assertTrue: expecting the reply to be there
     */
    @Test
    public void testAddCommentSize(){
        Comment comment = new Comment("this is my comment", new User("", "Beth", "Jones", "I_L0v3_C@t5", "CatLover371", "User"), new Date());
        comment.createNewComment("Comment reply", new User("", "Beth", "Jones", "I_L0v3_C@t5", "CatLover371", "User"), new Date(), comment);
        List<Comment> comments = comment.getCommentThread();

        assertEquals(2, comments.size());
        assertTrue(comments.contains(new Comment("this is my comment", new User("", "Beth", "Jones", "I_L0v3_C@t5", "CatLover371", "User"), new Date())));
        assertTrue(comments.contains(new Comment("Comment reply", new User("", "Beth", "Jones", "I_L0v3_C@t5", "CatLover371", "User"), new Date())));
    }

    /**
     * creates and instance of comments
     * adds the comment ino the array of comments
     * calls getComment 
     * 
     * -assertion tests-
     * assertNotNull: expecting the comments array to not be null
     * assertTFalse: expecting a return of false (the array to have something in it)
     */
    @Test
    public void testGetComment(){
        Comment comment = new Comment("this is my comment", new User("", "Beth", "Jones", "I_L0v3_C@t5", "CatLover371", "User"), new Date());
        comment.createNewComment("Comment reply", new User("", "Beth", "Jones", "I_L0v3_C@t5", "CatLover371", "User"), new Date(), comment);
        List<Comment> comments = comment.getCommentThread();

        assertNotNull(comments);
        assertFalse(comments.isEmpty());
    }
    


}
