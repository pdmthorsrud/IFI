public class Beholder{

    Rute[] ruter;

    Beholder(int lengde){
        ruter = new Rute[lengde];
    }
    
    public int hentLengde(){
        return ruter.length;
    }

    public void printBeholder(){
        for(int i=0; i<ruter.length; i++){
            System.out.print(ruter[i]);
        }
    }

    public Rute hentRute(int i){
        return ruter[i];
    }

    public boolean settInnRute(Rute r){
        for(int i=0; i<ruter.length; i++){
            if(ruter[i]==null){
                ruter[i] = r;
                return true;
            }
        }
        System.out.println("Det er ingen ledige plasser i ruterarrayen,");
        System.exit(1);
        return false;
    }

    public Rute getRuteIndeks(int i){
        if(!tomPlass(i)){
            return ruter[i];
        }else{
            return null;
        }
    }

    public boolean tomPlass(int i){
        if(ruter[i]==null){
            return true;
        }else{
            return false;
        }
    }

    public String[] sjekkVerdier(String[] k){
        for(int i=0; i<k.length; i++){	    
            for(int j=0; j<ruter.length; j++){
		if(ruter[j].hentVerdi()!=null && k[i] !=null && k[i].equals(ruter[j].hentVerdi())){
                    k[i]=null;
                }
            }
        }
        return k;
    }
}
