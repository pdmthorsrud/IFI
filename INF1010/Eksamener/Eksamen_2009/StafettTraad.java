import java.util.*;

public class StafettTraad implements Runnable{

    double totalTid;
    ArrayList<Utover> brukteUtovere = new ArrayList<Utover>();
    Monitor m;
    Etappe etappe;

    StafettTraad(double tid, ArrayList<Utover> array, Etappe etappe, Monitor m){
	totalTid = tid;
	brukteUtovere = klonListe(array);
	this.m = m;
	this.etappe = etappe;
    }

    public void run(){
	Etappetid tmp = etappe.forsteEtappetid();
	while(tmp.nesteTid !=null){
	    totalTid += tmp.etappetid();
	    brukteUtovere.add(tmp.utover());
	    tmp = tmp.nesteTid;
	    if(etappe.nesteEtappe==null){
		m.traadFerdig(totalTid, brukteUtovere);
	    }
	    new Thread(new StafettTraad(totalTid, brukteUtovere, etappe, m)).start();
	}
    }


    public ArrayList<Utover> klonListe(ArrayList<Utover> liste){
	ArrayList<Utover> returneres=null;
	for(Utover u: liste){
	    returneres.add(u);
	}
	if(returneres !=null){
	    return returneres;
	}
	return null;
    }

}
