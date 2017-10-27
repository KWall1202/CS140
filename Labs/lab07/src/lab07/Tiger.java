package lab07;

public class Tiger extends Carnivore {
	private String name;
	
	
	public Tiger(String prey, int predatoryLevel, String name) {
		super(prey, predatoryLevel);
		this.name = name;
	}

	@Override
	public void speak() {
		System.out.println("Growl!");

	}

	@Override
	public void eat() {
		System.out.println(name + " the Tiger eats " + super.getPrey());

	}

	@Override
	public void move() {
		System.out.println("Tigers move gracefully due to their powerful leg and shoulder muscles.");

	}

	@Override
	public void sleep() {
		System.out.println("Tigers like to sleep in rocky places, grassy areas, or inside caves.");

	}

	@Override
	public String kingdom() {
		return "Animalia";
	}

	@Override
	public String genus() {
		return "Panthera";
	}

	@Override
	public String species() {
		return "P.tigris (tiger)";
	}

	@Override
	void prowl() {
		System.out.println("The tiger pounces on an unsuspecting " + super.getPrey());

	}

	@Override
	String getAnimalName() {
		return "Tiger";
	}

	public String getName() {
		return name;
	}

}
