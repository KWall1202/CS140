package assignment07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class P19_7 {

	private static int countVowels(String string) {
		Set<Character> vowels = new HashSet<Character>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		int returnVal = 0;
		for(char x : string.toLowerCase().toCharArray()) {
			if(vowels.contains(x)) returnVal++;
		}
		return returnVal;
	}
	private static void insertLength(HashMap<Integer, Long> map, String name) {
		if(!map.containsKey(name.length())) {
			map.put(name.length(), 0L);
		}
		map.put(name.length(), map.get(name.length()) + 1);
	}
	
	private static void insertName(HashMap<String, ArrayList<String>> map, String name) {
		if(!map.containsKey(name.substring(0,1))) {
			map.put(name.substring(0,1), new ArrayList<String>());
		}
		map.get(name.substring(0,1)).add(name);
	}
	
	public static void main(String[] args) throws IOException {
		try(Stream<String> lines = Files.lines(Paths.get("fem1stnames.txt"))) {
			System.out.printf("Found %d female first names with 2 or fewer vowels\n", lines.filter(x -> countVowels(x) <= 2).count());
		}
		try(Stream<String> lines = Files.lines(Paths.get("fem1stnames.txt"))) {
			System.out.printf("The longest female first name with 2 or fewer vowels is %s\n", lines.filter(x -> countVowels(x) <= 2).max((x, y) -> x.length() - y.length()).get());
		}
		try(Stream<String> lines = Files.lines(Paths.get("fem1stnames.txt"))) {
			HashMap<Integer, Long> lengths = new HashMap<>();
			lines.filter(x -> countVowels(x) <= 2).forEach(x -> insertLength(lengths, x));
			for(int key : lengths.keySet()) {
				System.out.printf("There are %d female first names with length %d\n", lengths.get(key), key);
			}
		}
		try(Stream<String> lines = Files.lines(Paths.get("male1stnames.txt"))) {
			HashMap<String, ArrayList<String>> organizedNames = new HashMap<>();
			lines.forEach(x -> insertName(organizedNames, x));
			organizedNames.values().forEach(System.out::println);
		}
	}
}
