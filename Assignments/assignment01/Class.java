package assignment01;

/**
 * A class representing a college class
 */
public class Class {
	private String name; // The name of the class
	private String number; // The number of the class
	private int crn; // The crn of the class
	private int numCredits; // The number of credits the class is worth
	private double qualPoints; // The number of quality points earned in the class

	public static final Class DUMMY_CLASS = new Class("Dummy", "000", 0, 0); // Default values for a class object

	/**
	 * Constructs a class object given a class name,
	 * a class number, a number of credits, and a crn
	 *
	 * @param aName the name of the class
	 * @param aNumber the class number
	 * @param aNumCredits the number of credits for the class
	 * @param aCrn the class crn
	 */
	public Class(String aName, String aNumber, int aNumCredits, int aCrn){
		name  = aName;
		number = aNumber;
		numCredits = aNumCredits;
		crn = aCrn;
		}

	/**
	 * Gets the name of the class
	 *
	 * @return the name of the class
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the course number
	 *
	 * @return the course number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Gets the number of credits the class is worth
	 *
	 * @return the number of credits
	 */
	public int getNumCredits() {
		return numCredits;
	}

	/**
	 * Gets the crn of the course
	 *
	 * @return the crn of the class
	 */
	public int getCrn() {
		return crn;
	}

	/**
	 * Gets the quality point earned from the class
	 *
	 * @return the quality points earned in the class
	 */
	public double getQualPoints() {
		return qualPoints;
	}

	/**
	 * Sets the number of quality points earned in the class
	 *
	 * @param qPoints the quality points earned in the class
	 */
	public void setQualPoints(double qPoints) {
		qualPoints = qPoints;
	}
}
