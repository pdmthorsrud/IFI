import java.io.*;
class Lege implements Lik, Kommune, Comparable<Lege>{
    public String navn;
    public int avtaleNummer;


    Lege(String navn, int avtaleNummer){
        this.navn = navn;
        this.avtaleNummer = avtaleNummer;
    }

    public String toString(){
        return navn;
    }

    public boolean samme(String inn){
        if(navn.equals(inn)){
            return true;
        }
        else{
            return false;
        }
    }

    public void skrivLege(PrintWriter pw){
	pw.println(navn + ", " + avtaleNummer);
    }

    public int avtaleNummer(){
        return avtaleNummer;
    }

    public int compareTo(Lege l){
        return navn.compareTo(l.navn);
    }

}
