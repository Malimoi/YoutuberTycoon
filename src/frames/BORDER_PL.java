package frames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Main.Fenetre;

@SuppressWarnings("serial")
public class BORDER_PL extends JPanel {
	private Integer i;
	public BORDER_PL(Integer i){
		this.i=i;
	}
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.WHITE);
		if(i==1){
			g2d.fillRect(0, 0, 400-1, 5);	
			g2d.setColor(Color.decode("#D7D7D7"));
			g2d.drawLine(0, 0, 400-1, 0);
			g2d.drawLine(0, 0, 0, 5);
			g2d.drawLine(400-1, 0, 400-1, 5);
		}else if(i==2){
			g2d.fillRect(0, 0, 400, 15);	
			g2d.setColor(Color.decode("#D7D7D7"));
			g2d.drawLine(0, 14, 400, 14);
			g2d.drawLine(0, 0, 0, 14);
			g2d.drawLine(400-1, 0, 400-1, 14);
		}else if(i==3){
			g2d.fillRect(0, 0, 26, 450);
			g2d.setColor(Color.decode("#D7D7D7"));
			g2d.drawLine(0, 0, 0, 450);
		}else if(i==4){
			g2d.fillRect(0, 0, 26, 450);
			g2d.setColor(Color.decode("#D7D7D7"));
			g2d.drawLine(26-1, 0, 26-1, 450);
		}

		 
	}
}
