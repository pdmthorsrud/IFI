public class Fossilbil extends Bil{

    double utslippCO2;

    Fossilbil(String navn, String bilNr, double utslipp){
	super(navn, bilNr);
	utslippCO2 = utslipp;
    }

    public void settUtslippCO2(double i){
	utslippCO2 = i;
    }

    public void printFossilbil(){
	System.out.println("Utlsipp.CO2: " + utslippCO2);
    }
}
