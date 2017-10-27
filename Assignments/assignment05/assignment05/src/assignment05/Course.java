package assignment05;

public class Course {
	private String courseName;
	private int[] pagesToRead;
	
	public Course(String courseName) {
		this.courseName = courseName;
	}
	public void setNumReadings(int readings) {
		pagesToRead = new int[readings];
	}
	
	public void setPages(int reading, int totalPages) {
		pagesToRead[reading] = totalPages;
	}

	public String getCourseName() {
		return courseName;
	}
	
	public int getNumReadings() {
		if(pagesToRead != null) return pagesToRead.length;
		return 0;
	}
	
	public int getTotalPages(int reading) {
		if(pagesToRead != null && reading < pagesToRead.length) return pagesToRead[reading];
		return 0;
	}
}
