package assignment05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TravelByRentalCar implements TravelExpenses {
	private double totalRentalCost;
	private double fuelCost;
	private double fuelUsed;
	private int numberOfDaysRented;
	private String rentalCompany;	
	private LocalDate startDate;
	private LocalDate endDate;
	
	public TravelByRentalCar(double totalRentalCost, String rentalCompany, LocalDate startDate, LocalDate endDate) {
		this.totalRentalCost = totalRentalCost;
		this.rentalCompany = rentalCompany;
		this.startDate = startDate;
		this.endDate = endDate;
		numberOfDaysRented = (int)ChronoUnit.DAYS.between(startDate, endDate);
	}

	public void addFuel(double numGallons, double cost) {
		fuelUsed += numGallons;
		fuelCost += cost;
	}
	
	@Override
	public String getDescription() {
		return String.format("Rented for %d days from %s\nUsed %d gallons of fuel from %s to %s", numberOfDaysRented, rentalCompany, Math.round(fuelUsed), startDate, endDate);
	}
	
	@Override
	public double amountToReimburse() {
		return fuelCost + totalRentalCost;
	}

	@Override
	public LocalDate getStartDate() {
		return startDate;
	}

	@Override
	public LocalDate getEndDate() {
		return endDate;
	}
	
	@Override
	public int sequenceNo() {
		return 4;
	}
}