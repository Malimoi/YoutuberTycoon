package Main;
/*
 * ******************************************************
 *  * Copyright (C) 2015 Malimoi <sandeaujules975@gmail.com>
 *  *
 *  * This file (Fenetre) is part of YoutuberTycoon.
 *  *
 *  * Created by Malimoi on 14/07/15 16:37.
 *  *
 *  * YoutuberTycoon can not be copied and/or distributed without the express
 *  * permission of Malimoi.
 *  ******************************************************
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Fenetre extends JFrame{
	/*
	 * Je n'est aucune expérience en mise en page, je pense qu'il peut y avoir quelques améliorations à faire.
	 */
	public GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
    
	//get maximum window bounds
	public Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
			
	public int hauteur = (int) maximumWindowBounds.getHeight();
	public int largeur = (int) maximumWindowBounds.getWidth();
	
	public JButton bouton = new Bouton("Page d'accueil",1);
	public JButton bouton4 = new Bouton("Gestionnaire de vidéos",2);
	public JButton bouton2 = new Bouton("Mon planning",3);
	public JButton bouton3 = new Bouton("Mes notifications",4);
	
	//-CONTENT
	public JPanel content = new JPanel();
	
	//--CENTER
	public JPanel center = new JPanel();
		public JPanel c_north = new JPanel();
			public JLabel lab_c_n_subs = new JLabel();
			public JLabel lab_c_n_views = new JLabel();
			public JLabel lab_c_n_gold = new JLabel();
			public JLabel lab_c_n_nbsubs = new JLabel();
			public JLabel lab_c_n_nbviews = new JLabel();
			public JLabel lab_c_n_nbgold = new JLabel();
		public JPanel c_west = new JPanel();
		public JPanel c_east = new JPanel();
		public JPanel c_center = new JPanel();
			public JPanel c_c_north1 = new NOR();
				public JPanel c_c_n1_west = new NOR();
				public JPanel c_c_n1_south = new NOR();
				public JPanel c_c_n1_north = new NOR();
				public JPanel c_c_n1_center = new NOR();
					public JPanel c_c_n1_c_prof = new PROF_ACC();
					public JPanel c_c_n1_c_name = new NAME_ACC();
						public JLabel lab_c_c_n1_name = new JLabel();
						public JLabel lab_c_c_n1_partenaire = new JLabel();
			public JPanel c_c_north2 = new SUBS();
			public JPanel c_c_north3 = new NOR();
				public JLabel lab_c_c_north_subs = new JLabel();
				public JLabel lab_c_c_north_views = new JLabel();
				public JLabel lab_c_c_north_nbsubs = new JLabel();
				public JLabel lab_c_c_north_nbviews = new JLabel();
			public JPanel c_c_notif = new NOR();
				public JPanel c_c_nt_west = new NOR();
				public JPanel c_c_nt_east = new NOR();
				public JPanel c_c_nt_north = new NOR();
				public JPanel c_c_nt_south = new NOR();
				public JPanel c_c_nt_center = new NOR();
					public JLabel lab_c_c_nt_c_name = new JLabel();
					public JPanel c_c_nt_c_jourj = new JPanel();
					public JLabel lab_c_c_nt_c_jour = new JLabel();
					public JLabel lab_c_c_nt_c_date = new JLabel();
					public JLabel lab_c_c_nt_c_deChatClient = new JLabel();
			public JPanel c_c_videospannel = new NOR();
				public JPanel c_c_vp_west = new NOR();
				public JPanel c_c_vp_east = new NOR();
				public JPanel c_c_vp_north = new NOR();
				public JPanel c_c_vp_south = new NOR();
				public JPanel c_c_vp_center = new NOR();
					public JLabel lab_c_c_vp_c_name = new JLabel();
	public JPanel center_planning = new JPanel();
	
	public JPanel delete = new DEL();
	
	public Thread t;
	public int test = 0;
	
	public Fenetre() {
	
	test();
		
	this.setTitle("Youtuber Tycoon by Malimoi");
	this.setSize(1200,720);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setExtendedState(JFrame.NORMAL);
	//this.setDefaultLookAndFeelDecorated(false);    /*-> Plein écran.*/
	//this.setExtendedState(this.MAXIMIZED_BOTH);
	this.setUndecorated(false);
	this.setResizable(true);
				
	content.setLayout(new BorderLayout());
	int TotalInt = 0;
				
	//-- HAUT
	JPanel haut = new JPanel();
	haut.setPreferredSize(new Dimension(largeur, 60));
	haut.setBackground(Color.decode("#D7D7D7"));
	JPanel acc = new ACC();
	acc.setPreferredSize(new Dimension(255, 60));
	acc.setBounds(0, 0, 255, 60);
	TotalInt=TotalInt+255;
	JPanel name = new NOR();
	name.setPreferredSize(new Dimension(255-60, 60));
	name.setBounds(TotalInt+1, 0, 225, 60);
	TotalInt = TotalInt+225+1;
	JPanel nbsubs = new NOR();
	nbsubs.setPreferredSize(new Dimension((largeur-(TotalInt+1))/4, 60));
	nbsubs.setBounds(TotalInt+1, 0, 225, 60);
	TotalInt=TotalInt+1+225;
	JPanel nbgold = new NOR();
	nbgold.setPreferredSize(new Dimension((largeur-(TotalInt+1))/8, 60));
	nbgold.setBounds(TotalInt+1, 0, 225, 60);
	TotalInt=TotalInt+1+225;
				
	JPanel end = new NOR();
	end.setBounds(TotalInt+1, 0, largeur-(TotalInt+1), 60);
				
	//Subs
	lab_c_n_subs.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lab_c_n_subs.setText("Abonnés");
	lab_c_n_subs.setForeground(Color.GRAY);
	lab_c_n_subs.setHorizontalAlignment(JLabel.CENTER);
	lab_c_n_subs.setPreferredSize(new Dimension(225, 30));
	lab_c_n_nbsubs.setFont(new Font("Tahoma", Font.PLAIN, 19));
	lab_c_n_nbsubs.setText("11 156");
	lab_c_n_nbsubs.setForeground(Color.decode("#424242"));
	lab_c_n_nbsubs.setHorizontalAlignment(JLabel.CENTER);
	lab_c_n_nbsubs.setPreferredSize(new Dimension(225, 30));
	//Views
	lab_c_n_views.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lab_c_n_views.setText("Vues");
	lab_c_n_views.setForeground(Color.GRAY);
	lab_c_n_views.setHorizontalAlignment(JLabel.CENTER);
	lab_c_n_views.setPreferredSize(new Dimension(225, 30));
	lab_c_n_nbviews.setFont(new Font("Tahoma", Font.PLAIN, 19));
	lab_c_n_nbviews.setText("658 254");
	lab_c_n_nbviews.setForeground(Color.decode("#424242"));
	lab_c_n_nbviews.setHorizontalAlignment(JLabel.CENTER);
	lab_c_n_nbviews.setPreferredSize(new Dimension(225, 30));
	//Euros
	lab_c_n_gold.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lab_c_n_gold.setText("Euros");
	lab_c_n_gold.setForeground(Color.GRAY);
	lab_c_n_gold.setHorizontalAlignment(JLabel.CENTER);
	lab_c_n_gold.setPreferredSize(new Dimension(225, 30));
	lab_c_n_nbgold.setFont(new Font("Tahoma", Font.PLAIN, 19));
	lab_c_n_nbgold.setText("560");
	lab_c_n_nbgold.setForeground(Color.decode("#424242"));
	lab_c_n_nbgold.setHorizontalAlignment(JLabel.CENTER);
	lab_c_n_nbgold.setPreferredSize(new Dimension(225, 30));
	
	name.setLayout(new GridLayout(4,1));
	nbgold.setLayout(new GridLayout(4,1));
	nbsubs.setLayout(new GridLayout(4,1));
	name.add(new NOR());
	nbgold.add(new NOR());
	nbsubs.add(new NOR());	
	haut.setLayout(null);
	
	name.add(lab_c_n_nbsubs);
	name.add(lab_c_n_subs);
	nbsubs.add(lab_c_n_nbviews);
	nbsubs.add(lab_c_n_views);
	nbgold.add(lab_c_n_nbgold);
	nbgold.add(lab_c_n_gold);
	
	haut.add(name);	
	haut.add(nbsubs);
	haut.add(nbgold);
	haut.add(acc);
	haut.add(end);
				
	//-- WEST
	JPanel west = new JPanel();
	west.setPreferredSize(new Dimension(255, 16*25));
	west.setBackground(Color.WHITE);
	west.setLayout(new BorderLayout());
	
	JPanel w_left = new JPanel();
	w_left.setPreferredSize(new Dimension(20, 16*25));
	w_left.setBackground(Color.WHITE);
	JPanel w_right = new JPanel();
	w_right.setPreferredSize(new Dimension(20, 16*25));
	w_right.setBackground(Color.WHITE);
	JPanel w_north = new JPanel();
	w_north.setPreferredSize(new Dimension(255, 20));
	w_north.setBackground(Color.WHITE);
	JPanel w_center = new JPanel();
	w_center.setPreferredSize(new Dimension(205, 16*25));
	w_center.setBackground(Color.WHITE);
	
	west.add(w_left,BorderLayout.WEST);
	west.add(w_right,BorderLayout.EAST);
	west.add(w_north,BorderLayout.NORTH);
	
	GridLayout gl = new GridLayout(16,1);
	gl.setHgap(6);
	w_center.setLayout(null);
	
	bouton.addActionListener(new BoutonAccListener());
	bouton2.addActionListener(new BoutonPlanningListener());
	bouton3.addActionListener(new BoutonNotifListener());
	bouton4.addActionListener(new BoutonVideosListener());
	bouton.setBounds(0, 0, 225, 35);
	bouton2.setBounds(0, 105, 225, 35);
	bouton3.setBounds(0, 70, 225, 35);
	bouton4.setBounds(0, 35, 225, 35);
	w_center.add(bouton);
	w_center.add(bouton2);
	w_center.add(bouton3);
	w_center.add(bouton4);
	
	west.add(w_center,BorderLayout.CENTER);
				
	//-- CENTER
	center.setBackground(Color.decode("#F3F3F3"));
	center.setLayout(new BorderLayout());
		c_west.setPreferredSize(new Dimension(10,hauteur));
		c_west.setBackground(Color.decode("#F3F3F3"));
		c_east.setPreferredSize(new Dimension((largeur-255)/4,hauteur));
		c_east.setBackground(Color.decode("#F3F3F3"));
		c_north.setPreferredSize(new Dimension(largeur,10));
		c_north.setBackground(Color.decode("#F3F3F3"));	
			c_c_north1.setPreferredSize(new Dimension(((largeur-255)/4)*2, 80));
	
	center.add(c_east,BorderLayout.EAST);
	center.add(c_west,BorderLayout.WEST);
	center.add(c_north,BorderLayout.NORTH);
	center.add(c_center,BorderLayout.CENTER);
	c_center.setLayout(null);
	c_center.setBackground(Color.decode("#F3F3F3"));
		//West
		c_c_north1.setLayout(new BorderLayout());
		c_c_n1_west.setPreferredSize(new Dimension(15,hauteur));
		c_c_n1_north.setPreferredSize(new Dimension(largeur, 15));
		c_c_n1_south.setPreferredSize(new Dimension(largeur, 15));
		c_c_n1_center.setLayout(null);
			c_c_n1_c_prof.setBounds(0,0,50,50);
			c_c_n1_c_name.setBounds(15+50, 0, 300, 50);
			c_c_n1_c_prof.setLayout(new BorderLayout());
			c_c_n1_c_name.setLayout(new BorderLayout());
				//Lettre
				JLabel lab_lettre = new JLabel();
				lab_lettre.setFont(new Font("Tahoma", Font.PLAIN, 35));
				lab_lettre.setText("M");
				lab_lettre.setForeground(Color.WHITE);
				lab_lettre.setHorizontalAlignment(JLabel.CENTER);
				lab_lettre.setPreferredSize(new Dimension(50, 50));
				//Pseudo
				lab_c_c_n1_name.setFont(new Font("Tahoma", Font.PLAIN, 22));
				lab_c_c_n1_name.setText("Malimoi");
				lab_c_c_n1_name.setForeground(Color.BLACK);
				lab_c_c_n1_name.setHorizontalAlignment(JLabel.LEFT);
				lab_c_c_n1_name.setPreferredSize(new Dimension(300, 25));
				//Partenaire
				lab_c_c_n1_partenaire.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lab_c_c_n1_partenaire.setText("PARTENAIRE YOUTUBERTYCOON");
				lab_c_c_n1_partenaire.setForeground(Color.decode("#424242"));
				lab_c_c_n1_partenaire.setHorizontalAlignment(JLabel.LEFT);
				lab_c_c_n1_partenaire.setPreferredSize(new Dimension(300, 25));
			c_c_n1_c_name.add(lab_c_c_n1_name,BorderLayout.NORTH);
			c_c_n1_c_name.add(lab_c_c_n1_partenaire,BorderLayout.SOUTH);
			c_c_n1_c_prof.add(lab_lettre,BorderLayout.CENTER);
			c_c_n1_center.add(c_c_n1_c_prof);
			c_c_n1_center.add(c_c_n1_c_name);
		//East
		c_c_north1.setBounds(0, 0, ((largeur-255)/4)*2, 80);
		c_c_north2.setBounds(((largeur-255)/4)*2, 0, ((largeur-255)/8), 80);
		c_c_north3.setBounds(((largeur-255)/4)*2+((largeur-255)/8), 0, ((largeur-255)/8), 80);
		c_c_north2.setLayout(new GridLayout(4,1));
		c_c_north3.setLayout(new GridLayout(4,1));
			//Subs
			lab_c_c_north_subs.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lab_c_c_north_subs.setText("Abonnés");
			lab_c_c_north_subs.setForeground(Color.GRAY);
			lab_c_c_north_subs.setHorizontalAlignment(JLabel.CENTER);
			lab_c_c_north_subs.setPreferredSize(new Dimension(((largeur-255)/8), 40));
			lab_c_c_north_nbsubs.setFont(new Font("Tahoma", Font.PLAIN, 21));
			lab_c_c_north_nbsubs.setText("11 156");
			lab_c_c_north_nbsubs.setForeground(Color.decode("#424242"));
			lab_c_c_north_nbsubs.setHorizontalAlignment(JLabel.CENTER);
			lab_c_c_north_nbsubs.setPreferredSize(new Dimension(((largeur-255)/8), 40));
			//Views
			lab_c_c_north_views.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lab_c_c_north_views.setText("Vues");
			lab_c_c_north_views.setForeground(Color.GRAY);
			lab_c_c_north_views.setHorizontalAlignment(JLabel.CENTER);
			lab_c_c_north_views.setPreferredSize(new Dimension(((largeur-255)/8), 40));
			lab_c_c_north_nbviews.setFont(new Font("Tahoma", Font.PLAIN, 21));
			lab_c_c_north_nbviews.setText("658 254");
			lab_c_c_north_nbviews.setForeground(Color.decode("#424242"));
			lab_c_c_north_nbviews.setHorizontalAlignment(JLabel.CENTER);
			lab_c_c_north_nbviews.setPreferredSize(new Dimension(((largeur-255)/8), 40));
		//Notifications pannel :
		c_c_notif.setBounds(0, 12+80, (((largeur-255)-15-(largeur-255)/4))/2, 500);
		c_c_notif.setLayout(new BorderLayout());
		c_c_videospannel.setBounds((((largeur-255)-15-(largeur-255)/4))/2+15, 12+80, (((largeur-255)-15-(largeur-255)/4))/2, 500);
		c_c_videospannel.setLayout(new BorderLayout());
			/*
			 * Planning
			 */
			c_c_nt_west.setPreferredSize(new Dimension(26, hauteur));
			c_c_nt_east.setPreferredSize(new Dimension(26, hauteur));
			c_c_nt_north.setPreferredSize(new Dimension(largeur, 5));
			c_c_nt_south.setPreferredSize(new Dimension(largeur, 15));
			c_c_nt_center.setLayout(null);		
			/*
			 * Vidéos
			 */
			c_c_vp_west.setPreferredSize(new Dimension(26, hauteur));
			c_c_vp_east.setPreferredSize(new Dimension(26, hauteur));
			c_c_vp_north.setPreferredSize(new Dimension(largeur, 5));
			c_c_vp_south.setPreferredSize(new Dimension(largeur, 15));
			c_c_vp_center.setLayout(null);		
			
			/*
			 * Set the planning (ChatClient page)
		       ---------------------------
			 * Méthode qui renvoi à la construction du planning avec évenements.
		     */
		    setPlanning();
		    setVideosPannel();
		
		//Planning
		c_c_notif.add(c_c_nt_west,BorderLayout.WEST);
		c_c_notif.add(c_c_nt_east,BorderLayout.EAST);
		c_c_notif.add(c_c_nt_south,BorderLayout.SOUTH);
		c_c_notif.add(c_c_nt_north,BorderLayout.NORTH);
		c_c_notif.add(c_c_nt_center,BorderLayout.CENTER);
		//vidéos
		c_c_videospannel.add(c_c_vp_west,BorderLayout.WEST);
		c_c_videospannel.add(c_c_vp_east,BorderLayout.EAST);
		c_c_videospannel.add(c_c_vp_south,BorderLayout.SOUTH);
		c_c_videospannel.add(c_c_vp_north,BorderLayout.NORTH);
		c_c_videospannel.add(c_c_vp_center,BorderLayout.CENTER);
		
		c_c_north1.add(c_c_n1_west,BorderLayout.WEST);
		c_c_north1.add(c_c_n1_north,BorderLayout.NORTH);
		c_c_north1.add(c_c_n1_south,BorderLayout.SOUTH);
		c_c_north1.add(c_c_n1_center,BorderLayout.CENTER);
		c_c_north2.add(new NOR());
		c_c_north3.add(new NOR());
		c_c_north2.add(lab_c_c_north_nbviews);
		c_c_north3.add(lab_c_c_north_nbsubs);
		c_c_north2.add(lab_c_c_north_views);
		c_c_north3.add(lab_c_c_north_subs);
	c_center.add(c_c_north1);
	c_center.add(c_c_north2);
	c_center.add(c_c_north3);
	c_center.add(c_c_notif);
	c_center.add(c_c_videospannel);
	
	/*
	 * End Center
	 * Start Center_Planning
	 */
	
	center_planning.setBackground(Color.RED);
	
	content.add(haut, BorderLayout.NORTH);
	content.add(west, BorderLayout.WEST);
	
	content.setPreferredSize(new Dimension(largeur, hauteur));
		
	this.setContentPane(content);
	this.setVisible(true);	

	}
	/*
	 * Only test !
	 */
	public void test(){
		SimpleDateFormat formater = null;
		Date aujourdhui = new Date();
		
		formater = new SimpleDateFormat("yy/MM/dd/HH");
		String s = formater.format(aujourdhui);
		String[] sf = s.split("/");
		System.out.println("Nous sommes le "+sf[2]+"/"+sf[1]+"/"+sf[0]+" et il est "+sf[3]+"h");
	}
	
	public void resetPlanning(){
		c_c_nt_center.removeAll();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try{
			content.updateUI();
		}catch(Exception e){
			System.out.println("Erreur : "+test);
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setPlanning();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try{
			content.updateUI();
		}catch(Exception e){
			System.out.println("Erreur : "+test);
		}
	}
	
	public String ColId (Integer i){
		String s = "f";
		if (i==1){
			s="1";
		}if (i==2){
			s="2";
		}if (i==3){
			s="2";
		}if (i==4){
			s="b";
		}if (i==5){
			s="d";
		}
		return s;
	}
	public String ActivityId (Integer i, Long l){
		String s = "Glandouillette";
		String name = "";
		if (i==1){
			s="Travail";
		}if (i==2){
			for (int a = 0;a<ChatClient.videos.size();a++){
				if (ChatClient.videos.get(a).getID()==l){
					name = ChatClient.videos.get(a).getName();
				}
			}
			s="Nouvelle vidéo \""+name+"\"";
		}if (i==3){
			for (int a = 0;a<ChatClient.videos.size();a++){
				if (ChatClient.videos.get(a).getID()==l){
					name = ChatClient.videos.get(a).getName();
				}
			}
			s="Tournage \""+name+"\"";
		}if (i==4){
			for (int a = 0;a<ChatClient.videos.size();a++){
				if (ChatClient.videos.get(a).getID()==l){
					name = ChatClient.videos.get(a).getName();
				}
			}
			s="Montage \""+name+"\"";
		}if (i==5){
			s="Jour de paye";
		}
		return s;
	}
	/*
	 * Code couleur !
	 */
	public Color Col(String i){
		Color c = Color.WHITE;
		if(i=="1"){
			c = Color.decode("#1E00DF");
		}if (i=="2"){
			c = Color.decode("#01D42B");
		}if (i=="3"){
			c = Color.decode("#00B5D1");
		}if (i=="4"){
			c = Color.decode("#D10E00");
		}if (i=="5"){
			c = Color.decode("#BD00B7");
		}if (i=="6"){
			c = Color.decode("#DBB316");
		}if (i=="7"){
			c = Color.decode("#D4D3D1");
		}if (i=="8"){
			c = Color.decode("#656565");
		}if (i=="9"){
			c = Color.decode("#5863C3");
		}if (i=="a"){
			c = Color.decode("#40FE66");
		}if (i=="b"){
			c = Color.decode("#5AEFEA");
		}if (i=="c"){
			c = Color.decode("#FE4747");
		}if (i=="d"){
			c = Color.decode("#FB75EE");
		}if (i=="e"){
			c = Color.decode("#FDF400");
		}if (i=="f"){
			c = Color.decode("#FEFEFE");
		}if (i=="g"){
			c = Color.decode("#FE9900");
		}
		
		return c;	
	}
	
	class Bouton extends JButton implements MouseListener{
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
					this.img = ImageIO.read(new File("image/Planning2.png"));
				}else if(i==3){
					this.img = ImageIO.read(new File("image/Notif2.png"));
				}else if(i==4){
					this.img = ImageIO.read(new File("image/Video2.png"));
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D)g;
			g2d.setColor(FOND);
			g2d.fillRect(0, 0, hauteur, this.getHeight());
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
					this.img = ImageIO.read(new File("image/Planning.png"));
				}else if(i==3){
					this.img = ImageIO.read(new File("image/Notif.png"));
				}else if(i==4){
					this.img = ImageIO.read(new File("image/Video.png"));
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
					this.img = ImageIO.read(new File("image/Planning2.png"));
				}else if(i==3){
					this.img = ImageIO.read(new File("image/Notif2.png"));
				}else if(i==4){
					this.img = ImageIO.read(new File("image/Video2.png"));
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
					this.img = ImageIO.read(new File("image/Planning.png"));
				}else if(i==3){
					this.img = ImageIO.read(new File("image/Notif.png"));
				}else if(i==4){
					this.img = ImageIO.read(new File("image/Video.png"));
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
	class BoutonSep extends JButton{
		private String name;
		public BoutonSep(String str){
			super(str);
			this.name = str;
			this.setBorderPainted(false);
		}
		public void paintComponent(Graphics g){
			Color c = Color.decode("#1C2935");//Gris
			Graphics2D g2d = (Graphics2D)g;
			//GradientPaint gp = new GradientPaint(0,0,Color.WHITE,0,this.getHeight(),c2,true);
			//g2d.setPaint(gp);
			g2d.setColor(c);
			g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
			g2d.setColor(Color.BLACK);
			g2d.setFont(new Font("Alternate Gothic No3 D", Font.PLAIN, 20));
			FontMetrics fm = g2d.getFontMetrics();
			int height = fm.getHeight();
			int width = fm.stringWidth(this.name);			
			g2d.setRenderingHint(
			        RenderingHints.KEY_TEXT_ANTIALIASING,
			        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			
			g2d.drawString(this.name, this.getWidth()/2 - (width/2), (this.getHeight()/2)+(height/4));
			g2d.setColor(Color.decode("#454C53"));
			g2d.drawLine(0, this.getHeight()-1, this.getWidth(), this.getHeight()-1);
			try {
				g2d.drawImage(ImageIO.read(new File("image/Home.png")), 0, 0, 25, 25, this);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public class ACC extends JPanel {
		public ACC(){
			
		}
		public void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D)g;
			g2d.setColor(Color.WHITE);		
			g2d.fillRect(0, 0, largeur, 60);
			try {
				g2d.drawImage(ImageIO.read(new File("image/LogoHaut.png")), 0, 0, 225, 60, this);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public class MINI extends JPanel {
		private String path;
		public MINI(String path){
			this.path=path;
		}
		public void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D)g;
			g2d.setRenderingHint(
			        RenderingHints.KEY_ANTIALIASING,
			        RenderingHints.VALUE_ANTIALIAS_ON);
			
			try {
				g2d.drawImage(ImageIO.read(new File(path)), 0, 0, 25, 25, this);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public class MINIA extends JPanel {
		private String path;
		public MINIA(String path){
			this.path=path;
		}
		public void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D)g;
			g2d.setRenderingHint(
			        RenderingHints.KEY_ANTIALIASING,
			        RenderingHints.VALUE_ANTIALIAS_ON);
			
			try {
				g2d.drawImage(ImageIO.read(new File(path)), 0, 0, 165, 95, this);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public class PROF_ACC extends JPanel {
		public PROF_ACC(){
			
		}
		public void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D)g;
			g2d.setColor(Color.ORANGE);		
			g2d.fillRect(0, 0, 50, 50);
		}
	}
	
	public class NAME_ACC extends JPanel {
		public NAME_ACC(){
			
		}
		public void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D)g;
			g2d.setColor(Color.WHITE);
			g2d.fillRect(0, 0, 300, 50);	
		}
	}
	
	public class NOR extends JPanel {
		public NOR(){
			
		}
		public void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D)g;
			g2d.setColor(Color.WHITE);
			g2d.fillRect(0, 0, largeur, hauteur);	
		}
	}
	
	public class COLOR extends JPanel {
		private Color c;
		public COLOR(Color c){
			this.c=c;
		}
		public void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D)g;
			g2d.setColor(c);
			g2d.fillRect(0, 0, largeur, hauteur);	
		}
	}
	
	public class Prog extends JPanel {
		private Integer i;
		public Prog(Integer i){
			this.i=i;
		}
		public void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D)g;
			g2d.setColor(Color.decode("#F3F3F3"));
			g2d.fillRect(0, 0, largeur, hauteur);	
			/*
			 * A faire : liste de tous les IDs.
			 */
			if (i==1){
				g2d.setColor(Color.GREEN);
			}else if(i==2){
				g2d.setColor(Color.BLUE);
			}
			g2d.fillRect(0, 0, largeur, hauteur);	
		}
	}
	
	public class Even extends JPanel {
		private Integer i;
		public Even(Integer i){
			this.i=i;
		}
		public void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D)g;
			g2d.setColor(Color.WHITE);
			if (i==1){
				g2d.setColor(Color.GREEN);
			}else if(i==2){
				g2d.setColor(Color.BLUE);
			}			
			g2d.fillRect(0, 0, largeur, hauteur);	
		}
	}
	
	public class SUBS extends JPanel {
		public SUBS(){
			
		}
		public void paintComponent(Graphics g){
			Color c = Color.decode("#D7D7D7");//Gris
			Graphics2D g2d = (Graphics2D)g;
			g2d.setColor(Color.WHITE);
			g2d.fillRect(0, 0, ((largeur-255)/8), 80);	
			g2d.setColor(c);
			g2d.drawLine(((largeur-255)/8)-1, 20, ((largeur-255)/8)-1, 60);
		}
	}
	
	public class DEL extends JPanel {
		public DEL(){
			
		}
		public void paintComponent(Graphics g){
			Color c = Color.decode("#D7D7D7");//Gris
			Graphics2D g2d = (Graphics2D)g;
			g2d.setColor(c);
			g2d.fillRect(0, 0, largeur, hauteur*5);	
		}
	}
	
	
	public class CENTER extends JPanel {
		public CENTER(){
			
		}
		public void paintComponent(Graphics g){
			Color c = Color.decode("#D7D7D7");//Gris
			Graphics2D g2d = (Graphics2D)g;
			g2d.setColor(c);
			g2d.fillRect(0, 0, largeur, hauteur);	
		}
	}
	
	class BoutonAccListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			bouton.setEnabled(false);
			bouton2.setEnabled(true);
			bouton3.setEnabled(true);
			bouton4.setEnabled(true);
			if (test==2){
				content.remove(center_planning);
			}
			test=1;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			content.add(center,BorderLayout.CENTER);
			/* Existe-t-il une meilleur méthode ? */
			try{
				content.updateUI();
			}catch(Exception e){
				/* Petit test personnel pour vérifier le bon fonctionnement */
				System.out.println("Erreur : "+test);
			}				
		}
	}
	
	class BoutonPlanningListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			bouton.setEnabled(true);
			bouton2.setEnabled(false);
			bouton3.setEnabled(true);
			bouton4.setEnabled(true);
			if (test==1){
				content.remove(center);
			}
			test=2;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			content.add(center_planning,BorderLayout.CENTER);
			try{
				content.updateUI();
			}catch(Exception e){
				System.out.println("Erreur : "+test);
			}
			resetPlanning();
		}
	}
	
	class BoutonNotifListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			bouton.setEnabled(true);
			bouton2.setEnabled(true);
			bouton3.setEnabled(false);
			bouton4.setEnabled(true);
			if (test==1){
				content.remove(center);
			}
			else if (test==2){
				content.remove(center_planning);
			}
			test=3;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try{
				content.updateUI();
			}catch(Exception e){
				System.out.println("Erreur : "+test);
			}
		}
	}
	
	class BoutonVideosListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			bouton.setEnabled(true);
			bouton2.setEnabled(true);
			bouton3.setEnabled(true);
			bouton4.setEnabled(false);
			if (test==1){
				content.remove(center);
			}
			else if (test==2){
				content.remove(center_planning);
			}
			test=4;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try{
				content.updateUI();
			}catch(Exception e){
				System.out.println("Erreur : "+test);
			}
		}
	}
	
	public void setPlanning(){
		System.out.println("Execution de setPlanning");
		//Label : Name
		int TotalNotifY = 0;
		lab_c_c_nt_c_name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lab_c_c_nt_c_name.setText("PLANNING");
		lab_c_c_nt_c_name.setForeground(Color.decode("#474848"));
		lab_c_c_nt_c_name.setHorizontalAlignment(JLabel.LEFT);
		lab_c_c_nt_c_name.setBounds(0, 0, (((largeur-255)-15-(largeur-255)/4))/2, 40);
		TotalNotifY = TotalNotifY+40+3;
		Boolean encours = true;
		int d = 1;
		while (d!=5){
			
			Boolean plan = true;
			int i = 0;
			SimpleDateFormat formater = null;
			Date now = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(now);
			cal.add(Calendar.DAY_OF_YEAR, d-1); // <--
			Date date = cal.getTime();
			formater = new SimpleDateFormat("yy/MM/dd/HH/EEEE/MMMM/MMM");
			String s = formater.format(date);
			String[] sf = s.split("/");
			System.out.println("date:"+sf[2]+"/"+sf[1]+"/"+sf[0]);
			if (d==1){
				lab_c_c_nt_c_jour.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lab_c_c_nt_c_jour.setText(""+sf[4].toUpperCase()+"");
				lab_c_c_nt_c_jour.setForeground(Color.RED);
				lab_c_c_nt_c_jour.setHorizontalAlignment(JLabel.LEFT);
				lab_c_c_nt_c_jour.setBounds(0, TotalNotifY, (((largeur-255)-15-(largeur-255)/4))/2, 16);
				TotalNotifY = TotalNotifY+16;
				lab_c_c_nt_c_date.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lab_c_c_nt_c_date.setText(""+sf[2]+" "+sf[5].toUpperCase()+"");
				lab_c_c_nt_c_date.setForeground(Color.RED);
				lab_c_c_nt_c_date.setHorizontalAlignment(JLabel.LEFT);
				lab_c_c_nt_c_date.setBounds(0, TotalNotifY, (((largeur-255)-15-(largeur-255)/4))/2, 20);
				TotalNotifY = TotalNotifY+20+5;
				if (ChatClient.evenements.get(i).getYear()<Integer.parseInt(sf[0])){
					ChatClient.evenements.remove(i);
				}
				else if (ChatClient.evenements.get(i).getMonth()<Integer.parseInt(sf[1]) && !(ChatClient.evenements.get(i).getYear()>Integer.parseInt(sf[0]))){
					ChatClient.evenements.remove(i);
				}
				else if (ChatClient.evenements.get(i).getDay()<Integer.parseInt(sf[2]) && !(ChatClient.evenements.get(i).getMonth()>Integer.parseInt(sf[1]))){
					ChatClient.evenements.remove(i);
				}
				if (ChatClient.planning.get(i).getYear()<Integer.parseInt(sf[0])){
					ChatClient.planning.remove(i);
				}
				else if (ChatClient.planning.get(i).getMonth()<Integer.parseInt(sf[1]) && !(ChatClient.planning.get(i).getYear()>Integer.parseInt(sf[0]))){
					ChatClient.planning.remove(i);
				}
				else if (ChatClient.planning.get(i).getDay()<Integer.parseInt(sf[2]) && !(ChatClient.planning.get(i).getMonth()>Integer.parseInt(sf[1]))){
					ChatClient.planning.remove(i);
				}
				else if (ChatClient.planning.get(i).getHour()<=Integer.parseInt(sf[3]) && !(ChatClient.planning.get(i).getDay()>Integer.parseInt(sf[2]))){
					ChatClient.planning.remove(i);
				}
			}else{
				JLabel next_day = new JLabel();
				next_day.setFont(new Font("Tahoma", Font.PLAIN, 14));
				next_day.setText(sf[4].toUpperCase()+", "+(Integer.parseInt(sf[2]))+" "+sf[6].toUpperCase().replace(".", ""));
				next_day.setForeground(Color.RED);
				next_day.setHorizontalAlignment(JLabel.LEFT);
				next_day.setBounds(0, TotalNotifY, (((largeur-255)-15-(largeur-255)/4))/2, 16);
				TotalNotifY = TotalNotifY+16+5;
				c_c_nt_center.add(next_day);
			}
			
			/*
			 * Boucle 1 - évenement
			 */
			while(plan){
				if (ChatClient.evenements.size()-1==i){
					plan=false;
				}
				else{
						if (ChatClient.evenements.get(i).getDay()==Integer.parseInt(sf[2])){
							JPanel panel = new COLOR(Col(ColId(ChatClient.evenements.get(i).getId())));
							panel.setBounds(0, TotalNotifY, (((largeur-255)-15-(largeur-255)/4))/2, 17);
							TotalNotifY=TotalNotifY+15+5;
							panel.setLayout(new BorderLayout());
							JPanel nordd = new COLOR(Col(ColId(ChatClient.evenements.get(i).getId())));
							nordd.setPreferredSize(new Dimension(largeur,1));
							JPanel sudd = new COLOR(Col(ColId(ChatClient.evenements.get(i).getId())));
							sudd.setPreferredSize(new Dimension(largeur,1));
							JPanel westt = new COLOR(Col(ColId(ChatClient.evenements.get(i).getId())));
							westt.setPreferredSize(new Dimension(5,hauteur));
							JPanel centerr = new COLOR(Col(ColId(ChatClient.evenements.get(i).getId())));
							//centerr.setPreferredSize(new Dimension(largeur,hauteur));
							panel.add(nordd,BorderLayout.NORTH);
							panel.add(sudd,BorderLayout.SOUTH);
							panel.add(westt,BorderLayout.WEST);
							centerr.setLayout(new BorderLayout());
							
							JLabel label = new JLabel();
							label.setFont(new Font("Tahoma", Font.PLAIN, 15));
							label.setText(ActivityId(ChatClient.evenements.get(i).getId(),ChatClient.evenements.get(i).getData()));
							label.setForeground(Color.WHITE);
							label.setHorizontalAlignment(JLabel.LEFT);
							
							centerr.add(label, BorderLayout.CENTER);
							panel.add(centerr,BorderLayout.CENTER);
							c_c_nt_center.add(panel);
							System.out.println("(1-e) Jour égal à l'index : day "+ChatClient.evenements.get(i).getDay());
						}
						i++;
					}
			}
			//On réinitialise
			plan=true;
			i=0;
			/*
			 * Boucle 1 - horraire (jour j)
			 */
			while(plan){
				if (ChatClient.planning.size()-1==i){
					plan=false;
				}
				else{
						if (ChatClient.planning.get(i).getDay()==Integer.parseInt(sf[2])){
							Color c = Color.decode("#DCDCDC");
							if (encours==true){
								c = Color.decode("#C4FECA");
							}
							encours=false;
							JPanel panel = new COLOR(c);
							panel.setBounds(0, TotalNotifY, (((largeur-255)-15-(largeur-255)/4))/2, 50);
							TotalNotifY=TotalNotifY+50+5;
							panel.setLayout(new BorderLayout());
							JPanel nordd = new COLOR(c);
							nordd.setPreferredSize(new Dimension(largeur,5));
							JPanel sudd = new COLOR(c);
							sudd.setPreferredSize(new Dimension(largeur,5));
							JPanel westt = new COLOR(c);
							westt.setPreferredSize(new Dimension(5,hauteur));
							JPanel centerr = new COLOR(c);
							//centerr.setPreferredSize(new Dimension(largeur,hauteur));
							panel.add(nordd,BorderLayout.NORTH);
							panel.add(sudd,BorderLayout.SOUTH);
							panel.add(westt,BorderLayout.WEST);
							
							centerr.setLayout(new BorderLayout());
							JPanel norddd = new COLOR(c);
							norddd.setPreferredSize(new Dimension(largeur,(50-5-5)/2));
							norddd.setLayout(null);
							JPanel suddd = new COLOR(c);
							suddd.setPreferredSize(new Dimension(largeur,(50-5-5)/2));
							suddd.setLayout(null);
							
							JPanel color = new COLOR(Col(ColId(ChatClient.planning.get(i).getId())));
							color.setBounds(0, 0, (50-5-5)/2, (50-5-5)/2);
							
							JLabel label_name = new JLabel();
							label_name.setFont(new Font("Tahoma", Font.PLAIN, 18));
							label_name.setText(ActivityId(ChatClient.planning.get(i).getId(),ChatClient.planning.get(i).getData()));
							label_name.setForeground(Color.DARK_GRAY);
							label_name.setHorizontalAlignment(JLabel.LEFT);
							label_name.setBounds((50-5-5)/2+5, 0, largeur, (50-5-5)/2);
							
							JLabel label_hours = new JLabel();
							label_hours.setFont(new Font("Tahoma", Font.PLAIN, 12));
							String HourEnd = ChatClient.planning.get(i).getHour() < 22 ? ""+ChatClient.planning.get(i).getHour()+":00" : "<font color=red>"+
									ChatClient.planning.get(i).getHour()+":00 <i>(rique de fatigue !)</i></font>";
							label_hours.setText("<html>"+ChatClient.planning.get(i).getHour_start()+":00 à "+HourEnd+"</html>");
							//label_hours.setForeground(Color.GRAY);
							label_hours.setHorizontalAlignment(JLabel.LEFT);
							label_hours.setBounds((50-5-5)/2+5, 0, largeur, (50-5-5)/2);
							
							norddd.add(color);
							norddd.add(label_name);
							suddd.add(label_hours);
							centerr.add(norddd,BorderLayout.NORTH);
							centerr.add(suddd,BorderLayout.SOUTH);
							panel.add(centerr,BorderLayout.CENTER);
							c_c_nt_center.add(panel);
							System.out.println("(1) Jour égal à l'index : "+ChatClient.planning.get(i).getHour_start()+" -> "+ChatClient.planning.get(i).getHour()
									+" : day "+ChatClient.planning.get(i).getDay());
						}
						i++;
					}
			}
			d++;
		}		

		c_c_nt_center.add(lab_c_c_nt_c_name);
		c_c_nt_center.add(lab_c_c_nt_c_jour);
		c_c_nt_center.add(lab_c_c_nt_c_date);
		c_c_notif.setBounds(0, 12+80, (((largeur-255)-15-(largeur-255)/4))/2, TotalNotifY+20);
	}
	
	public void setVideosPannel(){
		int TotalNotifY = 0;
		lab_c_c_vp_c_name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lab_c_c_vp_c_name.setText("VIDÉOS");
		lab_c_c_vp_c_name.setForeground(Color.decode("#474848"));
		lab_c_c_vp_c_name.setHorizontalAlignment(JLabel.LEFT);
		lab_c_c_vp_c_name.setBounds(0, 0, (((largeur-255)-15-(largeur-255)/4))/2, 40);
		TotalNotifY = TotalNotifY+40+5;
		
		Boolean vid = true;
		int i = 0;
		
		while(vid){
			if (ChatClient.videos.size()-1==i || i == 5){
				vid=false;
			}else{
				JPanel miniature = new MINIA("image/CLASSES/"+ChatClient.videos.get(i).getVideogenre()+".png");
				miniature.setBounds(0, TotalNotifY, 165, 95);
				JLabel titre = new JLabel();
				titre.setFont(new Font("Tahoma", Font.PLAIN, 18));
				titre.setText(ChatClient.videos.get(i).getName());
				titre.setForeground(Color.GRAY);
				titre.setHorizontalAlignment(JLabel.LEFT);
				titre.setBounds(182, TotalNotifY+5, (((largeur-255)-15-(largeur-255)/4))/2, 18);
				JPanel views = new MINI("image/views.png");
				views.setBounds(180,TotalNotifY+(95-(30+35)),25,25);
				JLabel nbviews = new JLabel();
				nbviews.setFont(new Font("Tahoma", Font.PLAIN, 16));
				nbviews.setText(ChatClient.videos.get(i).getViews()+"");
				nbviews.setForeground(Color.GRAY);
				nbviews.setHorizontalAlignment(JLabel.LEFT);
				nbviews.setBounds(180+30, TotalNotifY+(95-(30+35))+5, (((largeur-255)-15-(largeur-255)/4))/2, 16);
				JPanel likes = new MINI("image/likes.png");
				likes.setBounds(180,TotalNotifY+(95-30),25,25);
				JLabel nblikes = new JLabel();
				nblikes.setFont(new Font("Tahoma", Font.PLAIN, 16));
				nblikes.setText(ChatClient.videos.get(i).getLikes()+"");
				nblikes.setForeground(Color.GRAY);
				nblikes.setHorizontalAlignment(JLabel.LEFT);
				nblikes.setBounds(180+30, TotalNotifY+(95-30)+5, (((largeur-255)-15-(largeur-255)/4))/2, 16);
				JPanel dislikes = new MINI("image/dislikes.png");
				dislikes.setBounds(275,TotalNotifY+(95-30),25,25);
				JLabel nbdis = new JLabel();
				nbdis.setFont(new Font("Tahoma", Font.PLAIN, 16));
				nbdis.setText(ChatClient.videos.get(i).getDislikes()+"");
				nbdis.setForeground(Color.GRAY);
				nbdis.setHorizontalAlignment(JLabel.LEFT);
				nbdis.setBounds(275+30, TotalNotifY+(95-30)+5, (((largeur-255)-15-(largeur-255)/4))/2, 16);
				
				c_c_vp_center.add(miniature);
				c_c_vp_center.add(titre);
				c_c_vp_center.add(nbviews);
				c_c_vp_center.add(nblikes);
				c_c_vp_center.add(nbdis);
				c_c_vp_center.add(views);
				c_c_vp_center.add(likes);
				c_c_vp_center.add(dislikes);
				TotalNotifY=TotalNotifY+95+15;
				
				i++;
			}	
		}
			
		c_c_vp_center.add(lab_c_c_vp_c_name);
		c_c_videospannel.setBounds((((largeur-255)-15-(largeur-255)/4))/2+15, 12+80, (((largeur-255)-15-(largeur-255)/4))/2, TotalNotifY+5);
	}
}
