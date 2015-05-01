public class Mengde<E>{

    private class Node{
	Node neste;
	Node forrige;
	E data;

	Node(E data){
	    this.data=data;
	}
    }

    private Node foerste, siste;

    boolean tom(){
	if(foerste==null && siste==null){
	    return true;
	}else{
	    return false;
	}
    }

    boolean leggTil(E e){
	Node current = foerste;
	if(tom()){
	    foerste = new Node(e);
	    siste = foerste;
	    /*foerste.neste = null;*/
	    return true;
	}else if(!inneholder(e)){
	    siste.neste = new Node(e);
	    siste.neste.forrige = siste;
	    siste = siste.neste;
	    return true;
	}else{
	    return false;
	}
    }

    E fjernEldste(){
	if(!tom() && foerste!=siste){
	    Node temp = foerste;
	    foerste = foerste.neste;
	    return temp.data;
	}else if(!tom() && foerste==siste){
	    Node temp = foerste;
	    foerste = foerste.neste;
	    siste = foerste;
	    return temp.data;
	}else{
	    return null;
	}
    }

    E fjernNyeste(){
	if(!tom() && foerste!=siste){
	    Node temp = siste;
	    siste = siste.forrige;
	    return temp.data;
	}else if(!tom() && foerste==siste){
	    Node temp = foerste;
	    foerste = foerste.neste;
	    siste = foerste;
	    return temp.data;
	}else{
	    return null;
	}
    }

    boolean inneholder(E e){
	if(tom()){
	    return false;
	}

	Node current = foerste;
	while(current!=null){
	    if(current.data==e){
		return true;
	    }
	    current = current.neste;
	}
	return false;
    }
}
