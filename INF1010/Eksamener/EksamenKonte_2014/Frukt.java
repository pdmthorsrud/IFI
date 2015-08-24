abstract class Frukt implements Comparable<Frukt>{    
    String sort;
    
    Frukt(String s){
	sort = s;
    }

    public int compareTo(String s){
	if(s.equals(sort)){
	    return 0;
	}else{
	    return -1;
	}
    }

    public String id(){
	return sort;
    }
}
