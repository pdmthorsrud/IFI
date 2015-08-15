public class Bil{
    String bilNr;
    String bilNavn;

    Bil(String s, String Nr){
	bilNavn = s;
	this.bilNr = Nr;
    }

    public String toString(){
	return bilNavn;
    }

    public void settNavn(String s){
	bilNavn = s;
    }

    public void settBilNr(String bilNr){
	this.bilNr = bilNr;
    }

    public void printBil(){
	System.out.println("BilNr: " + bilNr);
	System.out.println("BilNavn: " + bilNavn);
    }
}
