package assignment05;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public interface TravelExpenses {
	double mileage = 0.53;
	static double BREAKFAST_MAX = 8.0;
	static double LUNCH_MAX = 10.0;
	static double DINNER_MAX = 40.0;
	
	double amountToReimburse();
	
	default LocalDate getStartDate() {
		return LocalDate.now();
	}
	
	default LocalDate getEndDate() {
		return LocalDate.now();
	}
	
	default int sequenceNo() {
		return Integer.MAX_VALUE;
	}
	
	default String getDescription() {
		throw new UnsupportedOperationException("Must be implemented by class");
	}
	
	static void printReport(ArrayList<TravelExpenses> list) {
		Collections.sort(list, Comparator.comparing(TravelExpenses::getStartDate).thenComparing(new ExpensesOrder()));
		//Collections.sort(list, new ExpensesOrder());
		double totalExpenses = 0;
		for(TravelExpenses i : list) {
			totalExpenses += i.amountToReimburse();
			String s = String.format(" $%.2f",  i.amountToReimburse());
			System.out.println(i.getDescription() + s);
		}
		System.out.println(String.format("Total Expenses: $%.2f", totalExpenses));
	}
}