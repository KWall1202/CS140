package assignment06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Menu implements MComp {
	private String name;
	private String description;
	private ArrayList<MComp> comps = new ArrayList<>();
	
	public Menu(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void add(MComp mComp) {
		comps.add(mComp);
	}

	@Override
	public void remove(MComp mComp) {
		comps.remove(mComp);
	}

	@Override
	public MComp getChild(int i) {
		return comps.get(i);
	}

	@Override
	public void print() {
		System.out.println("\n" + name + ", " + description + "\n----------------------------");
	}

	@Override
	public Iterator<MComp> iterator() {
		return new CompositeIterator(comps.iterator());
	}
	
	@Override
	public void pushToStack(Stack<Iterator<MComp>> stack) {
		stack.push(comps.iterator());
	}

}
