import java.io.*;
class Person{
    private static int i = 0;
    protected String navn = "";
    protected String foedselsnummer;
    protected String adresse = "";
    protected int postnummer;
    protected int nummer;
    
    Person(String navn, String foedselsnummer, String adresse, int postnummer){
	this.navn = navn;
	this.foedselsnummer = foedselsnummer;
	this.adresse = adresse;
	this.postnummer = postnummer;
	nummer = i;
	i++;
    }

    public String toString(){
	return navn;
    }
    
    public int nummer(){
	return this.nummer;
    }

    public int getPostnummer(){
	return postnummer;
    }

    public String foedselsNr(){
	return this.foedselsnummer;
    }

    public boolean sjekkPersNr(String s){
	if(s.equals(foedselsnummer)){
	    return true;
	}else{
	    return false;
	}
    }

    public boolean sjekkUnikNr(int nr){
	return (nr==nummer);
    }

    public void skrivPerson(PrintWriter pw){
	pw.println(nummer + ", " + navn + ", " + foedselsnummer + ", " + adresse + ", " + postnummer);
    }
	
	



}
