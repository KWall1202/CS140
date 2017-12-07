package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import project.Instruction;

public class FullAssembler implements Assembler {
	int errorsFound = 0;
	Map<Integer, Boolean> blankness = new TreeMap<>();
	boolean readingCode = true;
	int noArgCount = 0;
	
	/*
	 * Pairs together a boolean value representing if a line is blank
	 * with an integer representing the number of the line
	 * adds the pair to the list blankness
	 * Only to be called by assemble()
	 * @param line, the string to be checked for blankness
	 * @param lineNumber, the integer representing the lineNumber 
	 */
	private void populateBlankness(String line, int lineNumber) {
		if(line.trim().length() == 0) {
			blankness.put(lineNumber, true);
		} else {
			blankness.put(lineNumber,  false);
		}
	}
	
	/*
	 * Checks if a line of code has leading whitespace
	 * Appends error to StringBuilder if there is leading whitespace
	 * Increments errorsFound if an error is found
	 * Only to be called by assemble()
	 * @param line, the line with the DATA separator
	 * @param lineNumber, the number of the line being checked
	 * @param error, the StringBuilder that all errors get appended to
	 * @param curRetVal, the return value of assemble() before this method is called
	 * @return the line number of the line being checked if an error is found, or curRetval if no errors are found
	 */
	private int checkLeadingWhitespace(String line, int lineNumber, StringBuilder error, int curRetVal) {
		int retVal = curRetVal;
		if(!blankness.get(lineNumber) && (line.charAt(0) == ' ' || line.charAt(0) == '\t')) {
			error.append("\nError on line " + (lineNumber) + ": Line starts with illegal white space");
			errorsFound++;
			retVal = lineNumber;
		}
		return retVal;
	}
	
	/*
	 * Checks if a given line includes a DATA separator
	 * Sets readingCode to false if it hasn't been already
	 * Checks if the DATA separator is written correctly (in all caps)
	 * Checks if there is an extraneous and illegal DATA separator
	 * Increments errorsFound if an error is found
	 * Only to be called by assemble()
	 * @param line, a line to be checked
	 * @param lineNumber, the number of the line being checked
	 * @param error, the StringBuilder that all errors get appended to
	 * @param curRetVal, the return value of assemble() before this method is called
	 * @return the line number of the line being checked if an error is found, or curRetval if no errors are found 
	 */
	private int checkDataSeparator(String line, int lineNumber, StringBuilder error, int curRetVal) {
		int retVal = curRetVal;
		// Should both errors be reported if possible? Or just the illegal separator error
		if(line.trim().toUpperCase().equals("DATA")) {
			if(readingCode) {
				readingCode = false;
			} else {
				error.append("\nError on line " + lineNumber + ": Illegal DATA separator"); // Extra DATA separator
				errorsFound++;
				retVal = lineNumber;
			}
			if(!line.trim().equals("DATA")) {
				error.append("\nError on Line " + lineNumber + ": Line does not have DATA in upper case"); // Incorrect DATA separator
				errorsFound++;
				retVal = lineNumber;
			}
		}
		return retVal;
	}
	
	/*
	 * Checks each line of code for a legal mnemonic
	 * Checks if mnemonic is written correctly (all caps)
	 * Checks if the mnemonic arguments are legal
	 * Increments errorsFound if an error is found
	 * Only to be called by assemble()
	 * @param line, a line to be checked
	 * @param lineNumber, the number of the line being checked
	 * @param error, the StringBuilder that all errors get appended to
	 * @param curRetVal, the return value of assemble() before this method is called
	 * @return the line number of the line being checked if an error is found, or curRetval if no errors are found 
	 */
	private int checkMnemonic(String line, int lineNumber, StringBuilder error, int curRetVal) {
		int retVal = curRetVal;
		if(blankness.get(lineNumber)) return retVal;
		String[] parts = line.trim().split("\\s+");
		if(Instruction.opcodes.keySet().contains(parts[0].toUpperCase())) {
			if(!Instruction.opcodes.keySet().contains(parts[0])) {
				error.append("\nError on line " + lineNumber + ": mnemonic must be upper case");
				errorsFound++;
				retVal = lineNumber;
			}
			retVal = checkArguments(parts, lineNumber, error, retVal); // Check arguments
		} else if(!blankness.get(lineNumber)) { //If line isn't blank and didn't have a mnemonic above it must be illegal
			error.append("\nError on Line " + lineNumber + ": Illegal mnemonic");
			errorsFound++;
			retVal = lineNumber;
		}
		return retVal;
	}
	
	/*
	 * Checks if a mnemonic has the right number of arguments
	 * Checks if a mnemonic has hex values for arguments
	 * Increments errorsFound if an error is found
	 * Only to be called by checkMnemonic()
	 * @param line, a line to be checked
	 * @param lineNumber, the number of the line being checked
	 * @param error, the StringBuilder that all errors get appended to
	 * @param curRetVal, the return value of checkMnemonic() before this method is called
	 * @return the line number of the line being checked if an error is found, or curRetval if no errors are found 
	 */
	private int checkArguments(String[] parts, int lineNumber, StringBuilder error, int curRetVal) {
		int retVal = curRetVal;
		if(blankness.get(lineNumber)) return retVal;
		if(noArgument.contains(parts[0].toUpperCase())) {
			if(parts.length != 1) {
				error.append("\nError on line " + lineNumber + ": this mnemonic cannot take arguments");
				errorsFound++;
				retVal = lineNumber;
			}
		} else if(parts.length == 1) {
			error.append("\nError on line " + lineNumber + ": this mnemonic is missing an argument");
			errorsFound++;
			retVal = lineNumber;
		} else if(parts.length > 2) {
			error.append("\nError on line " + lineNumber + ": this mnemonic has too many arguments");
			errorsFound++;
			retVal = lineNumber;
		} else { // There are the right number of arguments, checking to see that the argument is a proper hex number
			try{
				int flags = 0;
				if(parts[1].charAt(0) == '#') {
					flags = 2;
					parts[1] = parts[1].substring(1);
				} else if(parts[1].charAt(0) == '@') {
					flags = 4;
					parts[1] = parts[1].substring(1);
				} else if (parts[1].charAt(0) == '&') {
					flags = 6;
					parts[1] = parts[1].substring(1);
				}
				int arg = Integer.parseInt(parts[1], 16);
				int opPart = 8 * Instruction.opcodes.get(parts[0].toUpperCase()) + flags;
				opPart += Instruction.numOnes(opPart) % 2;
				} catch(NumberFormatException e) {
					error.append("\nError on line " + lineNumber + 
							": argument is not a hex number");
					errorsFound++;
					retVal = lineNumber;				
				}
		}
		return retVal;
	}
	
	/*
	 * Checks lines of the DATA section for illegal memory addresses
	 * Increments errorsFound if an error is found
	 * Only to be called by assemble()
	 * @param line, a line to be checked
	 * @param lineNumber, the number of the line being checked
	 * @param error, the StringBuilder that all errors get appended to
	 * @param curRetVal, the return value of assemble() before this method is called
	 * @return the line number of the line being checked if an error is found, or curRetval if no errors are found 
	 */
	private int checkAdress(String line, int lineNumber, StringBuilder error, int curRetVal) {
		int retVal = curRetVal;
		if(blankness.get(lineNumber) || line.trim().toUpperCase().equals("DATA")) return retVal;
		String[] parts = line.trim().split("\\s+");
		try {
			int address = Integer.parseInt(parts[0],16);
		} catch(NumberFormatException e) {
			error.append("\nError on line " + (lineNumber) + 
				": data has non-numeric memory address");
			errorsFound++;
			retVal = lineNumber;				
		}
		try {
			int value = Integer.parseInt(parts[1],16);
		} catch(NumberFormatException e) {
			error.append("\nError on line " + (lineNumber) + 
					": data has non-numeric value");
			errorsFound++;
			retVal = lineNumber;				
		} catch(ArrayIndexOutOfBoundsException e) {
			error.append("\nError on line " + (lineNumber) + 
					": data has non-numeric value");
			errorsFound++;
			retVal = lineNumber;		
		}
		return retVal;
	}
	
	
	/*
	 * Checks the lines to see if there are any illegal blank lines
	 * Increments errorsFound if an error is found
	 * Only to be called by assemble()
	 * @param StringBuilder error, the StringBuilder that all errors are appended to
	 * @param curRetVal, retVal of assemble() before this method is called
	 * @return the line number of the first illegal blank line, or curRetVal if no illegal blanks are found
	 */
	private int checkForIllegalBlankLines(StringBuilder error, int curRetVal) {
		int retVal = curRetVal;
		int firstBlank = 0;
		for(int i : blankness.keySet()) {
			if(blankness.get(i)) {
				if(firstBlank == 0) firstBlank = i; 
				try {
					if(!blankness.get(i+1)) {
						error.append("\nError on line " + firstBlank + ": illegal blank line in the source file");
						errorsFound++;
						return firstBlank;
					}
				} catch(NullPointerException e) {
				}
			}
		}
		return retVal;
	}
	
	@Override
	public int assemble(String inputFileName, String outputFileName, StringBuilder error) {
		int retVal = 0;
		if(error == null) throw new IllegalArgumentException("Coding error: the error buffer is null");
		List<String> lines = new ArrayList<>();
		blankness = new TreeMap<>();
		readingCode = true;
		errorsFound = 0;
		noArgCount = 0;
		try(Stream<String> assemblingLines = Files.lines(Paths.get(inputFileName))) {
			lines = assemblingLines.collect(Collectors.toList());
		} catch(Exception e) {
			error.append("\nUnable to open the source file");
			return -1;
		}
		
		for(int i=0; i < lines.size(); i++) {
			String line = lines.get(i);
			int lineNumber = i + 1;
			populateBlankness(line, lineNumber);
			retVal = checkLeadingWhitespace(line, lineNumber, error, retVal);
			retVal = checkDataSeparator(line, lineNumber, error, retVal);
			if(readingCode) {
				retVal = checkMnemonic(line, lineNumber, error, retVal);
			} else {
				retVal = checkAdress(line, lineNumber, error, retVal);
			}
		}
		
		retVal = checkForIllegalBlankLines(error, retVal);
		
		// assemble() code copied from SimpleAssembler edited to handle errors with when writing to the output file
		if(errorsFound == 0)  {
			Map<Boolean, List<String>> lists = null;
			readingCode = true;
			try (Stream<String> assemblingLines = Files.lines(Paths.get(inputFileName))) {
				lists = assemblingLines
					.filter(line -> line.trim().length() > 0)
					.map(line -> line.trim())
					.peek(line -> {if(line.trim().toUpperCase().equals("DATA")) readingCode = false;})
					.map(line -> line.trim())
					.collect(Collectors.partitioningBy(line -> readingCode));
//				System.out.println("true List " + lists.get(true)); // these lines can be uncommented 
//				System.out.println("false List " + lists.get(false)); // for checking the code
			} catch (IOException e) {
				e.printStackTrace();
			}
			lists.get(false).remove("DATA");
			List<Instruction> outputCode = lists.get(true).stream()
					.map(line -> line.split("\\s+"))
					.map(this::makeCode) // note how we use an instance method
					.collect(Collectors.toList());
			List<DataPair> outputData = lists.get(false).stream()
					.map(line -> line.split("\\s+"))
					.map(this::makeData)
					.collect(Collectors.toList());
			int bytesNeeded = noArgCount + 5*(outputCode.size()-noArgCount)
					+1+8*(outputData.size());

			ByteBuffer buff = ByteBuffer.allocate(bytesNeeded);
			outputCode.stream()
			.forEach(instr -> {
				buff.put(instr.opcode);
				if(!Instruction.noArgument(instr)) {
					buff.putInt(instr.arg);
				}
			});
			buff.put((byte)-1);
			outputData.stream() 
			.forEach(pair -> {
				buff.putInt(pair.address);
				buff.putInt(pair.value);
			});
			buff.rewind();
			boolean append = false;
			try (FileChannel wChannel = 
					new FileOutputStream(new File(outputFileName), append).getChannel()){
				wChannel.write(buff);
				wChannel.close();
			} catch (FileNotFoundException e) {
				error.append("\nError: Unable to write the assembled program to the output file");
				retVal =  -1;
			} catch (IOException e) {
				error.append("\nUnexplained IO Exception");
				retVal =  -1;
			}
		}
		return retVal;
	}
	
	private Instruction makeCode(String[] parts) {
		if(noArgument.contains(parts[0])) {
			noArgCount++;
			int opPart = 8 * Instruction.opcodes.get(parts[0]);
			opPart += Instruction.numOnes(opPart) % 2;
			return new Instruction((byte)opPart, 0);
		}
		int flags = 0;
		if(parts[1].charAt(0) == '#') {
			flags = 2;
			parts[1] = parts[1].substring(1);
		} else if(parts[1].charAt(0) == '@') {
			flags = 4;
			parts[1] = parts[1].substring(1);
		} else if (parts[1].charAt(0) == '&') {
			flags = 6;
			parts[1] = parts[1].substring(1);
		}
		int arg = Integer.parseInt(parts[1], 16);
		int opPart = 8 * Instruction.opcodes.get(parts[0]) + flags;
		opPart += Instruction.numOnes(opPart) % 2;
		return new Instruction((byte)opPart, arg);
	}
	
	private DataPair makeData(String[] parts) {
		return new DataPair(Integer.parseInt(parts[0], 16), Integer.parseInt(parts[1],  16));
	}

}
