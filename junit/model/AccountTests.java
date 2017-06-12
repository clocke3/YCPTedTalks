package edu.ycp.cs320.aroby.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class AccountTests {
	private Account model;
	private String email;
	private String password;
	
	@Before
	public void setUp() {
		model = new Account();
		
		email = "email";
		password = "password";
	}
	
	@Test
	public void TestGetSetEmail() {
		model.setEmail(email);
		assertTrue(model.getEmail() == email);
	}
	
	public void TestGetSetPassword() {
		model.setPassword(password);
		assertTrue(model.getPassword() == password);
	}
}
