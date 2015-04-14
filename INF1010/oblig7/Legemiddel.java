import java.io.*;

class Legemiddel{
    private static int i = 0;
    protected String navn = "";
    protected int pris = 0;
    protected int nummer = 0;

    public String toString(){
        return navn;
    }

    Legemiddel(String navn, int pris){
        this.navn = navn;
        this.pris = pris;
        this.nummer = i;
        i++;
    }
    public int nummer(){
        return this.nummer;
    }

    public int pris(){
        return pris;
    }

    public void printInfo(){
        System.out.println("Navn: " + navn);
        System.out.println("Pris: " + pris);
        System.out.println("Nummer: " + nummer);
    }

    public void skrivLegemiddel(PrintWriter pw){
	
    }

}
