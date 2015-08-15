public class TestTabell{

    public static void main(String[] args){
	Tabell tabell = new Tabell<String>(22);

	tabell.settInnIndeks("hei", 1);

	System.out.println("Forventet: hei || Aktuell: " + tabell.finnIndeks(1));
	System.out.println(tabell.finnIndeks(21));

	tabell.settInnIndeks("boo", 0);
	
	testForventet(tabell.finnIndeks(1)+"", "hei", "Hente indeks");
	testForventet(tabell.settInnIndeks("lol", 3)+"", "true", "Sette inn paa indeks");
	testForventet(tabell.settInnIndeks("kik", 22)+"", "false", "Sette inn paa for hoey indeks");
	testForventet(tabell.settInnIndeks("kik", -1)+"", "false", "Sette inn paa negativ indeks");
	testForventet(tabell.finnIndeks(22)+"", "null", "Hente indeks som er for hoey");
    }

    public static void testForventet(String aktuell, String forv, String hva){
	if(aktuell.equals(forv)){
	    System.out.println("OK. Hva: " + hva + " || Forventet: " + forv + " || Aktuell: " + aktuell);
	}else{
	    System.out.println("FEIL. Hva: " + hva + " || Forventet: " + forv + " || Aktuell: " + aktuell);
	}
    }
}
