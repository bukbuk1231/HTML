#include <iostream>
#include <time.h>
using namespace std;

void pause( int milliseconds ) {
  int limit = clock() + milliseconds * CLOCKS_PER_SEC / 1000;
  while ( clock() < limit ) {  

  }
}

 
  void printO()
  {
    int index = 0;
    int colorO = 0;
    int OPosition = 0;    
    char ESC = 27;
    for(colorO = 0; colorO <= 7; colorO++)
    {      
      cout << ESC << "[2J";
      for(OPosition = 0; OPosition < 80; OPosition++)
      {
	cout << ESC << "[13;0f";
	for(index = 0; index < 80; index++)
	{  
	  if(OPosition == index)
	  {
	    cout << ESC << "[" << colorO + 30 << ";40m";
	    cout << "O" << flush;
	    cout << ESC << "[37;40m";
	  }
	  else
	    cout << "o" << flush;	  
	}
	pause(50);
      }     
      cout << ESC << "[2J";
      for(OPosition = 80; OPosition >= 0; OPosition--)
      {
        for(index = 80; index >= 0; index--)
	{  
	  cout << ESC << "[13;" << index << "f";
	  if(OPosition == index)
	  {
	    cout << ESC << "[" << colorO + 30 << ";40m";
	    cout << "O" << flush;
	    cout << ESC << "[37;40m";
	  }
	  else
	    cout << "o" << flush;
	}
	pause(50);	
      }
     
    }
  }  
  

int main()
{  
  char ESC = 27; 
  cout << ESC << "[2J";
  cout << ESC << "[37;40m";
  cout << ESC << "[13;0f";
  for(int i = 0; i < 80; i++)
    cout << "o";
  printO();
  cout << endl;
  return 0;
}
