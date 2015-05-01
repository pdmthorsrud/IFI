public class TraadTeller extends Thread{

    Monitor m;
    String[] ordliste;
    int start;
    int stopp;
    String ord;
    int antall = 0;

    TraadTeller(Monitor m, String[] ordliste, int start, int stopp, String ord){
	this.m = m;
	this.ordliste = ordliste;
	this.start = start;
	this.stopp = stopp;
	this.ord = ord;
    }
    
    public void run(){
	for(int i=start; i<stopp; i++){
	    if(ordliste[i].equals(ord)){
		antall++;
	    }
	}
	m.leggTilAntall(antall);
    }
}
