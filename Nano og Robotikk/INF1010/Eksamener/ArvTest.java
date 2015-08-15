class Hei{

    int i = 987435;

}



class DenSomArver extends Hei{
    public void print(){
	System.out.println(i);
    }
}


public class ArvTest{

    public static void main(String[] args) {
	DenSomArver a = new DenSomArver();

	a.print();
    }
}
