package assignment03;

import java.time.LocalDateTime;

public class CalendarTester {
    public static void main(String[] args) {        
        CalendarItem test = new CalendarItem();
        test.setDescription("this is just a sample meeting of CS 140 that has already happened");
        test.setEnd(LocalDateTime.of(2017,9,11,11,50));
        test.setStart(LocalDateTime.of(2017,9,11,10,50));
        test.setTitle("CS 140");
        test.setLocation("FA 212");
        
        CalendarItem early = new CalendarItem();
        early.setDescription("This is an early event that will come before other things");
        early.setEnd(LocalDateTime.of(2017,10,13,12,00));
        early.setStart(LocalDateTime.of(2017,10,13,10,15));
        early.setTitle("Early event");
        early.setLocation("A place");
        
        CalendarItem lateNoOverlap = new CalendarItem();
        lateNoOverlap.setDescription("This is a later event that will not overlap with \"Early event\"");
        lateNoOverlap.setEnd(LocalDateTime.of(2017,10,13,15,30));
        lateNoOverlap.setStart(LocalDateTime.of(2017,10,13,13,06));
        lateNoOverlap.setTitle("Late no overlaps event");
        lateNoOverlap.setLocation("Somewhere");
        
        CalendarItem lateOverlap = new CalendarItem();
        lateOverlap.setDescription("This is a later event that will overlap with \"Early event\"");
        lateOverlap.setEnd(LocalDateTime.of(2017,10,13,12,30));
        lateOverlap.setStart(LocalDateTime.of(2017,10,13,11,30));
        lateOverlap.setTitle("Late Overlap event");
        lateOverlap.setLocation("Somewhere else");
        
        CalendarItem pastEvent = new CalendarItem();
        pastEvent.setDescription("Event that happened in the past");
        pastEvent.setEnd(LocalDateTime.of(2017,9,10,14,30));
        pastEvent.setStart(LocalDateTime.of(2017,9,10,12,30));
        pastEvent.setTitle("Past event");
        pastEvent.setLocation("The past");
        
        LocalDateTime nowTime = LocalDateTime.now();
        CalendarItem currentEvent = new CalendarItem();
        currentEvent.setDescription("Event that is occurring right now");
        currentEvent.setEnd(nowTime.plusMinutes(30));
        currentEvent.setStart(nowTime);
        currentEvent.setTitle("Current event");
        currentEvent.setLocation("The present");
        
        CalendarItem nullEvent = null;
        CalendarItem nullTimes = new CalendarItem();
        
        System.out.println("Expected value: false");
        System.out.println(early.hasTimeConflictWith(lateNoOverlap));
        
        System.out.println("Expected value: false");
        System.out.println(lateNoOverlap.hasTimeConflictWith(early));
        
        System.out.println("Expected value: true");
        System.out.println(lateOverlap.hasTimeConflictWith(early));

        System.out.println("Expected value: true");
        System.out.println(early.hasTimeConflictWith(lateOverlap));
        
        System.out.println("Expected value: false");
        System.out.println(lateNoOverlap.hasTimeConflictWith(lateOverlap));
        
        System.out.println("Expected value: false");
        System.out.println(lateOverlap.hasTimeConflictWith(lateNoOverlap));
        
        System.out.println("Expected value: true");
        System.out.println(early.noTimeConflictWith(lateNoOverlap));
        
        System.out.println("Expected value: true");
        System.out.println(lateNoOverlap.noTimeConflictWith(early));
        
        System.out.println("Expected value: false");
        System.out.println(lateOverlap.noTimeConflictWith(early));

        System.out.println("Expected value: false");
        System.out.println(early.noTimeConflictWith(lateOverlap));
        
        System.out.println("Expected value: true");
        System.out.println(lateNoOverlap.noTimeConflictWith(lateOverlap));
        
        System.out.println("Expected value: true");
        System.out.println(lateOverlap.noTimeConflictWith(lateNoOverlap));
        
        System.out.println("Expected value: true");
        System.out.println(lateOverlap.endsBefore(lateNoOverlap));

        System.out.println("Expected value: false");
        System.out.println(lateNoOverlap.endsBefore(lateOverlap));
        
        System.out.println("Expected value: false");
        System.out.println(lateNoOverlap.endsBefore(early));

        System.out.println("Expected value: true");
        System.out.println(lateOverlap.endsBefore(lateNoOverlap));
        
        System.out.println("Expected value: true");
        System.out.println(early.endsBefore(lateNoOverlap));
        
        System.out.println("Expected value: false");
        System.out.println(early.endsBefore(lateOverlap));
        
        System.out.println("Expected value: false");
        System.out.println(lateOverlap.startsAfter(lateNoOverlap));

        System.out.println("Expected value: true");
        System.out.println(lateNoOverlap.startsAfter(lateOverlap));
        
        System.out.println("Expected value: true");
        System.out.println(lateNoOverlap.startsAfter(early));

        System.out.println("Expected value: false");
        System.out.println(lateOverlap.startsAfter(lateNoOverlap));
        
        System.out.println("Expected value: false");
        System.out.println(early.startsAfter(lateNoOverlap));
        
        System.out.println("Expected value: false");
        System.out.println(early.startsAfter(lateOverlap));
        
        CalendarList events = new CalendarList();
        System.out.println("Testing setNext on empty list");
        events.setNext();
        System.out.println("Method called");
        System.out.println("Testing resetFirst on empty list");
        events.resetFirst();
        System.out.println("Method called");
        events.insertItem(lateOverlap);
        System.out.println("Expected value: null");
        events.printNext();
        System.out.println("Expecting \"Late overlap\" event");
        events.setNext();
        events.printNext();
        System.out.println("Expecting an Optional empty");
        System.out.println(events.findConflict(lateNoOverlap));
        events.insertItem(lateNoOverlap);
        System.out.println("Expecting \"Late overlap\" event");
        events.printNext();
        System.out.println("Expecting \"Late no overlap\" event");
        events.setNext();
        events.printNext();
        System.out.println("Expecting \"Late Overlap\", then \"Late No Overlap\"");
        events.printCalendar();
        System.out.println("Expecting \"Past Event\", then \"Late Overlap\", then \"Late No Overlap\"");
        events.testingInsert(pastEvent);
        events.printCalendar();
        System.out.println("Expecting \"Late overlap\" event");
        events.setNext();
        events.printNext();
        System.out.println("Expecting \"Late Overlap\", then \"Late No Overlap\"");
        events.resetFirst();
        events.printCalendar();
        System.out.println("Expecting \"Current Event\", then \"Late Overlap\", then \"Late No Overlap\"");
        events.testingInsert(currentEvent);
        events.printCalendar();
        System.out.println("Expecting \"Late overlap\" event");
        events.setNext();
        events.printNext();
        System.out.println("Expecting \"Late Overlap\", then \"Late No Overlap\"");
        events.resetFirst();
        events.printCalendar();
        System.out.println("Expecting an IllegalArgumentException");
        try {
            events.insertItem(early);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e);
        }
        System.out.println("Expecting Optional of \"Late Overlap Event\"");
        System.out.println(events.findConflict(early));
        System.out.println("Expecting an IllegalArgumentException");
        try {
            events.insertItem(test);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e);
        }
        System.out.println("Expecting an IllegalArgumentException");
        try {
            events.insertItem(nullEvent);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e);
        }
        System.out.println("Expecting an IllegalArgumentException");
        try {
            events.findConflict(nullEvent);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e);
        }
        System.out.println("Expecting an IllegalArgumentException");
        try {
            events.findConflict(nullTimes);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e);
        }
        System.out.println("Expecting an IllegalArgumentException");
        try {
            events.insertItem(currentEvent);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e);
        }
        System.out.println("Expecting an Optional empty");
        System.out.println(events.findConflict(currentEvent));
        
    }
}