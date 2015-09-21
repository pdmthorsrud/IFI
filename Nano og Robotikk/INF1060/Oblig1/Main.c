#include <stdio.h>
#include <stdlib.h>
#include <string.h>


struct node{
  char *data;
  struct node *next;
};

typedef struct node str_node;

FILE *fr;
str_node *first = NULL;

void readFile();
void print();

int main(int argc, char *argv[]){
  readFile();
  print();
}


void readFile(){
  fr = fopen("tresmaa.txt", "rt");
  char text[200];
  str_node *tmp;
  str_node *curr = first;

  while((fgets(text, 200, fr))!=NULL){
    if(curr==NULL){
      printf("Reading first line\n");
      curr = malloc(sizeof(str_node));
      curr->data = malloc(strlen(text)+1);
      curr->data = text;
      first = curr;
      printf("Printing text: %s", text);
      printf("Printing curr->data: %s\n", first->data);
    }else{
      printf("Reading rest of the lines\n");
      tmp = curr;
      tmp->next = curr;
      curr = malloc(sizeof(str_node));
      curr->data=malloc(strlen(text)+1);
      curr->data = text;
      printf("Printing text: %s", text);
      printf("Printing curr->data: %s\n", curr->data);
    }
  }
  if(curr==NULL){
    printf("Curr er null her ogsaa");
  }
  fclose(fr);
}

void print(){
  printf("Hello, nr. 2");
  str_node *curr = first;

  printf("Printing first->data: %s\n", first->data);
  
  //while(curr!=NULL){
  //printf("%s\n",curr->data);
  //curr = curr->next;
  //}
  

}
