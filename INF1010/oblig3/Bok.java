class Bok implements TilUtlaan{

    private String tittel;
    private String utlaaner=null;

    Bok(String tittel){
	this.tittel = tittel;
    }

    public boolean settUtlaaner(String ut){
	if(utlaaner==null){
	    this.utlaaner = ut;
	    return true;
	}else{
	    return false;
	}
    }

    public String leverTilbake(){
	if(utlaaner!=null){
	    String temp = utlaaner;
	    utlaaner = null;
	    return utlaaner;
	}else if(utlaaner==null){
	    return null;
	}
	return null;
    }

    public String hentTittel(){
	return tittel;
    }

    public String hentUtlaaner(){
	return utlaaner;
    }

}
