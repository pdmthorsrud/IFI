class Lastebil extends Fossilbil{

    double nyttevekt;
    
    Lastebil(String navn, String bilNr, double co2, double nyttevekt){
	super(navn, bilNr, co2);
	this.nyttevekt = nyttevekt;
    }

    public void settNyttevekt(double i){
	nyttevekt = i;
    }

    public void printLastebil(){
	System.out.println("Nyttevekt: " + nyttevekt);
    }

}
