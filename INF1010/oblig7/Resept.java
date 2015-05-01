import java.io.*;
class Resept{
    private static int i = 0;
    private Legemiddel legemiddel;
    private Lege lege;
    private Person person;
    private int reseptNummer;
    private int reit;
    //farge: true = blå, false = hvit
    private boolean farge;
    private String fargeString;

    Resept(Legemiddel legemiddel, Lege lege, Person person, int reit, boolean farge){
        this.legemiddel = legemiddel;
        this.lege = lege;
        this.person = person;
        this.reit = reit;
        this.farge = farge;
        reseptNummer = i;
        i++;
        if(farge){
            fargeString = "blaa";
        }else{
            fargeString = "hvit";
        }

    }

    public String toString(){
        return legemiddel.toString();
    }
    public boolean bruk(){
        if(reit == 0){
            System.out.println("Denne resepten er ikke gyldig");
            return false;
        }
        else{
            reit--;
            System.out.println("Resepten har naa " + reit + " ganger igjen.");
            return true;
        }

    }

    public boolean riktigResept(int reseptNummer, String persNr, int nr){
        if(this.reseptNummer == reseptNummer && persNr.equals(person.foedselsnummer)){
            return true;
        }else if(this.reseptNummer == reseptNummer && nr == person.nummer()){
            return true;
        }else{
            return false;
        }

    }

    public int getReseptNr(){
        return reseptNummer;
    }

    public boolean sjekkPersonPersNr(String persNr){
        return (persNr.equals(person.foedselsNr()));
    }

    public boolean sjekkPersonUnikNr(int nr){
        return (nr == person.nummer());
    }

    public Legemiddel getLegemiddel(){
        return legemiddel;
    }

    public boolean erBlaa(){
        return farge;
    }

    public int getPris(){
        if(farge){
            return 0;
        }else{
            return legemiddel.pris();
        }
    }

    public void printResept(){
        System.out.println(reseptNummer + ", " + fargeString + ", " + person.nummer() + ", " + lege + ", " + legemiddel.nummer() + ", " + reit);
    }

    public void skrivResept(PrintWriter pw){
        pw.println(reseptNummer + ", " + fargeString + ", " + person.nummer() + ", " + lege + ", " + legemiddel.nummer() + ", " + reit);
    }

    public Person getPerson(){
        return person;
    }

    public Lege getLege(){
        return lege;
    }

    public int reit(){
        return reit;
    }

}
