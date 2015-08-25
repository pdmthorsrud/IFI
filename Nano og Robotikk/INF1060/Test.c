/* Hello World program */

#include<stdio.h>

main(int argc, char *argv[])
{
  if(argc==2){
    printf("Input: %s \n", argv[1]);
  }else{
    printf("You did not send with the correct amount of arguments\n");
  }
  if(typeof(argv[0]) == int){
    print("This is an int\n");
  }
}
