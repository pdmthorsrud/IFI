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

    public void setvirkestoff(int virkestoff){
	this.virkestoff = virkestoff;

    }

}
