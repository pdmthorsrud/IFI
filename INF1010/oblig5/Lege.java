class Lege implements Lik{

    String navn;

    public boolean lik(String s){
	if(s.equals(navn)){
	    return true;
	}else{
	    return false;
	}
    }

}
