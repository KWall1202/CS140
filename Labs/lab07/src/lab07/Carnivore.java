package lab07;

public abstract class Carnivore extends Animal {
	private String prey;
	private int predatoryLevel;
	
	public Carnivore(String prey, int predatoryLevel) {
		super();
		this.prey = prey;
		this.predatoryLevel = predatoryLevel;
	}

	public int getPredatoryLevel() {
		return predatoryLevel;
	}

	abstract void prowl();

	public String getPrey() {
		return prey;
	}

	@Override
	public String toString() {
		return "A carnivore only eats meat. It can additionally perform the action prowl, and has prey it eats";
	}
}
