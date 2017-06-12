package edu.ycp.cs320.aroby.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.aroby.model.ReadAReview;
//set up tests
public class ReadAReviewTest {
	private ReadAReview model3;
	
	@Before
	public void setUp() throws Exception {
		model3 = new ReadAReview(null, null, null, null, null, null);
		
	}
	@Test
	public void getsetTopicTest(){
		model3.setTopic("CS");
		assertEquals(model3.getTopic(), "CS");
	}
	@Test
	public void getsetDescriptTest(){
		model3.setDescription("YCP");
		assertEquals(model3.getDescript(), "YCP");
	}
	@Test
	public void getsetReviewTextTest(){
		model3.setReviewText("dca");
		assertEquals(model3.getReviewText(), "dca");
	}
	@Test
	public void getsetLinkTest(){
		model3.setLink("http");
		assertEquals(model3.getLink(), "http");
	}
	@Test
	public void getsetNameTest(){
		model3.setName("Gaz");
		assertEquals(model3.getName(), "Gaz");
	}
	@Test
	public void getsetAuthorTest(){
		model3.setAuthor("Price");
		assertEquals(model3.getAuthor(), "Price");
	}
}
