import java.util.*;

public class TestEldsteForstReseptListe{
    public static void main(String[] args){
	EldsteForstReseptListe resepter = new EldsteForstReseptListe();

	Lege l1 = new Lege("Deniz", 0);
	Lege l2 = new Lege("PD", 1300);
	Lege l3 = new Lege("AndreAss", 1200);

	Person p1 = new Person("PD", "1293", "Olav M. Troviks", 864);
	AP pille1 = new AP("coke", 2345, 23, 13, 12);
	Resept r1 = new Resept(pille1, l1, p1, 10, true);

	Person p2 = new Person("AndreAss", "1693", "M. Troviks", 86);
	AP pille2 = new AP("fanta", 234, 123, 5613, 312);
	Resept r2 = new Resept(pille2, l2, p2, 10, true);

	Person p3 = new Person("Deniz", "193", "Troviks", 8);
	AP pille3 = new AP("pepsi", 23, 12, 561, 31);
	Resept r3 = new Resept(pille3, l3, p3, 10, true);

	
	testForventet(resepter.settInn(r1)+"", "true", "Sette inn resept 1");
	testForventet(resepter.settInn(r2)+"", "true", "Sette inn resept 2");
	testForventet(resepter.settInn(r3)+"", "true", "Sette inn resept 3");

	System.out.println("\nPrinter liste hvor eldste er forst");
	for(Resept r: resepter){
	    System.out.println(r);
	}

	
    }


    public static void testForventet(String aktuell, String forv, String hva){
	if(aktuell.equals(forv)){
	    System.out.println("OK. HVA: " + hva + " || AKTUELL: " + aktuell + " || FORV: " + forv);
	}else{
	    System.out.println("FEIL. HVA: " + hva + " || AKTUELL: " + aktuell + " || FORV: " + forv);
	}
    }
}
