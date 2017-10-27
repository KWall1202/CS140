package assignment04;

public class WorkforceTester {
    public static void main(String[] args) {
        Person managerOneP = new Person("Wallace", "Kevin", 'J');
        Manager managerOne = new Manager(managerOneP);    
        managerOne.setSalary(95333);
        managerOne.setDepartment("HR");
        
        Person managerTwoP = new Person("Shmo", "Joe", 'A');
        Manager managerTwo = new Manager(managerTwoP);
        managerTwo.setSalary(145750);
        managerTwo.setDepartment("Full Stack Development");
        
        Person teamOneEmpOneP = new Person("LowSalary1", "TeamOne1", 'R');
        Employee teamOneEmpOne = new Employee(teamOneEmpOneP);
        teamOneEmpOne.setSalary(45000);
        
        Person teamOneEmpTwoP = new Person("HighSalary1", "TeamOne2", 'X');
        Employee teamOneEmpTwo = new Employee(teamOneEmpTwoP);
        teamOneEmpTwo.setSalary(75000);
        
        Person teamTwoEmpOneP = new Person("LowSalary2", "TeamTwo1", 'K');
        Employee teamTwoEmpOne = new Employee(teamTwoEmpOneP);
        teamTwoEmpOne.setSalary(47500);
        
        Person teamTwoEmpTwoP = new Person("MediumSalary", "TeamTwo2", 'T');
        Employee teamTwoEmpTwo = new Employee(teamTwoEmpTwoP);
        teamTwoEmpTwo.setSalary(60125);
        
        Person teamTwoEmpThreeP = new Person("HighSalary2", "TeamTwo3", 'F');
        Employee teamTwoEmpThree = new Employee(teamTwoEmpThreeP);
        teamTwoEmpThree.setSalary(125000);
        
        Person nullPerson = new Person(null, null, 'x');
        Employee nullEmployee = new Employee(nullPerson);
        
        
        managerOne.addToTeam(teamOneEmpOne);
        managerOne.addToTeam(teamOneEmpTwo);
        //managerOne.addToTeam(null);
        
        managerTwo.addToTeam(teamTwoEmpOne);
        managerTwo.addToTeam(teamTwoEmpTwo);
        managerTwo.addToTeam(teamTwoEmpThree);
        
        System.out.println("Expected:\nName: Kevin J. Wallace Salary: 95333.0\nDepartment:  HR\n\tName: TeamOne1 R. LowSalary1 Salary: 45000.0\n\tName: TeamOne2 X. HighSalary1 Salary: 75000.0\n");
        System.out.println("Received:\n" + managerOne);
        
        System.out.println("Expected:\nName: Joe A. Shmo Salary: 145750.0\nDepartment:  Full Stack Development\n\tName: TeamTwo1 K. LowSalary2 Salary: 47500.0\n\tName: TeamTwo2 T. MediumSalary Salary: 60125.0\n\tName: TeamTwo3 F. HighSalary2 Salary: 125000.0\n");
        System.out.println("Received:\n" + managerTwo);
    }
}