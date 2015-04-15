public class Rute{

    private int lengdeFinal;
    private int ruteID;
    private String verdi;
    private int radNr;
    private int kolonneNr;
    private int boksNr;
    private int antRaderIBoks;
    private int antKolonnerIBoks;
    private String[] muligeVerdier;
    public Rute neste;
    private Beholder rad;
    private Beholder kolonne;
    private Beholder boks;
    private Brett b;

    Rute(int lengde, String verdi, Brett b, int ruteID, int antRaderIBoks, int antKolonnerIBoks){
	this.lengdeFinal = lengde;
	this.b = b;
	this.verdi=verdi;
	this.ruteID = ruteID;
	this.antRaderIBoks = antRaderIBoks;
	this.antKolonnerIBoks = antKolonnerIBoks;
	if(verdi!=null){
	    muligeVerdier = null;
	}else{
	    muligeVerdier = new String[lengde];

	    for(int i=0; i<lengde; i++){
		muligeVerdier[i] = i+1+"";
		if(i>8){
		    for(char ch='a'; i<lengde; ch++){
			muligeVerdier[i] = ch+"";
			i++;
		    }
		    break;
		}
	    }
	}
	opprettRad();
	opprettKolonne();
	opprettBoks();
    }

    public String toString(){
	if(verdi==null){
	    return ".";
	}
	return verdi;
    }

    public void opprettRad(){
	if(ruteID!=0){
	    radNr = ruteID/lengdeFinal;
	    rad = b.hentBeholder(radNr, "rad");
	}else{
	    rad = b.hentBeholder(0, "rad");
	}
	rad.settInnRute(this);
    }

    public void opprettKolonne(){
	if(ruteID!=0){
	    kolonneNr = ruteID%lengdeFinal;
	    System.out.println("KolonneNr for rute " + ruteID + " : " +kolonneNr);
	    kolonne = b.hentBeholder(kolonneNr, "kolonne");
	}else{
	    kolonne = b.hentBeholder(0, "kolonne");
	}
	kolonne.settInnRute(this);
    }

    public void printKolonne(){
	kolonne.printBeholder();
    }

    public void opprettBoks(){
	if(ruteID!=0){
	    boksNr = (radNr -(radNr%antRaderIBoks) + (kolonneNr/antKolonnerIBoks));
	    boks = b.hentBeholder(boksNr, "boks");
	}else{
	    boks = b.hentBeholder(0, "boks");
	}
	boks.settInnRute(this);
    }

    public String[] finnMuligeTall(){
	if(verdi != null){
	    System.out.println("Denne ruten har en allerede satt verdi : " + verdi);
	    return null;
	}
	rad.sjekkVerdier(muligeVerdier);
	kolonne.sjekkVerdier(muligeVerdier);
	boks.sjekkVerdier(muligeVerdier);
	return muligeVerdier;
    }

    public boolean finnesMuligeVerdier(){
	for(int i=0; i<muligeVerdier.length; i++){
	    if(muligeVerdier[i]!=null){
		return true;
	    }
	}
	return false;
    }

    public boolean harSattVerdi(){
	if(muligeVerdier==null){
	    return true;
	}
	return false;
    }

    public void printMuligeVerdierArray(){
	for(int i=0; i<muligeVerdier.length; i++){
	    System.out.println(muligeVerdier[i]);
	}
    }
    
    public void printMuligeVerdier(){
	if(verdi!=null){
	    System.out.println("Denne ruten har den satte verdien : " + verdi);
	    return;
	}
	
	finnMuligeTall();
	System.out.println("Printer ut alle mulige verdier for rute nr: " + ruteID);
	for(int i=0; i<muligeVerdier.length; i++){
	    if(muligeVerdier[i]!=null)
		System.out.println(muligeVerdier[i]);
	}
	System.out.println("Ferdig med printMuligeVerdier");
    }

    public void settNeste(Rute r){
	neste = r;
    }

    public String hentVerdi(){
	return verdi;
    }

    public Rute hentNeste(){
	return neste;
    }

    public boolean fyllUtDenneRutenOgResten(){
	if(!harSattVerdi() && finnesMuligeVerdier()){
	    for(int i=0; i<muligeVerdier.length; i++){
		if(muligeVerdier[i]!=null){
		    verdi = muligeVerdier[i];
		}
	    }
	}
	if(harSattVerdi()){
	    neste.fyllUtDenneRutenOgResten();
	}
	if(neste.fyllUtDenneRutenOgResten()){
	    
	}
	return false;
    }

    //sjekker om stuff funker

}
