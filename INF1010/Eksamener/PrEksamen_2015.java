import javax.swing.*; import java.awt.*; import java.awt.event.*;

class Rute extends JPanel implements MouseListener{
    public static 

    
    JLabel hull = null; //Objektet vi bruker for aa visualisere hull eller brikke
    int kolonne;
    int rad;
    boolean opptatt;
    Rute[][] ruteArray;
    
    ImageIcon brikkeB = new ImageIcon("blank.png"); //hull
    ImageIcon brikkeR = new ImageIcon("raud.png"); //raud
    ImageIcon brikkeG = new ImageIcon("gronn.png"); //groenn

    Rute(int kolonne, int rad, Rute[][] ruteArray){
	hull = new JLabel(brikkeB);
	this.kolonne = kolonne;
	this.rad = rad;
	opptatt = false;
	this.ruteArray = ruteArray;
    }
    
    public void mouseExited(MouseEvent e){
    }
    public void mouseEntered(MouseEvent e){
    }
    public void mouseClicked(MouseEvent e){
	
    }
    public void mousePressed(MouseEvent e){
    }
    public void mouseReleased(MouseEvent e){
    }    
}


class firePR{

    public static void main(String[] args) {
	JFrame ramme = new JFrame("Fire_paa_rad");
	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout(6,7));

	for(int i=0; i<7; i++)
{
	}

	
	ramme.add(panel);
	ramme.pack();
	ramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	ramme.setVisible(true);
    }
    
}







//oppgave 4

class Beholder<T>{

    Node forst;
    Node bakerst;

    public void settInn(T t){
	if(forst==null && bakerst==null){
	    forst = new Node<T>(t);
	    bakerst = forst;
	}else if(forst==bakerst){
	    if(forst.compareTo(t)<0){

	    }
	}
	
    }
    

    private class Node<T> implements Comparable<T>{

	T data;
	Node neste;

	Node(T t){
	    data = t;
	}

	public int compareTo(T t){
	    return 0;
	}

    }





}
