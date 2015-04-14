import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

class LesFil{

    static int i=0;
    static String navn = "Bil" + i;
    ArrayList<Bil> biler = new ArrayList<Bil>();
    File filnavn = new File("biler.txt");
    Scanner les;

    LesFil(){
	try{
	    les = new Scanner(filnavn);
	} catch (FileNotFoundException e){
	    System.out.println("Error: file not found");
	}
    }

    String lesOrd(){
	String temp;
	temp = les.next();
	return temp;
    }


    void lesInnBil(){
	String bilNr = lesOrd();

	biler.add(new Bil(navn, bilNr));
	System.out.println("Les Bil");
	i++;
	navn = "Bil" + i;
    }

    void lesInnFossilbil(){
	String bilNr = lesOrd();
	double co2;
	co2 = Double.parseDouble(lesOrd());

	biler.add(new Fossilbil(navn, bilNr, co2));
	System.out.println("Les Fossil");
	i++;
	navn = "Bil" + i;
    }

    void lesInnLastebil(){
	String bilNr = lesOrd();
	double co2 = Double.parseDouble(lesOrd());
	double nyttevekt = Double.parseDouble(lesOrd());

	biler.add(new Lastebil(navn, bilNr, co2, nyttevekt));
	System.out.println("Les Lastebil");
	i++;
	navn = "Bil" + i;
    }

    void lesInnElBil(){
	String bilNr = lesOrd();
	int batteri = Integer.parseInt(lesOrd());

	biler.add(new ElBil(navn, bilNr, batteri));
	System.out.println("Les ElBil");
	i++;
	navn = "Bil" + i;
    }

    void lesInnPersonFossilbil(){
	String bilNr = lesOrd();
	double co2 = Double.parseDouble(lesOrd());
	int passasjerer = Integer.parseInt(lesOrd());

	biler.add(new Personbil(navn, bilNr, co2, passasjerer));
	System.out.println("Les Personbil");
	i++;
	navn = "Bil" + i;
    }

    void lesInnBiler(){
	int a=0;
	while(les.hasNext()){
	    String lest;
	    lest = lesOrd();
	    if(lest.equals("BIL")){
		lesInnBil();
	    }else if(lest.equals("FOSSIL")){
		lesInnFossilbil();
	    }else if(lest.equals("LASTEBIL")){
		lesInnLastebil();
	    }else if(lest.equals("EL")){
		lesInnElBil();
	    }else if(lest.equals("PERSONFOSSILBIL")){
		lesInnPersonFossilbil();
	    }else{
		System.out.println("FEIL.");
	    }
	    a++;
	}
	System.out.println("Slutt på lesinn");
    }

    public void printFossilbiler(){
	for(Bil b: biler){
	    if(b instanceof Fossilbil){
		System.out.println("\n" + b + " er en fossilbil med spesifikasjonene: ");
		Fossilbil bil = (Fossilbil) b;
		bil.printFossilbil();
	    }
	    if(b instanceof Personbil){
		Personbil bil = (Personbil) b;
		bil.printPersonbil();
	    }
	    if(b instanceof Lastebil){
		Lastebil bil = (Lastebil) b;
		bil.printLastebil();
	    }
	}
    }
}
