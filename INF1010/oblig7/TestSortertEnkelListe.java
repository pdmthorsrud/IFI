public class TestSortertEnkelListe{

    public static void main(String[] args) {

	SortertEnkelListe<Lege, Lege> leger = new SortertEnkelListe<>();
	testForventet(leger.tomListe()+"", "true", "Sjekker om leger er tom");

	Lege l1 = new Lege("Deniz", 0);
	Lege l2 = new Lege("PD", 1300);
	Lege l3 = new Lege("AndreAss", 1200);

	leger.settInn(l2);
	testForventet(leger.tomListe()+"", "false", "Sjekker om leger er tom");

	leger.settInn(l3);
	leger.settInn(l1);
	System.out.println("\nTEST ALFABETISK REKKEFOELGE");
	leger.printUtElementer();

	testForventet(leger.finnElement("AndreAss")+"", "AndreAss", "Test finne element");

	SortertEnkelListe<Lege, Lege> legerKunEn = new SortertEnkelListe<>();

	testForventet(legerKunEn.finnElement("PD")+"", "null", "Test finne element naar liste er tom");
	
	Lege l21 = new Lege("Elsie", 0);
	leger.settInn(l21);

	testForventet(leger.finnElement("Else")+"", "null", "Test finne element");
	testForventet(leger.finnElement("Elsie")+"", "Elsie", "Test finne element");

	leger.printUt();
	
    }


    public static void testForventet(String aktuell, String forv, String hva){
	if(aktuell.equals(forv)){
	    System.out.println("OK. HVA: " + hva + " || AKTUELL: " + aktuell + " || FORV: " + forv);
	}else{
	    System.out.println("FEIL. HVA: " + hva + " || AKTUELL: " + aktuell + " || FORV: " + forv);
	}
    }

}
