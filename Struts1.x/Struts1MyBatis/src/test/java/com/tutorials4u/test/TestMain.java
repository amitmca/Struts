package com.tutorials4u.test;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.tutorials4u.model.User;
import com.tutorials4u.service.UserService;

public class TestMain {
	private static UserService userService;

	@BeforeClass
	public static void setup() {
		userService = new UserService();
	}

	@AfterClass
	public static void teardown() {
		userService = null;
	}

	@Test
	public void testGetUserById() {
		User user = userService.getUserById(11);
		Assert.assertNotNull(user);
		System.out.println(user);
	}

	@Test
	public void testGetAllUsers() {
		List<User> users = userService.getAllUsers();
		Assert.assertNotNull(users);
		for (User user : users) {
			System.out.println(user);
		}

	}

	@Test
	public void testInsertUser() {
		User user = new User();
		user.setUsername("test");
		user.setPassword("secret");
		user.setFirstName("TestFirstName");
		user.setLastName("TestLastName");
		user.setPhone("8796154725");
		user.setEmailId("testmail@gmail.com");
		userService.insertUser(user);
		Assert.assertTrue(user.getUser_id() != 0);
		User createdUser = userService.getUserById(user.getUser_id());
		Assert.assertNotNull(createdUser);
		Assert.assertEquals(user.getEmailId(), createdUser.getEmailId());
		Assert.assertEquals(user.getPassword(), createdUser.getPassword());
		Assert.assertEquals(user.getFirstName(), createdUser.getFirstName());
		Assert.assertEquals(user.getLastName(), createdUser.getLastName());

	}

	@Test
	public void testUpdateUser() {
		long timestamp = System.currentTimeMillis();
		User user = userService.getUserById(11);
		user.setFirstName("TestFirstName" + timestamp);
		user.setLastName("TestLastName" + timestamp);
		userService.updateUser(user);
		User updatedUser = userService.getUserById(11);
		Assert.assertEquals(user.getFirstName(), updatedUser.getFirstName());
		Assert.assertEquals(user.getLastName(), updatedUser.getLastName());
	}

	@Test
	public void testDeleteUser() {
		User user = userService.getUserById(12);
		userService.deleteUser(user.getUser_id());
		User deletedUser = userService.getUserById(12);
		Assert.assertNull(deletedUser);

	}
}
