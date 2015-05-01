class Resept{
    private static int i = 0;
    private Legemiddel legemiddel;
    private Lege lege;
    private Person person;
    private int reseptNummer;
    private int reit;
    //farge: true = blå, false = hvit
    private boolean farge;
    
    Resept(Legemiddel legemiddel, Lege lege, Person person, int reit, boolean farge){
	this.legemiddel = legemiddel;
	this.lege = lege;
	this.person = person;
	this.reit = reit;
	this.farge = farge;
	reseptNummer = i;
	i++;
    }
    public boolean bruk(){
	if(reit == 0){
	    return false;
	}
	else{
	    reit--;
	    return true;
	}
	
    }
	

}
