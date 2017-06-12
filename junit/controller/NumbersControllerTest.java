package edu.ycp.cs320.aroby.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.aroby.controller.NumbersController;
import edu.ycp.cs320.aroby.model.Numbers;

public class NumbersControllerTest {
	private Numbers model;
	private NumbersController controller; 
	
	@Before
	public void setUp() {
		model = new Numbers();
		controller = new NumbersController();
		
		model.setFirst(10.0);
		model.setSecond(10.0);
		model.setThird(10.0);
		
		controller.setModel(model);
	}
	
	@Test
	public void testAdd() {
		double result = controller.add();
		assertTrue(result == model.getFirst() + model.getSecond() + model.getThird());
	}
	
	public void testMultiply() {
		double result = controller.multiply();
		assertTrue(result == model.getFirst() * model.getSecond());
	}
}
