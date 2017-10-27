package assignment05;

import java.util.Comparator;

public class ByDobThenNameComp implements Comparator<Person> {

	@Override
	public int compare(Person person1, Person person2) {
		int returnVal = person1.getDateOfBirth().compareTo(person2.getDateOfBirth());
		if (returnVal == 0) {
			returnVal = person1.compareTo(person2);
		}
		return returnVal;
	}
}
