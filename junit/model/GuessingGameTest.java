package edu.ycp.cs320.aroby.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.aroby.model.GuessingGame;

public class GuessingGameTest {
	private GuessingGame model;
	
	@Before
	public void setUp() {
		model = new GuessingGame();
	}
	
	@Test
	public void testSetMin() {
		model.setMin(1);
		assertEquals(1, model.getMin());
	}
	
	public void testSetMax() {
		model.setMax(100);
		assertEquals(100, model.getMax());
	}
	
	public void testGetMin() {
		model.setMin(10);
		assertEquals(10, model.getMin());
	}
	
	public void testGetMax() {
		model.setMax(100);
		assertEquals(100, model.getMax());
	}
	
	public void testIsDone() {
		model.setMin(10);
		model.setMax(100);
		assertEquals(true, model.isDone());
	}
	
	public void testGetGuess() {
		model.setMin(10);
		model.setMax(20);
		int guess = model.getMin() + (model.getMax()-model.getMin())/2;
		assertEquals(guess,model.getGuess());
	}
	
	public void testIsLessThan() {
		model.setMax(100);
		model.setMin(10);
		model.setIsLessThan(model.getGuess());
		assertEquals(99, model.getGuess());
	}
	
	public void testIsGreaterThan() {
		model.setMax(100);
		model.setMin(10);
		model.setIsGreaterThan(model.getGuess());
		assertEquals(11, model.getGuess());
	}
}
