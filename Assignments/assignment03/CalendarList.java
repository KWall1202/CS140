package assignment03;

import java.time.LocalDateTime;
import java.util.Optional;

public class CalendarList {
    private CalendarItem first;
    private CalendarItem next;
    
    public void setNext() {
        LocalDateTime now = LocalDateTime.now();
        if (first != null) {
            CalendarItem temp = first.getNextItem();
            if (temp == null) {
                next = first;
            } else {
                while (temp != null) {
                    if (temp.getStart().isAfter(now) || temp.getStart().isEqual(now)) {
                        next = temp;
                        temp = null;
                    } else {
                    temp = temp.getNextItem();
                    }
                }
            }
        }
    }
    
    void testingInsert(CalendarItem newItem) {
        if(newItem != null) {
            Optional<CalendarItem> temp = findConflict(newItem);
            if(temp.isPresent()) {
                throw new IllegalArgumentException("You have a conflict. "
                + "Please use findConflict to find the conflicting appointment");
            }
            insert(newItem);
        }
    }
    
    private void insert(CalendarItem newItem) {
        if (first == null) {
            first = newItem;
            return;
        } else if (newItem.endsBefore(first)) {
            newItem.setNextItem(first);
            first = newItem;
        } else {
            CalendarItem temp = first;
            while(temp != null) {
                if (temp.endsBefore(newItem)) {
                    newItem.setNextItem(temp.getNextItem());
                    temp.setNextItem(newItem);
                    temp = null;
                } else {
                temp = temp.getNextItem();
                }
            }
        }
    }
    
    public void resetFirst() {
        setNext();
        first = next;
    }
    
    public void insertItem(CalendarItem newItem) {
        if (newItem == null || newItem.getStart() == null || newItem.getEnd() == null) {
            throw new IllegalArgumentException("Can't insert a null item or an item with null start or end");
        }
        if (first != null) {
            setNext();
        }
        LocalDateTime now = LocalDateTime.now();
        CalendarItem nowItem = new CalendarItem();
        nowItem.setStart(now);
        nowItem.setEnd(now);
        if (newItem.endsBefore(nowItem)) {
            throw new IllegalArgumentException("It is too late for that appointment");
        }
        if(newItem.getStart().isBefore(now)) {
            throw new IllegalArgumentException("That appointment is under way--run!");
        }
        if (first != null) {
            Optional<CalendarItem> temp = findConflict(newItem);
            if(temp.isPresent()) {
                throw new IllegalArgumentException("You have a conflict. "
                + "Please use findConflict to find the conflicting appointment");
            }
        }
        insert(newItem);
    }
    
    public Optional<CalendarItem> findConflict(CalendarItem newItem) {
        if (newItem == null || newItem.getStart() == null || newItem.getEnd() == null) {
            throw new IllegalArgumentException("Cannot find conflicts with an event with null fields");
        }
        CalendarItem temp = first;
        while (temp != null) {
            if (temp.hasTimeConflictWith(newItem)) {
                return Optional.of(temp);
            }
            temp = temp.getNextItem();
        }
        return Optional.empty();
    }
    
    public void printNext() {
        System.out.println(next);
    }
    
    public void printCalendar() {
        CalendarItem temp = first;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNextItem();
        }
    }
}