#include <stdio.h>
#include <stdlib.h>
#include <string.h>


struct node{
  char *data;
  int number;
  struct node *next;
};

typedef struct node str_node;

FILE *fr;
str_node *first = NULL;
int numberOfNodes=0;

void readFile();
void print();

int main(int argc, char *argv[]){
  readFile();
  print();
}


void readFile(){
  fr = fopen("tresmaa.txt", "rt");
  char text[200];
  str_node *curr = first;

  while((fgets(text, 200, fr))!=NULL){
    if(curr==NULL){
      printf("Reading first line\n");
      curr = malloc(sizeof(str_node));
      curr->data = malloc(strlen(text)+1);
      curr->data = text;
      printf("%d\n", curr->number);
      first = curr;
      printf("Printing text: %s", text);
      printf("Printing curr->data: %s\n", first->data);
    }else{
      printf("Reading rest of the lines\n");
      curr = curr->next;
      curr = malloc(sizeof(str_node));
      curr->data = malloc(strlen(text)+1);
      curr->data = text;
      printf("Printing text: %s", text);
      printf("Printing curr->data: %s\n", curr->data);
    }
  }
  fclose(fr);
}

void print(){
  printf("Hello, nr. 2\n");
  str_node *curr = first;
  printf("%s\n", curr->data);

  while(curr->number!=numberOfNodes){
    printf("%s\n",curr->data);
    curr = curr->next;
  }


}
