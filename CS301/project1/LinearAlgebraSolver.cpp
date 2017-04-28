// LinearAlgebraSolver.cpp : Defines the entry point for the console application.
//

#include <iostream>
#include <string>
#include <fstream>
#include <cmath>
using namespace std;

void solveMatrix(double**, int, int);
double* getRatio(double**, int, int, double*, int);
void elimination(double**, int, int, int, int);

int main()
{
	int choice = 0;
	cout << "1. Enter the coefficients and vectors of the equation" << endl;
	cout << "2. Enter the file name that contains the matrix data" << endl;
	cout << "You choose: ";
	cin >> choice;
	cin.ignore(999999, '\n');
	if (choice == 1)
	{
		int row = 0, col = 0;
		cout << "Enter the number of rows of the matrix: ";
		cin >> row;
		cout << "Enter the number of columns of the matrix(including the vectors): ";
		cin >> col;
		double **matrix = new double*[row];
		for (int i = 0; i < row; i++)
			matrix[i] = new double[col];
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				cout << "Enter the (" << i << "," << j << ") element in the matrix: ";
				cin >> matrix[i][j];
			}
		}
		solveMatrix(matrix, row, col);
	}
	else
	{
		int countRow = 0, countCol = 0;
		ifstream matrix_data;
		string matrix_data_file, dataLine;
		cout << "Please enter the file name: ";
		getline(cin, matrix_data_file);
		//matrix_data.open("E:/CS/CS301/project1/input.txt");
		matrix_data.open(matrix_data_file.c_str());
		while (getline(matrix_data, dataLine))
		{
			for (int i = 0; i < dataLine.length(); i++)
			{
				if (dataLine[i] != ' ' && countRow == 0)
					countCol++;
			}
			countRow++;
		}

		double **matrix = new double*[countRow];
		for (int i = 0; i < countRow; i++)
			matrix[i] = new double[countCol];
		matrix_data.close();
		ifstream read_matrix_data;
		read_matrix_data.open(matrix_data_file.c_str());
		for (int i = 0; i < countRow; i++)
			for (int j = 0; j < countCol; j++)
				read_matrix_data >> matrix[i][j];
		solveMatrix(matrix, countRow, countCol);
	}
    return 0;
}

void solveMatrix(double **matrix, int rowLen, int colLen)
{
	int pivotRow = 0, len = rowLen;
	double max = 0;
	double *ratio = getRatio(matrix, rowLen, colLen, new double[rowLen], len);
	for (int i = 0; i < rowLen; i++)
		if (ratio[i] > max)
			pivotRow = i;
	ratio[pivotRow] = -1;
	len--;
	max = 0;
	elimination(matrix, pivotRow, rowLen, colLen, len);
	while (len != 0)
	{
		ratio = getRatio(matrix, rowLen, colLen, ratio, len);
		for (int i = 0; i < rowLen; i++)
			if (ratio[i] > max)
				pivotRow = i;
		ratio[pivotRow] = -1;
		len--;
		max = 0;
		elimination(matrix, pivotRow, rowLen, colLen, len);
	}
	
		for(int i = 0; i < rowLen; i++){
		for(int j = 0; j < colLen; j++){
		cout << matrix[i][j] << " ";
		}
		cout << endl;
		}
	


}

double* getRatio(double **matrix, int rowLen, int colLen, double *ratio, int len)
{
	double max = 0;
	for (int i = 0; i < rowLen; i++)
	{
		for (int j = 0; j < colLen - 1; j++)
		{
			if(ratio[i] != -1)
				if (abs(matrix[i][j]) > max)
					max = abs(matrix[i][j]);	
		}
		ratio[i] = abs(matrix[i][rowLen - len]) / max;
	}
	return ratio;
}

void elimination(double **matrix, int pivotRow, int rowLen, int colLen, int len)
{
	for (int i = 0; i < rowLen - 1; i++)
	{
		if (i != pivotRow)
		{
			double fraction = matrix[i][rowLen - len] / matrix[pivotRow][rowLen - len];
			for (int j = colLen - len - 1; j < colLen; j++)
			{
				double tmp = matrix[pivotRow][j] * fraction;
				matrix[i][j] = tmp + matrix[i][j];
			}
		}
	}
}