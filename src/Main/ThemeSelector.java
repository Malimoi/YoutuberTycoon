package Main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import frames.IMAGE_;
import frames.Progress;
import frames.buttons.Arrow_Button;

public class ThemeSelector extends JFrame{
public static GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
    
	//get maximum window bounds
	public static Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
			
	public static int hauteur = (int) maximumWindowBounds.getHeight();
	public static int largeur = (int) maximumWindowBounds.getWidth();
	
	public static int nb_theme = 1;
	public static JPanel panel_img = new IMAGE_("ANIMAUX_THEMEbig");
	public static JPanel pan = new PaneauImg();
	public static JLabel theme = new JLabel();
	public JLabel lab2 = new JLabel();
	public int phase = 1;
	public ThemeSelector(){
		
		clip.play();
		
		this.setTitle("Youtuber Tycoon by Malimoi");
		this.setSize(1200,720);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.NORMAL);
		this.setUndecorated(true);
		this.setResizable(true);
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setVisible(true);
		
		pan.setLayout(null);
		JLabel lab = new JLabel();
		lab.setFont(new Font("Tahoma", Font.PLAIN, 110));
		lab.setText("BIENVENUE !");
		lab.setForeground(new Color(254,254,254,255));
		lab.setHorizontalAlignment(JLabel.CENTER);
		lab.setBounds(0, 45, largeur, 150);
		theme = new JLabel();
		theme.setFont(new Font("Tahoma", Font.PLAIN, 60));
		theme.setText("ANIMAUX");
		theme.setForeground(new Color(254,254,254,255));
		theme.setHorizontalAlignment(JLabel.CENTER);
		theme.setBounds(largeur/2-300, 213, 600, 150);
		pan.add(theme);
		pan.add(lab);
		lab2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lab2.setText("Avant de commencer à jouer, vous devez choisir votre point fort. (+25% de progrès)");
		lab2.setForeground(new Color(254,254,254,255));
		lab2.setHorizontalAlignment(JLabel.CENTER);
		lab2.setBounds(0, 45+120, largeur, 35);
		pan.add(lab2);
		this.setContentPane(pan);
		Thread t = new Thread(new AffTheme());
			
				
			panel_img.setBounds(largeur/2-150, 250+75, 300, 300);
			pan.add(panel_img);
			
			JButton next = new Arrow_Button(1);
			next.setBounds(largeur/2+150+15, 250+75+150-50/2, 50, 50);
			pan.add(next);
			JButton prev = new Arrow_Button(2);
			prev.setBounds(largeur/2-150-15-55, 250+75+150-50/2, 50, 50);
			pan.add(prev);
			
		JButton start = new JButton("Valider et débuter");
		start.setFont(new Font("Tahoma", Font.PLAIN, 18));
		start.setForeground(Color.white);
		start.setBackground(new Color(0,0,0,0));
		start.setBounds(largeur/2-100, 250+75+300+20, 200, 50);
		start.addActionListener(new StartEvent());
		pan.add(start);
			
			pan.updateUI();
			
	}
	public void Close(){
		this.setVisible(false);
		this.dispose();
	}
	class AffTheme implements Runnable{
		public void run(){
			
		}
	}

	@SuppressWarnings("serial")
	static class PaneauImg extends JPanel {
		
		public void paintComponent(Graphics g){
			try{
				Image img = ImageIO.read(new File("image/CHOIX_THEMES.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
		
	}
	
	public class StartEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Close();
			new Progress();
			
		}
		
	}
	
}


