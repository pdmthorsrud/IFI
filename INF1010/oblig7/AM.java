import java.io.*;
class AM extends TypeA implements Mikstur{
    private int virkestoff = 0;
    private int cm3 = 0;
    private int virkestoffTot = 0;


    AM(String navn, int pris, int cm3, int virkestoff, int narkotisk){
        super(navn, pris);
        this.cm3 = cm3;
        this.virkestoff = virkestoff;
        this.virkestoffTot = virkestoff * cm3;
        this.narkotisk = narkotisk;
    }


    public void setcm3(int cm3){
        this.cm3 = cm3;

    }

    public void setvirkestoff(int virkestoff){
        this.virkestoff = virkestoff;
    }

    public int getVirkestoffTot(){
	return virkestoffTot;
    }

    public int getVirkestoff(){
	return virkestoff;
    }

    public void printInfo(){
	System.out.println("Navn: " + navn);
	System.out.println("Pris: " + pris);
	System.out.println("Nummer: " + nummer);
	System.out.println("Virkestoff: " + virkestoff + " pr cm3");
	System.out.println("Mengde: " + cm3 + "cm3");
	System.out.println("Narkotisk: " + narkotisk);
    }

    public void skrivLegemiddel(PrintWriter pw){
	pw.println(nummer + ", " + navn + ", mikstur, a, " + pris + ", " + cm3 + ", " + virkestoff + ", " + narkotisk);  
    }


}
