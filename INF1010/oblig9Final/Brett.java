
import java.util.*;
import java.io.*;

public class Brett{
    Scanner in;
    private int antRaderIBoks;
    private int ruteID =0;
    private int antKolonnerIBoks;
    private int lengdeFinal;
    private Beholder[] rader;
    private Beholder[] kolonner;
    private Beholder[] bokser;

    public void lesFil(String filnavn) throws Exception{
	in = new Scanner(new File(filnavn));
	String innlest;
	antRaderIBoks = tryCatch();
	System.out.println("AntRaderiBoks : " + antRaderIBoks);
	antKolonnerIBoks = tryCatch();
	System.out.println("AntKolonnerIBoks : " + antKolonnerIBoks);
	lengdeFinal = antRaderIBoks * antKolonnerIBoks;
	System.out.println("LengdeFinal : " + lengdeFinal);
	
	rader = new Beholder[lengdeFinal];
	kolonner = new Beholder[lengdeFinal];
	bokser = new Beholder[lengdeFinal];
	opprettBeholdere(rader, lengdeFinal);
	opprettBeholdere(kolonner, lengdeFinal);
	opprettBeholdere(bokser, lengdeFinal);
	System.out.println("Har opprettet rader, kolonner og bokser");

	while(in.hasNextLine()){
	    innlest = in.nextLine();
	    String[] innlestRuter = innlest.split("");
	    opprettRuter(lengdeFinal, innlestRuter);
	}
	System.out.println("Ferdig med opprettelse av ruter");
    }

    public void opprettBeholdere(Beholder[] beholder, int lengde){
	for(int i=0; i<beholder.length; i++){
	    beholder[i] = new Beholder(lengde);
	}
    }

    public void opprettRuter(int lengde, String[] s){
	for(int i=0; i<s.length; i++){
	    if(s[i].equals(".")){
		new Rute(lengde, null, this, ruteID, antRaderIBoks, antKolonnerIBoks);
		ruteID++;
	    }else{
		new Rute(lengde, s[i], this, ruteID, antRaderIBoks, antKolonnerIBoks);
		ruteID++;
	    }
	}
    }

    public Beholder hentBeholder(int nr, String type){
	if(type.equals("rad")){
	    Beholder temp = rader[nr];
	    return temp;
	}else if(type.equals("kolonne")){
	    return kolonner[nr];
	}else if(type.equals("boks")){
	    return bokser[nr];
	}
	return rader[0];
    }

    public int tryCatch(){
	int s;
	try{
	    s = Integer.parseInt(in.nextLine());
	    return s;
	}catch(Exception e){
	    System.out.println("Noe gikk galt");
	    System.exit(1);
	}
	return 666;
    }

    public void printRuteRadNr(int radNr, int ruteNr){
	rader[radNr].hentRute(ruteNr).printMuligeVerdier();
    }

    public void printBrett(){
	for(int i=0; i<rader.length; i++){
	    rader[i].printBeholder();
	    System.out.println();
	}
    }
    
    public void printKolonne(int i){
	kolonner[i].printBeholder();
    }
}
