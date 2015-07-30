package frames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Main.Fenetre;

@SuppressWarnings("serial")
public class ACC extends JPanel {
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.WHITE);		
		g2d.fillRect(0, 0, Fenetre.largeur, 60);
		try {
			g2d.drawImage(ImageIO.read(new File("image/LogoHaut.png")), 0, 0, 225, 60, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
