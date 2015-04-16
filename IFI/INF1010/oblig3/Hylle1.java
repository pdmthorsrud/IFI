class Hylle1<T> implements GenHylle<T>{

    T[] hylle;
    int stoerrelse;

    Hylle1(int i){
	hylle = (T[]) new Object[i];
	stoerrelse = i;
    }

    public int genHylleStoerrelse(){
	return stoerrelse;
    }

    public void settPaaPlass(T objekt, int plass){
	if(plass>=hylle.length){
	    System.out.println("Plass " + plass + " finnes ikke");
	}else if(sjekkLedig(plass)){
	    hylle[plass] = objekt;
	}else if(!sjekkLedig(plass)){
	    System.out.println("Denne plassen er ikke ledig");
	}
    }

    public T taUt(T objekt){
	for(int i=0; i<hylle.length; i++){
	    if(hylle[i]==objekt){
		T temp = objekt;
		hylle[i] = null;
		return temp;
	    }
	}
	return null;
    }

    public boolean sjekkLedig(int plass){
	if(hylle[plass]==null){
	    return true;
	}else{
	    return false;
	}
    }

    public int mengdePlasserOpptatt(){
	int teller=0;
	for(int i=0; i<hylle.length; i++){
	    if(hylle[i]!=null) teller++;
	}
	return teller;
    }

    public T hentObjekt(int i){
	return hylle[i];
    }
}
