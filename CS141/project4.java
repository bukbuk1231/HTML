// Lou, Junda
// CS 141 03
// Project #3 : Line Sorter

// NOT COMPLETE, but done for grading

import java.util.Scanner;
import java.io.*;
public class project4{
    public static void main(String[] args) throws IOException {
	String fileName = args[0];
	char recordType = ' ';
	int row = getInputFileLine(fileName);
	String[][] inputFileData = getInputFileData(fileName, row);
	String[][] sortedInputFileData = Sort(inputFileData);
	output(sortedInputFileData);

    }
    
    public static int getInputFileLine(String fileName) throws IOException {
	int row = 0;
        File file = new File(fileName);
	Scanner inputFile = new Scanner(file);
	while (inputFile.hasNext()) {
	    inputFile.nextLine();
	    row++;
	}
	inputFile.close();
	return row;
    }
	
    public static String[][] getInputFileData(String fileName, int row) throws IOException {
	int i = 0;
	String[][] inputFileData = new String[row][];
	File file = new File(fileName);
	Scanner inputFile = new Scanner(file);
	while (inputFile.hasNext()) {
	    inputFileData[i] = inputFile.nextLine().split(" ");
	    i++;
	}
	inputFile.close();
	return inputFileData;
    }
    public static String[][] Sort(String[][] inputFileData) {
	String[][] tmp = new String[inputFileData[0].length][inputFileData.length];
	for (int i = 0; i < tmp.length; i++) {
	    for (int j = 0; j < tmp[0].length; j++){
		tmp[i][j] = inputFileData[j][i];
	    }
	}
	for (int i = 0; i < inputFileData.length; i++) {
	    Sorter input = new Sorter(tmp[i]);
	    tmp[i] = input.sort(tmp[i], tmp[i].length - 1);
	}
	for (int i = 0; i < tmp[0].length; i++) {
	    for (int j = 0; j < tmp.length; j++) {
		inputFileData[i][j]
		    }
	}
	return inputFileData;
    }
    
    public static void output(String[][] sortedInputFileData) {
	for (int i = 0; i < sortedInputFileData.length;i++){
	    for (int j =0;j<sortedInputFileData[0].length;j++){
		System.out.print(sortedInputFileData[i][j]);
	    }
	    System.out.println();
	}

    }

}
