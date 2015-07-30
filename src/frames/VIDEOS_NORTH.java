package frames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Main.Fenetre;

public class VIDEOS_NORTH extends JPanel {
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, Fenetre.largeur-(225+10+10+10+10+9), Fenetre.hauteur/7);	
		g2d.setColor(Color.decode("#D7D7D7"));
		g2d.drawLine(0, Fenetre.hauteur/7-1, Fenetre.largeur-(225+10+10+10+10+9), Fenetre.hauteur/7-1);
	}
}
