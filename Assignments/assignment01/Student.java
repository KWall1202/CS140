package assignment01;

/**
 * A class representing a student
 */
public class Student {
	private Person self; // person enrolled as student
	private Class class1 = Class.DUMMY_CLASS; // a class the student is enrolled in
	private Class class2 = Class.DUMMY_CLASS; // a class the student is enrolled in
	private Class class3 = Class.DUMMY_CLASS; // a class the student is enrolled in
	private Class class4 = Class.DUMMY_CLASS; // a class the student is enrolled in

    /**
     * Sets the value of the first class's quality points
     *
     * @param qPoints the quality ponts of the course
     */
	public void setQualPoints1(double qPoints) {
		class1.setQualPoints(qPoints);
	}

	public void setQualPoints2(double qPoints) {
		class2.setQualPoints(qPoints);
	}

	public void setQualPoints3(double qPoints) {
		class3.setQualPoints(qPoints);
	}

	public void setQualPoints4(double qPoints) {
		class4.setQualPoints(qPoints);
	}

	public void setClass1(Class course) {
		class1 = course;
	}

	public void setClass2(Class course) {
		class2 = course;
	}

	public void setClass3(Class course) {
		class3 = course;
	}

	public void setClass4(Class course) {
		class4 = course;
	}

	public String getName() {
		return self.getFirstName() + " " + self.getMiddleInitial() + ". " + self.getLastName();
	}

	public Class getClass1() {
		return class1;
	}

	public Class getClass2() {
		return class2;
	}

	public Class getClass3() {
		return class3;
	}

	public Class getClass4() {
		return class4;
	}

	public double computeSemesterGPA() {
		double gpa = 0.0;
		double totalPoints = class1.getQualPoints() + class2.getQualPoints() + class3.getQualPoints() + class4.getQualPoints();
		int totalCredits = class1.getNumCredits() + class2.getNumCredits() + class3.getNumCredits() + class4.getNumCredits();
		if (totalCredits > 0) {
			gpa = totalPoints / totalCredits;
		}
		return gpa;
	}

	public Student(Person aStudent) {
		self = aStudent;
	}
}
