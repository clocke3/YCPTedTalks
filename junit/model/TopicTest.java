package edu.ycp.cs320.aroby.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TopicTest {
	private Topic topic1;
	private Topic topic2;
	private Topic topic3;
	
	@Before
	public void setUp() throws Exception{
		topic1 = new Topic();
		topic2 = new Topic();
		topic3 = new Topic();
		
		topic1.setTopic("Movies");
		topic1.setTopicId(7);
		
		topic2.setTopic("Environment");
		topic2.setTopicId(24);
		
		topic3.setTopic("Crime");
		topic3.setTopicId(52);
	}
	
	@Test
	public void test_getTopic(){
		assertEquals("Movies", topic1.getTopic());
		assertEquals("Environment", topic2.getTopic());
		assertEquals("Crime", topic3.getTopic());
	}
	
	@Test
	public void test_getTopicId(){
		assertEquals(7, topic1.getTopicId());
		assertEquals(24, topic2.getTopicId());
		assertEquals(52, topic3.getTopicId());
	}
}
