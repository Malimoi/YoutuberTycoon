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

@SuppressWarnings("serial")
public class Bouton extends JButton implements MouseListener{
	private String name;
	private Integer i;
	private Color FOND;
	private Color FONT;
	private Image img;
	
	public Bouton(String str, Integer i){
		super(str);
		this.name = str;
		this.i = i;
		this.FOND=Color.WHITE;
		this.FONT=Color.decode("#424242");
		this.setBorderPainted(false);
		this.addMouseListener(this);
		try {
			if (i==1){
				this.img = ImageIO.read(new File("image/Home2.png"));
			}else if (i==2){
				this.img = ImageIO.read(new File("image/Video2.png"));
			}else if(i==3){
				this.img = ImageIO.read(new File("image/Planning2.png"));
			}else if(i==4){
				this.img = ImageIO.read(new File("image/Notif2.png"));
			}
			
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
		g2d.setFont(new Font("Tahoma", Font.PLAIN, 17));
		FontMetrics fm = g2d.getFontMetrics();
		int height = fm.getHeight();
		//int width = fm.stringWidth(this.name);
		g2d.setRenderingHint(
		        RenderingHints.KEY_TEXT_ANTIALIASING,
		        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.drawString(this.name, 12+22+7, (this.getHeight()/2)+(height/4)+1);
		g2d.drawImage(img, 12, this.getHeight()/7, 22, 22, this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		this.FOND=Color.decode("#393939");	
		this.FONT=Color.WHITE;
		try {
			if (i==1){
				this.img = ImageIO.read(new File("image/Home.png"));
			}else if (i==2){
				this.img = ImageIO.read(new File("image/Video.png"));
			}else if(i==3){
				this.img = ImageIO.read(new File("image/Planning.png"));
			}else if(i==4){
				this.img = ImageIO.read(new File("image/Notif.png"));
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		this.FOND=Color.WHITE;
		this.FONT=Color.decode("#424242");	
		try {
			if (i==1){
				this.img = ImageIO.read(new File("image/Home2.png"));
			}else if (i==2){
				this.img = ImageIO.read(new File("image/Video2.png"));
			}else if(i==3){
				this.img = ImageIO.read(new File("image/Planning2.png"));
			}else if(i==4){
				this.img = ImageIO.read(new File("image/Notif2.png"));
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		this.FOND=Color.decode("#D10E00");	
		this.FONT=Color.WHITE;
		try {
			if (i==1){
				this.img = ImageIO.read(new File("image/Home.png"));
			}else if (i==2){
				this.img = ImageIO.read(new File("image/Video.png"));
			}else if(i==3){
				this.img = ImageIO.read(new File("image/Planning.png"));
			}else if(i==4){
				this.img = ImageIO.read(new File("image/Notif.png"));
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
