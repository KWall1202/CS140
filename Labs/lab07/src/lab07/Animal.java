package lab07;

public abstract class Animal implements Actions, Classifications {

	@Override
	public String toString() {
		return "This is the higher level abstract animal class. Its subclasses will implement the interfaces.\n";
	}

	abstract String getAnimalName();

}
