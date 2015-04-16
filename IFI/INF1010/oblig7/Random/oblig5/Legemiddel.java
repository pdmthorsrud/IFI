class Legemiddel{
    private static int i = 0;
    private String navn = "";
    private int pris = 0;
    private int nummer = 0;


    Legemiddel(String navn, int pris){
	this.navn = navn;
	this.pris = pris;
	this.nummer = i;
	i++;
    }


}
