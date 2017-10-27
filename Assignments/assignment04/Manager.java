package assignment04;

import java.util.ArrayList;

public class Manager extends Employee {
    private String department;
    private ArrayList<Employee> team = new ArrayList<>();

    public Manager(Person aPerson) {
        super(aPerson);
    }
    
    public void setDepartment(String newDepartment) {
        department = newDepartment;
    }
    
    public void addToTeam(Employee newTeammate) {
        team.add(newTeammate);
    }
    
    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append(super.toString());
        build.append("\n");
        build.append("Department:  ");
        build.append(department);
        build.append("\n");
        for (Employee teamMember : team) {
            build.append("\t");
            build.append(teamMember.toString());
            build.append("\n");
        }
        return build.toString();
    }
}