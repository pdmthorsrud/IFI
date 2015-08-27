#include <stdio.h>

int ishex(unsigned char current_char){
  return (current_char >= '0' && current_char <= '9')
}

int main(){

  printf("Is c a hex = %d", ishex("c"));

}
