class Person{
    private static int i = 0;
    private String navn = "";
    private int fødselsnummer;
    private String adresse = "";
    private int postnummer;
    private int nummer;
    
    Person(String navn, int fødselsnummer, String adresse, int postnummer){
	this.navn = navn;
	this.fødselsnummer = fødselsnummer;
	this.adresse = adresse;
	this.postnummer = postnummer;
	nummer = i;
	i++;
    }
	
	



}
