import java.util.*;
import java.io.*;

public class Tabell<T> implements AbstraktTabell<T>, Iterable<T>{

    T[] liste;

    @SuppressWarnings("unchecked")

    public Tabell(int lengde){
	liste = (T[]) new Object[lengde];
	System.out.println("Liste med lengde " + lengde + " har blitt lagd");
    }

    public boolean settInnIndeks(T t, int i){
	if(i>liste.length-1 || i<0){
	    System.out.println("Denne plassen finnes ikke");
	    return false;
	}else if(liste[i]==null){
	    liste[i] = t;
	    return true;
	}else{
	    System.out.println("Denne plassen er tatt");
	    return false;
	}
    }
    public T finnIndeks(int i){
	if(i>liste.length-1 || i<0){
	    System.out.println("Denne plassen finnes ikke");
	    return null;
	}
	if(liste[i]!=null){
	    return liste[i];
	}else{
	    return null;
	}
    }
    public void printUt(){
	for(int i=0; i<liste.length; i++){
	    if(liste[i]!=null){
		System.out.println(i + " " + liste[i]);
	    }
	}
    }

    public MyIterator iterator(){
	return new MyIterator();
    }

    private class MyIterator implements Iterator{
	int i;

	public boolean hasNext(){
	    if(i<liste.length){
		return true;
	    }else{
		return false;
	    }
	}
	public T next(){
	    T temp = liste[i];
	    i++;
	    return temp;
	}
	public void remove(){}
    }
}
