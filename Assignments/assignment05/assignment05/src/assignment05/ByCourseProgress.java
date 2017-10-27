package assignment05;

import java.util.Comparator;

public class ByCourseProgress implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getCourse() == null && o2.getCourse() != null) return -1;
		if(o2.getCourse() == null && o1.getCourse() != null) return 1;
		if(o2.getCourse() == null && o1.getCourse() == null) return o1.compareTo(o2);
		if(o1.percentRead() > o2.percentRead()) return 1;
		if(o1.percentRead() < o2.percentRead()) return -1;
		if(o1.percentCompleted() > o2.percentCompleted()) return 1;
		if(o1.percentCompleted() < o2.percentCompleted()) return -1;
		return o1.compareTo(o2);
	}

}
