import javax.swing.*; import java.awt.*; import java.awt.event.*;


public class Addisjonskalkulator{

    public static void main(String[] args) {

	JFrame ramme = new JFrame();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	panel2.setLayout(new GridLayout(3,4));

	JLabel inntastet = new JLabel("Hello");
	panel1.add(inntastet);
	panel1.setSize(50,50);

	ramme.setLayout(new BorderLayout());
	

	JButton knapp1 = new JButton("1");;
	JButton knapp2 = new JButton("2");
	JButton knapp3 = new JButton("3");
	JButton knappPluss = new JButton("+");
	JButton knapp4 = new JButton("4");
	JButton knapp5 = new JButton("5");
	JButton knapp6 = new JButton("6");
	JButton knappErLik = new JButton("=");
	JButton knapp7 = new JButton("7");
	JButton knapp8 = new JButton("8");
	JButton knapp9 = new JButton("9");
	JButton knapp0 = new JButton("0");

	panel2.add(knapp1);
	panel2.add(knapp2);
	panel2.add(knapp3);
	panel2.add(knappPluss);
	panel2.add(knapp4);
	panel2.add(knapp5);
	panel2.add(knapp6);
	panel2.add(knappErLik);
	panel2.add(knapp7);
	panel2.add(knapp8);
	panel2.add(knapp9);
	panel2.add(knapp0);

	ramme.add(panel1, BorderLayout.NORTH);
	ramme.add(panel2, BorderLayout.SOUTH);

	ramme.setVisible(true);
	ramme.setSize(600, 200);
	ramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
