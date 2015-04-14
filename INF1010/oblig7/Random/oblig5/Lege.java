class Lege implements Lik, Kommune{
    public String navn = "";
    public int avtaleNummer;


    Lege(String navn, int avtaleNummer){
	this.navn = navn;
	this.avtaleNummer = avtaleNummer;
    }
    public boolean samme(String inn){
	if(navn.equals(inn)){
	    return true;
	}
	else{
	    return false;
	}

    }
    public int avtaleNummer(){
	return avtaleNummer;
    }
    








}
