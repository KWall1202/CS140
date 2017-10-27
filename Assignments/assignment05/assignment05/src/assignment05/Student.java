package assignment05;

public class Student implements Comparable<Student>{
	private Person self;
	private Course course;
	private int[] progress;
	private boolean[] completed;
	
	public Student(Person self) {
		super();
		this.self = self;
	}
	
	@Override
	public String toString() {
		return self.toString();
	}
	
	@Override
	public int compareTo(Student other){
		return self.compareTo(other.self);
	}
	
	public void setCourse(Course crs) {
		course = crs;
		progress = new int[crs.getNumReadings()];
		completed = new boolean[crs.getNumReadings()];
		for(int i=0; i < completed.length; i++) {
			completed[i] = false;
		}
	}
	
	public void read(int reading) {
		if (!completed[reading]) {
			progress[reading] += 1;
			if (progress[reading] >= course.getTotalPages(reading)) {
				progress[reading] = course.getTotalPages(reading); //In case somehow a student read more pages than in a reading, this sets the pages read back to the intended number so percentRead() is still accurate
				completed[reading] = true;
			}
		}
	}
	
	public int percentRead() {
		double pagesRead = 0;
		double totalPagesRequired = 0;
		for (int i=0; i < progress.length; i++) {
			pagesRead += progress[i];
			totalPagesRequired += course.getTotalPages(i);
		}
		return (int)Math.round(pagesRead * 100 / totalPagesRequired);
	}
	
	public int percentCompleted() {
		double completedReadings = 0;
		for(boolean i : completed) {
			if(i) {
				completedReadings++;
			}
		}
		return (int)Math.round(completedReadings * 100 / course.getNumReadings());
	}

	public Course getCourse() {
		return course;
	}
}
