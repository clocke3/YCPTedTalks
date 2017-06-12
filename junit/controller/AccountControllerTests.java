package edu.ycp.cs320.aroby.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.aroby.controller.GuessingGameController;
import edu.ycp.cs320.aroby.model.Account;
import edu.ycp.cs320.aroby.model.GuessingGame;

public class AccountControllerTests {
	private Account model;
	private AccountController controller;
	
	@Before
	public void setUp() {
		model = new Account();
		controller = new AccountController();
		
		model.setEmail("email");
		model.setPassword("password");
		model.setAdmin(false);
		model.setFirstName("good");
		model.setLastName("student");
		
		controller.setModel(model);
	}
	
	@Test
	public void TestModel() {
		assertTrue(model == controller.getModel());
	}
}