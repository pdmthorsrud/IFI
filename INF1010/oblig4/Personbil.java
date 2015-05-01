public class Personbil extends Fossilbil{

    int antPassasjerer;

    Personbil(String navn, String bilNr, double co2, int antPassasjerer){
	super(navn, bilNr, co2);
	this.antPassasjerer = antPassasjerer;	
    }

    public void settAntPassasjerer(int i){
	antPassasjerer = i;
    }

    public void printPersonbil(){
	System.out.println("AntPassasjerer: " + antPassasjerer);
    }
}
