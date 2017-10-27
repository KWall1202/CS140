package assignment01;

public class Driver {
	public static void main(String[] args) {
		Person person1 = new Person("Levinstein", "Michael", 'D');
		Person person2  = new Person("Gage", "Mitchell", 'G');
		Person person3  = new Person("Wallace", "Kevin", 'J');
		Student student1 = new Student(person1);
		Student student2 = new Student(person2);
		Student student3 = new Student(person3);
		Class biol118 = new Class("Intro: Cell & Molecular Biology", "BIOL118", 4, 11271);
		Class chem231 = new Class("Organic Chemistry 1", "CHEM231", 4, 12602);
		Class mdvl101 = new Class("Intro to Medieval & Early Modern Studies", "MDVL101", 4, 15188);
		student2.setClass1(mdvl101);
		student2.setClass2(chem231);
		student3.setClass3(biol118);
		Class cs140 = new Class("Programming with Objects", "CS140", 4, 10390);
		Class cs120 = new Class("Computer Systems 1: Machine Organization", "CS120", 4, 23534);
		Class cs101 = new Class("Prof Skills Ethics & CS Trends", "CS101", 1, 10039);
		Class math304 = new Class("Linear Algebra", "MATH304", 4, 11099);
		student3.setClass1(cs101);
		student3.setClass2(cs120);
		student3.setClass3(cs140);
		student3.setClass4(math304);
		biol118.setQualPoints(4.0 * biol118.getNumCredits());
		chem231.setQualPoints(3.3 * chem231.getNumCredits());
		mdvl101.setQualPoints(3.3 * mdvl101.getNumCredits());
		cs140.setQualPoints(3.7 * cs140.getNumCredits());
		cs120.setQualPoints(3.0 * cs120.getNumCredits());
		cs101.setQualPoints(3.0 * cs101.getNumCredits());
		math304.setQualPoints(4.0 * math304.getNumCredits());
		System.out.printf(student1.getName() + "'s GPA: %.2f\n", student1.computeSemesterGPA());
        System.out.println("Expected: 0.00");
		System.out.printf(student2.getName() + "'s GPA: %.2f\n", student2.computeSemesterGPA());
        System.out.println("Expected: 3.30");
		System.out.printf(student3.getName() + "'s GPA: %.2f\n", student3.computeSemesterGPA());
        System.out.println("Expected: 3.52");
	}
}
