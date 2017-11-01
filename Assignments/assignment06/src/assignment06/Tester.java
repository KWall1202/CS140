package assignment06;

import static assignment06.TriangleClassifier.createTriple;
import static assignment06.TriangleClassifier.removeScalene;

import java.util.ArrayList;
import java.util.Collections;

import assignment06.TriangleClassifier.Triple;

public class Tester {
	public static void main(String[] args) {
		ArrayList<Triple> list = new ArrayList<>();
		list.add(createTriple(3,4,5)); //Right angle scalene triangle
		list.add(createTriple(5,5,5)); //Equilateral triangle
		list.add(createTriple(6,4,5)); //Scalene acute triangle
		list.add(createTriple(3,5,7)); //Scalene obtuse triangle
		list.add(createTriple(3,2,2)); //Isosceles obtuse triangle
		list.add(createTriple(1,2,2)); //Iscosceles acute triangle
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		removeScalene(list);
		System.out.println(list);
	}
}
