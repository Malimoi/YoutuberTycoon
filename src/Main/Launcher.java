package Main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import frames.IMAGE_;
import frames.Progress;
import frames.buttons.Arrow_Button;
import utilities.Video;

@SuppressWarnings("serial")
public class Launcher extends JFrame{
public static GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
    
	//get maximum window bounds
	public static Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
			
	public static int hauteur = (int) maximumWindowBounds.getHeight();
	public static int largeur = (int) maximumWindowBounds.getWidth();

	public JPanel pan = new PaneauImg();
	public static JLabel lab2 = new JLabel();
	public static JPasswordField passField;
	public static JTextField pseudoField;
	public Launcher(){
	    
		this.setTitle("Launcher de Youtuber Tycoon");
		this.setSize(1200,720);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.NORMAL);
		this.setUndecorated(false);
		this.setResizable(false);
		//this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setVisible(true);
		
		pan.setLayout(new BorderLayout());
		
		JPanel haut = new PaneauImg();
		haut.setPreferredSize(new Dimension(1200, 720));
		haut.setLayout(null);
		JPanel logo = new Fenetre.AllImages("image/LOGO.png", 600, 600);
		logo.setBounds(300,0,600,600);
		haut.add(logo);
		
		JLabel lab = new JLabel();
		lab.setFont(new Font("Dominique", Font.PLAIN, 25));
		lab.setText("Youtuber Tycoon version "+MainClient.version);
		lab.setForeground(Color.RED);
		lab.setHorizontalAlignment(JLabel.LEFT);
		lab.setBounds(0, 655, largeur, 30);
		
		haut.add(lab);		
		
		lab2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lab2.setText("");
		lab2.setForeground(Color.RED);
		lab2.setHorizontalAlignment(JLabel.CENTER);
		lab2.setBounds(0, 30, 1200, 35);
		
		haut.add(lab2);
		
		JLabel pseudo = new JLabel();
		pseudo.setFont(new Font("Dominique", Font.PLAIN, 25));
		pseudo.setText("Pseudo");
		pseudo.setForeground(Color.WHITE);
		pseudo.setHorizontalAlignment(JLabel.LEFT);
		pseudo.setBounds(550, 650, 200, 30);
		
		pseudoField = new JTextField();
		pseudoField.setBounds(625, 650, 150, 30);
		
		haut.add(pseudoField);	
		haut.add(pseudo);		
		
		JLabel mdp = new JLabel();
		mdp.setFont(new Font("Dominique", Font.PLAIN, 25));
		mdp.setText("Mot de passe");
		mdp.setForeground(Color.WHITE);
		mdp.setHorizontalAlignment(JLabel.LEFT);
		mdp.setBounds(790, 650, 200, 30);
		
		passField = new JPasswordField();
		passField.setBounds(930, 650, 150, 30);
		
		haut.add(passField);
		haut.add(mdp);
		
		JButton start = new ClassicButton("Start");
		start.setBounds(930+165, 650, 70, 30);
		
		haut.add(start);
		
		pan.add(haut,BorderLayout.NORTH);
		
		this.setContentPane(pan);
			
		pan.updateUI();
			
			
	}
	public void Close(){
		this.setVisible(false);
		this.dispose();
	}

	static class PaneauImg extends JPanel {
		
		public void paintComponent(Graphics g){
			try{
				Image img = ImageIO.read(new File("image/FOND_LAUNCHER.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
		
	}
	
	public class ClassicButton extends JButton implements MouseListener {
		private String name;
		private Color FOND;
		private Color FONT;

		public ClassicButton(String str) {
			super(str);
			this.name = str;
			this.FOND = Color.WHITE;
			if (str.equals("" + Fenetre.videopage)) {
				this.FOND = Color.decode("#D3D3D3");
				this.setEnabled(false);
			}
			this.FONT = Color.decode("#424242");
			this.setBorderPainted(false);
			this.addMouseListener(this);
		}

		public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(FOND);
			g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
			g2d.setColor(FONT);
			g2d.setFont(new Font("Tahoma", Font.PLAIN, 17));
			FontMetrics fm = g2d.getFontMetrics();
			int height = fm.getHeight();
			// int width = fm.stringWidth(this.name);
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g2d.drawString(this.name, 15, (this.getHeight() / 2) + (height / 4) + 1);
			g2d.setColor(Color.decode("#D7D7D7"));
			g2d.drawLine(0, 0, this.getWidth(), 0);
			g2d.drawLine(0, this.getHeight() - 1, this.getWidth(), this.getHeight() - 1);
			g2d.drawLine(0, 0, 0, this.getHeight());
			g2d.drawLine(this.getWidth() - 1, 0, this.getWidth() - 1, this.getHeight() - 1);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			this.FOND = Color.decode("#D3D3D3");
				if (name.contains("Start")){
					MainClient.access.send(pseudoField.getText());
					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					MainClient.access.send(passField.getText());
				}
			}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		}

}


