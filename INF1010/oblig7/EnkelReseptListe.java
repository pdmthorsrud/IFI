import java.util.*;

public class EnkelReseptListe implements Iterable<Resept>{

    protected Node foran;
    protected Node bak;

    /*public boolean settInn(Resept r){
      if(foran==null){
      foran = new Node(r);
      bak = foran;
      return true;
      }else{
      bak.neste = new Node(r);
      bak = bak.neste;
      return true;
      }

      }*/

    public Resept finnResept(int reseptNr){
        Node temp = foran;
        try{
            while(temp!=null){
                if(temp.obj.getReseptNr() == reseptNr){
                    return temp.obj;
                }
                temp = temp.neste;
            }
        }catch (NoSuchElementException e){
            System.out.println("Denne resepten finnes ikke");
        }
        System.out.println("Denne resepten finnes ikke");
        return null;
    }
    /*
      public int finnLengde(){
      Node temp = foran;
      int antall = 0;
      while(temp!=null){
      antall++;
      temp = temp.neste;
      }
      return antall;
      }
    */
    public Iterator<Resept> iterator(){
        return new MyIterator();
    }



    private class MyIterator implements Iterator<Resept>{
        /*int lengde = finnLengde();*/
        Node iteratorPeker = foran;

        public boolean hasNext(){
            return (iteratorPeker!=null);
        }
        public Resept next(){
            Resept temp = iteratorPeker.obj;
            iteratorPeker = iteratorPeker.neste;
            return temp;
        }
    }

    public void printUt(){
	for(Resept r: this){
	    System.out.println(r.getReseptNr() + "   " + r.getLegemiddel() + "    " + r.getPris() + "   " + r.getPerson());
	}
    }
    
    public class Node{
        Resept obj;
        Node neste;

        Node(Resept r){
            obj = r;
        }
    }

}
