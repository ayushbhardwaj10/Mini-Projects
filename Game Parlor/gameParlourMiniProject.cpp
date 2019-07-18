#include<bits/stdc++.h>
#include<stdlib.h>
using namespace std;
char guess1; 
int total1;  


class information{
	public :
	string player[10];
	string email[2];
	string pno[2];
	string cityloc[2];

};

class ticTacToe : public information 
{
public:
	void* operator new (size_t size)
	{
		void * ptr;
		ptr=malloc(size);
		return ptr;
	}
	void getdata1();
	void putdata1();
	
		void printBoard1() const;
	void getMove1(int number, char& playMove, int& playPosition);
	void setMove1(char move, int position);
	void checkMove1(char& move, int& position, int num);
	
	friend int numOfMoves(); 
	
	bool isWinner() const;
	ticTacToe();
	void setIntro();
    void checkPlayer(int& number);
    void congratPlayer(int num);
private:
	char board1[3][3];
	int totalMoves;
};


class Question: public information
{
public:
    void setValues(string, string, string, string, string, char, int); 
    void askQuestion(); 
    void getquiz();
    void putquiz();
    

private:
    string Question_Text;
    string answer_1;
    string answer_2;
    string answer_3;
    string answer_4;

    char correct_answer;
    int Question_Score;
};

void Question::getquiz()
{ 
   cout<<"\nWHATS YOUR NAME ? \n";
     cin>>player[0];
     cout<<endl;
      cout<<"ENTER EMAIL-ID :"<<endl;
      cin>>email[0];
      cout<<endl;
      cout<<"ENTER YOUR PHONE NUMBER : \n";
      cin>>pno[0];
      cout<<endl;
      cout<<"WHICH CITY YOU LIVE LIVE IN "<<player[0]<<" ?"<<endl;
      cin>>cityloc[0];
      cout<<endl;

}
void Question::putquiz()
{   cout<<"THANKYOU FOR COMING TO THE GAME PARLOUR. WE WILL CONTACT YOU LATER \n\n"<<endl;
    cout<<"YOUR DETAILS ARE :\n\n";
   cout<<"NAME OF PLAYER ";
    cout<<player[0];
     cout<<endl;
      cout<<"EMAIL-ID :";
      cout<<email[0];
      cout<<endl;
      cout<<"PHONE NUMBER : ";
      cout<<pno[0];
      cout<<endl;
      cout<<"YOUR CITY ";
      cout<<cityloc[0];
      cout<<endl;

}

// FUNCTIONS FOR THE BASE CLASS
void ticTacToe::getdata1()
{  
     cout<<"ENTER NAME OF 1ST PLAYER : \n";
     cin>>player[0];
     cout<<endl;
      cout<<"ENTER EMAIL-ID :"<<endl;
      cin>>email[0];
      cout<<endl;
      cout<<"ENTER YOUR PHONE NUMBER : \n";
      cin>>pno[0];
      cout<<endl;
      cout<<"WHICH CITY YOU LIVE LIVE IN "<<player[0]<<" ?"<<endl;
      cin>>cityloc[0];
      cout<<endl;
      cout<<"ENTER NAME OF 2ND PLAYER : \n";
      cin>>player[1];
      cout<<endl;
      cout<<"ENTER EMAIL-ID :"<<endl;
      cin>>email[1];
      cout<<endl;
      cout<<"ENTER YOUR PHONE NUMBER : \n";
      cin>>pno[1];
      cout<<endl;
      cout<<"WHICH CITY YOU LIVE LIVE IN "<<player[1]<<" ?"<<endl;
      cin>>cityloc[1];
      cout<<endl;
     }
   void ticTacToe::putdata1()
{   cout<<"THANKYOU FOR COMING TO THE GAME PARLOUR. WE WILL CONTACT YOU LATER \n\n"<<endl;
    cout<<"YOUR DETAILS ARE :\n\n";
     cout<<"PLAYER 1 NAME : ";
     cout<<player[0];
     cout<<endl;
      cout<<"PLAYER 1 EMAIL-ID :";
      cout<<email[0];
      cout<<endl;
      cout<<"PLAYER 1 PHONE NUMBER : ";
      cout<<pno[0];
      cout<<endl;
      cout<<"PLAYER 1 CITY : ";
      cout<<cityloc[0];
      cout<<endl;
      cout<<"PLAYER 2 NAME: ";
      cout<<player[1];
      cout<<endl;
      cout<<"PLAYER 2 EMAIL-ID :";
      cout<<email[1];
      cout<<endl;
      cout<<"PLAYER 2 PHONE NUMBER : ";
      cout<<pno[1];
      cout<<endl;
      cout<<"PLAYER 2 CITY ";
      cout<<cityloc[1];
      cout<<endl;
     }
     
int numOfMoves();

int main()
{   int select;   
    cout<<"\n ///////////////WELCOME TO THE GAME PARLOUR ///////////////////////////// \n \n \n \n";
    cout<<"WE HAVE THE FOLLOWING TWO GAMES : \n";
    cout<<"1.TIC TAC TOE \n";
    cout<<"2.QUIZ GAME \n";
    cout<<"\nWHICH GAME YOU WANT TO PLAY ? \n\n";
    cin>>select;
    switch(select)
   { case 1:                 // TIC TAC TOE GAME
	 {
	 
   	ticTacToe *myGame; 
    myGame= new ticTacToe;	                
	myGame->getdata1();
	char move; 
	int position; 
	int index=0; 

	myGame->setIntro();
	myGame->printBoard1();
   
	while(!myGame->isWinner() && numOfMoves()<9) 
	{
		myGame->checkPlayer(index); 
		myGame->getMove1(index,move,position);
		myGame->checkMove1(move,position,index);
		myGame->setMove1(move,position);

		if(myGame->isWinner()) 
		{
			myGame->printBoard1();
			cout<<endl;
			myGame->congratPlayer(index);
			cout<<endl;
			myGame->putdata1();
			return 0;
		}
          
		cout << endl;
		system("cls");
		myGame->printBoard1(); 

		index++;
	}
	
	cout << "Cats game!" << endl; 
	}break;
	
	 
	
	case 2:
	{
		Question q[50];
			cout << "WELCOME TO C++ QUIZ \n";

    Question qz;
    qz.getquiz();
    
     
  q[1].setValues("1. which of them is not a OOP?",
        "C++",
        "C",
        "JAVA",
        "PYTHON",
        'b',
        4);

    q[2].setValues("2. which of them will not increment the value of 'x' ?",
        "x++",
        "x*0.5",
        "x/0.1",
        "++x",
        'b',
        4);

    q[3].setValues("3. which of them is the header-file for 'setprecision' '' ?",
        "iostream",
        "bits/stdc++.h",
        "stdlib",
        "iomanip",
        'd',
        4);

    q[4].setValues("4. what is 'iostream' ?",
        "it's'directive",
        "it's'pre-processor directive",
        "it's 'file",
        "it's'command",
        'b',
        4);

    q[5].setValues("5. who designed JAVA?",
        " James Stephen smith ",
        " James Gosling ",
        " Bary b Bary ",
        " Steve jobs ",
        'b',
        4);

    q[6].setValues("6. What is the capital of North Korea ?",
        "Hokaedo",
        "Tokyo",
        "Pyongyang",
        "Hiroshima",
        'c',
        4);

    q[7].setValues("7. Who was the 2nd person after Neil armstrong to set his foot on moon",
        "Sunita williams",
        "Kalpana chawla",
        "Buzz aldrin",
        "Stephen mark",
        'c',
        4);

    q[8].setValues("8. Who is the current captain of India cricket team in ODI",
        "Rohit Sharma",
        "Ms Dhoni",
        "Virat kohli",
        "Ajinkya Rahane",
        'c',
        4);

    q[9].setValues("9. According to Ramayana who was the mother of Lord Rama",
        "Kaushalaya",
        "Radha",
        "Yashomati",
        "Kakayi",
        'a',
        4);

    q[10].setValues("10. What rating does this project deserve out of 10 .",
        "9.5",
        "8",
        "7",
        "Perfect 10",
        'd',
        4);

  
    for(int i=1;i<=10;i++)
    {  
    	 q[i].askQuestion();
	}

	
    cout << "Your Total Score is " << total1 << " out of 40!\n";
    cout << "\n";

   
  
    if (total1 > 15) {
        cout <<"YOU PASSED\n";
        cout << "\n";
         qz.putquiz();
        cin.get();
        cin.ignore();
        return 0;
    }
    else
    {
        cout << "You failed... Sorry, better luck next time.\n";
        cout << "\n";
        qz.putquiz();
    }
    cin.get();
    cin.ignore();
    
   }
    break;

  }
	return 0;
	
}
void Question::setValues(string q, string a1, string a2, string a3, string a4, char ca, int pa)
{   
    Question_Text = q;
    answer_1 = a1;
    answer_2 = a2;
    answer_3 = a3;
    answer_4 = a4;
    correct_answer = ca;
    Question_Score = pa;
    
}

void Question::askQuestion()
{  
    cout << "\n";
    cout << Question_Text << "\n";
    cout << "a. " << answer_1 << "\n";
    cout << "b. " << answer_2 << "\n";
    cout << "c. " << answer_3 << "\n";
    cout << "d. " << answer_4 << "\n";
    cout << "\n";

    
    cout << "What is your answer?" << "\n";
    cin >> guess1;
    
    if (guess1 == correct_answer) {
        cout << "\n";
        cout << "Correct!" << "\n";
        total1 = total1 + Question_Score;
        cout << "\n";
        cout << "Press enter to continue." << "\n";
        cin.get();
        cin.ignore();
    }
    else  
    {
        cout << "\n";
        cout << "Sorry, you're wrong..." << "\n";
        cout << "The correct answer is " << correct_answer << "." << "\n";
        cout << "\n";
        cout << "Press enter to continue." << "\n";
        cin.get();
        cin.ignore();
    }
    
}

void ticTacToe::printBoard1() const
{     
    for(int i=0;i<68;i++)
		{ cout<<"_";
		}
		cout<<endl;
		cout<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<<" "<<"|"<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<< " "<< " "<< " "<<"|"<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<<"|";  
		cout<<endl;
		cout<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<<" "<<"|"<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<< " "<< " "<< " "<<"|"<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<<"|";  
	    cout<<endl;
	for(int row=0;row<3;row++)
	{
		for(int col=0;col<3;col++)
		  {
		    cout<< board1[row][col] << " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<"|"<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<< " ";
		   }
		
		cout<<endl<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<<" "<<"|"<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<< " "<< " "<< " "<<"|"<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<<"|";  
		cout<<endl<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<<" "<<"|"<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<< " "<< " "<< " "<<"|"<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<<"|";  
		cout<<endl<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<<" "<<"|"<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<< " "<< " "<< " "<<"|"<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<<"|";  
		cout<<endl<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<<" "<<"|"<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<<"|"<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<<"|"; 
		cout<<endl; 
		for(int i=0;i<68;i++)
		{ cout<<"_";
		}
		if(row<=1)
		{
		cout<<endl;
		cout<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<<" "<<"|"<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<< " "<< " "<< " "<<"|"<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<<"|";  
		cout<<endl;
		cout<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<<" "<<"|"<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<< " "<< " "<< " "<<"|"<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<<"|";  
		cout<<endl;
		cout<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<<" "<<"|"<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<< " "<< " "<< " "<<"|"<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<< " "<<" "<<" "<<"|";  
		cout<<endl;
	    }
	}
	cout<<endl;
}

void ticTacToe::getMove1(int number, char& playMove, int& playPosition)
{
	if(number==0)
	{
		cout << player[0] << ", Enter your move X and it's'position: ";
		cin >> playMove >> playPosition;
	}
	else
	{
		cout << player[1]<< ", Enter your move O and it's'position: ";
		cin >> playMove >> playPosition;
	}
}

void ticTacToe::checkMove1(char& move, int& position, int num)
{
	if(num==0)
	{
		while(move!='X' && move!='x')
		{
			cout << "You must enter X as your move. Please reenter your move: ";
			cin >> move;
		} 
	} 
	else
	{
		while(move!='O' && move!='o')
		{
			cout << "You  must enter O as your move. Please reenter your move: ";
			cin >> move;
		}
	} 


	while(position<=0 || position>=10)
	{
		cout << "Invalid position. Position must be greater than 1 but must be less than 9 Reenter position: ";
		cin >> position;
		
	} 
}

void ticTacToe::setMove1(char move, int position)
{  
	if(position<=3)
		board1[0][position-1]=move;
	else if(position<=6)
	{
		switch(position)
		{
		case 4:
			board1[1][0]=move;
			break;
		case 5:
			board1[1][1]=move;
			break;
		case 6:
			board1[1][2]=move;
			break;
		}
	}
	else if(position<=9)
	{
		switch(position)
		{
		case 7:
			board1[2][0]=move;
			break;
		case 8:
			board1[2][1]=move;
			break;
		case 9:
			board1[2][2]=move;
			break;
		}
	}

	totalMoves++;
}

int numOfMoves() 
{ ticTacToe T;
	return (T.totalMoves);
}

bool ticTacToe::isWinner() const
{
	if(board1[0][0]==board1[1][1] && board1 [0][0]==board1[2][2])
			return true;
	else if(board1[2][0]==board1[1][1] && board1 [2][0]==board1[0][2])
			return true;
	else if(board1[0][0]==board1[0][1] && board1 [0][0]==board1[0][2])
			return true;
	else if(board1[1][0]==board1[1][1] && board1 [1][0]==board1[1][2])
			return true;
	else if(board1[2][0]==board1[2][1] && board1 [2][0]==board1[2][2])
			return true;
	else if(board1[0][0]==board1[1][0] && board1 [0][0]==board1[2][0])
			return true;
	else if(board1[0][1]==board1[1][1] && board1 [0][1]==board1[2][1])
			return true;
	else if(board1[0][2]==board1[1][2] && board1 [0][2]==board1[2][2])
			return true;
	
	return false;
}

ticTacToe::ticTacToe()
{
	char checker='1';
	for(int row=0;row<3;row++)
		for(int col=0;col<3;col++)
		{
			board1[row][col]=checker;
			checker++;
		}
		
	totalMoves=0;
}

void ticTacToe :: setIntro()
{
	cout << player[0] << ", your moves are X's." << endl;
	cout << player[1] << ", your moves are O's." << endl;
	cout << endl;
}

void ticTacToe:: checkPlayer(int& number)
{
	if(number>1)
		number=0;
}

void ticTacToe:: congratPlayer( int num)
{  
	cout << "Congratulations, " << player[num] << "! You have won!" << endl;
}
