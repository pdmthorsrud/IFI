#include <stdio.h>
typedef struct person{

  int age;

  char* name;
} person_p;

void set_name(person_p* person, char* name){
  person->name = name;
}


int main(int argc, char* argv[]){


}
