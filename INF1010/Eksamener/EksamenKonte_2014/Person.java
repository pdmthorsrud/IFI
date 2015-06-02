public class Person implements Comparable{

    String id;
    
    public String id(){
	return id;
    }

    public int compareTo(String s){
	if(s.equals(id)){
	    return 0;
	}else{
	    return -1;
	}
    }

}
