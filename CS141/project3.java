// Lou, Junda
// CS 141 03
// Project #3 : Line Sorter
//

import java.io.*;
import java.util.Scanner;
public class project3{
    public static void main(String[] args) throws IOException {
	char sortMode = args[0].charAt(0);
	String fileName = args[1];
	int countLine = getInputLineNum(fileName);
	String[] inputLine = getInputData(countLine, fileName);
	sortInput(inputLine, sortMode);

    }

    public static int getInputLineNum(String fileName) throws IOException {
	int countLine = 0;
	File file = new File(fileName);
	Scanner inputFile = new Scanner(file);
	while (inputFile.hasNext()){
	    inputFile.nextLine();
	    countLine++;
	}
	inputFile.close();
	return countLine;
    }
   
    public static String[] getInputData(int countLine, String fileName) throws IOException {	
	int i = 0;
	String[] inputLine = new String[countLine];
	File file = new File(fileName);
	Scanner inputFile = new Scanner(file);
	while (inputFile.hasNext()){
	    inputLine[i] = inputFile.nextLine();
	    i++;
	}
	inputFile.close();
	return inputLine;	
    }

    public static void sortInput(String[] inputLine, char sortMode) throws IOException {
	if (sortMode == 'c' || sortMode == 'C'){
	    Sorter input = new Sorter(inputLine);
	    String[] output = input.sort(inputLine, inputLine.length - 1);
	    PrintWriter outputFile = new PrintWriter("sorted_input.txt");
	    for (int i = 0; i < output.length; i++)
		outputFile.println(output[i]);
	    outputFile.close();
	}
	if (sortMode == 'i' || sortMode == 'I'){
	    iSorter input = new iSorter(inputLine);
	    String[] output = input.iSort(inputLine, inputLine.length - 1);
	    PrintWriter outputFile = new PrintWriter("sorted_input.txt");
	    for (int i = 0; i < output.length; i++)
		outputFile.println(output[i]);
	    outputFile.close();
	}
    }
}