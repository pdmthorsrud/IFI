public class EgenTest{
    public static void main(String[] args){
	String e = "Nr1";
    
	Mengde<String> liste = new Mengde();
	if(liste.tom()){
	    System.out.println("Denne listen er tom. OK");
	}else{
	    System.out.println("Denne listen returnerer false paa tom(). FEIL");
	}

	liste.leggTil(e);

	if(!liste.tom()){
	    System.out.println("Denne listen er ikke tom. OK");
	}else{
	    System.out.println("Denne listen returnerer true paa tom(). FEIL");
	}

	if(liste.leggTil(e)){
	    System.out.println("Fikk lov til aa legge til to av samme objekt. FEIL");
	}else{
	    System.out.println("Fikk ikke lov til aa legge til to av samme objekt. OK");
	}

    }
}
