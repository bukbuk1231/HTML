#include <iostream>
#include <fstream>
#include <string>
#include <time.h>

using namespace std;

void pause(int);
void plot(int, int, char);
void hplot(int, int, char, int);
void vplot(int, int, char, int);
void move(int, int, int, int, int, int, char[25][80]);
void copy(int, int, int, int, int, int, char[25][80]);
void checkArray(char[25][80]);

int main(int cnt, char* args[])
{
  const string cls = "\e[2J\e[0;0f"; 
  const string resetCursor = "\e[0;0f";
  const int MAX_LINE_CHAR = 65536;
  string command_file = args[1];

  ifstream myfile;
  myfile.open(command_file.c_str());
  
  ofstream logfile;
  logfile.open("project2.log");
  
  string command;
  string string_data;
  bool ifpause = false;
  int time_gap;
  int data1;
  int data2;
  int data3;
  int data4;
  int data5;
  int data6;
  char char_data;
  int char_amount;
  int line_number = 1;
  char screen_data[25][80];
  
  for(int i = 0; i < 25; i++)
    for(int j = 0; j < 80; j++)
      screen_data[i][j] = ' ';
  
  while(myfile >> command)
  {  
    if(command == "clear")
      cout << cls;
    else if(command == "setms")
    {
      myfile >> data1;
      time_gap = data1;
    }
    else if(command == "setfg")
    {
      myfile >> data1;
      cout << "\e[" << data1 << "m";
    }
    else if(command == "setbg")
    {
      myfile >> data1;
      cout << "\e[" << data1 << "m";
    }      
    else if(command == "pause")    
      pause(time_gap);
    else if(command == "slow")
      ifpause = true;
    else if(command == "fast")
      ifpause = false;
    else if(command == "plot")
    {
      myfile >> data1 >> data2 >> char_data;
      plot(data1, data2, char_data);
      screen_data[data1][data2] = char_data;
      cout << resetCursor;
    }
    else if(command == "hplot")
    {
      myfile >> data1 >> data2 >> char_data >> char_amount;
      hplot(data1, data2, char_data, char_amount);
      for(int i = 0; i < char_amount; i++)
      {
	screen_data[data1][data2] = char_data;
	data2++;
      }
      cout << resetCursor;
    }
    else if(command == "vplot")
    {
      myfile >> data1 >> data2 >> char_data >> char_amount;
      vplot(data1, data2, char_data, char_amount);
      for(int i = 0; i < char_amount; i++)
      {
	screen_data[data1][data2] = char_data;
	data1++;
      }
      cout << resetCursor;
    }
    else if(command == "text")
    {
      myfile >> data1 >> data2;
      getline(myfile, string_data);
      cout << "\e[" << data1 << ";" << data2 << "f";
      cout << string_data;
      for(int i = 0; i < string_data.length(); i++)
      {
	screen_data[data1][data2] = string_data[i];
	data2++;
      }
      cout << resetCursor;
    }
    else if(command == "move")
    {
      myfile >> data1 >> data2 >> data3 >> data4 >> data5 >> data6;
      move(data1, data2, data3, data4, data5, data6, screen_data);
      cout << resetCursor;
    }
    else if(command == "copy")
    {
      myfile >> data1 >> data2 >> data3 >> data4 >> data5 >> data6;
      copy(data1, data2, data3, data4, data5, data6, screen_data);
      cout << resetCursor;
    }
    else if(command == "//")    
      myfile.ignore(MAX_LINE_CHAR, '\n');
    else if(command == "quit")
      break;
    else if(command == "check")
    {
      cout << cls;
      checkArray(screen_data);
      cout << resetCursor;
    }
    else
      logfile << "Error: Line " << line_number << " - bad command \"" << command << "\", skipping." << endl;
    if(ifpause)
      pause(time_gap);
    line_number++;
  }  
  myfile.close();
  logfile.close();
  return 0;
}

void pause(int milliseconds)
{
  int limit = clock() + milliseconds * CLOCKS_PER_SEC / 1000;
  while ( clock() < limit ) 
  {
  }
}

void plot(int row, int col, char ch)
{
  cout << "\e[" << row << ";" << col << "f";
  cout << ch;
}	 

void hplot(int row, int col, char ch, int amount)
{
  cout << "\e[" << row << ";" << col << "f";
  for(int i = 0; i < amount; i++)
    cout << ch << flush;
}

void vplot(int row, int col, char ch, int amount)
{  
  for(int i = 0; i < amount; i++)
  {
    cout << "\e[" << row << ";" << col << "f";
    cout << ch << flush;
    row++;
  }
}

void move(int row, int col, int wid, int len, int newRow, int newCol, char screen_data[25][80])
{
  char tmp[25][80];
  int x = row;
  int y = col;
  for(int i = row; i < row + wid; i++) 
  { 
    for(int j = col; j < col + len; j++)
    {
      tmp[i][j] = screen_data[i][j];
      screen_data[i][j] = ' ';
    }
  } 
  for(int i = newRow; i < newRow + wid; i++)
  {
    for(int j = newCol; j < newCol + len; j++)
    {
      screen_data[i][j] = tmp[x][y];         
      y++;    
    }
    y = col;
    x++;
  }
  for(int i = 0; i < 25; i++)
  {
    for(int j = 0; j < 80; j++)
    {
      cout << "\e[" << i << ";" << j << "f";
      cout << screen_data[i][j] << flush;
    }
  }
}

void copy(int row, int col, int wid, int len, int newRow, int newCol, char screen_data[25][80])
{
  char tmp[25][80];
  int x = row;
  int y = col;
  for(int i = row; i < row + wid; i++)    
    for(int j = col; j < col + len; j++)   
      tmp[i][j] = screen_data[i][j];      
  for(int i = newRow; i < newRow + wid; i++)
  {
    for(int j = newCol; j < newCol + len; j++)
    {
      screen_data[i][j] = tmp[x][y];         
      y++;    
    }
    y = col;
    x++;
  }   
  for(int i = 0; i < 25; i++)
  {
    for(int j = 0; j < 80; j++)
    {
      cout << "\e[" << i << ";" << j << "f";
      cout << screen_data[i][j] << flush;
    }
  }
}

void checkArray(char screen_data[25][80])
{
 for(int i = 0; i < 25; i++)
  {
    for(int j = 0; j < 80; j++)
    {
      cout << "\e[" << i << ";" << j << "f";
      cout << screen_data[i][j] << flush;
    }
  }
}
