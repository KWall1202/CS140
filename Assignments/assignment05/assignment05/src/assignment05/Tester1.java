package assignment05;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

public class Tester1 {
	private ArrayList<TravelExpenses> objectsWithExpenses = new ArrayList<>();
	
	public void addExpense(TravelExpenses expense) {
		System.out.println("Added:  " + expense.getDescription());
		objectsWithExpenses.add(expense);
	}
	
	@Test
	public void testExpenses() {
		TravelByRentalCar rentalCarToReceiveFuel = new TravelByRentalCar(350.00, "Enterprise", LocalDate.of(2017, 10, 10), LocalDate.of(2017, 10, 14));
		addExpense(rentalCarToReceiveFuel);
		rentalCarToReceiveFuel.addFuel(9.867, 2.77);
		TravelByOwnCar ownCarToReceiveMiles = new TravelByOwnCar(LocalDate.of(2017, 1,  15), LocalDate.of(2017, 1,  25));
		ownCarToReceiveMiles.addMiles(85.33);
		addExpense(new TravelByRentalCar(87.5555, "Budget", LocalDate.of(2016,  2,  21), LocalDate.of(2017, 2, 21)));
		addExpense(new Lodging(LocalDate.of(2017, 10, 10), LocalDate.of(2017, 11, 4), "Holiday Inn", 600.00));
		addExpense(new Lodging(LocalDate.of(2017, 9, 10), LocalDate.of(2017, 12, 2), "Some resort", 6324.113));
		addExpense(new TravelByAir(LocalDate.of(2017, 10, 5), LocalDate.of(2018, 1, 5), "Southwest", 1276.87));
		addExpense(new TravelByAir(LocalDate.of(2017,  4,  3), LocalDate.of(2017, 6,  29), "Delta", 321.098));
		addExpense(new Meal(MealType.LUNCH, 13.00, LocalDate.of(2017, 10, 20)));
		addExpense(new Meal(MealType.BREAKFAST, 125.00, LocalDate.of(2017, 10, 20)));
		addExpense(new Meal(MealType.DINNER, 5, LocalDate.of(2018,  1,  1)));
		addExpense(new Meal(MealType.LUNCH, 6, LocalDate.of(2018,  1,  16)));
		addExpense(new TravelByOwnCar(LocalDate.of(2015, 6,  29), LocalDate.of(2015, 7,  2)));
		addExpense(ownCarToReceiveMiles);
		addExpense(new TravelByRail(LocalDate.of(2017, 12, 20), LocalDate.of(2018, 1, 3), "AMTRAK", 173.35));
		addExpense(new TravelByRail(LocalDate.of(2017, 10, 12), LocalDate.of(2017, 10, 15), "LIRR", 65.50));
		addExpense(new TravelByBus(LocalDate.of(2017, 3, 8), LocalDate.of(2018, 3, 22), "Adirondack Trailways", 84.64));
		addExpense(new TravelByBus(LocalDate.of(2018, 1, 15), LocalDate.of(2018, 1, 16), "Greyhound", 100.10));
		TravelExpenses.printReport(objectsWithExpenses);
	}
	
	@Test
	public void testDefaultGetDescription() {
		final class Test implements TravelExpenses {
			public double amountToReimburse() {return 0;}
		}
		Test test = new Test();
		try {
			test.getDescription();
			System.out.println("TravelExpenses default getDescription() method didn't throw an UnsuppportedOperationException when a class didn't implement the method.");
		} catch(UnsupportedOperationException e) {}
	}
	
	@Test
	public void testTravelByRentalCarAmountToReimburse() {
		TravelByRentalCar rentalCar = new TravelByRentalCar(350, "Enterprise", LocalDate.of(2017, 10, 10), LocalDate.of(2017, 10, 14));
		try {
			assertEquals(350.00, rentalCar.amountToReimburse(), 1e-6);
		} catch(AssertionError e) {
			System.out.println("TravelByRentalCar's amountToReimburse() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testTravelByRentalCarAddFuel() {
		TravelByRentalCar rentalCar = new TravelByRentalCar(350, "Enterprise", LocalDate.of(2017, 10, 10), LocalDate.of(2017, 10, 14));
		rentalCar.addFuel(8.79, 21.21);
		try {
			assertEquals(371.21, rentalCar.amountToReimburse(), 1e-6);
		} catch(AssertionError e) {
			System.out.println("TravelByRentalCar's addFuel() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testLodgingAmountToReimburse() {
		Lodging lodging = new Lodging(LocalDate.of(2017, 10, 10), LocalDate.of(2017, 11, 4), "Holiday Inn", 600);
		try {
			assertEquals(600.00, lodging.amountToReimburse(), 1e-6);
		} catch(AssertionError e) {
			System.out.println("Lodging's amountToReimburse() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testTravelByAirAmountToReimburse() {
		TravelByAir air = new TravelByAir(LocalDate.of(2017, 10, 10), LocalDate.of(2018, 1, 5), "Southwest", 1276.87);
		try {
			assertEquals(1276.87, air.amountToReimburse(), 1e-6);
		} catch(AssertionError e) {
			System.out.println("TravelByAir's amountToReimburse() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testMealAmountToReimburseMealPrice() {
		Meal meal = new Meal(MealType.BREAKFAST, 13.00, LocalDate.of(2017, 10, 20));
		try {
			assertEquals(13, meal.amountToReimburse(), 1e-6);
		} catch(AssertionError e) {
			System.out.println("Meal's amountToReimburse() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testMealAmountToReimburseMaxPrice() {
		Meal meal = new Meal(MealType.BREAKFAST, 7.00, LocalDate.of(2017, 10, 20));
		try {
			assertEquals(8, meal.amountToReimburse(), 1e-6);
		} catch(AssertionError e) {
			System.out.println("Meal's amountToReimburse() method failed: " + e.getMessage());
			throw e;
		}
	}

	@Test
	//Testing amountToReimburse for an owned car that travels no miles
	public void testTravelByOwnCarAmountToReimburse00() {
		TravelByOwnCar car = new TravelByOwnCar(LocalDate.of(2017, 2, 20), LocalDate.of(2017, 2, 3));
		try {
			assertEquals(car.amountToReimburse(), 0, 1e-6);
		} catch(AssertionError e) {
			System.out.println("TravelByOwnCar's amountToReimburse() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	//Testing amountToReimburse for an owned car that travels some amount of miles
	public void testTravelByOwnCarAmountToReimburse01() {
		TravelByOwnCar car = new TravelByOwnCar(LocalDate.of(2017, 2, 20), LocalDate.of(2017, 2, 3));
		car.addMiles(564.33);
		try {
			assertEquals(car.amountToReimburse(), 299.0949, 1e-6);
		} catch(AssertionError e) {
			System.out.println("TravelByOwnCar's amountToReimburse() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testTravelByRailAmountToReimburse() {
		TravelByRail rail = new TravelByRail(LocalDate.of(2017, 10, 12), LocalDate.of(2017, 10, 15), "LIRR", 65.50);
		try {
			assertEquals(rail.amountToReimburse(), 65.50, 1e-6);
		} catch(AssertionError e) {
			System.out.println("TravelByRail's amountToReimburse() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testTravelByBusAmountToReimburse() {
		TravelByBus bus = new TravelByBus(LocalDate.of(2017, 3, 8), LocalDate.of(2018, 3, 22), "Adirondack Trailways", 84.64);
		try {
			assertEquals(bus.amountToReimburse(), 84.64, 1e-6);
		} catch(AssertionError e) {
			System.out.println("TravelByBus's amountToReimburse() method failed: " + e.getMessage());
			throw e;
		}
	}
}
