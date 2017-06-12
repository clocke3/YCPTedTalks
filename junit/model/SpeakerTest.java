package edu.ycp.cs320.aroby.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SpeakerTest {
	private Speaker speaker1;
	private Speaker speaker2;
	
	@Before
	public void setUp() throws Exception{
		speaker1 = new Speaker();
		speaker2 = new Speaker();
		
		speaker1.setFirstname("Lana");
		speaker1.setLastname("Turner");
		speaker1.setSpeakerId(12);
		
		speaker2.setFirstname("Cheryl");
		speaker2.setLastname("Turner");
		speaker2.setSpeakerId(13);
	}
	
	@Test
	public void test_getFirstname(){
		assertEquals("Lana", speaker1.getFirstname());
		assertEquals("Cheryl", speaker2.getFirstname());
	}
	
	@Test
	public void test_getLastname(){
		assertEquals("Turner", speaker1.getLastname());
		assertEquals("Turner", speaker2.getLastname());
	}
	
	@Test
	public void test_getSpeakerId(){
		assertTrue(speaker1.getSpeakerId() == 12);
		assertTrue(speaker2.getSpeakerId() == 13);
	}
	
}
