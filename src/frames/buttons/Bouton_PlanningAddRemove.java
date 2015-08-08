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
public class Bouton_PlanningAddRemove extends JButton implements MouseListener{
	private Integer i;
	private Color FOND;
	private Color FONT;
	private Image img;
	private Integer imgTaille;
	private Integer stringTaille;
	
	public Bouton_PlanningAddRemove(Integer i){
		this.imgTaille = 40;
		this.stringTaille = 20;
		this.i = i;
		this.FOND=Color.WHITE;
		this.FONT=Color.decode("#424242");
		this.setBorderPainted(false);
		this.addMouseListener(this);
		try {
			if (i==1){
				this.img = ImageIO.read(new File("image/Add-Property.png"));
			}else if (i==2){
				this.img = ImageIO.read(new File("image/Edit-Property.png"));
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
		g2d.setFont(new Font("Tahoma", Font.PLAIN, stringTaille));
		FontMetrics fm = g2d.getFontMetrics();
		int height = fm.getHeight();
		//int width = fm.stringWidth(this.name);
		g2d.setRenderingHint(
		        RenderingHints.KEY_TEXT_ANTIALIASING,
		        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.drawImage(img, 12, this.getHeight()/7, imgTaille, imgTaille, this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (i==2){
			Fenetre.cp_c_c_c_right.removeAll();
			try {
				Thread.sleep(10);
			} catch (InterruptedException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			Fenetre.EDIT_PLAN(1,0);
			Fenetre.cp_c_c_c_right.updateUI();
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		this.imgTaille=55;
	}
	@Override
	public void mouseExited(MouseEvent e) {
		this.imgTaille=40;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		this.imgTaille=55;
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		//RAS
	}

}
