import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TestDrawLine extends JFrame{
    public static void main(String[] args) {
	JFrame f = new JFrame();
	JPanel p = new JPanel() {
		@Override
		protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    g.setColor(Color.BLACK);
		    g.drawLine(200, 1000, 1000, 100);
		}
	    };
	f.add(p);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
    }
}
