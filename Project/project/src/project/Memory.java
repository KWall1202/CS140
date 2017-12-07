package project;

import java.util.Arrays;

public class Memory {
	public static final int DATA_SIZE = 512;
	public static final int CODE_SIZE = 256;
	private int[] data = new int[DATA_SIZE];
	private Instruction[] code = new Instruction[CODE_SIZE];
	private int changedDataIndex = -1;
	private int programSize = 0;
	
	int[] getData() {
		return data;
	}
	
	int getData(int index) {
		return data[index];
	}
	
	int[] getData(int min, int max) {
		return Arrays.copyOfRange(data, min, max);
	}
	
	void setData(int index, int value) {
		data[index] = value;
	}
	
	void clearData() {
		for(int i=0; i < data.length; i++) data[i] = 0;
		changedDataIndex = -1;

	}

	Instruction[] getCode() {
		return code;
	}
	
	Instruction getCode(int index) {
		if(index < 0 || index >= CODE_SIZE) throw new CodeAccessException("Illegal access to code");
		return code[index];
	}
	
	Instruction[] getCode(int min, int max) {
		return Arrays.copyOfRange(code, min, max);
	}
	
	void setCode(int index, Instruction value) {
		code[index] = value;
		programSize = Math.max(programSize, index);
	}

	void clearCode() {
		for(int i=0; i < code.length; i++) code[i] = null;
	}
	
	int getChangedDataIndex() {
		return changedDataIndex;
	}

	int getProgramSize() {
		return programSize;
	}

	public void setProgramSize(int i) {
		programSize = i;
	}
}
