class PilleA extends LegemiddelPille{

    int styrke;

    PilleA(String navn, double pris, int piller, double virkestoff, int styrke){
	super(navn, pris, piller, virkestoff);
	this.styrke = styrke;
    }
}
