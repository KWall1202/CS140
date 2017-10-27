package assignment05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Lodging implements TravelExpenses {
	private LocalDate startDate;
	private LocalDate endDate;
	private String lodgingName;
	private int numberOfNights;
	private double costOfStay;
	
	
	public Lodging(LocalDate startDate, LocalDate endDate, String lodgingName, double costOfStay) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.lodgingName = lodgingName;
		this.costOfStay = costOfStay;
		numberOfNights = (int)ChronoUnit.DAYS.between(startDate, endDate);
	}

	@Override
	public int sequenceNo() {
		return 6;
	}

	@Override
	public double amountToReimburse() {
		return costOfStay;
	}
	
	@Override
	public String getDescription() {
		return String.format("Stayed in %s for %d nights from %s to %s", lodgingName, numberOfNights, startDate, endDate);
	}

	@Override
	public LocalDate getStartDate() {
		return startDate;
	}


	@Override
	public LocalDate getEndDate() {
		return endDate;
	}
}