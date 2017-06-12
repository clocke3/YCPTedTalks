package edu.ycp.cs320.aroby.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ProfessorTest {
	private Professor first;
	private Professor sec;
	private Professor th;
	private int Id;
	private int Id1;
	private int Id2;
	
	@Before
	public void setUp() {
		first = new Professor();
		sec = new Professor();
		th = new Professor();
		Id = 123;
		Id1 = 619;
		Id2 = 1738;
	}
	
	@Test
	public void TestGetSetId() {
		first.setProfessorID(Id);
		assertTrue(first.getProfessorID() == Id);
		sec.setProfessorID(Id1);
		assertTrue(sec.getProfessorID() == Id1);
		th.setProfessorID(Id2);
		assertTrue(th.getProfessorID() == Id2);
	}
	@Test
	public void TestAccountinfo(){
		first.setFirstName("Big");
		first.setLastName("Baller");
		first.setAdmin(true);
		assertTrue(first.getFirstName() == "Big");
		assertTrue(first.getLastName() == "Baller");
		assertTrue(first.getAdmin());
	}
}
