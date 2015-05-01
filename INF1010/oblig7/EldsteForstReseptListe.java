import java.io.*;
import java.util.*;

public class EldsteForstReseptListe extends EnkelReseptListe implements Iterable<Resept>{

    public Resept taUtEldste(){
        if(foran==bak){
            Node temp = foran;
            foran=null;
            bak=null;
            return temp.obj;
        }else{
            Node temp = foran;
            foran = temp.neste;
	    return temp.obj;
        }
    }
    public boolean settInn(Resept r){

	Node n = new Node(r);
	if(foran == null){
	    foran = n;
	    bak = n;
	    return true;
	}
	else{    
	    Node temp = bak;
	    bak = n;
	    temp.neste = n;
	    return true;
	}
    }
}
