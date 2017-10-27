package lab04;

import java.util.ArrayList;

public class Roster {
    private ArrayList<Student> classRoster = new ArrayList<>();

    public ArrayList<Student> getRoster() {
        return classRoster;
    }

    public void addStudent(Student s) {
        classRoster.add(s);
    }

    public void dropStudent(String name) {
        for (int i=0; i < classRoster.size(); i++) {
            if (classRoster.get(i).getName() == name) {
                classRoster.remove(i);
            }
        }
    }
    
    public String toString() {
        String returnString = "[";
        for (int i=0; i < classRoster.size(); i++) {
            if (i < classRoster.size() - 1) {
                returnString = returnString + classRoster.get(i).getName() + ", ";
            } else {
                returnString = returnString + classRoster.get(i).getName() + "]";
            }
        }
        return returnString;
    }

    public void sortById() {
        for (int i=0; i < classRoster.size(); i++) {
            for (int j=1; j < classRoster.size() - i; j++) {
                if (classRoster.get(j).getId() < classRoster.get(j - 1).getId()) {
                    Student temp = classRoster.get(j);
                    classRoster.set(j, classRoster.get(j - 1));
                    classRoster.set(j - 1, temp);
                }
            }
        }
    }
}
