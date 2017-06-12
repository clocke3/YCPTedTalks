package edu.ycp.cs320.aroby.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.aroby.model.Review;

public class ReviewControllerTest {
	private Review model1, model2;
	private ReviewController controller1, controller2;
	
	@Before
	public void setUp() throws Exception {
		model1 = new Review();
		model2 = new Review();
		controller1 = new ReviewController();
		controller2 = new ReviewController();

		model1.setTedTalkId(2);
		model1.setAccountId(33);
		model1.setReview("I love it");
		model1.setReviewId(1);
		model1.setRating(3);
		
		model2.setTedTalkId(3);
		model2.setAccountId(22);
		model2.setReview("I hate it");
		model2.setReviewId(3);
		model2.setRating(8);
		
		
		controller1.setModel(model1);
		controller2.setModel(model2);
		
		controller1.getModel();
		controller2.getModel();
	}
	
	@Test
	public void test_isCorrect(){
		assertTrue(controller1.isCorrect());
		assertFalse(!controller2.isCorrect());
	}
}
