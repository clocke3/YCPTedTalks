package edu.ycp.cs320.aroby.model;

import static org.junit.Assert.*;
import edu.ycp.cs320.aroby.model.Search;
import org.junit.Before;
import org.junit.Test;

public class SearchTest {
	private Search s = new Search();
	private Search s2 = new Search();

	@Test
	public void TestSearch(){
		s.setSearch("Food");
		s2.setSearch("York");
		assertTrue(s.getSearch() == "Food");
		assertTrue(s2.getSearch() == "York");
	}
	@Test
	public void TestExtra(){
		s.setExtraSearch("Apples");
		s2.setExtraSearch("College");
		assertTrue(s.getExtraSearch() == "Apples");
		assertTrue(s2.getExtraSearch() == "College");
	}
	
}
