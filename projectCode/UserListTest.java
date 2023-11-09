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
     * Testing UserList class
     */
public class UserListTest {
    private UserList users = UserList.getInstance();
	private ArrayList<User> userList = users.getUsers();
	
	@BeforeEach
	public void setup() {
		userList.clear();
        String uuid = UUID.randomUUID().toString();
        ArrayList<Project> projectList = null;
		userList.add(new User(uuid, "Samuel", "Falcon", "password123", "SFalcon", "USER"));
		userList.add(new User(uuid, "Ashton", "Putman", "password321", "APutman", "USER"));
		DataWriter.saveUsers(userList);
	}
	
	@AfterEach
	public void tearDown() {
		users.getUsers().clear();
		DataWriter.saveUsers(userList);
	}
	
	
	@Test
	void testHaveUserValidFirstItem() {
		User hasSamuelUser = users.login("SFalcon", "password123");
		assertNotNull(hasSamuelUser);
	}
	
	@Test
	void testHaveUserValidLastItem() {
		User hasAshtonUser = users.login("APutman", "password321");
		assertNotNull(hasAshtonUser);
	}
	
	@Test
	void testHaveUserInValid() {
		User hasInvalidUser = users.login("jsmith", "wrongpassword");
		assertNull(hasInvalidUser);
	}
	
	@Test
	void testHaveUserEmpty() {
		User hasEmpty = users.login("", "");
		assertNull(hasEmpty);
	}
	
}