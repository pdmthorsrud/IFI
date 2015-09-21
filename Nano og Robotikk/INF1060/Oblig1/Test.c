#include <stdio.h>

int main(int argc, char *argv[]){

  if(argc==1){
    printf("Wrong argument. write a commando after calling the program\n");
  }
  
  printf(argv[1]);
  

}
