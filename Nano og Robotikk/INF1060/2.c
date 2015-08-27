#include <stdio.h>

char strgetc(char s[], int pos){
  return s[pos];
}


int main(){

  char s[] = "Hei";

  printf("%c\n", strgetc(s, 2));

}


