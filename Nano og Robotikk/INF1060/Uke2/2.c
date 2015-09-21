#include <stdio.h>

int main(int argc, char* argv[]){

  int i;
  short arr[] = {2, 1, -1, 10, 22, 21};
  int arrlen = 6;
  for(i = 0; i < arrlen; i++)
    printf("[%d]: %d\n", i, *(arr + i));

}
