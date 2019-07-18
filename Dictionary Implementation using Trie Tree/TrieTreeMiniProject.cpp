#include<bits/stdc++.h>

using namespace std;

const int ALPHABET_SIZE= 26;
const int CASE = 'a';
 

struct node{
	node* parent = NULL ;
	node* children[ALPHABET_SIZE]={};
	int occurrences = 0 ;
};

void insertnode(node *trietree, char const *word)
{
	node* currentnode = trietree ; // points to root and then traverses :)
	while( *word != '\0'){
		if( currentnode->children[*word-CASE] == NULL)// if this is the first of it alphabet child
		{
			currentnode->children[*word-CASE] = new node();
			currentnode->children[*word-CASE]->parent = currentnode ;
			//no need to increase the occurence as in this case the last letter will increase occurneces 
		}
		currentnode = currentnode->children[*word-CASE];
		++word;
	}
	++currentnode->occurrences ;// when the word is added we increase the occurence of it by 1
}

node* search(node* trietree,char *word){
	// returns with the node where the last alphabet of the word lies, also deals with the case when 
	// word is null, i.e. returns NULL in that case)
	node *current = trietree ;
	while(*word != '\0')
	{
		if( current->children[*word-CASE] == NULL )
			return NULL;
			
		current = current->children[*word-CASE];
		*word++;
	}
	return (current->occurrences > 0)?current:NULL ;//when the word isn't in the trie( but that would be check out by the above loop
	// and NULL would be returned) so this only checks whether the word passed was empty or not , if it was a empty string then NULL is returned
}
void deletenode(node* trietree,char *word)
{
	node* current = search(trietree,word);
	if(current != NULL)
	{ --current->occurrences;
	  node* parent= NULL;
	  bool isleaf= true;
	  
	  for(int i=0;i<ALPHABET_SIZE;i++)           
	  { if(current->children[i] != NULL)
	    { isleaf = false;
	      break;
		}
	  	
	  }
	
	while( current->parent != NULL&& isleaf && current->occurrences == 0 )// make sures we reached the root ( we could have also done as    current != trietree
	{
		parent = current->parent ;
		for(int i = 0 ;i< ALPHABET_SIZE ; i++)
		{
		  if(parent->children[i]==current)
		  { parent->children[i]== NULL;
		    delete current;
		    current = parent;
		  }
		  else if(parent->children[i] != NULL)                     // Generally case is impossible
		  { isleaf= false ;
		    break;
		  }  
	    }
    }
    }
}
void preorderprint(node* trietree,vector<char>word)//instead of passing char pointer we pass vector
{
	if(trietree->occurrences>0)
	{ for(auto it = word.begin() ;it != word.end(); ++it)
	   {
	   	cout<< *it;
	   }
		
		cout<<" "<<trietree->occurrences<<endl;
	}
  for(int i=0;i<ALPHABET_SIZE; ++i)
   { if(trietree->children[i] != NULL)
    { word.push_back(CASE +i);
	  preorderprint(trietree->children[i],word); 
      word.pop_back();
	}
   }
}

 
 
int main(){
	char input[50];
	char wordi[100];
	int choice;
	FILE *p;
	vector<char>word;
	int i,j,k,n,l,v1,v2;
	node* trietree = new node();
	node* nn;
	p=fopen("words.txt","r");
	
	while(fscanf(p,"%s",input)==1)				//readind 1 word fron file
	{
		insertnode(trietree,input);					//printing read word
	}
	printf("//////////////////////////////\n");
	 printf("HEY FRIEND.. WELCOME TO MY DICTIONARY  :) \n");
	 printf("////////////////////////////////////\n");
	printf("//////////////////////////////////// \n");
	 printf("THE DICTIONARY IS READY TO USE \n");
	 printf("//////////////////////////////////////\n");
	
	fclose(p);
	do
	{ 
	 
	 printf("ENTER YOUR CHOICE : \n1.Insert\n2.Search\n3.delete\n4.Display\n5.EXIT\n");
	 scanf("%d",&choice);
	 switch(choice)
	 {
	 	case 1 : printf("WHICH WORD YOU WANT TO INSERT ?\n");
	 	         scanf("%s",wordi);
		         insertnode(trietree,wordi);
		         printf("%s IS ADDED TO THE LIST ",wordi);
		      
		         break;
		case 2 : printf("WHICH WORD YOU WANT TO SEARCH ?\n");
		          scanf("%s",wordi);
		         nn=search(trietree,wordi);
                 printf("Searched word \n");
                 if(nn != NULL)
                 printf("FOUND \n");
                 else printf("NOT FOUND \n");
                 break;
       case 3 : printf("WHICH WORD YOU WANT TO DELETE ?\n");
	 	          scanf("%s",wordi);
	 	         deletenode(trietree,wordi);
	 	         printf("%s IS DELETED FROM THE DICTIONARY",wordi);
		         break;
		case 4: preorderprint(trietree,word);
		        break;
		case 5: exit(0);
		default : printf("WRONG CHOICE ENTERED :(");
	 	         
	 }
	 printf("\n\n\n");
  }while(choice<=4);
	return 0;
}
