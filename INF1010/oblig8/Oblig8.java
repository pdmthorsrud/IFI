import java.io.*;
import java.util.*;


public class Oblig8{

    public static void main(String[] args) throws Exception{ // ordSomSkalTelles, filSomSkalLeses, antallTraader
	String[] ordliste;
	String antallOrdString;
	int antallOrd=0;
	int k=0;
	int indeks=0;
	int ordPrTraad;
	Monitor m;
	Oblig8 o = new Oblig8();

	Scanner in = new Scanner(new File(args[1]));
	antallOrdString = in.nextLine();

	try{
	    k = Integer.parseInt(args[2]);
	}catch(Exception e){
	    System.out.println("Tallet du skrev inn er ikke gyldig");
	    System.exit(1);
	}
	m = new Monitor(k);

	try{
	    antallOrd = Integer.parseInt(antallOrdString);
	}catch(Exception e){
	    e.getMessage();
	    System.exit(1);
	}
	ordliste = new String[antallOrd];
	ordPrTraad = o.finnOrdPrTraad(k, antallOrd);

	while(in.hasNextLine()){
	    ordliste[indeks] = in.nextLine();
	    indeks++;
	}

	o.opprettTraader(k, ordPrTraad, m, ordliste, args[0]);
	m.vent();

	System.out.println("Ordet " + args[0] + " finnes " + m.hentAntall() + " ganger i listen.");
    }


    public int finnOrdPrTraad(int k, int antallOrd){
	int ordPrTraad = (int)Math.round((antallOrd/(double)k));
	return ordPrTraad;
    }

    public void opprettTraader(int k, int ordPrTraad, Monitor m, String[] ordliste, String ord){
	int start=0;
	int stopp=ordPrTraad;
	for(int i=0; i<k; i++){
	    if(i==k-1){
		stopp = ordliste.length;
	    }

	    new TraadTeller(m, ordliste, start, stopp, ord).start();
	    start = start + ordPrTraad;
	    stopp = stopp + ordPrTraad;
	}
	System.out.println("Ferdig med oprettelse av traader");
    }
}
