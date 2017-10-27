package assignment03;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class CalendarItem {
    private LocalDateTime start;
    private LocalDateTime end;
    private String title;
    private String description;
    private String location;
    private CalendarItem nextItem;
    
    public LocalDateTime getStart() {
        return start;
    }
    
    public LocalDateTime getEnd() {
        return end;
    }

    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getLocation() {
        return location;
    }
    
    public CalendarItem getNextItem() {
        return nextItem;
    }
    
    public void setStart(LocalDateTime aStart) {
        if(end != null && end.isBefore(aStart)) {
            throw new IllegalArgumentException("the end cannot be before the start");
        } else {
            start = aStart;
        }
    }
    
    public void setEnd(LocalDateTime aEnd) {
        if(start != null && start.isAfter(aEnd)) {
            throw new IllegalArgumentException("the start cannot be after end");
        } else {
            end = aEnd;
        }
    }
    
    public void setTitle(String aTitle) {
        title = aTitle;
    }
    
    public void setDescription(String aDescription) {
        description = aDescription;
    }
    
    public void setLocation(String aLocation) {
        location = aLocation;
    }
    
    public void setNextItem(CalendarItem aNextItem) {
        nextItem = aNextItem;
    }
    
    public boolean endsBefore(CalendarItem other) {
        return end.isBefore(other.start);
    }
    
    public boolean startsAfter(CalendarItem other) {
        return start.isAfter(other.end);
    }
    
    public boolean noTimeConflictWith(CalendarItem other) {
        return endsBefore(other) || startsAfter(other);
    }	
    
    public boolean hasTimeConflictWith(CalendarItem other) {
        return !noTimeConflictWith(other);
    }
    
    public String toString() {
	DateTimeFormatter dayForm =  DateTimeFormatter.ofPattern("MMMM d, yyyy");
	DateTimeFormatter timeForm =  DateTimeFormatter.ofPattern("h:m a");
	return start.format(dayForm) +" from " + start.format(timeForm) 
			+ " to " + end.format(timeForm) + "\n"
			+ title + " in " + location + "\n"
			+ description;
    }
}