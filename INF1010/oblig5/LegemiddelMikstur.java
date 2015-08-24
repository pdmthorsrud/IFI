abstract class LegemiddelMikstur extends Legemiddel implements Mikstur{
    
    double cm3;
    double virkestoff;
    
    LegemiddelMikstur(String navn, double pris, double cm3, double virkestoff){
	super(navn, pris);
	this.navn = navn;
	this.pris = pris;
	settMikstur(cm3, virkestoff);
    }

    public void settMikstur(double cm3, double virkestoff){
	this.cm3 = cm3;
	this.virkestoff = virkestoff;
    }
}
