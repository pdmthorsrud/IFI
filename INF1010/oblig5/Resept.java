class Resept{

    int nr;
    Legemiddel middel;
    Lege lege;
    Person person;
    int reit;
    boolean blaa;
    double pris;

    Resept(int nr, Legemiddel middel, Lege lege, Person person, int reit, boolean blaa, double pris){
	this.nr = nr;
	this.middel = middel;
	this.lege = lege;
	this.person = person;
	this.reit = reit;
	this.blaa = blaa;
	if(blaa){
	    this.pris = 0;
	}else{
	    this.pris = pris;
	}
    }
    
    boolean Gyldig(){
	if(reit!=0){
	    return true;
	}else{
	    return false;
	}
    }
}
