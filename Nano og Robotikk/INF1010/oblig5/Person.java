class Person{

    String navn;
    int foedselNr;
    int postNr;
    String veiNavn;
    int veiNr;
    String adresse;

    Person(String navn, int foedselNr,int postNr, String veiNavn, int veiNr){
	this.navn = navn;
	this.foedselNr = foedselNr;
	this.postNr = postNr;
	this.veiNavn = veiNavn;
	this.veiNr = veiNr;
	adresse = veiNavn + postNr;
    }
    

}
