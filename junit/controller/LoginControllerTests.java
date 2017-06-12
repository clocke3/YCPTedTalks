package edu.ycp.cs320.aroby.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.aroby.model.Account;

import edu.ycp.cs320.aroby.controller.LoginController;

public class LoginControllerTests {
	private Account model;
	private LoginController controller;
	
	@Before
	public void setUp() {
		model = new Account();
		controller = new LoginController();
		
		model.setEmail("aroby@ycp.edu");
		model.setPassword("password");
		model.setFirstName("aaron");
		model.setLastName("roby");
		model.setAdmin(true);
		model.setAccountId(1);		
		
	}	
}
