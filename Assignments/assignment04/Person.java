package assignment04;

/**
 * A class representing a person
 */
public class Person {
	private String lastName; // The last name of the person
	private String firstName; // The first name of the person
	private char middleInitial; // The middle initial of the person
	
	/**
	 * Constructs a person object given a first name,
	 * a last name, and a middle initial
	 *
	 * @param aLastName the last name of the person
	 * @param aFirstName the first name of the person
	 * @param aMiddleInitial the middle initial of the person
	 */
	public Person(String aLastName, String aFirstName, char aMiddleInitial) {
		lastName = aLastName;
		firstName = aFirstName;
		middleInitial = aMiddleInitial;
	}
	
	/**
	 * Gets the first name of the person
	 *
	 * @return the person's first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Gets the last name of the person
	 *
	 * @return the person's last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Gets the first class the student is enrolled in
	 *
	 * @return the person's middle initial
	 */
	public char getMiddleInitial() {
		return middleInitial;
	}
}
