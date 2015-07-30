package frames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Main.Fenetre;

@SuppressWarnings("serial")
public class VIDEOS_CENTER extends JPanel {
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, Fenetre.largeur-(225+10+10+10+10+9), Fenetre.hauteur);	
	}
}
