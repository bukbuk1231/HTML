// LinearAlgebraSolver.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <string>
#include <fstream>
#include <cmath>
#include <iomanip>
using namespace std;

struct Fraction
{
	double nume;
	double deno;
};

void solveMatrix(double**, Fraction**, int, int);
double* getRatio(double**, int, int, double*, int);
void elimination(double**, Fraction**, int, int, int, int);


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
		Fraction **fracMatrix = new Fraction*[row];
		for (int i = 0; i < row; i++) {
			matrix[i] = new double[col];
			fracMatrix[i] = new Fraction[col];
		}
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				cout << "Enter the (" << i << "," << j << ") element in the matrix: ";
				cin >> matrix[i][j];
			}
		}
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				fracMatrix[i][j].deno = 1;
				fracMatrix[i][j].nume = matrix[i][j];
			}
		}
		cout << "Original Matrix: " << endl;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				cout << matrix[i][j] << " ";
			}
			cout << endl;
		}
		solveMatrix(matrix, fracMatrix, row, col);
	}
	else
	{
		int countRow = 0, countCol = 0;
		ifstream matrix_data;
		string matrix_data_file, dataLine;
		cout << "Please enter the file name: ";
		getline(cin, matrix_data_file);
		matrix_data.open("E:/CS-Projects/CS301/project1/input.txt");
		//matrix_data.open(matrix_data_file.c_str());
		while (getline(matrix_data, dataLine))
		{
			if (countRow == 0)
			{
				for (int i = 0; i < dataLine.length(); i++)
				{
					if (dataLine[i] == ' ')
						countCol++;
				}
			}
			countRow++;
		}
		countCol = (countCol + 1) / 2 * 2;
		double **matrix = new double*[countRow];
		Fraction **fracMatrix = new Fraction*[countRow];
		for (int i = 0; i < countRow; i++) {
			matrix[i] = new double[countCol];
			fracMatrix[i] = new Fraction[countCol];
		}
		matrix_data.close();
		ifstream read_matrix_data;
		read_matrix_data.open("E:/CS-Projects/CS301/project1/input.txt");
		//read_matrix_data.open(matrix_data_file.c_str());
		for (int i = 0; i < countRow; i++)
			for (int j = 0; j < countCol; j++)
				read_matrix_data >> matrix[i][j];
		for (int i = 0; i < countRow; i++)
		{
			for (int j = 0; j < countCol; j++)
			{
				fracMatrix[i][j].deno = 1;
				fracMatrix[i][j].nume = matrix[i][j];
			}
		}
		cout << "Original Matrix: " << endl;
		for (int i = 0; i < countRow; i++) {
			for (int j = 0; j < countCol; j++) {
				cout << matrix[i][j] << " ";
			}
			cout << endl;
		}
		solveMatrix(matrix, fracMatrix, countRow, countCol);
	}
    return 0;
}

void solveMatrix(double **matrix, Fraction **fracMatrix, int rowLen, int colLen)
{
	cout << setprecision(2) << fixed;
	int pivotRow = 0, len = rowLen;
	double max = 0;
	double *ratio = getRatio(matrix, rowLen, colLen, new double[rowLen], len);
	for (int i = 0; i < rowLen; i++)
	{
		if (ratio[i] > max)
		{
			pivotRow = i;
			max = ratio[i];
		}
	}
	ratio[pivotRow] = -1;
	max = 0;
	elimination(matrix, fracMatrix, pivotRow, rowLen, colLen, len);
	len--;
	cout << endl << "Pivoting number " << rowLen - len << " :" << endl;
	for (int i = 0; i < rowLen; i++) {
		for (int j = 0; j < colLen; j++) {
			cout << matrix[i][j] << " ";
		}
		cout << endl;
	}
	
	while (len >= 1)
	{
		ratio = getRatio(matrix, rowLen, colLen, ratio, len);
		for (int i = 0; i < rowLen; i++)
		{
			if (ratio[i] > max)
			{
				pivotRow = i;
				max = ratio[i];
			}
		}
		ratio[pivotRow] = -1;
		max = 0;
		elimination(matrix, fracMatrix, pivotRow, rowLen, colLen, len);
		len--;
		cout << endl << "Pivoting number " << rowLen - len << " :" << endl;
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				cout << matrix[i][j] << " ";
			}
			cout << endl;
		}
	}
	
	for (int i = 0; i < rowLen; i++) 
		for (int j = 0; j < colLen; j++)
				matrix[i][j] = fracMatrix[i][j].nume / fracMatrix[i][j].deno;
			
	for (int i = 0; i < rowLen; i++) {
		for (int j = 0; j < colLen - 1; j++) {
			if (matrix[i][j] != 0) {
				matrix[i][colLen - 1] = matrix[i][colLen - 1] / matrix[i][j];
				matrix[i][j] = 1;
			}
		}
	}
	cout << endl << "Final Matrix: " << endl;
	for (int i = 0; i < rowLen; i++) {
		for (int j = 0; j < colLen; j++) {
			cout << matrix[i][j] << " ";
		}
		cout << endl;
	}
	cout << endl << "Answers:" << endl;
	char ch = 'a';
	for (int i = 0; i < rowLen; i++) {
		for (int j = 0; j < colLen; j++) {
			if (matrix[i][j] == 1) {
				ch = (char)((int)ch + j);
				cout << ch << " = " << matrix[i][colLen - 1] << endl;
				ch = 'a';
				break;
			}
		}
	}

}

double* getRatio(double **matrix, int rowLen, int colLen, double *ratio, int len)
{
	double max = 0;
	for (int i = 0; i < rowLen; i++)
	{
		if (ratio[i] != -1)
		{
			for (int j = colLen - len - 1; j < colLen - 1; j++)
			{
				if (abs(matrix[i][j]) > max)
					max = abs(matrix[i][j]);
			}
			ratio[i] = abs(matrix[i][colLen - len - 1]) / max;
		}
		max = 0;
	}
	return ratio;
}

void elimination(double** matrix, Fraction **fracMatrix, int pivotRow, int rowLen, int colLen, int len)
{
	for (int i = 0; i < rowLen; i++)
	{
		if (i != pivotRow)
		{
			double frac = -(matrix[i][colLen - len - 1] / matrix[pivotRow][colLen - len - 1]);
			
			Fraction fraction;
			fraction.nume = -((fracMatrix[i][colLen - len - 1].nume) * (fracMatrix[pivotRow][colLen - len - 1].deno));
			fraction.deno = (fracMatrix[i][colLen - len - 1].deno) * (fracMatrix[pivotRow][colLen - len - 1].nume);
			
			for (int j = colLen - len - 1; j < colLen; j++)
			{
				
				matrix[i][j] = (matrix[pivotRow][j] * frac) + matrix[i][j];
				
				Fraction tmp;
				tmp.deno = fracMatrix[pivotRow][j].deno * fraction.deno;
				tmp.nume = fracMatrix[pivotRow][j].nume * fraction.nume;
				fracMatrix[i][j].nume = tmp.nume * fracMatrix[i][j].deno + fracMatrix[i][j].nume * tmp.deno;
				fracMatrix[i][j].deno = tmp.deno * fracMatrix[i][j].deno;
				
			}
		}
	}
}