package assignment05;

import java.time.LocalDate;

public class TravelByBus implements TravelExpenses {
	private LocalDate outboundStartDate;
	private LocalDate inboundEndDate;
	private String busLines;
	private double totalCost;
	
	public TravelByBus(LocalDate outboundStartDate, LocalDate inboundEndDate, String busLines, double totalCost) {
		this.outboundStartDate = outboundStartDate;
		this.inboundEndDate = inboundEndDate;
		this.busLines = busLines;
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
		return String.format("Left with %s on %s and returned on %s", busLines, outboundStartDate, inboundEndDate);
	}
	
	@Override
	public int sequenceNo() {
		return 3;
	}
}
