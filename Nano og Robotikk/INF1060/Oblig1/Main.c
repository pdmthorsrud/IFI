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
str_node *curr;

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

  while((fgets(text, 200, fr))!=NULL){
    if(first==NULL){
      printf("reading line\n");
      first = curr;
      curr = malloc(sizeof(str_node));
      curr->data = malloc(strlen(text)+1);
      curr->data = text;
    }else{
      printf("reading line\n");
      tmp = curr;
      tmp->next = curr;
      curr = malloc(sizeof(str_node));
      curr->data=malloc(strlen(text)+1);
      curr->data = text;
    }
  }
  fclose(fr);
}

void print(){

  curr = first;

  while(curr!=NULL){
    printf("Printing line\n");
    printf("%s\n",curr->data);
    curr = curr->next;
    printf("Finished printing line\n");
  }
  

}
