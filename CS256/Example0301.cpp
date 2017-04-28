#include <iostream>
using namespace std;

int main()
{

  char ESC = 27;
  
  //clear the screen
  cout << ESC << "[2J" << ESC << "[0;0f" << flush;
  cout << ESC << "[13;35f";
  cout << "Hello World";
  cout << ESC << "[1;80f";
  return 0;
}
