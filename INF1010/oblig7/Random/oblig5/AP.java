class AP extends TypeA implements Pille{
    private int virkestoff = 0;
    private int piller = 0;
    private int virkestoffTot = 0;

    
    AP(String navn, int pris, int narkotisk, int piller, int virkestoff ){
	super(navn, pris);
	this.narkotisk = narkotisk;
	this.piller = piller;
	this.virkestoff = virkestoff;
	this.virkestoffTot = virkestoff * piller;
    }
    public void setpiller(int piller){
	this.piller = piller;
       

    }

    public void setvirkestoff(int virkestoff){
	this.virkestoff = virkestoff;

    }

}
