import java.util.Scanner;

class Test{
    public static void main(String[] args) {
        String hei;
        int tall;
        boolean test;
        double desimal;

        //tester hei variablen
        hei = "Hei på deg";
        System.out.println(hei);

        //tester tall variablen
        tall = 21;
        if(tall<20){
            System.out.println("Tallet er mindre enn 20");
        }else if(tall<=20){
            System.out.println("Tallet er stoerre enn 20");
        }else{
            System.out.println("Over 20");
        }

        //tester boolean
        test = true;
        if(test){
            System.out.println("variablen test = true");
        }else{
            System.out.println("variablen test = false");
        }


	Scanner in;
	int lest;
	int lest2;
	in = new Scanner(System.in);

	System.out.println("skriv inn tall nr 1");
	lest = Integer.parseInt(in.nextLine()); 
	System.out.println("Skriv inn tall nr 2");
	lest2 = Integer.parseInt(in.nextLine());

	System.out.println("Summen av disse er : " + (lest+lest2));
	
    }
}
