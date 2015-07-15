import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame{
	public GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
    
	//get maximum window bounds
	public Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
			
	public int hauteur = (int) maximumWindowBounds.getHeight();
	public int largeur = (int) maximumWindowBounds.getWidth();
	public Fenetre() {
		
		
		this.setTitle("Youtuber Tycoon by Malimoi");
		this.setSize(1200,720);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.NORMAL);
		//this.setDefaultLookAndFeelDecorated(false);    
		//this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setUndecorated(false);
		this.setResizable(true);
		
		JPanel content = new JPanel();

				
				content.setLayout(new BorderLayout());
				int TotalInt = 0;
				
				//-- HAUT
				JPanel haut = new JPanel();
				haut.setPreferredSize(new Dimension(largeur, hauteur/29));
				haut.setBackground(Color.WHITE);
				JPanel acc = new ACC();
				acc.setPreferredSize(new Dimension(hauteur/29, hauteur/29));
				acc.setBounds(0, 0, hauteur/29, hauteur/29);
				acc.setBackground(Color.BLACK);
				JPanel name = new ACC();
				name.setPreferredSize(new Dimension(largeur/11-hauteur/29, hauteur/29));
				name.setBounds(hauteur/29+1, 0, largeur/11-hauteur/29-1, hauteur/29);
				name.setBackground(Color.CYAN);
				TotalInt = largeur/11-hauteur/29+hauteur/29;
				JPanel nbgold = new ACC();
				nbgold.setPreferredSize(new Dimension((largeur-(TotalInt+1))/8, hauteur/29));
				nbgold.setBounds(TotalInt+1, 0, (largeur-(TotalInt+1))/8, hauteur/29);
				TotalInt=TotalInt+1+(largeur-(TotalInt+1))/8;
				JPanel nbsubs = new ACC();
				nbsubs.setPreferredSize(new Dimension((largeur-(TotalInt+1))/4, hauteur/29));
				nbsubs.setBounds(TotalInt+1, 0, (largeur-(TotalInt+1))/4, hauteur/29);
				TotalInt=TotalInt+1+(largeur-(TotalInt+1))/4;
				
				//--
				JLabel label = new JLabel();
				label.setFont(new Font("Tahoma", Font.PLAIN, 15));
				label.setText("Malimoi");
				label.setForeground(Color.WHITE);
				label.setHorizontalAlignment(JLabel.CENTER);
				//--
				JLabel labelMoney = new JLabel();
				labelMoney.setFont(new Font("Tahoma", Font.PLAIN, 15));
				labelMoney.setText("1200 EUR");
				labelMoney.setForeground(Color.WHITE);
				labelMoney.setHorizontalAlignment(JLabel.CENTER);
				//--
				JLabel labelSubs = new JLabel();
				labelSubs.setFont(new Font("Tahoma", Font.PLAIN, 15));
				labelSubs.setText("10997 SUBSCRIBERS");
				labelSubs.setForeground(Color.WHITE);
				labelSubs.setHorizontalAlignment(JLabel.CENTER);
				//--
				
				JPanel end = new ACC();
				end.setBounds(TotalInt+1, 0, largeur-(TotalInt+1), hauteur/29);
				
				name.setLayout(new BorderLayout());
				name.add(label, BorderLayout.CENTER);
				nbgold.setLayout(new BorderLayout());
				nbgold.add(labelMoney, BorderLayout.CENTER);
				nbsubs.setLayout(new BorderLayout());
				nbsubs.add(labelSubs, BorderLayout.CENTER);
				haut.setLayout(null);
				haut.add(acc);
				haut.add(name);
				//haut.add(goldimg);
				haut.add(nbgold);
				haut.add(nbsubs);
				haut.add(end);
				
				//-- WEST
				JPanel west = new JPanel();
				west.setPreferredSize(new Dimension(largeur/11, hauteur));
				west.setBackground(Color.decode("#454C53"));
				west.setLayout(new GridLayout(12,1));
				JButton bouton = new Bouton("1");
				JButton bouton2 = new Bouton("2");
				JButton bouton3 = new Bouton("3");
				west.add(bouton);
				west.add(bouton2);
				west.add(bouton3);
				
				//-- CENTER
				JPanel center = new JPanel();
				center.setBackground(Color.BLACK);
				
				content.add(haut, BorderLayout.NORTH);
				content.add(west, BorderLayout.WEST);
				content.add(center, BorderLayout.CENTER);
				//content.add(name);
				content.setPreferredSize(new Dimension(largeur, hauteur));
				//content.add(money);
		this.setContentPane(content);
		this.setVisible(true);	

	}
	
	private void init(){
		

	}
	
	class Bouton extends JButton{
		private String name;
		public Bouton(String str){
			super(str);
			this.name = str;
			this.setBorderPainted(false);
		}
		public void paintComponent(Graphics g){
			Color c = Color.decode("#1C2935");//Gris
			Color c2 = Color.decode("#4A4A4A");//Gris Foncé
			Graphics2D g2d = (Graphics2D)g;
			//GradientPaint gp = new GradientPaint(0,0,Color.WHITE,0,this.getHeight(),c2,true);
			//g2d.setPaint(gp);
			g2d.setColor(c);
			g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
			g2d.setColor(Color.WHITE);
			FontMetrics fm = g2d.getFontMetrics();
			int height = fm.getHeight();
			int width = fm.stringWidth(this.name);
			g2d.drawString(this.name, this.getWidth()/2 - (width/2), (this.getHeight()/2)+(height/4));
		}
	}
	
	public class ACC extends JPanel {
		private String name;
		private int posX;
		private int posY;
		private int width;
		private int height;
		public ACC(){
			
		}
		public void paintComponent(Graphics g){
			Color c = Color.decode("#6A6A6A");//Gris
			Color c2 = Color.decode("#4A4A4A");//Gris Foncé
			Graphics2D g2d = (Graphics2D)g;
			GradientPaint gp = new GradientPaint(0,0,c,0,hauteur/29,c2,true);
			g2d.setPaint(gp);		
			g2d.fillRect(0, 0, largeur, hauteur/29);	
		}
	}

}
