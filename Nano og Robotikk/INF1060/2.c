#include <stdio.h>

int main(){

  char s[] = "Hei";

  strgetc(s, 2);

}


char strgetc(char s[], int pos){
  return s[pos];
}
