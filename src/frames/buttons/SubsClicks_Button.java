package frames.buttons;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import Main.Fenetre;
import Main.MainClient;

@SuppressWarnings("serial")
public class SubsClicks_Button extends JButton implements MouseListener{
	private Color FOND;
	private Color FONT;
	private Image img;
	
	public SubsClicks_Button(){
		this.FOND=Color.WHITE;
		this.FONT=Color.decode("#424242");
		this.setBorderPainted(false);
		this.addMouseListener(this);
		try {
			this.img = ImageIO.read(new File("image/Sub1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(FOND);
		g2d.fillRect(0, 0, Fenetre.hauteur, this.getHeight());
		g2d.setColor(FONT);
		g2d.setFont(new Font("Tahoma", Font.PLAIN, 20));
		g2d.drawImage(img, 12, this.getHeight()/7, 200, 50, this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		MainClient.Total_Clicks_Subs++;
		Fenetre.tot_clicks_subs.setText(MainClient.Total_Clicks_Subs+"");
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		try {
			this.img = ImageIO.read(new File("image/Sub2.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		try {
			this.img = ImageIO.read(new File("image/Sub1.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		try {
			this.img = ImageIO.read(new File("image/Sub2.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		//RAS
	}

}
