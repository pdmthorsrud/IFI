class Test implements Hello{

    public void hello(){
	System.out.println("Hello");
    }

    public void goodbye(){
	System.out.println("Goodbye");
    }

}

class ExtendTest extends Test{

    public void something(){
	System.out.println("Something");
    }

}



interface Hello{
    public void hello();
}


public class TestProgram{
    public static void main(String[] args) {

	Test t = new Test();
	

	t.hello();
	t.goodbye();

	Hello ht = (Hello) t;

	ht.hello();
	Test t2 = (Test)ht;
	t2.goodbye();

	Test j = new ExtendTest();
	j.hello();
	j.goodbye();
	
    }
}
