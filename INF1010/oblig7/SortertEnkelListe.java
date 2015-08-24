import java.util.*;
import java.lang.*;

public class SortertEnkelListe<T extends Comparable<T>, Lik> implements AbstraktSortertEnkelListe<T>, Iterable<T>{

    private Node<T> foran = null;
    private Node<T> bak = null;



    public boolean settInn(T t){
	Node<T> node = new Node<T>(t);
	if(tomListe()){
	    foran = node;
	    bak = node;
	    return true;
	}
	else if(foran == bak && node.t.compareTo(foran.t) < 0){
	    Node<T> temp = foran;
	    foran = node;
	    foran.neste = temp;
	    bak = temp;
	    return true;
	}
	else if(foran == bak && node.t.compareTo(foran.t) >= 0){
	    foran.neste = node;
	    bak = node;
	    return true;
	}
	else{
	    Node<T> temp = foran;
	    while(temp.neste != null){
		if(temp.neste == bak && temp.neste.t.compareTo(node.t) < 0){
		    bak.neste = node;
		    bak = node;
		    return true;
		}
		else if(foran.t.compareTo(node.t) >= 0){
		    Node<T> temp2 = foran;
		    foran = node;
		    foran.neste = temp2;
		    return true;
		}
		else if(temp.neste.t.compareTo(node.t) > 0){
		    Node<T> temp2 = temp.neste;
		    temp.neste = node;
		    node.neste = temp2;
		    return true;
		}
		temp = temp.neste;
	    }
	}
	return false;
    }

    public T finnElement(String s){

	if(tomListe()){
	    return null;
	}else {
	    Node temp = foran;
	    if(temp==foran){
		if(temp.t.toString().equals(s)){
		    return(T) temp.t;
		}
	    } //end if

	    while(temp!=null){
		if(temp.t.toString().equals(s)){
		    return(T) temp.t;
		} // end if
		temp = temp.neste;
	    }
	} //end else
	return null;
    } // end metode


    public void printUtElementer(){

	Node temp = foran;

	while(temp!=null){
	    System.out.println(temp.t);
	    temp = temp.neste;
	}

    }

    public boolean tomListe(){
	if(foran == null){
	    return true;
	}
	return false;
    }


    public Iterator<T> iterator(){
	return new MyIterator();
    }

    private class MyIterator implements Iterator<T>{
	/*int lengde = finnLengde();*/
	Node<T> iteratorPeker = foran;

	public boolean hasNext(){
	    return (iteratorPeker!=null);
	}
	public T next(){
	    T temp = iteratorPeker.t;
	    iteratorPeker = iteratorPeker.neste;
	    return temp;
	}
    }

    public void printUt(){
	for(T t: this){
	    System.out.println(t);
	}
    }
    
    private class Node<T>{
	T t = null;
	Node<T> neste = null;

	Node(T t){
	    this.t = t;
	}

    }
}
