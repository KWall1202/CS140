package assignment05;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class Tester2 {
	@Test
	public void testSortClassByCourseProgress() {
		ArrayList<Student> roster = new ArrayList<>();
		Course crs = new Course("Test Course");
		crs.setNumReadings(4);
		crs.setPages(0, 25);
		crs.setPages(1, 35);
		crs.setPages(2,  10);
		crs.setPages(3, 30);
		for(int i=0; i < 5; i++) {
			roster.add(new Student(new Person(NamesResource.getRandomLastName(), NamesResource.getRandomFirstName(), NamesResource.getRandomBirthDate(2016))));
			roster.get(i).setCourse(crs);
		}
		for(int i=0; i < 24; i++) {
			roster.get(3).read(0);
			roster.get(1).read(0);
		}
		for(int i=0; i < 10; i++) {
			roster.get(2).read(2);
			roster.get(3).read(2);
			roster.get(1).read(3);
		}
		for(int i=0; i < 35; i++) {
			roster.get(0).read(1);
		}
		roster.add(new Student(new Person(NamesResource.getRandomLastName(), NamesResource.getRandomFirstName(), NamesResource.getRandomBirthDate(2016))));
		roster.add(new Student(new Person(NamesResource.getRandomLastName(), NamesResource.getRandomFirstName(), NamesResource.getRandomBirthDate(2016))));
		System.out.println("1st student goes to 7th, 2nd goes to 5th, 3rd goes to 4th, 4th goes to 6th, 5th goes to 3rd, The last two go to the front in alphabetical order");
		System.out.println("--------------Roster before sort--------------");
		for(Student i : roster) {
			System.out.println(i);
		}
		Collections.sort(roster, new ByCourseProgress());
		System.out.println("--------------Roster After sort--------------");
		for(Student i : roster) {
			System.out.println(i);
		}
	}
	
	@Test
	public void testRead() {
		Student s1 = new Student(new Person(NamesResource.getRandomLastName(), NamesResource.getRandomFirstName(), NamesResource.getRandomBirthDate(2016)));
		Course crs = new Course("Test Course");
		crs.setNumReadings(4);
		crs.setPages(0, 25);
		crs.setPages(1, 35);
		crs.setPages(2,  10);
		crs.setPages(3, 30);
		s1.setCourse(crs);
		for(int i=0; i < 24; i++) {
			s1.read(0);
		}
		try {
			assertEquals(24, s1.percentRead());
		} catch(AssertionError e) {
			System.out.println("Student's read() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testPercentRead() {
		Student s1 = new Student(new Person(NamesResource.getRandomLastName(), NamesResource.getRandomFirstName(), NamesResource.getRandomBirthDate(2016)));
		Course crs = new Course("Test Course");
		crs.setNumReadings(4);
		crs.setPages(0, 25);
		crs.setPages(1, 35);
		crs.setPages(2,  10);
		crs.setPages(3, 30);
		s1.setCourse(crs);
		for(int i=0; i < 35; i++) {
			s1.read(1);
		}
		try {
			assertEquals(35, s1.percentRead());
		} catch (AssertionError e){
			System.out.println("Student's percentRead() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testPercentCompleted() {
		Student s1 = new Student(new Person(NamesResource.getRandomLastName(), NamesResource.getRandomFirstName(), NamesResource.getRandomBirthDate(2016)));
		Course crs = new Course("Test Course");
		crs.setNumReadings(4);
		crs.setPages(0, 25);
		crs.setPages(1, 35);
		crs.setPages(2, 10);
		crs.setPages(3, 30);
		s1.setCourse(crs);
		for(int i=0; i < 35; i++) {
			s1.read(1);
		}
		try {
			assertEquals(25, s1.percentCompleted());
		} catch (AssertionError e){
			System.out.println("Student's percentCompleted() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testGetCourseNameNull() {
		Course crs = new Course(null);
		try {
			assertEquals(null, crs.getCourseName());
		} catch (AssertionError e) {
			System.out.println("Course's getCourseName() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testGetCourseName() {
		Course crs = new Course("CS 140");
		try {
			assertEquals("CS 140", crs.getCourseName());
		} catch (AssertionError e) {
			System.out.println("Course's getCourseName() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testGetCourseNull() {
		Student s1 = new Student(new Person(NamesResource.getRandomLastName(), NamesResource.getRandomFirstName(), NamesResource.getRandomBirthDate(2016)));
		Course crs = new Course(null);
		s1.setCourse(crs);
		try {
			assertEquals(crs, s1.getCourse());
		} catch (AssertionError e) {
			System.out.println("Student's getCourse() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testGetCourse() {
		Student s1 = new Student(new Person(NamesResource.getRandomLastName(), NamesResource.getRandomFirstName(), NamesResource.getRandomBirthDate(2016)));
		Course crs = new Course("CS 140");
		s1.setCourse(crs);
		try {
			assertEquals(crs, s1.getCourse());
		} catch (AssertionError e) {
			System.out.println("Student's getCourse() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testGetNumReadings() {
		Course crs = new Course(null);
		crs.setNumReadings(3);
		try {
			assertEquals(3, crs.getNumReadings());
		} catch (AssertionError e) {
			System.out.println("Course's getNumReadings() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testGetTotalPages() {
		Course crs = new Course(null);
		crs.setNumReadings(3);
		crs.setPages(2, 55);
		try {
			assertEquals(55, crs.getTotalPages(2));
		} catch (AssertionError e) {
			System.out.println("Course's getTotalPages() method failed: " + e.getMessage());
			throw e;
		}
	}
}
