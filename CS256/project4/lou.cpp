#include <iostream>
#include <string>
#include <fstream>

using namespace std;

int checkBoard(char[3][3]);
bool preAttack(char[3][3], char, char);
bool defense(char[3][3], char, char);
bool attack(char[3][3], char, char);
bool checkHorizontal(char[3][3], char, char, bool);
bool checkVertical(char[3][3], char, char, bool);
bool checkDiagonal(char[3][3], char, char, bool);
bool randomPick(char[3][3], char);

int main(int cnt, char* args[])
{
  string game_board_file = args[1];
  char letter = args[2][0];
  char opponent = 'X';
  char board[3][3];
  int win = 0;
  ifstream game_board;
  game_board.open(game_board_file.c_str()); 
  string line;

  if(letter == 'X')
    opponent = 'O';    
  for(int i = 0; i < 3; i++)   
  {
    getline(game_board, line);
    for(int j = 0; j < 3; j++)
      board[i][j] = line[j];    
  }  
 
  game_board.close();
  if(!preAttack(board, letter, opponent))
    if(!defense(board, letter, opponent)) 
      if(!attack(board, letter, opponent))
	randomPick(board, letter); 
     
  win = checkBoard(board);
  ofstream new_game_board;
  new_game_board.open(game_board_file.c_str());
  for(int i = 0; i < 3; i++) {
    for(int j = 0; j < 3; j++) {
      new_game_board << board[i][j];
    }
    new_game_board << endl;
  }
  new_game_board.close();
  for(int i = 0; i < 3; i++) {
    for(int j = 0; j < 3; j++) {
      cout << board[i][j];
    }
    cout << endl;
  }
  if(win == 1) {
    cout << endl;
    cout << "X Wins!" << endl;
  }
  else if(win == 2) {
    cout << endl;
    cout << "O Wins!" << endl;
  }   
  else if(win == 0) {
    cout << endl;
    cout << "Tied!" << endl;
  }
  return 0;
}

bool preAttack(char board[3][3], char letter, char opponent)
{
  bool picked = false;
  if(checkHorizontal(board, letter, opponent, true))
    picked = true;
  else if(checkVertical(board, letter, opponent, true))
    picked = true;
  else if(checkDiagonal(board, letter, opponent, true))
    picked = true;
  return picked;
}

bool defense(char board[3][3], char letter, char opponent)
{ 
  int i = 0, j = 0;
  bool picked = false;
  if(checkHorizontal(board, letter, opponent, false)) 
    picked = true;    
  else if(checkVertical(board, letter, opponent, false)) 
    picked = true;
  else if(checkDiagonal(board, letter, opponent, false)) 
    picked = true;
  return picked;
}

bool checkHorizontal(char board[3][3], char letter, char opponent, bool attack)
{
  int count = 0, row = 0;
  bool defend = false, atk = false;
  if(!attack) {
    for(int i = 0; i < 3; i++) { 
      for(int j = 0; j < 3; j++) { 
	if(board[i][j] != ' ')
	  count++;
      }
      if(count != 3) {
	count = 0;
	for(int k = 0; k < 3; k++) {
	  if(board[i][k] == opponent)
	    count++;
	}
	if(count == 2) {	
	  defend = true;
	  row = i;
	}
	if(defend) {
	  for(int k = 0; k < 3; k++) {
	    if(board[row][k] == ' ') {
	      board[row][k] = letter; 
	      return true;
	    }
	  }
	}     
      }
      count = 0;
    }
  }
  else {
    count = 0;
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) { 
	if(board[i][j] != ' ')
	  count++;
      }
      if(count != 3) {
	count = 0;
	for(int k = 0; k < 3; k++) {
	  if(board[i][k] == letter)
	    count++;	
	}
	if(count == 2) {
	  atk = true;
	  row = i;
	}
	if(atk) {
	  for(int j = 0; j < 3; j++) {
	    if(board[row][j] == ' ') {
	      board[row][j] = letter;
	      return true;
	    }
	  }      
	}
      }
      count = 0;
    }
  }
  return false;
}

bool checkVertical(char board[3][3], char letter, char opponent, bool attack)
{
  int count = 0, col = 0, tmp = 0;
  bool defend = false, atk = false;
  if(!attack) {
    for(int j = 0; j < 3; j++) {
      for(int i = 0; i < 3; i++) { 
	if(board[i][j] != ' ')
	  count++;
      }
      if(count != 3) {
	count = 0;
	for(int k = 0; k < 3; k++) {
	  if(board[k][j] == opponent)
	    count++;
	}
	if(count == 2) {	 
	  defend = true;
	  col = j;
	}
	if(defend) {
	  for(int k = 0; k < 3; k++) {
	    if(board[k][col] == ' ') {
	      board[k][col] = letter; 
	      return true;	
	    }
	  }  
	}     
      }
      count = 0;
    }
  }
  else {
    count = 0;
    for(int j = 0; j < 3; j++) {
      for(int i = 0; i < 3; i++) { 
	if(board[i][j] != ' ')
	  count++;
      }
      if(count != 3) {
	count = 0;	 
	for(int k = 0; k < 3; k++) {
	  if(board[k][j] == letter)
	    count++;	
	}
	if(count == 2) {
	  atk = true;
	  col = j;	 
	}             
	if(atk) {
	  for(int k = 0; k < 3; k++) {
	    if(board[k][col] == ' ') {
	      board[k][col] = letter;
	      return true;
	    }	
	  }
	}
      }
      count = 0;
    }
  }  
  return false;
}

bool checkDiagonal(char board[3][3], char letter, char opponent, bool attack)
{
  int count = 0;
  if(!attack) {
    for(int i = 0; i < 3; i++)
      if(board[i][i] != ' ')
	count++;
    if(count != 3) { 
      count = 0;
      for(int i = 0; i < 3; i++)
	if(board[i][i] == opponent)
	  count++;
      if(count == 2) {
	for(int i = 0; i < 3; i++) {
	  if(board[i][i] == ' ') {
	    board[i][i] = letter;
	    return true;
	  }
	}
      }   
    }
    count = 0;
    for(int i = 0; i < 3; i++)
      if(board[i][2 - i] != ' ')
	count++;
    if(count != 3) {
      count = 0;
      for(int i = 0; i < 3; i++)
	if(board[i][2 - i] == opponent)
	  count++;   
      if(count == 2) {      
	for(int i = 0; i < 3; i++) {
	  if(board[i][2 - i] == ' ') {
	    board[i][2 - i] = letter;
	    return true;	
	  }
	}
      }
    }
  }
  else {
    count = 0;
    for(int i = 0; i < 3; i++)
      if(board[i][i] != ' ')
	count++;
    if(count != 3) {      
      count = 0;
      for(int i = 0; i < 3; i++)
	if(board[i][i] == letter)
	  count++;
      if(count == 2) {
	for(int i = 0; i < 3; i++) {
	  if(board[i][i] == ' ') {
	    board[i][i] = letter;
	    return true;
	  }
	}
      }
    }
    else {
      count = 0;
      for(int i = 0; i < 3; i++)
	if(board[i][2 - i] != ' ')
	  count++;
      if(count != 3) {      
	count = 0;
	for(int i = 0; i < 3; i++)
	  if(board[i][2 - i] == letter)
	    count++;
	if(count == 2) {
	  for(int i = 0; i < 3; i++) {
	    if(board[i][2 - i] == ' ') {
	      board[i][2 - i] = letter;
	      return true;
	    }
	  }
	}
      }
    }
  }
  return false;
}

bool attack(char board[3][3], char letter, char opponent)
{
  int i = 0, j = 0, count = 0;
  if(board[1][1] == ' ') {
    board[1][1] = letter;
    return true;
  }
  if(board[1][1] == opponent) {
    for(i = 0; i < 3; i++)
      for(j = 0; j < 3; j++)
	if(board[i][j] != ' ')
	  count++;   
    if(count == 1) {
      board[0][0] = letter;
      return true;
    }
    else if(count == 2) {
      if(board[0][0] == letter) {
	board[2][2] = letter;
	return true;
      }
      else if(board[0][2] == letter) {
	board[2][0] = letter;
	return true;
      }
      else if(board[2][0] == letter) {
	board[0][2] = letter;
	return true;
      }
      else if(board[2][2] == letter) {
	board[0][0] = letter;
	return true;
      }
      else if(board[0][1] == letter || board[1][0] == letter) {
	board[0][0] = letter;
	return true;
      }
      else if(board[2][1] == letter || board[1][2] == letter) {
	board[2][2] = letter;
	return true;
      }
    }
  }
  count = 0;
  if(board[1][1] == letter) {
    for(i = 0; i < 3; i++)
      for(j = 0; j < 3; j++)
	if(board[i][j] == opponent)
	  count++;
    if(count == 1) {
      if(board[0][0] == opponent) {
	board[2][0] = letter;
	return true;
      }
      else if(board[0][2] == opponent) {
	board[2][2] = letter;
	return true;
      }
      else if(board[2][0] == opponent) {
	board[0][0] = letter;
	return true;
      }
      else if(board[2][2] == opponent) {
	board[0][2] = letter;
	return true;
      }
      else
	board[0][0] = letter;
      return true;
    }
  }
  count = 0;
  for(i = 0; i < 3; i++)
      for(j = 0; j < 3; j++)
	if(board[i][j] != ' ')
	  count++;
  if(count == 3) {
    count = 0;
    for(i = 0; i < 3; i++)
      for(j = 0; j < 3; j++)
	if(board[i][j] == opponent)
	  count++;
    if(count == 2) {      
      if(board[1][1] == letter) {
	if((board[0][0] == opponent && board[2][2] == opponent) || (board[0][2] == opponent && board[2][0] == opponent)) {
	  board[0][1] = letter;
	  return true;
	}
	else if(board[0][1] == opponent && board[2][1] == opponent) {
	  board[1][0] = letter;
	  return true;
	}
      }
    }
    else {
      board[0][1] = letter;
      return true;
    }
  }        
  return false;
}

int checkBoard(char board[3][3])
{
  int count = 0;
  for(int i = 0; i < 3; i++) {
    for(int j = 0; j < 3; j++) {
      if(board[i][j] == 'X')
	count++;
      if(count == 3)
	return 1;
    }
    count = 0;
  }
  count = 0;
  for(int j = 0; j < 3; j++) {
    for(int i = 0; i < 3; i++) {
      if(board[i][j] == 'X')
	count++;
      if(count == 3)
	return 1;
    }
    count = 0;
  }
  count = 0;
  for(int i = 0; i < 3; i++) {
      if(board[i][i] == 'X')
	count++;
      if(count == 3)
	return 1;
  }
  count = 0;
  for(int i = 0; i < 3; i++) {
      if(board[i][2 - i] == 'X')
	count++;
      if(count == 3)
	return 1;
  }
  count = 0;
  for(int i = 0; i < 3; i++) {
    for(int j = 0; j < 3; j++) {
      if(board[i][j] == 'O')
	count++;
      if(count == 3)
	return 2;
    }
    count = 0;
  }

  for(int j = 0; j < 3; j++) {
    for(int i = 0; i < 3; i++) {
      if(board[i][j] == 'O')
	count++;
      if(count == 3)
	return 2;
    }
    count = 0;
  }
  count = 0;
  for(int i = 0; i < 3; i++) {
      if(board[i][i] == 'O')
	count++;
      if(count == 3)
	return 2;
  }
  count = 0;
  for(int i = 0; i < 3; i++) {
    if(board[i][2 - i] == 'O')
	count++;
      if(count == 3)
	return 2;
  }
  count = 0;
  for(int i = 0; i < 3; i++) {
    for(int j = 0; j < 3; j++) {
      if(board[i][j] != ' ')
	count++;
    }
  }
  if(count == 9)
    return 0;
  return 999;
}

bool randomPick(char board[3][3], char letter)
{
  int i = 0, j = 0;
  for(i = 0; i < 3; i++) {
    for(j = 0; j < 3; j++) {
      if(board[i][j] == ' ') {
	board[i][j] = letter;
	return true;
      }
    }    
  }
  return false;
}
