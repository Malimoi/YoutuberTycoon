package frames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Main.Fenetre;

@SuppressWarnings("serial")
public class Even extends JPanel {
	private Integer i;
	public Even(Integer i){
		this.i=i;
	}
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.WHITE);
		if (i==1){
			g2d.setColor(Color.GREEN);
		}else if(i==2){
			g2d.setColor(Color.BLUE);
		}			
		g2d.fillRect(0, 0, Fenetre.largeur, Fenetre.hauteur);	
	}
}
