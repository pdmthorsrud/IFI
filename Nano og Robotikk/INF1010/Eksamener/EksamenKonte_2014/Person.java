public class Person implements Comparable<String>{

    String id;
    
    public String id(){
	return id;
    }

    Person(String s){
	id = s;
    }

    public int compareTo(String s){
	if(s.equals(id)){
	    return 0;
	}else{
	    return -1;
	}
    }
}
