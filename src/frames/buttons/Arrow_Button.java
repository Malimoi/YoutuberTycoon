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
import javax.swing.JLabel;

import frames.IMAGE_;
import Main.Fenetre;
import Main.ThemeSelector;

@SuppressWarnings("serial")
public class Arrow_Button extends JButton implements MouseListener{
	private Integer i;
	private Color FOND;
	private Color FONT;
	private Image img;
	private Integer imgTaille;
	private Integer stringTaille;
	
	public Arrow_Button(Integer i){
		this.imgTaille = 40;
		this.stringTaille = 20;
		this.i = i;
		this.FOND=Color.WHITE;
		this.FONT=Color.decode("#424242");
		this.setBorderPainted(false);
		this.addMouseListener(this);
		try {
			if (i==1){
				this.img = ImageIO.read(new File("image/RIGHT_ARROW.png"));
			}else if (i==2){
				this.img = ImageIO.read(new File("image/LEFT_ARROW.png"));
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(FOND);
		g2d.setRenderingHint(
		        RenderingHints.KEY_TEXT_ANTIALIASING,
		        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.drawImage(img, 12, this.getHeight()/7, imgTaille, imgTaille, this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		ThemeSelector.pan.remove(ThemeSelector.panel_img);
		ThemeSelector.pan.add(ThemeSelector.theme);
		if (i==1){		
			ThemeSelector.nb_theme++;
			if (ThemeSelector.nb_theme>13){
				ThemeSelector.nb_theme=1;
			}
			
		}else if (i==2){
			ThemeSelector.nb_theme--;
			if (ThemeSelector.nb_theme<1){
				ThemeSelector.nb_theme=13;
			}
		}
		if (ThemeSelector.nb_theme==1){
			ThemeSelector.panel_img=new IMAGE_("ANIMAUX_THEMEbig");
			ThemeSelector.theme.setText("ANIMAUX");
		}if (ThemeSelector.nb_theme==2){
			ThemeSelector.panel_img=new IMAGE_("CUISINE_THEMEbig");
			ThemeSelector.theme.setText("CUISINE");
		}if (ThemeSelector.nb_theme==3){
			ThemeSelector.panel_img=new IMAGE_("HUMOUR_THEMEbig");
			ThemeSelector.theme.setText("HUMOUR");
		}if (ThemeSelector.nb_theme==4){
			ThemeSelector.panel_img=new IMAGE_("DIVERTISSEMENT_THEMEbig");
			ThemeSelector.theme.setText("DIVERTISSEMENT");
		}if (ThemeSelector.nb_theme==5){
			ThemeSelector.panel_img=new IMAGE_("SPORT_THEMEbig");
			ThemeSelector.theme.setText("SPORT");
		}if (ThemeSelector.nb_theme==6){
			ThemeSelector.panel_img=new IMAGE_("MAKEUP_MODE_THEMEbig");
			ThemeSelector.theme.setText("MAKEUP / MODE");
		}if (ThemeSelector.nb_theme==7){
			ThemeSelector.panel_img=new IMAGE_("MONTAGE_THEMEbig");
			ThemeSelector.theme.setText("MONTAGE");
		}if (ThemeSelector.nb_theme==8){
			ThemeSelector.panel_img=new IMAGE_("DEV_THEME");
			ThemeSelector.theme.setText("DEVELOPPEMENT");
		}if (ThemeSelector.nb_theme==9){
			ThemeSelector.panel_img=new IMAGE_("EDUCATION_THEMEbig");
			ThemeSelector.theme.setText("EDUCATION");
		}if (ThemeSelector.nb_theme==10){
			ThemeSelector.panel_img=new IMAGE_("MUSIQUE_THEMEbig");
			ThemeSelector.theme.setText("MUSIQUE");
		}if (ThemeSelector.nb_theme==11){
			ThemeSelector.panel_img=new IMAGE_("DESIGN_THEMEbig");
			ThemeSelector.theme.setText("DESIGN / GRAPHISME");
		}if (ThemeSelector.nb_theme==12){
			ThemeSelector.panel_img=new IMAGE_("GAMING_THEMEbig");
			ThemeSelector.theme.setText("GAMING");
		}if (ThemeSelector.nb_theme==13){
			ThemeSelector.panel_img=new IMAGE_("ECRITURE_THEMEbig");
			ThemeSelector.theme.setText("ECRITURE");
		}
		ThemeSelector.panel_img.setBounds(ThemeSelector.largeur/2-150, 250+75, 300, 300);
		ThemeSelector.pan.add(ThemeSelector.panel_img);
		ThemeSelector.pan.updateUI();
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		try {
			if (i==1){
				this.img = ImageIO.read(new File("image/RIGHT_ARROW_SUR.png"));
			}else if (i==2){
				this.img = ImageIO.read(new File("image/LEFT_ARROW_SUR.png"));
			}	
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		try {
			if (i==1){
				this.img = ImageIO.read(new File("image/RIGHT_ARROW.png"));
			}else if (i==2){
				this.img = ImageIO.read(new File("image/LEFT_ARROW.png"));
			}	
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		try {
			if (i==1){
				this.img = ImageIO.read(new File("image/RIGHT_ARROW_SUR.png"));
			}else if (i==2){
				this.img = ImageIO.read(new File("image/LEFT_ARROW_SUR.png"));
			}	
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
