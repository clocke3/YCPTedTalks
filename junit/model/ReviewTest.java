package edu.ycp.cs320.aroby.model;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.aroby.model.Review;
//set up tests
public class ReviewTest {
	private Review model1;
	private String date;
	
	// TODO: Fix these!
	@Before
	public void setUp() throws Exception {
		model1 = new Review();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		LocalDateTime dt = LocalDateTime.now();
		date = dtf.format(dt).toString();
		
		model1.setAccountId(1);
		model1.setDate(date);
		model1.setRating(3);
		model1.setReview("I really liked it.");
		model1.setReviewId(1);
		model1.setTedTalkId(5);
	}
	
	@Test
	public void test_getAccountId(){
		assertEquals(1, model1.getAccountId());
	}
	
	@Test
	public void test_getReviewId(){
		assertEquals(1, model1.getReviewId());
	}
	
	@Test
	public void test_getDate(){
		assertEquals(date, model1.getDate());
	}
	
	@Test
	public void test_getRating(){
		assertEquals(3, model1.getRating());
	}
	
	@Test
	public void test_getReview(){
		assertEquals("I really liked it.", model1.getReview());
	}
	
	@Test
	public void test_getTedTalkId(){
		assertEquals(5, model1.getTedTalkId());
	}
}
