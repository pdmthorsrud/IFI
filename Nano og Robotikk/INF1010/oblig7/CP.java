import java.io.*;
class CP extends TypeC implements Pille {
    private int virkestoff = 0;
    private int piller = 0;
    private int virkestoffTot = 0;

    CP(String navn, int pris, int piller, int virkestoff){
        super(navn, pris);
        this.piller = piller;
        this.virkestoff = virkestoff;
        this.virkestoffTot  = virkestoff * piller;
    }
    public void setpiller(int piller){
        this.piller = piller;
    }


    public int getVirkestoff(){
        return virkestoff;
    }

    public int getVirkestoffTot(){
        return virkestoffTot;
    }


    public void setvirkestoff(int virkestoff){
        this.virkestoff = virkestoff;

    }


    public void skrivLegemiddel(PrintWriter pw){
        pw.println(nummer + ", " + navn + ", pille, c, " + pris + ", " + piller + ", " + virkestoff);
    }

    
    public void printInfo(){
        System.out.println("Navn: " + navn);
        System.out.println("Pris: " + pris);
        System.out.println("Nummer: " + nummer);
        System.out.println("Virkestoff: " + virkestoff + " pr pille");
        System.out.println("Mengde: " + piller + " piller");
    }


}
