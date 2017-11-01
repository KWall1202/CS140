package assignment06;

import java.util.Iterator;

public class NullIterator implements Iterator<MComp> {

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@Override
	public MComp next() {
		return null;
	}

}
