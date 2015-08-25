#include <stdio.h>
#include <limits.h>
#include <stdlib.h>

int main() {
    short a, b, sum;
    
    short max = SHRT_MAX;
    short tmp = max-a;
    if(tmp>b){
      printf("Your answer exceeds the limit of a short.\n");
      exit(0);
    }
    

    a = 20000;  b = 20000;  sum = a+b;
    printf("%d + %d = %d\n", a, b, sum);
}
