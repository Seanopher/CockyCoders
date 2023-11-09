package projectCode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Kaylee Walz 
 * Testing the Dataloader class
 */
public class DataLoaderTest {
    private UserList users = UserList.getInstance();
	private ArrayList<User> userList = users.getUsers();
	
	@BeforeEach
	public void setup() {
		UserList.getInstance().getUsers().clear();
		DataWriter.saveUsers(userList);
	}
	
	@AfterEach
	public void tearDown() {
		UserList.getInstance().getUsers().clear();
		DataWriter.saveUsers(userList);
	}
	
    /**
    * Writing to zero users
    */
	
	@Test
	void testWritingZeroUsers() {
		userList = users.getUsers();
		assertEquals(0, userList.size());
	}

    /**
    * Writing to 1 user
    */
	@Test
	void testWritingOneUser() {
        String uuid = UUID.randomUUID().toString();
		userList.add(new User(uuid, "Samuel", "Falcon", "password123", "SFalcon", "USER"));
		DataWriter.saveUsers(userList);
		assertEquals("SFalcon", users.getUsers().get(0).getUsername());
	}
	
    /**
    * Writing to 5 users
    */
	@Test
	void testWritingFiveUsers() {
        String uuid = UUID.randomUUID().toString();
		userList.add(new User(uuid, "Samuel", "Falcon", "password123", "SFalcon", "USER"));
		userList.add(new User(uuid, "Samuel", "Falcon", "password123", "SFalcon", "USER"));
		userList.add(new User(uuid, "Samuel", "Falcon", "password123", "SFalcon", "USER"));
		userList.add(new User(uuid, "Samuel", "Falcon", "password123", "SFalcon", "USER"));
		userList.add(new User(uuid, "Samuel", "Falcon", "password123", "SFalcon", "USER"));
		DataWriter.saveUsers(userList);
		assertEquals("SFalcon", users.getUsers().get(4).getUsername());
	}
	
    /**
    * Writing to an empty users
    */
	@Test
	void testWritingEmptyUser() {
		userList.add(new User("", "", "", "", "", ""));
		DataWriter.saveUsers(userList);
		assertEquals("", users.getUsers().get(0).getUsername());
	}
	
    /**
    * Writing a null user
    */
	@Test
	void testWritingNullUser() {
		userList.add(new User(null, "", "", 0, ""));
		DataWriter.saveUsers(userList);
		assertEquals(null, users.getUsers().get(0).getUsername());
	}
}
