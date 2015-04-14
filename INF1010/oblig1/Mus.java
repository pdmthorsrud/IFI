class Mus{
    private boolean syk;
    private int vekt=10;
    private boolean lever=true;
    public static int i=0;
    public String navn;

    //laa til en static int-variabel i som blir plusset paa 1 hver gang en ny mus blir lagret, samtidig som hver mus faar
    //navnet "musNr" + i. Paa denne maaten vil alle musene ha et unikt navn, samtidig som jeg kan holde styr
    //paa hvilken mus i 'rekken' den er. 
    public Mus(int v, boolean syk){
	this.syk = syk;
	vekt = v;
	i++;
	navn = "musNr" + i;
	lever = true;
    }

    //stod ikke noe i oppgaven om denne ekstra strengen med println, men la den til, slik at utskriften stemte overens
    //med hva det staar paa nett at utskriften skal vaere.
    public boolean sjekktilstand(String id, String navn, boolean syk, int vekt, boolean lever){
	if(this.navn.equals(navn) && this.syk==syk){
	    System.out.println("********* Test av musobjekt, testid: " + id + " ***\n ** navn: " + navn + ", OK. \n ** syk: " + syk + ", OK.\n ** vekt: " + vekt + ", OK.");
	}else{
	    System.out.println("navn, syk, eller vekt stemmer ikke overens");
	}
	if(this.syk==syk && this.vekt==vekt && this.lever==lever){
	    return true;
	}else{
	    return false;
	}
    }

    //bruker her navnet som jeg lager i konstruktoeren.
    public boolean infoOmTilstand(String id){
	System.out.println("--- " + id + " ---" + "Info om mus: navn: " + navn + ", vekt: " + vekt + ", " + printLever()); 
	return syk;
    }


    //gjoer noedvendige endringer naar en mus blir bitt
    public void bliBitt(){
	if(syk){
	    lever=false;
	}else{
	    syk=true;
	}
    }

    //printer ut om musen er syk, lever, eller er doed.
    public String printLever(){
	if(lever){
	    if(syk){
		return "syk";
	    }else{
		return "lever";
	    }
	}
	return "doed";
    }

    public boolean syk(){
	return syk;
    }

    //har her to forskjellige metoder for aa hente vekt. Dette fordi det var en del
    //rot med hvilken returvariabler vekt() metoden skulle ha
    public int hentVekt(){
	return vekt;
    }
    public String vekt(){
	return vekt+"";
    }

    public boolean lever(){
	return lever;
    }

    public void settSyk(){
	syk = true;
    }

    public void settDoed(){
	lever = false;
    }

}
