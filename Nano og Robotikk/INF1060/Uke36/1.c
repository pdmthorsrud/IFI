void sum(int a, int b, int* result){

  *result = a+b;

}

int main(int argc, char* argv){
  int result;
  sum(4, 5, &result);

  printf("%d\n", result);

}
