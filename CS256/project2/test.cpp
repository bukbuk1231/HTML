#include <iostream>
using namespace std;

int main() {
  cout << "\e[2J";
  for ( int i = 0; i <= 5; i++ ) {
    cout << "\e[0;" << i << "fA";
    cout << "\e[1;" << i << "fB";
    cout << "\e[" << i << ";0fC";
    cout << "\e[" << i << ";1fD";
  }
  cout << endl << endl;
}
