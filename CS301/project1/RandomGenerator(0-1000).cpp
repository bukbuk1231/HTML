#include <fstream>
#include <iostream>
#include <time.h>
#include <cstdlib>
using namespace std;

int main()
{
  int n = 0;
  cout << "Enter the n: ";
  cin >> n;
  srand(time(0));
  ofstream test;
  test.open("test.txt");
  for(int i = 0; i < n; i++) {
    for(int j = 0; j < n+1; j++) {
      test << rand()%1000 << " ";
    }
    test << endl;
  }
  test.close();




}
