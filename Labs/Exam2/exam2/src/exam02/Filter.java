package exam02;

import java.util.ArrayList;

public class Filter {
	public static ArrayList<Integer> filter(ArrayList<Integer> list, BooleanFunction func) {
		ArrayList<Integer> filteredList = new ArrayList<>();
		for(int i : list) {
			if(func.apply(i)) filteredList.add(i);
		}
		return filteredList;
	}
}
