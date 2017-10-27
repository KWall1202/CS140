package assignment05;

import java.time.LocalDate;

public class TravelByOwnCar implements TravelExpenses {
	private double milesDriven;
	private LocalDate startDate;
	private LocalDate endDate;
	
	public TravelByOwnCar(LocalDate startDate, LocalDate endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public void addMiles(double miles) {
		milesDriven += miles;
	}

	@Override
	public String getDescription() {
		return "Own car used, miles driven: " + milesDriven;
	}

	@Override
	public double amountToReimburse() {
		return milesDriven * mileage;
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
		return 5;
	}
}
