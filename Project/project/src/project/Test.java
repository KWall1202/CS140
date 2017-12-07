package project;

public class Test {
	public static void main(String[] args) {
		try {
			Instruction.checkParity(new Instruction((byte)1, 0));
			System.out.println("checkParity() didnt throw an error when it should've.");
		} catch(ParityCheckException e) {
			System.out.println("Caught expected error: " + e.getMessage());
		}
		
		try {
			Instruction.checkParity(new Instruction((byte)7, 0));
			System.out.println("checkParity() didnt throw an error when it should've.");
		} catch(ParityCheckException e) {
			System.out.println("Caught expected error: " + e.getMessage());
		}
		
		try {
			Instruction.checkParity(new Instruction((byte)2, 0));
			System.out.println("checkParity() didnt throw an error when it should've.");
		} catch(ParityCheckException e) {
			System.out.println("Caught expected error: " + e.getMessage());
		}
		
		try {
			Instruction.checkParity(new Instruction((byte)24, 0));
			System.out.println("checkParity() didnt throw an error, as expected");
		} catch(ParityCheckException e) {
			System.out.println("Caught unexpected error: " + e.getMessage());
		}
		
		try {
			Instruction.checkParity(new Instruction((byte)15, 0));
			System.out.println("checkParity() didnt throw an error, as expected");
		} catch(ParityCheckException e) {
			System.out.println("Caught unexpected error: " + e.getMessage());
		}
		
		try {
			Instruction.checkParity(new Instruction((byte)63, 0));
			System.out.println("checkParity() didnt throw an error, as expected");
		} catch(ParityCheckException e) {
			System.out.println("Caught unexpected error: " + e.getMessage());
		}
	}
}
