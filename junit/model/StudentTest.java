package edu.ycp.cs320.aroby.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class StudentTest {
	private Student first;
	private Student sec;
	private String major;
	private int ID;
	
	@Before
	public void setUp() {
		first = new Student();
		sec = new Student();
		major = "CS";
		ID = 903099099;
	}
	
	@Test
	public void TestGetSetMajor() {
		first.setMajor(major);
		assertTrue(first.getMajor() == major);
		sec.setMajor("EE");
		assertTrue(sec.getMajor() == "EE");
	}
	@Test
	public void TestGetSetPassword() {
		first.setYCPId(ID);
		assertTrue(first.getYCPId() == ID);
		sec.setYCPId(903099009);
		assertTrue(sec.getYCPId() == 903099009);
	}
	@Test
	public void TestAccountinfo(){
		first.setFirstName("Best");
		first.setLastName("Student");
		assertTrue(first.getFirstName() == "Best");
		assertTrue(first.getLastName() == "Student");
	}
}
