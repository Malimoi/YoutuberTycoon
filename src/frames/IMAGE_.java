package frames;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
	public class IMAGE_ extends JPanel {
		private String name;
		private int x;
		private int y;
		public IMAGE_(String name,int x,int y){
			this.name=name;
			this.x=x;
			this.y=y;
		}
		public void paintComponent(Graphics g){
			try{
				Image img = ImageIO.read(new File("image/THEMES/"+name+".png"));
				g.drawImage(img, 0, 0, x, y, this);
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
		
	}