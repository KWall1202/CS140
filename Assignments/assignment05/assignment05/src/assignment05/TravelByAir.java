package assignment05;

import java.time.LocalDate;

public class TravelByAir implements TravelExpenses {
	private LocalDate outboundStartDate;
	private LocalDate inboundEndDate;
	private String airlines;
	private double totalCost;
	
	public TravelByAir(LocalDate outboundStartDate, LocalDate inboundEndDate, String airlines, double totalCost) {
		this.outboundStartDate = outboundStartDate;
		this.inboundEndDate = inboundEndDate;
		this.airlines = airlines;
		this.totalCost = totalCost;
	}

	@Override
	public double amountToReimburse() {
		return totalCost;
	}
	
	@Override
	public LocalDate getStartDate() {
		return outboundStartDate;
	}

	@Override
	public LocalDate getEndDate() {
		return inboundEndDate;
	}

	@Override
	public String getDescription() {
		return String.format("Left with %s on %s and returned on %s", airlines, outboundStartDate, inboundEndDate);
	}

	@Override
	public int sequenceNo() {
		return 1;
	}
}
