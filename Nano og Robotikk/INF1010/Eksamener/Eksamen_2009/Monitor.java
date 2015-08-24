public class Monitor{

    double minsteTid;
    ArrayList<Utover> utovere;
    

    public synchronized void ferdigTraad(double totalTid, ArrayList<Utover> utovere){
	
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
