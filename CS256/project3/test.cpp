#include <iostream>
#include <cstring>
#include <cstdlib>

using namespace std;



int main()
{
  struct lol
  {
    int *x;
    char y;
  };

  lol z = {int[2], 'b'};
  cout << z.x << endl;
  cout << z.y << endl;

}


