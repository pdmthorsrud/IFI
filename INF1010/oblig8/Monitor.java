public class Monitor{
    private int antallTot;
    private int antallFerdigeTraader;
    private int k;

    Monitor(int k){
	this.k = k;
    }
    
    synchronized public void vent(){
	while(antallFerdigeTraader != k){
	    try{
		wait();
	    }catch (InterruptedException e){
		System.out.println("Det skjedde en feil som ikke skal skje (og da mener jeg virkelig I DET HELE TATT)");
	    }
	}
    }
    
    synchronized public void leggTilAntall(int antall){
	antallFerdigeTraader++;
	antallTot += antall;
	if(antallFerdigeTraader==k){
	    notify();
	}
    }

    synchronized public int hentAntall(){
	return antallTot;
    }
}
