#include <stdio.h>
#include <string.h>
#define STREQ(s1, s2) strcmp(s1, s2)==0




int main(){

  char s[] = "test1";
  char e[] = "test2";
  char f[] = "test1";

  printf("%s + %s = %d\n", s, e, STREQ(s,e));
  printf("%s + %s = %d\n", s, f, STREQ(s,f));

}
