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
		public IMAGE_(String name){
			this.name=name;
		}
		public void paintComponent(Graphics g){
			try{
				Image img = ImageIO.read(new File("image/THEMES/"+name+".png"));
				g.drawImage(img, 0, 0, 300, 300, this);
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
		
	}