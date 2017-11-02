package lab09;

import java.util.Comparator;

public class Bonus {
	public static void main(String[] args) {
		Comparator<String> strComp = (i,j) -> i.length() - j.length();
		BinarySearchTree<String> strs = new BinarySearchTree<>(strComp);
		strs.insert("Hello");
		strs.insert("One");
		strs.insert("Loooooooooooong");
		strs.insert("shrt");
		strs.insert("CS 140");
		strs.insert("Kevin"); //this shouldn't end up in the tree because it has the same length as "Hello"
		strs.insert("several");
		strs.insert("Binary Search Tree String");
		strs.insert("Eeeeeeeveeennnnnn Loooooooongerrr");
		strs.insert("s");
		strs.prettyPrint();
	}
}
