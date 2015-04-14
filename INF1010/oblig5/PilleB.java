class PilleB extends LegemiddelPille{

    int vanedannende;

    PilleB(String navn, double pris, int piller, double virkestoff, int vanedannende){
	super(navn, pris, piller, virkestoff);
	this.vanedannende = vanedannende;
    }
}
