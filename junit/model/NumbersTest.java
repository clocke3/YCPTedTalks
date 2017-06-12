package edu.ycp.cs320.aroby.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class NumbersTest {
	private Numbers model;
	private Double first;
	private Double second;
	private Double third;
	
	@Before
	public void setUp() {
		model = new Numbers();
		
		first = 1.0;
		second = 1.0;
		third = 1.0;
	}
	
	@Test
	public void testSetFirst() {
		model.setFirst(second);
		assertEquals(first, model.getFirst());
	}
	
	public void testGetFirst() {
		assertEquals(first, model.getFirst());
	}
	
	public void testSetSecond() {
		model.setSecond(second);
		assertEquals(second, model.getSecond());
	}
	
	public void testGetSecond() {
		assertEquals(second, model.getSecond());
	}
	
	public void testSetThird() {
		model.setThird(third);
		assertEquals(third, model.getThird());
	}
	
	public void testGetThird() {
		assertEquals(third, model.getThird());
	}
}
