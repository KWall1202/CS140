package assignment04; 

public class Employee{
    private Person person;
    private double salary;
    
    public Employee(Person aPerson) {
        person = aPerson;
    }
    
    public void setSalary(double newSalary) {
        salary = newSalary;
    }
    
    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append("Name: ");
        build.append(person.getFirstName());
        build.append(" ");
        build.append(person.getMiddleInitial());
        build.append(". ");
        build.append(person.getLastName());
        build.append(" Salary: ");
        build.append(salary);
        return build.toString();
    }
}