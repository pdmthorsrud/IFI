class MiksturB extends LegemiddelMikstur{

    int vanedannende;

    MiksturB(String navn, double pris, double cm3, double virkestoff, int vanedannende){
	super(navn, pris, cm3, virkestoff);
	this.vanedannende = vanedannende;
    }
}
