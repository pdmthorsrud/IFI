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

    public void setvirkestoff(int virkestoff){
	this.virkestoff = virkestoff;

    }
    

}
