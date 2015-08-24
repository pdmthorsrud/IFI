import java.io.*;
class CM extends TypeC implements Mikstur{
    private int virkestoff = 0;
    private int cm3 = 0;
    private int virkestoffTot = 0;


    CM(String navn, int pris, int cm3, int virkestoff){
        super(navn, pris);
        this.cm3 = cm3;
        this.virkestoff = virkestoff;
        this.virkestoffTot = virkestoff * cm3;
    }
    public void setcm3(int cm3){
        this.cm3 = cm3;

    }


    public int getVirkestoff(){
        return virkestoff;
    }

    public int getVirkestoffTot(){
        return virkestoffTot;
    }

    public void skrivLegemiddel(PrintWriter pw){
        pw.println(nummer + ", " + navn + ", mikstur, c, " + pris + ", " + cm3 + ", " + virkestoff);
    }


    public void setvirkestoff(int virkestoff){
        this.virkestoff = virkestoff;

    }

    public void printInfo(){
        System.out.println("Navn: " + navn);
        System.out.println("Pris: " + pris);
        System.out.println("Nummer: " + nummer);
        System.out.println("Virkestoff: " + virkestoff + " pr cm3");
        System.out.println("Mengde: " + cm3 + "cm3");
    }

}
