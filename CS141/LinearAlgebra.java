// Recursive check : check col[0], if all 0, recurse col[1], and so on
// until find the first non 0 entry, use solveMatrix

import java.util.Scanner;
public class LinearAlgebra
{
    public static void main(String[] args)
    {
	double Matrix[][] = setMatrix();
	solveMatrix(Matrix);
    }
    public static double[][] setMatrix(){
	Scanner kb = new Scanner(System.in);
        System.out.print("Enter your rows: ");
	int row = kb.nextInt();
	System.out.print("Enter your columns: ");
	int col = kb.nextInt();
	kb.nextLine();
	double[][] matrix = new double[row][col];
	for (int i = 0; i < row; i++){
	    for (int j = 0; j < col; j++){
		System.out.print("Enter your element at (" + (i+1) + "," + (j+1) + "): ");
		matrix[i][j] = kb.nextDouble();
		kb.nextLine();
	     }
	}
	return matrix;
    }

    public static void solveMatrix(double[][] matrix){
	int numRow = matrix.length;
	int numCol = matrix[0].length;
	int col = 0;
	// check entries
	try {
	for (int row = 0; row < numRow; row++){
	    while (col < row && matrix[row][col] == 0) {
	


	}
}