public class Beholder<T extends Comparable>{

    Node forste = null;
    Node siste = null;


    public T fjern(T t){
        Node tmp = finnes(t);
        if(tmp==null){
            System.out.println("Denne noden finnes ikke");
            return null;
        }else{
            tmp.forrige.neste = tmp.neste;
            return tmp.data;
        }
    }

    public void settInn(T t){
        if(forste==null && siste==null){
            forste = new Node(t);
            siste = forste;
        }else if(finnes(t)==null){
            siste.neste = new Node(t);
            siste.neste.forrige = siste.neste;
            siste = siste.neste;
        }else{
            System.out.println("Dette objektet finnes fra foer. Objektet ble ikke satt inn paa nytt");
        }
    }

    public T hent(){
        Node tmp = forste;
        siste.neste = forste;
        forste = forste.neste;
        return tmp.data;
    }

    public Node finnes(T t){
        Node tmp = forste;
        while(tmp!=null){
            if(tmp.data.compareTo(t)==0){
                return tmp;
            }
            tmp = tmp.neste;
        }
        return null;
    }

    public boolean tom(){
        return forste==null;
    }

    public void ovfAlleFraBeholder(Beholder<T> b){
        while(!tom()){
            T t = hent();
            fjern(t);
            b.settInn(t);
        }
    }

    private class Node{
        T data;
        Node neste;
        Node forrige;

        Node(T t){
            data = t;
            neste = null;
            forrige = null;
        }
    }
}
