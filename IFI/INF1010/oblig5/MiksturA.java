class MiksturA extends LegemiddelMikstur{

    int styrke;

    MiksturA(String navn, double pris, double cm3, double virkestoff, int styrke){
	super(navn, pris, cm3, virkestoff);
	this.styrke = styrke;
    }
}
