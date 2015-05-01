import java.io.*;
class AP extends TypeA implements Pille{
    private int virkestoff = 0;
    private int piller = 0;
    private int virkestoffTot = 0;


    AP(String navn, int pris, int piller, int virkestoff, int narkotisk ){
        super(navn, pris);
        this.narkotisk = narkotisk;
        this.piller = piller;
        this.virkestoff = virkestoff;
        this.virkestoffTot = virkestoff * piller;
    }
    public void setpiller(int piller){
        this.piller = piller;


    }

    public int getVirkestoffTot(){
        return virkestoffTot;
    }


    public int getVirkestoff(){
        return virkestoff;
    }


    public void setvirkestoff(int virkestoff){
        this.virkestoff = virkestoff;
    }

    
    public void skrivLegemiddel(PrintWriter pw){
	pw.println(nummer + ", " + navn + ", pille, a, " + pris + ", " + piller + ", " + virkestoff + ", " + narkotisk);  
    }


    public void printInfo(){
        System.out.println("Navn: " + navn);
        System.out.println("Pris: " + pris);
        System.out.println("Nummer: " + nummer);
        System.out.println("Virkestoff: " + virkestoff + " pr pille");
        System.out.println("Mengde: " + piller + " piller");
        System.out.println("Narkotisk: " + narkotisk);
    }

}
