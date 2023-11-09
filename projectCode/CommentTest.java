package projectCode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

/*
import org.junit.Before; 
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
*/
import org.junit.jupiter.api.Test;

public class CommentTest {

    /**
     * AddComments Tests
     * creates an instance of comments
     * adds the comment ino the array of comments
     * calls getComment 
     * 
     * -assertion tests-
     * assert equals: expect a 1 when testing th comment size
     * assertTrue: expecting the first comment to be there
     * assertTrue: expecting the reply to be there
     */
    @Test
    public void testCreateCommentSize(){
        String message = "this is my comment";
        String replyMessage = "Comment reply";
        Comment comment = new Comment(message, new User("", "Beth", "Jones", "I_L0v3_C@t5", "CatLover371", "User"), new Date());
        comment.createNewComment(replyMessage, new User("", "Beth", "Jones", "I_L0v3_C@t5", "CatLover371", "User"), new Date(), comment);
        List<Comment> comments = comment.getCommentThread();

        assertEquals(1, comments.size());
    }
    @Test
    public void testAddCommentOriginalComment(){
        String message = "this is my comment";
        String replyMessage = "Comment reply";
        Comment comment = new Comment(message, new User("", "Beth", "Jones", "I_L0v3_C@t5", "CatLover371", "User"), new Date());
        comment.createNewComment(replyMessage, new User("", "Beth", "Jones", "I_L0v3_C@t5", "CatLover371", "User"), new Date(), comment);
        List<Comment> comments = comment.getCommentThread();

        assertTrue(comments.contains(new Comment("this is my comment", new User("", "Beth", "Jones", "I_L0v3_C@t5", "CatLover371", "User"), new Date())));
    }
    @Test
    public void testAddCommentSecondComment(){
        String message = "this is my comment";
        String replyMessage = "Comment reply";
        Comment comment = new Comment(message, new User("", "Beth", "Jones", "I_L0v3_C@t5", "CatLover371", "User"), new Date());
        comment.createNewComment(replyMessage, new User("", "Beth", "Jones", "I_L0v3_C@t5", "CatLover371", "User"), new Date(), comment);
        List<Comment> comments = comment.getCommentThread();

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
    public void testGetCommentThreadNotNull(){
        String message = "this is my comment";
        String replyMessage = "Comment reply";
        Comment comment = new Comment(message, new User("", "Beth", "Jones", "I_L0v3_C@t5", "CatLover371", "User"), new Date());
        comment.createNewComment(replyMessage, new User("", "Beth", "Jones", "I_L0v3_C@t5", "CatLover371", "User"), new Date(), comment);
        List<Comment> comments = comment.getCommentThread();

        assertNotNull(comments);
    }
    @Test
    public void testGetCommentThreadIsFalse(){
        String message = "this is my comment";
        String replyMessage = "Comment reply";
        Comment comment = new Comment(message, new User("", "Beth", "Jones", "I_L0v3_C@t5", "CatLover371", "User"), new Date());
        comment.createNewComment(replyMessage, new User("", "Beth", "Jones", "I_L0v3_C@t5", "CatLover371", "User"), new Date(), comment);
        List<Comment> comments = comment.getCommentThread();

        assertFalse(comments.isEmpty());
    }


}
