public class Bol<T>{

    private T beboer = null;

    public T beboer(){
	return beboer;
    }

    public void settInn(T m){
	beboer = m;
    }

    public T taUt(){
	T m = beboer;
	beboer = null;
	return m;
    }

    public boolean tomt(){
	if(beboer==null){
	    return true;
	}else{
	    return false;
	}
    }


}
