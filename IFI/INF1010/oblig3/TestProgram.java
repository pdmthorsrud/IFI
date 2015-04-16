class TestProgram{
    public static void main(String[] args){
	
	//Oppretter foerst en hylle med plass til 100 boeker
	Hylle1<Bok> hylleHundre = new Hylle1<Bok>(100);

	//oppretter en bok, setter den inn, tar den saa ut, sjekker saa
	//at den er blitt fjernet.
	Bok bokSomTasUt = new Bok("BokSomTasUt");

	hylleHundre.settPaaPlass(bokSomTasUt, 31);
	if(!hylleHundre.sjekkLedig(31)){
	    System.out.println("OK. Plass er ikke ledig");
	}else{
	    System.out.println("FEIL. sjekkLedig() returnerer true. Forventet: false");
	}

	hylleHundre.taUt(bokSomTasUt);
	if(hylleHundre.sjekkLedig(31)){
	    System.out.println("OK. Plass er ledig");
	}else{
	    System.out.println("FEIL. sjekkLedig() returnerer false. Forventet: true");
	}

	//oppretter en bok og proever aa sette denne inn paa en plass som ikke
	//finnes.
	Bok bokFeilPlass = new Bok("No place for you~");
	hylleHundre.settPaaPlass(bokFeilPlass, 100);

	//oppretter en hylle med 50, og teller saa mengden boeker i den.
	//putter saa inn 24 boeker i hyllen, og kjoerer 
	//mengdePlasserOpptatt() igjen
	//sjekker ogsaa om genHylleStoerrelse fungerer
	Hylle1<Bok> hylleFemti = new Hylle1<Bok>(50);
	if(hylleFemti.mengdePlasserOpptatt()==0){
	    System.out.println("OK. 0 plasser opptatt");
	}else{
	    System.out.println("FEIL. Ikke 0 plasser opptatt");
	}

	if(hylleFemti.genHylleStoerrelse()==50){
	    System.out.println("OK. Hyllestoerrelse = 50.");
	}else{
	    System.out.println("FEIL. Hyllestoerrelse != 50.");
	}

	for(int i=0; i<24; i++){
	    String navn = "bok" + i;
	    hylleFemti.settPaaPlass(new Bok(navn), i);
	}

	if(hylleFemti.mengdePlasserOpptatt()==24){
	    System.out.println("OK. 24 plasser opptatt");
	}else{
	    System.out.println("FEIL. Ikke 24 plasser opptatt");
	}

	//oppretter en utlaaner til bok1 i hylleFemti, sjekker om denne
	//saa stemmer. Returnerer den, og sjekker paa nytt.
	if(hylleFemti.hentObjekt(1).hentUtlaaner()==null){
	    System.out.println("OK. Har ingen utlaaner");
	}else{
	    System.out.println("FEIL. utlaaner!=null");
	}

	if(hylleFemti.hentObjekt(1).leverTilbake()==null){
	    System.out.println("OK. Bok1 har ingen utlaaner");
	}else{
	    System.out.println("FEIL. Bok1 har utlaaner. forventet: skal ikke");
	}
	

	hylleFemti.hentObjekt(1).settUtlaaner("Maria");
	if(hylleFemti.hentObjekt(1).hentUtlaaner().equals("Maria")){
	    System.out.println("OK. Utlaaner er Maria");
	}else{
	    System.out.println("FEIL. Utlaaner er ikke Maria");
	}

	if(!hylleFemti.hentObjekt(1).settUtlaaner("PD")){
	    System.out.println("OK. Bok1 har utlaaner");
	}else{
	    System.out.println("FEIL. Bok1 har ikke utlaaner");
	}

	hylleFemti.hentObjekt(1).leverTilbake();
	if(hylleFemti.hentObjekt(1).hentUtlaaner()==null){
	    System.out.println("OK. Har ingen utlaaner");
	}else{
	    System.out.println("FEIL. utlaaner != null");
	}

    }
}	
