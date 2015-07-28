package frames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Main.Fenetre;

@SuppressWarnings("serial")
public class SUBS extends JPanel {
	public SUBS(){
		
	}
	public void paintComponent(Graphics g){
		Color c = Color.decode("#D7D7D7");//Gris
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, ((Fenetre.largeur-255)/8), 80);	
		g2d.setColor(c);
		g2d.drawLine(((Fenetre.largeur-255)/8)-1, 20, ((Fenetre.largeur-255)/8)-1, 60);
	}
}
