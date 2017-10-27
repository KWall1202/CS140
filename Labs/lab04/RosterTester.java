package lab04;

public class RosterTester {
    public static void main(String[] args) {
        Roster testRoster = new Roster();
        Student sStuden = new Student(2001235, "Some Student");            
        Student kWallac = new Student(652592, "Kevin Wallace");
        Student gWashin = new Student(000001, "George Washington");
        Student aHam = new Student(10, "Alexander Hamilton");
        testRoster.addStudent(sStuden);
        testRoster.addStudent(kWallac);
        testRoster.addStudent(gWashin);
        testRoster.addStudent(aHam);
        System.out.println("Expected: [Some Student, Kevin Wallace, George Washington, Alexander Hamilton]");
        System.out.println(testRoster);
        testRoster.dropStudent(gWashin.getName());
        System.out.println("Expected: [Some Student, Kevin Wallace,  Alexander Hamilton]");
        System.out.println(testRoster);
        testRoster.sortById();
        System.out.println("Expected: [Alexander Hamilton, Kevin Wallace, Some Student]");
        System.out.println(testRoster);
        System.out.println("Expected: \nAlexander Hamilton\n10\nKevin Wallace\n652592\nSome Student\n2001235\n");
        for (Student s: testRoster.getRoster()) {
            System.out.println(s.getName());
            System.out.println(s.getId());
        }
    }
}
