package edu.ycp.cs320.aroby.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.aroby.controller.GuessingGameController;
import edu.ycp.cs320.aroby.model.GuessingGame;

public class GuessingGameControllerTest {
	private GuessingGame model;
	private GuessingGameController controller;
	
	@Before
	public void setUp() {
		model = new GuessingGame();
		controller = new GuessingGameController();
		
		model.setMin(1);
		model.setMax(100);
		
		controller.setModel(model);
	}
	
	@Test
	public void testNumberIsGreater() {
		int currentGuess = model.getGuess();
		controller.setNumberIsGreaterThanGuess();
		assertTrue(model.getGuess() > currentGuess);
	}
	
	public void testNumberIsLesser() {
		int currentGuess = model.getGuess();
		controller.setNumberIsLessThanGuess();
		assertTrue(model.getGuess() < currentGuess);
	}
	
	public void testStartGame() {
		controller.startGame();
		assertTrue(1 == model.getMin());
		assertTrue(100 == model.getMax());
	}
	
	public void testSetNumberFound() {
		controller.setNumberFound();
		assertTrue(model.getMin() == model.getMin());
		assertTrue(model.getMin() == model.getGuess());
		assertTrue(model.getMax() == model.getGuess());
	}
}
