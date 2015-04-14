abstract class LegemiddelPille extends Legemiddel implements Pille{

    int pillerPrEske;
    double virkestoff;
    
    LegemiddelPille(String navn, double pris, int piller, double virkestoff){
	super(navn, pris);
	nr = 0;
	this.navn = navn;
	this.pris = pris;
	settPille(piller, virkestoff);
    }

    public void settPille(int piller, double virkestoff){
	pillerPrEske = piller;
	this.virkestoff = virkestoff;
    }
}
