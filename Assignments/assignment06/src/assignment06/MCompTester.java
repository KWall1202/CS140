package assignment06;

import java.util.Collections;
import java.util.Iterator;

public class MCompTester {
	public static void main(String args[]) {
		Server server = new Server(makeTest());
		   
		server.printMenu();

		System.out.println("\n++++++++++++++++");
		server.printVegetarianMenu();

	}
	
	public static MComp makeTest() {	
		MComp pancakeHouseMenu = 
			new Menu("PANCAKE HOUSE MENU", "Breakfast");
		MComp dinerMenu = 
			new Menu("DINER MENU", "Lunch");
		MComp cafeMenu = 
			new Menu("CAFE MENU", "Dinner");
		MComp dessertMenu = 
			new Menu("DESSERT MENU", "Dessert of course!");
  
		MComp allMenus = new Menu("ALL MENUS", "All menus combined");
  
		allMenus.add(pancakeHouseMenu);
		allMenus.add(dinerMenu);
		allMenus.add(cafeMenu);
  
		pancakeHouseMenu.add(new MenuItem(
			"K&B's Pancake Breakfast", 
			"Pancakes with scrambled eggs, and toast", 
			true,
			2.99));
		pancakeHouseMenu.add(new MenuItem(
			"Regular Pancake Breakfast", 
			"Pancakes with fried eggs, sausage", 
			false,
			2.99));
		pancakeHouseMenu.add(new MenuItem(
			"Blueberry Pancakes",
			"Pancakes made with fresh blueberries, and blueberry syrup",
			true,
			3.49));
		pancakeHouseMenu.add(new MenuItem(
			"Waffles",
			"Waffles, with your choice of blueberries or strawberries",
			true,
			3.59));

		dinerMenu.add(new MenuItem(
			"Vegetarian BLT",
			"(Fakin') Bacon with lettuce & tomato on whole wheat", 
			true, 
			2.99));
		dinerMenu.add(new MenuItem(
			"BLT",
			"Bacon with lettuce & tomato on whole wheat", 
			false, 
			2.99));
		dinerMenu.add(new MenuItem(
			"Soup of the day",
			"A bowl of the soup of the day, with a side of potato salad", 
			false, 
			3.29));
		dinerMenu.add(new MenuItem(
			"Hotdog",
			"A hot dog, with saurkraut, relish, onions, topped with cheese",
			false, 
			3.05));
		dinerMenu.add(new MenuItem(
			"Steamed Veggies and Brown Rice",
			"A medly of steamed vegetables over brown rice", 
			true, 
			3.99));
 
		dinerMenu.add(new MenuItem(
			"Pasta",
			"Spaghetti with Marinara Sauce, and a slice of sourdough bread",
			true, 
			3.89));
   
		dinerMenu.add(dessertMenu);
  
		dessertMenu.add(new MenuItem(
			"Apple Pie",
			"Apple pie with a flakey crust, topped with vanilla icecream",
			true,
			1.59));
		dessertMenu.add(new MenuItem(
			"Cheesecake",
			"Creamy New York cheesecake, with a chocolate graham crust",
			true,
			1.99));
		dessertMenu.add(new MenuItem(
			"Sorbet",
			"A scoop of raspberry and a scoop of lime",
			true,
			1.89));

		cafeMenu.add(new MenuItem(
			"Veggie Burger and Air Fries",
			"Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
			true, 
			3.99));
		cafeMenu.add(new MenuItem(
			"Soup of the day",
			"A cup of the soup of the day, with a side salad",
			false, 
			3.69));
		cafeMenu.add(new MenuItem(
			"Burrito",
			"A large burrito, with whole pinto beans, salsa, guacamole",
			true, 
			4.29));
		
		return allMenus;
	}
	
	public static MenuItem cheapest(MComp menus) {
		MenuItem cheapest = null;
		for(MComp item: menus) {
			if(item instanceof MenuItem) {
				if(cheapest == null) cheapest = (MenuItem)item;
				if(((MenuItem)item).getPrice() < cheapest.getPrice()) cheapest = (MenuItem)item;
			} else {
				if(cheapest == null) cheapest = cheapest(item);
				if(cheapest(item).getPrice() < cheapest.getPrice()) cheapest = cheapest(item);
			}
		}
		return cheapest;
	}
		
	public static MenuItem dearest(MComp menus) {
		MenuItem dearest = null;
		for(MComp item: menus) {
			if(item instanceof MenuItem) {
				if(dearest == null) dearest = (MenuItem)item;
				if(((MenuItem)item).getPrice() > dearest.getPrice()) dearest = (MenuItem)item;
			} else {
				if(dearest == null) dearest = cheapest(item);
				if(cheapest(item).getPrice() > dearest.getPrice()) dearest = cheapest(item);
			}
		}
		return dearest;
	}
	
	public static MenuItem longestDescr(MComp menus) {
		MenuItem longestDescr = null;
		for(MComp item: menus) {
			if(item instanceof MenuItem) {
				if(longestDescr == null) longestDescr = (MenuItem)item;
				if(((MenuItem)item).getDescription().length() > longestDescr.getDescription().length()) longestDescr = (MenuItem)item;
			} else {
				if(longestDescr == null) longestDescr = cheapest(item);
				if(cheapest(item).getDescription().length() > longestDescr.getDescription().length()) longestDescr = cheapest(item);
			}
		}
		return longestDescr;
	}
}