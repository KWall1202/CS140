package assignment06;

import java.util.Iterator;

public class MenuItem implements MComp {
	private String name;
	private String description;
	private boolean vegetarian;
	private double price;
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public Iterator<MComp> iterator() {
		return new NullIterator();
	}

	@Override
	public void print() {
		System.out.print("\t" + name);
		if(vegetarian) {
			System.out.print("(v)");
		}
		System.out.println(", " + price + "\n\t\t-- " + description);
	}

	public MenuItem(String name, String description, boolean vegetarian, double price) {
		super();
		this.name = name;
		this.description = description;
		this.vegetarian = vegetarian;
		this.price = price;
	}

}
