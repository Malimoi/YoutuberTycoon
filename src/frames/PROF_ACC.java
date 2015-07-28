package frames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PROF_ACC extends JPanel {
	public PROF_ACC(){
		
	}
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.ORANGE);		
		g2d.fillRect(0, 0, 50, 50);
	}
}
