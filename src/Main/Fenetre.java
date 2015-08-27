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
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JTextArea;

import Main.MainClient.ChatAccess;
import accessoires.Accessoire;
import accessoires.Camera;
import accessoires.Micro;
import utilities.Evenement;
import utilities.Planning;
import utilities.Video;
import frames.ACC;
import frames.BORDER_PL;
import frames.COLOR;
import frames.IMAGE_;
import frames.MINI;
import frames.MINIA;
import frames.NAME_ACC;
import frames.NOR;
import frames.PROF_ACC;
import frames.SUBS;
import frames.VIDEOS_NORTH;
import frames.buttons.Bouton;
import frames.buttons.Bouton_PlanningAddRemove;
import frames.buttons.SubsClicks_Button;
import frames.buttons.ToutAfficher;

@SuppressWarnings({"serial","rawtypes"})
public class Fenetre extends JFrame{
	/*
	 * Je n'est aucune expérience en mise en page, je pense qu'il peut y avoir quelques améliorations à faire.
	 */
	public static GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
    
	//get maximum window bounds
	public static Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
			
	public static int hauteur = (int) maximumWindowBounds.getHeight();
	public static int largeur = (int) maximumWindowBounds.getWidth();
	
	//Principaux
	public JButton boutonAcc = new Bouton("Page d'accueil",1);
	public JButton boutonVideoGest = new Bouton("Gestionnaire de vidéos",2);
	public JButton boutonPlanning = new Bouton("Mon planning",3);
	public JButton bouton3 = new Bouton("Mes compétences",4);
	//Mini-Jeux
	public JButton boutonSubClick = new Bouton("Subscribers Clickers",5);
	
	//-CONTENT
	public static JPanel content = new JPanel();
	
	
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
					public JLabel lab_c_c_nt_c_deMainClient = new JLabel();
			public JPanel c_c_videospannel = new NOR();
				public JPanel c_c_vp_west = new NOR();
				public JPanel c_c_vp_east = new NOR();
				public JPanel c_c_vp_north = new NOR();
				public JPanel c_c_vp_south = new NOR();
				public JPanel c_c_vp_center = new NOR();
					public JLabel lab_c_c_vp_c_name = new JLabel();
					public JButton vid_affich = new ToutAfficher("Tout afficher", 1);
	public JPanel center_videos = new JPanel();
	//public JScrollPane scroll = new JScrollPane(center_videos,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		public JPanel cv_east = new COLOR(Color.decode("#F3F3F3"));
		public JPanel cv_west = new COLOR(Color.decode("#F3F3F3"));
		public JPanel cv_north = new COLOR(Color.decode("#F3F3F3"));
		public JPanel cv_center = new NOR();
			public JPanel cv_c_north = new VIDEOS_NORTH(1);
				public JLabel video = new JLabel();
				public JLabel nbvideo = new JLabel();
				public JPanel nbvideopan = new COLOR(Color.GRAY);
				public JButton mettreenligne = new ClassicButton("Faire une vidéo");
			public JPanel cv_c_south = new NOR();
	public JPanel center_planning = new JPanel();
		public JPanel cp_east = new COLOR(Color.decode("#9BFCA1"));
		public JPanel cp_west = new COLOR(Color.decode("#9BFCA1"));
		public JPanel cp_north = new COLOR(Color.decode("#9BFCA1"));
		public JPanel cp_center = new NOR();
			public JPanel cp_c_north = new VIDEOS_NORTH(3);
				public JLabel lab_planning = new JLabel();
				public JLabel lab_planningInfo = new JLabel();
			public JPanel cp_c_center = new COLOR(Color.decode("#F3F3F3"));
				public JPanel cp_c_c_north = new COLOR(Color.decode("#ffffff"));
				public JPanel cp_c_c_west = new COLOR(Color.decode("#ffffff"));
				public JPanel cp_c_c_east = new COLOR(Color.decode("#ffffff"));
				public static JPanel cp_c_c_center = new NOR();
					public static JLabel DATE_OF_DAY = new JLabel();
					public static JLabel Agenda = new JLabel();
					public static JPanel cp_c_c_c_1 = new NOR();
						public static JPanel cp_c_c_c_1_center = new AllImages("image/carreaux.jpg",400,500);
					public static JPanel cp_c_c_c_2 = new NOR();
						public static JPanel cp_c_c_c_2_center = new AllImages("image/carreaux.jpg",400,500);
					public static JPanel cp_c_c_c_right = new NOR();
						public static JComboBox edit_first_choice = new JComboBox();
						public static JButton edit_but_accept;
						public static JComboBox edit_hour_start = new JComboBox();
						public static JComboBox edit_hour_end = new JComboBox();
						public static JComboBox edit_date_box = new JComboBox();
						public static JComboBox edit_date = new JComboBox();
						public static JComboBox create_first_choice = new JComboBox();
						public static JButton create_but_accept;
						public static JComboBox create_2nd_choice = new JComboBox();
						public static JButton create_2ndbut_accept;
						public static JComboBox create_3rd_choice = new JComboBox();
						public static JButton create_3rdbut_accept;
						public static JComboBox create_hour_start = new JComboBox();
						public static JComboBox create_hour_end = new JComboBox();
						public static JComboBox create_date_box = new JComboBox();
					public JButton plan_add = new Bouton_PlanningAddRemove(1);
					public JButton plan_edit = new Bouton_PlanningAddRemove(2);
	public JPanel center_levels = new JPanel();
		public JPanel cl_east = new COLOR(Col("6"));
		public JPanel cl_west = new COLOR(Col("6"));
		public JPanel cl_north = new COLOR(Col("6"));
		public JPanel cl_center = new NOR();
			public JPanel cl_c_north = new VIDEOS_NORTH(2);
				public JLabel lab_levels = new JLabel();
				public JLabel lab_levelsInfo = new JLabel();
			public JPanel cl_c_center = new COLOR(Color.decode("#ffffff"));
	public JPanel center_subsclick = new JPanel();
		public JPanel csc_east = new COLOR(Color.red);
		public JPanel csc_west = new COLOR(Color.red);
		public JPanel csc_north = new COLOR(Color.red);
		public JPanel csc_center = new NOR();
			public JPanel csc_c_north = new VIDEOS_NORTH(4);
				public JLabel lab_sc = new JLabel();
				public JLabel lab_scInfo = new JLabel();
			public JPanel csc_c_center = new COLOR(Color.gray);
				public JPanel csc_c_c_left = new COLOR(Color.white);
					public JButton subs_clicks = new SubsClicks_Button();
					public static JLabel tot_clicks_subs = new JLabel();
				public JPanel csc_c_c_center = new COLOR(Color.decode("#EEEFEF"));
				public JPanel csc_c_c_right = new COLOR(Color.white);
	//Variable Creator Step 1
	public JComboBox categoriescombo;
	public JComboBox formatscombo;
	public JTextArea enter_titre;
	public JComboBox camerascombo;
	public JComboBox microscombo;
	
	//Variable Creator Step 2
	public JSlider ecrituretimeslid;
	public JSlider tournagetimeslid;
	public JSlider montagetimeslid;
	public JSlider postprodtimeslid;
	
	public Thread t;
	public static int test = 0;
	public static int videopage = 1;

	
	@SuppressWarnings("static-access")
	public Fenetre() {
		
		Thread th = new Thread(new Music());
	    
	    th.start();
		
	
	test();
	
	this.setTitle("Youtuber Tycoon by Malimoi");
	this.setSize(1200,720);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setExtendedState(JFrame.NORMAL);
	//this.setDefaultLookAndFeelDecorated(false);    /*-> Plein écran.*/
	this.setExtendedState(this.MAXIMIZED_BOTH);
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
	lab_c_n_nbsubs.setText(MainClient.player.getSubscribers()+"");
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
	lab_c_n_nbviews.setText(MainClient.player.getViews()+"");
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
	lab_c_n_nbgold.setText(MainClient.player.getDollars()+"");
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
	
	boutonAcc.addActionListener(new BoutonAccListener());
	boutonPlanning.addActionListener(new BoutonPlanningListener());
	bouton3.addActionListener(new BoutonCompetListener());
	boutonVideoGest.addActionListener(new BoutonVideosListener());
	boutonSubClick.addActionListener(new BoutonSubsClicksListener());
	vid_affich.addActionListener(new BoutonToutaffichListener());
	
	boutonAcc.setBounds(0, 0, 225, 35);
	boutonVideoGest.setBounds(0, 35, 225, 35);
	boutonPlanning.setBounds(0, 70, 225, 35);
	bouton3.setBounds(0, 105, 225, 35);
	JLabel mini_games = new JLabel();
	mini_games.setFont(new Font("Tahoma", Font.PLAIN, 17));
	mini_games.setText("<html><u>Mini-Jeux</u><html>");
	mini_games.setForeground(Color.RED);
	mini_games.setHorizontalAlignment(JLabel.LEFT);
	mini_games.setBounds(0, 140, 225, 20);
	boutonSubClick.setBounds(0, 160, 225, 35);
	
	w_center.add(boutonAcc);
	w_center.add(boutonVideoGest);
	w_center.add(boutonPlanning);
	w_center.add(bouton3);
	w_center.add(mini_games);
	w_center.add(boutonSubClick);
	
	west.add(w_center,BorderLayout.CENTER);
				
	//-- CENTER (Acc)
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
				lab_lettre.setText("M");//Ici: get la première lettre du pseudo.
				lab_lettre.setForeground(Color.WHITE);
				lab_lettre.setHorizontalAlignment(JLabel.CENTER);
				lab_lettre.setPreferredSize(new Dimension(50, 50));
				//Pseudo
				lab_c_c_n1_name.setFont(new Font("Tahoma", Font.PLAIN, 22));
				lab_c_c_n1_name.setText(MainClient.player.getPseudo());
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
			lab_c_c_north_nbsubs.setText(MainClient.player.getSubscribers()+"");
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
			lab_c_c_north_nbviews.setText(MainClient.player.getViews()+"");
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
			c_c_vp_south.setPreferredSize(new Dimension(largeur, 50));
			c_c_vp_center.setLayout(null);		
			
			/*
			 * Set the planning (MainClient page)
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
		c_c_videospannel.add(c_c_vp_north,BorderLayout.NORTH);
		c_c_videospannel.add(c_c_vp_south,BorderLayout.SOUTH);
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
	 * Start Center_Vidéos
	 */
	center_videos.setPreferredSize(new Dimension(Fenetre.largeur-(225+10+10),hauteur));
	center_videos.setLayout(new BorderLayout());
		cv_west.setPreferredSize(new Dimension(10, hauteur));
		cv_east.setPreferredSize(new Dimension(10, hauteur));
		cv_north.setPreferredSize(new Dimension(largeur, 10));
		cv_center.setLayout(new BorderLayout());
			cv_c_north.setPreferredSize(new Dimension(Fenetre.largeur-(225+10+10), Fenetre.hauteur/7));
			cv_c_north.setLayout(null);
			video.setFont(new Font("Tahoma", Font.PLAIN, 25));
			video.setText("Vidéos");
			video.setForeground(Color.decode("#424242"));
			video.setHorizontalAlignment(JLabel.CENTER);
			video.setBounds(0, 22, 120, 25);
			nbvideopan.setBounds(120, 20, 45, 29);
			nbvideopan.setLayout(new BorderLayout());
			nbvideo.setFont(new Font("Tahoma", Font.PLAIN, 18));
			nbvideo.setText((MainClient.videos.size()-1)+"");
			nbvideo.setForeground(Color.decode("#ffffff"));
			nbvideo.setHorizontalAlignment(JLabel.CENTER);
			nbvideopan.add(nbvideo,BorderLayout.CENTER);
			mettreenligne.setBounds(25, 65, 140, 38);
			cv_c_south.setLayout(null);
			cv_c_south.setPreferredSize(new Dimension(Fenetre.largeur-(225+10+10), Fenetre.hauteur-(Fenetre.hauteur/7)));
			
			setVideosGestionnaire();
			
			cv_c_north.add(nbvideopan);
			cv_c_north.add(video);
			cv_c_north.add(mettreenligne);
			cv_center.add(cv_c_north, BorderLayout.NORTH);
			cv_center.add(cv_c_south, BorderLayout.CENTER);
		
	center_videos.add(cv_west,BorderLayout.WEST);
	center_videos.add(cv_east,BorderLayout.EAST);
	center_videos.add(cv_north,BorderLayout.NORTH);
	center_videos.add(cv_center,BorderLayout.CENTER);
	
	/*
	 * End Center
	 * Start Center_Planning
	 */
	center_planning.setPreferredSize(new Dimension(Fenetre.largeur-(225+10+10),hauteur));
	center_planning.setLayout(new BorderLayout());
		cp_west.setPreferredSize(new Dimension(10, hauteur));
		cp_east.setPreferredSize(new Dimension(10, hauteur));
		cp_north.setPreferredSize(new Dimension(largeur, 10));
		cp_center.setLayout(new BorderLayout());
			/*
			 * North
			 */
			cp_c_north.setPreferredSize(new Dimension(Fenetre.largeur-(225+10+10), Fenetre.hauteur/7));
			cp_c_north.setLayout(null);
			lab_planning.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lab_planning.setText("Planning");
			lab_planning.setForeground(Color.decode("#424242"));
			lab_planning.setHorizontalAlignment(JLabel.CENTER);
			lab_planning.setBounds(8, 22, 120, 30);
			lab_planningInfo.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lab_planningInfo.setText("C'est ici que vous gérez votre emploi du temps !");
			lab_planningInfo.setForeground(Color.decode("#424242"));
			lab_planningInfo.setHorizontalAlignment(JLabel.CENTER);
			lab_planningInfo.setBounds(10, 22+50, 400, 20);
			/*
			 * Center
			 */
			cp_c_center.setLayout(new BorderLayout());
			cp_c_center.setPreferredSize(new Dimension(Fenetre.largeur-(225+10+10), hauteur-Fenetre.hauteur/7));
			cp_c_c_north.setPreferredSize(new Dimension(largeur,15));
			cp_c_c_west.setPreferredSize(new Dimension(15,hauteur));
			cp_c_c_east.setPreferredSize(new Dimension(15,hauteur));
			cp_c_c_center.setLayout(null);
				
				cp_c_c_c_1.setBounds(0,100,400,450);
				cp_c_c_c_1.setLayout(new BorderLayout());
				cp_c_c_c_2.setBounds(399,100,400,450);
				cp_c_c_c_2.setLayout(new BorderLayout());
				cp_c_c_c_1_center.setLayout(null);
				cp_c_c_c_2_center.setLayout(null);			
				
				setPlanningPage();
				/*
				 * setModifPage(); ??
				 */
				plan_add.setBounds(largeur-255-10-10-15-15-110, 0, 60, 60);
				plan_edit.setBounds(largeur-255-10-10-15-15-60, 0, 60, 60);
				cp_c_c_c_right.setBounds(810,100,(largeur-10-10-255)-810-30,450);
				cp_c_c_c_right.setLayout(null);
				
				cp_c_c_center.add(DATE_OF_DAY);
				cp_c_c_center.add(Agenda);
				cp_c_c_center.add(cp_c_c_c_1);
				cp_c_c_center.add(cp_c_c_c_2);
				cp_c_c_center.add(cp_c_c_c_right);
				cp_c_c_center.add(plan_add);
				cp_c_c_center.add(plan_edit);
				
			cp_c_north.add(lab_planning);
			cp_c_north.add(lab_planningInfo);
			cp_c_center.add(cp_c_c_north,BorderLayout.NORTH);
			cp_c_center.add(cp_c_c_west,BorderLayout.WEST);
			cp_c_center.add(cp_c_c_east,BorderLayout.EAST);
			cp_c_center.add(cp_c_c_center,BorderLayout.CENTER);
		cp_center.add(cp_c_north,BorderLayout.NORTH);
		cp_center.add(cp_c_center,BorderLayout.CENTER);
	center_planning.add(cp_west,BorderLayout.WEST);
	center_planning.add(cp_east,BorderLayout.EAST);
	center_planning.add(cp_north,BorderLayout.NORTH);
	center_planning.add(cp_center,BorderLayout.CENTER);
			
	/*
	 * End Center_Planning
	 * Start Center_Levels
	 */
	
	center_levels.setPreferredSize(new Dimension(Fenetre.largeur-(225+10+10),hauteur));
	center_levels.setLayout(new BorderLayout());
		cl_west.setPreferredSize(new Dimension(10, hauteur));
		cl_east.setPreferredSize(new Dimension(10, hauteur));
		cl_north.setPreferredSize(new Dimension(largeur, 10));
		cl_center.setLayout(new BorderLayout());
			/*
			 * North
			 */
			cl_c_north.setPreferredSize(new Dimension(Fenetre.largeur-(225+10+10), Fenetre.hauteur/7));
			cl_c_north.setLayout(null);
			lab_levels.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lab_levels.setText("Vos compétences");
			lab_levels.setForeground(Color.decode("#424242"));
			lab_levels.setHorizontalAlignment(JLabel.CENTER);
			lab_levels.setBounds(8, 22, 200, 30);
			lab_levelsInfo.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lab_levelsInfo.setText("C'est ici que vous pouvez voir votre expérience dans chaque domaine !");
			lab_levelsInfo.setForeground(Color.decode("#424242"));
			lab_levelsInfo.setHorizontalAlignment(JLabel.LEFT);
			lab_levelsInfo.setBounds(10, 22+50, 600, 20);
			/*
			 * Center
			 */
			cl_c_center.setLayout(null);
			setLevelsPage();
						
		cl_center.add(cl_c_north,BorderLayout.NORTH);
		cl_center.add(cl_c_center,BorderLayout.CENTER);
		cl_c_north.add(lab_levels);
		cl_c_north.add(lab_levelsInfo);
	center_levels.add(cl_west,BorderLayout.WEST);
	center_levels.add(cl_east,BorderLayout.EAST);
	center_levels.add(cl_north,BorderLayout.NORTH);
	center_levels.add(cl_center,BorderLayout.CENTER);
	
	/*
	 * End Center_Levels
	 * Start Subscribers_Clikers
	 */
	
	center_subsclick.setPreferredSize(new Dimension(Fenetre.largeur-(225+10+10),hauteur));
	center_subsclick.setLayout(new BorderLayout());
		csc_west.setPreferredSize(new Dimension(10, hauteur));
		csc_east.setPreferredSize(new Dimension(10, hauteur));
		csc_north.setPreferredSize(new Dimension(largeur, 10));
		csc_center.setLayout(new BorderLayout());
			/*
			 * North
			 */
			csc_c_north.setPreferredSize(new Dimension(Fenetre.largeur-(225+10+10), Fenetre.hauteur/7));
			csc_c_north.setLayout(null);
			lab_sc.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lab_sc.setText("Mini-Jeu");
			lab_sc.setForeground(Color.decode("#424242"));
			lab_sc.setHorizontalAlignment(JLabel.LEFT);
			lab_sc.setBounds(10, 22, 200, 30);
			lab_scInfo.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lab_scInfo.setText("Subscribers Clicker : MORE SUBS !");
			lab_scInfo.setForeground(Color.decode("#424242"));
			lab_scInfo.setHorizontalAlignment(JLabel.LEFT);
			lab_scInfo.setBounds(10, 22+50, 600, 20);
			/*
			 * Center
			 */
			csc_c_center.setLayout(new BorderLayout());
				csc_c_c_left.setPreferredSize(new Dimension((largeur-300)/3,hauteur));
				csc_c_c_left.setLayout(null);
					JPanel logo = new JPanel();
					logo.setBackground(Color.ORANGE); //Get couleur image de profil.
					logo.setBounds(((largeur-300)/3)/2-60, 50, 120, 120);
					logo.setLayout(new BorderLayout());
						JLabel lab_lettre1 = new JLabel();
						lab_lettre1.setFont(new Font("Tahoma", Font.PLAIN, 75));
						lab_lettre1.setText("M");//Ici: get la première lettre du pseudo.
						lab_lettre1.setForeground(Color.WHITE);
						lab_lettre1.setHorizontalAlignment(JLabel.CENTER);
						lab_lettre1.setPreferredSize(new Dimension(200, 200));
					logo.add(lab_lettre1,BorderLayout.CENTER);
					subs_clicks.setBounds(((largeur-300)/3)/2-100, 50+120, 200, 50);
					subs_clicks.setLayout(null);
						tot_clicks_subs.setFont(new Font("Arial", Font.PLAIN, 12));
						tot_clicks_subs.setText("10 000 00"+MainClient.Total_Clicks_Subs);
						tot_clicks_subs.setForeground(Color.gray);
						tot_clicks_subs.setHorizontalAlignment(JLabel.CENTER);
						tot_clicks_subs.setBounds(98, 40/2+4, 100, 16);
					subs_clicks.add(tot_clicks_subs);
				csc_c_c_left.add(logo);
				csc_c_c_left.add(subs_clicks);
				csc_c_c_center.setPreferredSize(new Dimension((largeur-245)/3,hauteur));
				csc_c_c_right.setPreferredSize(new Dimension((largeur-300)/3,hauteur));
			csc_c_center.add(csc_c_c_left,BorderLayout.WEST);
			csc_c_center.add(csc_c_c_center,BorderLayout.CENTER);
			csc_c_center.add(csc_c_c_right,BorderLayout.EAST);
			//setSubsClicksPage();
						
		csc_center.add(csc_c_north,BorderLayout.NORTH);
		csc_center.add(csc_c_center,BorderLayout.CENTER);
		csc_c_north.add(lab_sc);
		csc_c_north.add(lab_scInfo);
	center_subsclick.add(csc_west,BorderLayout.WEST);
	center_subsclick.add(csc_east,BorderLayout.EAST);
	center_subsclick.add(csc_north,BorderLayout.NORTH);
	center_subsclick.add(csc_center,BorderLayout.CENTER);
	
	/*
	 * End Subscribers_Clikers
	 * Start Game
	 */
	
	content.add(haut, BorderLayout.NORTH);
	content.add(west, BorderLayout.WEST);
	
	content.setPreferredSize(new Dimension(largeur, hauteur));

	this.setContentPane(content);
	this.setVisible(true);	
	
	boutonAcc.setEnabled(false);
	content.add(center,BorderLayout.CENTER);
	test=1;

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
	
	public static void resetPlanningPage(){
		cp_c_c_c_1.removeAll();
		cp_c_c_c_2.removeAll();
		cp_c_c_c_1_center.removeAll();
		cp_c_c_c_2_center.removeAll();
		cp_c_c_c_right.removeAll();
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
		setPlanningPage();
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
	
	public static String ColId (Integer i){
		String s = "f";
		if (i==1){
			s="1";
		}if (i==2){
			s="2";
		}if (i==3){
			s="e";
		}if (i==4){
			s="2";
		}if (i==5){
			s="b";
		}if (i==6){
			s="9";
		}if (i==7){
			s="d";
		}if (i==8){
			s="6";
		}if (i==9){
			s="6";
		}
		return s;
	}
	public static String ActivityId (Integer i, Long l){
		String s = "Glandouillette";
		String name = "";
		if (i==1){
			s="Travail";
		}if (i==2){
			for (int a = 0;a<MainClient.videos.size();a++){
				if (MainClient.videos.get(a).getID()==l){
					name = MainClient.videos.get(a).getName();
				}
			}
			s="Nouvelle vidéo \""+name+"\"";
		}if (i==3){
			for (int a = 0;a<MainClient.videos.size();a++){
				if (MainClient.videos.get(a).getID()==l){
					name = MainClient.videos.get(a).getName();
				}
			}
			s="Écriture \""+name+"\"";
		}if (i==4){
			for (int a = 0;a<MainClient.videos.size();a++){
				if (MainClient.videos.get(a).getID()==l){
					name = MainClient.videos.get(a).getName();
				}
			}
			s="Tournage \""+name+"\"";
		}if (i==5){
			for (int a = 0;a<MainClient.videos.size();a++){
				if (MainClient.videos.get(a).getID()==l){
					name = MainClient.videos.get(a).getName();
				}
			}
			s="Montage \""+name+"\"";
		}if (i==6){
			for (int a = 0;a<MainClient.videos.size();a++){
				if (MainClient.videos.get(a).getID()==l){
					name = MainClient.videos.get(a).getName();
				}
			}
			s="Post-Prod \""+name+"\"";
		}if (i==7){
			s="Jour de paye";
		}if (i==8){
			s="Apprentissage: "+MainClient.categ_list[l.intValue()];
		}if (i==9){
			s="Cours: "+MainClient.categ_list[l.intValue()];
		}
		return s;
	}
	/*
	 * Code couleur !
	 */
	public static Color Col(String i){
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
	
	public String[] list_categ_videos(){
		List<String> list_categ = new ArrayList<String>();
		if (MainClient.player.getLvl_animations_films()>0){
			list_categ.add("ANIMATIONS/FILMS");
		}if (MainClient.player.getLvl_animaux()>0){
			list_categ.add("ANIMAUX");
		}if (MainClient.player.getLvl_divertissement()>0){
			list_categ.add("DIVERTISSEMENT");
		}if (MainClient.player.getLvl_gaming()>0){
			list_categ.add("GAMING");
		}if (MainClient.player.getLvl_humour()>0){
			list_categ.add("HUMOUR");
		}if (MainClient.player.getLvl_makeup_mode()>0){
			list_categ.add("MAKEUP/MODE");
		}if (MainClient.player.getLvl_musique()>0){
			list_categ.add("MUSIQUE");
		}if (MainClient.player.getLvl_sciences()>0){
			list_categ.add("SCIENCES");
		}if (MainClient.player.getLvl_sport()>0){
			list_categ.add("SPORT");
		}if (MainClient.player.getLvl_cuisine()>0){
			list_categ.add("CUISINE");
		}
		String[] s = new String[list_categ.size()];
		s = list_categ.toArray(s);
		return s;
	}
	
	public class ClassicButton extends JButton implements MouseListener{
		private String name;
		private Color FOND;
		private Color FONT;
		
		public ClassicButton(String str){
			super(str);
			this.name = str;
			this.FOND=Color.WHITE;
			if (str.equals(""+Fenetre.videopage)){
				this.FOND=Color.decode("#D3D3D3");	
				this.setEnabled(false);
			}
			this.FONT=Color.decode("#424242");
			this.setBorderPainted(false);
			this.addMouseListener(this);
		}
		public void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D)g;
			g2d.setColor(FOND);
			g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
			g2d.setColor(FONT);
			g2d.setFont(new Font("Tahoma", Font.PLAIN, 17));
			FontMetrics fm = g2d.getFontMetrics();
			int height = fm.getHeight();
			//int width = fm.stringWidth(this.name);
			g2d.setRenderingHint(
			        RenderingHints.KEY_TEXT_ANTIALIASING,
			        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g2d.drawString(this.name, 15, (this.getHeight()/2)+(height/4)+1);
			g2d.setColor(Color.decode("#D7D7D7"));
			g2d.drawLine(0, 0, this.getWidth(), 0);
			g2d.drawLine(0, this.getHeight()-1, this.getWidth(), this.getHeight()-1);
			g2d.drawLine(0, 0, 0, this.getHeight());
			g2d.drawLine(this.getWidth()-1, 0, this.getWidth()-1, this.getHeight()-1);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			this.FOND=Color.decode("#D3D3D3");	
			if (!name.contains("Faire une vidéo")){
				int page = Integer.parseInt(name);
				Fenetre.videopage=page;
				cv_c_south.removeAll();
				try {
					Thread.sleep(10);
				} catch (InterruptedException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				setVideosGestionnaire();
				cv_center.add(cv_c_south,BorderLayout.CENTER);
				try{
					content.updateUI();
				}catch(Exception ex){
					System.out.println("Erreur : "+test);
				}
			}
			if (name.contains("Faire une vidéo")){
				cv_c_south.removeAll();
				try {
					Thread.sleep(10);
				} catch (InterruptedException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				setVideosCreator(1);
				cv_center.add(cv_c_south,BorderLayout.CENTER);
				try{
					content.updateUI();
				}catch(Exception ex){
					System.out.println("Erreur : "+test);
				}
			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			this.FOND=Color.decode("#D3D3D3");	
		}
		@Override
		public void mouseExited(MouseEvent e) {
			this.FOND=Color.WHITE;
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
	
	class BoutonToutaffichListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			boutonAcc.setEnabled(true);
			boutonVideoGest.setEnabled(false);
			content.remove(center);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			test=2;
			content.add(center_videos,BorderLayout.CENTER);
			/* Existe-t-il une meilleur méthode ? */
			try{
				content.updateUI();
			}catch(Exception e){
				/* Petit test personnel pour vérifier le bon fonctionnement */
				System.out.println("Erreur : "+test);
			}	
		}
	}
	
	class BoutonAccListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			boutonAcc.setEnabled(false);
			boutonVideoGest.setEnabled(true);
			boutonPlanning.setEnabled(true);
			bouton3.setEnabled(true);
			boutonSubClick.setEnabled(true);
			if (test==3){
				content.remove(center_planning);
			}else if (test==2){
				content.remove(center_videos);
			}else if (test==4){
				content.remove(center_levels);
			}else if (test==5){
				content.remove(center_subsclick);
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
			resetPlanning();
		}
	}
	
	class BoutonPlanningListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			boutonAcc.setEnabled(true);
			boutonPlanning.setEnabled(false);
			boutonVideoGest.setEnabled(true);
			bouton3.setEnabled(true);
			boutonSubClick.setEnabled(true);
			if (test==1){
				content.remove(center);
			}else if (test==2){
				content.remove(center_videos);
			}else if (test==4){
				content.remove(center_levels);
			}else if (test==5){
				content.remove(center_subsclick);
			}
			test=3;
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
			resetPlanningPage();
		}
	}
	
	class BoutonCompetListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			boutonAcc.setEnabled(true);
			boutonVideoGest.setEnabled(true);
			boutonPlanning.setEnabled(true);
			bouton3.setEnabled(false);
			boutonSubClick.setEnabled(true);
			MainClient.access.send("Malimoi password start");
			if (test==1){
				content.remove(center);
			}
			else if (test==3){
				content.remove(center_planning);
			}else if (test==2){
				content.remove(center_videos);
			}else if (test==5){
				content.remove(center_subsclick);
			}
			test=4;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cl_c_center.removeAll();
			setLevelsPage();
			content.add(center_levels,BorderLayout.CENTER);
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
			boutonAcc.setEnabled(true);
			boutonVideoGest.setEnabled(false);
			boutonPlanning.setEnabled(true);
			bouton3.setEnabled(true);
			boutonSubClick.setEnabled(true);
			if (test==1){
				content.remove(center);
			}
			else if (test==3){
				content.remove(center_planning);
			}else if (test==4){
				content.remove(center_levels);
			}else if (test==5){
				content.remove(center_subsclick);
			}
			test=2;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cv_c_south.removeAll();
			setVideosGestionnaire();
			content.add(center_videos,BorderLayout.CENTER);
			try{
				content.updateUI();
			}catch(Exception e){
				System.out.println("Erreur : "+test);
			}
			

		}
	}
	
	class BoutonSubsClicksListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			boutonAcc.setEnabled(true);
			boutonVideoGest.setEnabled(true);
			boutonPlanning.setEnabled(true);
			bouton3.setEnabled(true);
			boutonSubClick.setEnabled(false);
			
			if (test==1){
				content.remove(center);
			}else if (test==2){
				content.remove(center_videos);
			}else if (test==3){
				content.remove(center_planning);
			}else if (test==4){
				content.remove(center_levels);
			}
			test=5;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			content.add(center_subsclick,BorderLayout.CENTER);
			try{
				content.updateUI();
			}catch(Exception e){
				System.out.println("Erreur : "+test);
			}
			

		}
	}
	
	public static class EditStepOne implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String s = (String) edit_first_choice.getSelectedItem();
			Boolean v = false;
			Long l = 0L;
			Planning pl = null;
			if (!s.contains("Choix")){
				for (String m : s.split(" ")){
					if (v){
						l=Long.valueOf(m);
						v=false;
					}
					if(m.equals("<hidden")){v=true;}
				}
				for (int i = 0;i<MainClient.planning.size()-1;i++){
					if(MainClient.planning.get(i).getUUID().equals(l)){
						pl=MainClient.planning.get(i);
					}
				}
				edit_first_choice.setEnabled(false);
				edit_but_accept.setEnabled(false);
				EDIT_PLAN_STEP_2(pl);
			}		
		}
		
	}
	
	public static class EditStepTwo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ArrayList<Integer> ar = new ArrayList<Integer>();
			String s = (String) edit_hour_start.getSelectedItem();
			String s2 = (String) edit_hour_end.getSelectedItem();
			String sd = (String) edit_date_box.getSelectedItem();
			Boolean v = false;
			Long l = 0L;
			Planning pl = null;
			Integer h1 = 0;
			Integer h2 = 0;
			Integer day = 0;
			Integer month = 0;
			Integer year = 0;

			day=Integer.valueOf(sd.split(" ")[0]);
			month=Integer.valueOf(sd.split(" ")[2]);
			year=Integer.valueOf(sd.split(" ")[4]);
			
			if (!s.contains("Choix")){
				for (String m : s.split(" ")){
					if (v){
						l=Long.valueOf(m);
						v=false;
					}
					if(m.equals("<hidden")){v=true;}
				}
				for (int i = 0;i<MainClient.planning.size()-1;i++){
					if(MainClient.planning.get(i).getUUID().equals(l)){
						pl=MainClient.planning.get(i);
					}
				}
				for (int a = 0;a<MainClient.planning.size();a++){
					if (a!=MainClient.planning.size()-1 && MainClient.planning.get(a).getDay()==day &&
							MainClient.planning.get(a).getMonth()==month && MainClient.planning.get(a).getYear()==year && 
							MainClient.planning.get(a)!=pl){
						for (int x = MainClient.planning.get(a).getHour_start();x<MainClient.planning.get(a).getHour();x++){
							ar.add(x);
						}
					}
				}
				String si = s.split(" ")[1].replace("h", "");
				Integer hour = Integer.valueOf(si);
				h1=hour;
				if (ar.contains(hour)){
					edit_hour_start.setBackground(Col("c"));
				}else{
					edit_hour_start.setBackground(Color.decode("#C4FECA"));
				}
			}
			ar.clear();
			if (!s2.contains("Choix")){
				for (String m : s2.split(" ")){
					if (v){
						l=Long.valueOf(m);
						v=false;
					}
					if(m.equals("<hidden")){v=true;}
				}
				for (int i = 0;i<MainClient.planning.size()-1;i++){
					if(MainClient.planning.get(i).getUUID().equals(l)){
						pl=MainClient.planning.get(i);
					}
				}
				for (int a = 0;a<MainClient.planning.size();a++){
					if (a!=MainClient.planning.size()-1 && MainClient.planning.get(a).getDay()==day &&
							MainClient.planning.get(a).getMonth()==month && MainClient.planning.get(a).getYear()==year &&
							MainClient.planning.get(a)!=pl){
						for (int x = MainClient.planning.get(a).getHour_start()+1;x<MainClient.planning.get(a).getHour();x++){
							ar.add(x);
						}
					}
				}
				String si = s2.split(" ")[1].replace("h", "");
				Integer hour = Integer.valueOf(si);
				h2=hour;
				if (ar.contains(hour)){
					edit_hour_end.setBackground(Col("c"));
				}else{
					edit_hour_end.setBackground(Color.decode("#C4FECA"));
				}
			}
			if (h1>=h2){
				edit_hour_end.setBackground(Col("c"));
				edit_hour_start.setBackground(Col("c"));
			}
			for (int d = h1;d<=h2;d++){
				if (ar.contains(d)){
					edit_hour_end.setBackground(Col("c"));
				}
			}
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_YEAR, 0); // <--
			Date date = cal.getTime();
			SimpleDateFormat formater = new SimpleDateFormat("HH/dd");
			String st = formater.format(date);
			String[] sf = st.split("/");
			if (Integer.valueOf(sf[0])>=pl.getHour_start()-2&&day==Integer.valueOf(sf[1])){
				edit_hour_end.setBackground(Col("c"));
				edit_hour_start.setBackground(Col("c"));
			}
			/*
			 * Vérification du côté client. Le serveur vérifira aussi. En cas d'erreur,
			 * le joueur sera banni 1 an du mode online automatiquement.
			 */
			if (edit_hour_end.getBackground().equals(Color.decode("#C4FECA"))&&
					edit_hour_start.getBackground().equals(Color.decode("#C4FECA"))){
				for (int a = 0;a<MainClient.planning.size();a++){
					if (a!=MainClient.planning.size()-1 && MainClient.planning.get(a)==pl){
						MainClient.planning.get(a).setHour_start(h1);
						MainClient.planning.get(a).setHour(h2);
						MainClient.planning.get(a).setDay(day);
						MainClient.planning.get(a).setMonth(month);
						MainClient.planning.get(a).setYear(year);
						MainClient.TriPlanning();
						resetPlanningPage();
					}
				}
			}
		}	
	}
	
	public static class CreateStepOne implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
				String s = (String) create_first_choice.getSelectedItem();
				if (s.contains("video")){
					CREATE_PLAN_STEP_2(1);
				}else if(s.contains("apprentissage")){
					CREATE_PLAN_STEP_2(2);
				}else{
					CREATE_PLAN_STEP_2(3);
				}
		}
		
	}
	
	public static class CreateStepTwo implements ActionListener{
		private Integer i;
		public CreateStepTwo(int i){
			this.i=i;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (i.equals(1)){
				String s = (String) create_2nd_choice.getSelectedItem();
				Boolean v = false;
				Long l = 0L;
				Video vi = null;
				if (!s.contains("Choix")){
					for (String m : s.split(" ")){
						if (v){
							l=Long.valueOf(m);
							v=false;
						}
						if(m.equals("<hidden")){v=true;}
					}
					for (int i = 0;i<MainClient.videos.size();i++){
						if(MainClient.videos.get(i).getID().equals(l)){
							vi=MainClient.videos.get(i);
						}
					}
					create_2nd_choice.setEnabled(false);
					create_2ndbut_accept.setEnabled(false);
					int time;
					/*
					 * A modifier pour plus de sécurité.
					 */
					if (s.contains("ecriture")){
						time=vi.getEcritureRemain();
					}else if (s.contains("tournage")){
						time=vi.getTournageRemain();
					}else if (s.contains("montage")){
						time=vi.getMontageRemain();
					}else if (s.contains("post-production")){
						time=vi.getPostprodRemain();
					}else{
						time=0;
					}
					CREATE_PLAN_STEP_3(i,vi,time);
				}
			}else if (i.equals(2)||i.equals(3)){
				Integer index = (Integer) create_3rd_choice.getSelectedIndex();
				create_3rd_choice.setEnabled(false);
				create_3rdbut_accept.setEnabled(false);
				CREATE_PLAN_STEP_3(i,null,index);		
			}
		}		
	}
	
	public static class CreateStepTwoBis implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {	
			Integer i = (Integer) create_2nd_choice.getSelectedIndex();
			if (!i.equals(0)){
				create_2nd_choice.setEnabled(false);
				create_2ndbut_accept.setEnabled(false);
				CREATE_PLAN_STEP_2bis(i+1);
			}	
		}	
	}
	
	public static class CreateStepThree implements ActionListener{
		private Video vi;
		private Integer type;
		private Integer time;
		public CreateStepThree(Integer type, Video video, Integer time){
			this.vi=video;
			this.type=type;
			this.time=time;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ArrayList<Integer> ar = new ArrayList<Integer>();
			String s = (String) create_hour_start.getSelectedItem();
			String s2 = (String) create_hour_end.getSelectedItem();
			String sd = (String) create_date_box.getSelectedItem();
			Boolean v = false;
			Long l = 0L;
			Planning pl = null;
			Integer h1 = 0;
			Integer h2 = 0;
			Integer day = 0;
			Integer month = 0;
			Integer year = 0;

			day=Integer.valueOf(sd.split(" ")[0]);
			month=Integer.valueOf(sd.split(" ")[2]);
			year=Integer.valueOf(sd.split(" ")[4]);
			
			Integer status = 0;
			if (type==1){
				status = getStatus(vi);
			}		
			if (status!=5){
				if (!s.contains("Choix")){
					for (int a = 0;a<MainClient.planning.size();a++){
						if (a!=MainClient.planning.size()-1 && MainClient.planning.get(a).getDay()==day &&
								MainClient.planning.get(a).getMonth()==month && MainClient.planning.get(a).getYear()==year){
							for (int x = MainClient.planning.get(a).getHour_start();x<MainClient.planning.get(a).getHour();x++){
								ar.add(x);
							}
						}
					}
					String si = s.split(" ")[1].replace("h", "");
					Integer hour = Integer.valueOf(si);
					h1=hour;
					if (ar.contains(hour)){
						create_hour_start.setBackground(Col("c"));
						return;
					}else{
						create_hour_start.setBackground(Color.decode("#C4FECA"));
					}
				}
				ar.clear();
				if (!s2.contains("Choix")){
					for (int a = 0;a<MainClient.planning.size();a++){
						if (a!=MainClient.planning.size()-1 && MainClient.planning.get(a).getDay()==day &&
								MainClient.planning.get(a).getMonth()==month && MainClient.planning.get(a).getYear()==year){
							for (int x = MainClient.planning.get(a).getHour_start()+1;x<MainClient.planning.get(a).getHour();x++){
								ar.add(x);
							}
						}
					}
					String si = s2.split(" ")[1].replace("h", "");
					Integer hour = Integer.valueOf(si);
					h2=hour;
					if (ar.contains(hour)){
						create_hour_end.setBackground(Col("c"));
						return;
					}else{
						create_hour_end.setBackground(Color.decode("#C4FECA"));
					}
				}
				if (h1>=h2){
					create_hour_end.setBackground(Col("c"));
					create_hour_start.setBackground(Col("c"));
					return;
				}if ((h2-h1)>time && type.equals(1)){
					create_hour_end.setBackground(Col("c"));
					create_hour_start.setBackground(Col("c"));
					return;
				}
				for (int d = h1;d<=h2;d++){
					if (ar.contains(d)){
						create_hour_end.setBackground(Col("c"));
						return;
					}
				}
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DAY_OF_YEAR, 0); // <--//
				Date date = cal.getTime();
				//dddd
				SimpleDateFormat formater = new SimpleDateFormat("HH/dd");
				String st = formater.format(date);
				String[] sf = st.split("/");
				if (Integer.valueOf(sf[0])>=h1-2&&day==Integer.valueOf(sf[1])){
					create_hour_end.setBackground(Col("c"));
					create_hour_start.setBackground(Col("c"));
					return;
				}
				/*
				 * Vérification du côté client. Le serveur vérifira aussi. En cas d'erreur,
				 * le joueur sera banni 1 an du mode online automatiquement.
				 */
				//if (create_hour_end.getBackground().equals(Color.decode("#C4FECA"))&&
						//create_hour_start.getBackground().equals(Color.decode("#C4FECA"))){
					if (type.equals(1)){
						
							MainClient.planning.add(new Planning(h1, h2, day, month, year, status+3, vi.getID(), (long)MainClient.planning.size()));
							for (int v2 = 0;v2<MainClient.videos.size();v2++){
								if (MainClient.videos.get(v2).getID()==vi.getID()){
									if (status.equals(0)){
										MainClient.videos.get(v2).setEcritureRemain(h2-h1-MainClient.videos.get(v2).getEcritureRemain());
									}else if(status.equals(1)){
										MainClient.videos.get(v2).setTournageRemain(h2-h1-MainClient.videos.get(v2).getTournageRemain());
									}else if(status.equals(2)){
										MainClient.videos.get(v2).setMontageRemain(h2-h1-MainClient.videos.get(v2).getMontageRemain());
									}else{
										MainClient.videos.get(v2).setPostprodRemain(h2-h1-MainClient.videos.get(v2).getPostprodRemain());
									}
								}
							}
							
						}				
					else if (type.equals(2)||type.equals(3)){
						MainClient.planning.add(new Planning(h1, h2, day, month, year, 6+type, (long)time, (long)MainClient.planning.size()));
					}
					MainClient.TriPlanning();
					
				//}
			}else{
				for (int v2 = 0;v2<MainClient.videos.size();v2++){
					if (MainClient.videos.get(v2).getID()==vi.getID()){
						MainClient.videos.get(v2).setTournageRemain(-1);
					}
				}
				MainClient.evenements.add(new Evenement(day, month, year, 2, vi.getID()));
				MainClient.TriEvents();
			}
			resetPlanningPage();
		}		
	}
	
	public class VideoCreatorSlidEvent implements ActionListener{
		
		private Integer step;
		
		public VideoCreatorSlidEvent(Integer step){
			this.step=step;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(step.equals(1)){
				char[] titre_chars = enter_titre.getText().toCharArray();
				if (titre_chars.length>30){
					JLabel error = new JLabel();
					error.setFont(new Font("Tahoma", Font.PLAIN, 15));
					error.setText("30 caractères max !");
					error.setForeground(Col("c"));
					error.setHorizontalAlignment(JLabel.LEFT);
					error.setBounds(25+300+8, 55+25+8, 300, 20);
					cv_c_south.add(error);
					cv_c_south.updateUI();
					return;
				}if (titre_chars.length<3){
					JLabel error = new JLabel();
					error.setFont(new Font("Tahoma", Font.PLAIN, 15));
					error.setText("3 caractères min !");
					error.setForeground(Col("c"));
					error.setHorizontalAlignment(JLabel.LEFT);
					error.setBounds(25+300+8, 55+25+8, 300, 20);
					cv_c_south.add(error);
					cv_c_south.updateUI();
					return;
				}
				boolean v = false;
				long l = 0;
				Accessoire cam = null;
				String s = (String) camerascombo.getSelectedItem();
				for (String m : s.split(" ")){
					if (v){
						l=Long.valueOf(m);
						v=false;
					}
					if(m.equals("<hidden")){v=true;}
				}
				for (int i = 0;i<MainClient.cameras.size();i++){
					if(MainClient.cameras.get(i).getID()==l){
						cam=(Camera) MainClient.cameras.get(i);
					}
				}
				v = false;
				l = 0;
				Accessoire micro = null;
				String s1 = (String) microscombo.getSelectedItem();
				for (String m : s1.split(" ")){
					if (v){
						l=Long.valueOf(m);
						v=false;
					}
					if(m.equals("<hidden")){v=true;}
				}
				for (int i = 0;i<MainClient.cameras.size();i++){
					if(MainClient.cameras.get(i).getID()==l){
						micro=(Micro) MainClient.cameras.get(i);
					}
				}
				try{
					String categorie = categoriescombo.getSelectedItem().toString();
					MainClient.videos.add(new Video(enter_titre.getText(), 0, 0, 0, 0L, 0L, 0L, 0L, categorie.contains("/")?categorie.replace("/", "_"):categorie, 0,
							cam, micro, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (long)MainClient.videos.size()));
					
					/*
					 * On tri.
					 */
					MainClient.TriVideos();
					cv_c_south.removeAll();
					setVideosCreator(2);
				}catch(Exception ex){
					System.out.println("(error) no categories");
				}			
				
			}else if(step.equals(2)){
				MainClient.videos.get(0).setEcritureTime(ecrituretimeslid.getValue());
				MainClient.videos.get(0).setTournageTime(tournagetimeslid.getValue());
				MainClient.videos.get(0).setMontageTime(montagetimeslid.getValue());
				MainClient.videos.get(0).setPostprodTime(postprodtimeslid.getValue());
				MainClient.videos.get(0).setEcritureRemain(ecrituretimeslid.getValue());
				MainClient.videos.get(0).setTournageRemain(tournagetimeslid.getValue());
				MainClient.videos.get(0).setMontageRemain(montagetimeslid.getValue());
				MainClient.videos.get(0).setPostprodRemain(postprodtimeslid.getValue());
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
		Integer day = 0;
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
			
			if (d==1){
				day=Integer.valueOf(sf[2]);
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
				while(plan){
					if (MainClient.planning.size()-1==i){
						plan=false;
					}
					else if (MainClient.planning.get(i).getHour()<=Integer.parseInt(sf[3]) && Integer.parseInt(sf[2])==MainClient.planning.get(i).getDay()){
							MainClient.planning.remove(i);
					}
					i++;
				}
				i=0;
				plan=true;
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
				if (MainClient.evenements.size()-1==i){
					plan=false;
				}
				else{
						if (MainClient.evenements.get(i).getDay()==Integer.parseInt(sf[2])){
							JPanel panel = new COLOR(Col(ColId(MainClient.evenements.get(i).getId())));
							panel.setBounds(0, TotalNotifY, (((largeur-255)-15-(largeur-255)/4))/2, 17);
							TotalNotifY=TotalNotifY+15+5;
							panel.setLayout(new BorderLayout());
							JPanel nordd = new COLOR(Col(ColId(MainClient.evenements.get(i).getId())));
							nordd.setPreferredSize(new Dimension(largeur,1));
							JPanel sudd = new COLOR(Col(ColId(MainClient.evenements.get(i).getId())));
							sudd.setPreferredSize(new Dimension(largeur,1));
							JPanel westt = new COLOR(Col(ColId(MainClient.evenements.get(i).getId())));
							westt.setPreferredSize(new Dimension(5,hauteur));
							JPanel centerr = new COLOR(Col(ColId(MainClient.evenements.get(i).getId())));
							//centerr.setPreferredSize(new Dimension(largeur,hauteur));
							panel.add(nordd,BorderLayout.NORTH);
							panel.add(sudd,BorderLayout.SOUTH);
							panel.add(westt,BorderLayout.WEST);
							centerr.setLayout(new BorderLayout());
							
							JLabel label = new JLabel();
							label.setFont(new Font("Tahoma", Font.PLAIN, 15));
							label.setText(ActivityId(MainClient.evenements.get(i).getId(),MainClient.evenements.get(i).getData()));
							label.setForeground(Color.WHITE);
							label.setHorizontalAlignment(JLabel.LEFT);
							
							centerr.add(label, BorderLayout.CENTER);
							panel.add(centerr,BorderLayout.CENTER);
							c_c_nt_center.add(panel);
							System.out.println("(1-e) Jour égal à l'index : day "+MainClient.evenements.get(i).getDay());
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
				if (MainClient.planning.size()-1==i){
					plan=false;
				}
				else{
						if (MainClient.planning.get(i).getDay()==Integer.parseInt(sf[2])){
							Color c = Color.decode("#DCDCDC");
							if (encours==true){
								if (MainClient.planning.get(i).getHour_start()<=Integer.valueOf(sf[3])&&MainClient.planning.get(i).getDay()==day){
									c = Color.decode("#C4FECA");
								}else{
									c = Color.decode("#FBE369");
								}
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
							
							JPanel color = new COLOR(Col(ColId(MainClient.planning.get(i).getId())));
							color.setBounds(0, 0, (50-5-5)/2, (50-5-5)/2);
							
							JLabel label_name = new JLabel();
							label_name.setFont(new Font("Tahoma", Font.PLAIN, 18));
							label_name.setText(ActivityId(MainClient.planning.get(i).getId(),MainClient.planning.get(i).getData()));
							label_name.setForeground(Color.DARK_GRAY);
							label_name.setHorizontalAlignment(JLabel.LEFT);
							label_name.setBounds((50-5-5)/2+5, 0, largeur, (50-5-5)/2);
							
							JLabel label_hours = new JLabel();
							label_hours.setFont(new Font("Tahoma", Font.PLAIN, 12));
							String HourEnd = MainClient.planning.get(i).getHour() < 22 ? ""+MainClient.planning.get(i).getHour()+":00" : "<font color=red>"+
									MainClient.planning.get(i).getHour()+":00 <i>(rique de fatigue !)</i></font>";
							label_hours.setText("<html>"+MainClient.planning.get(i).getHour_start()+":00 à "+HourEnd+"</html>");
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
							System.out.println("(1) Jour égal à l'index : "+MainClient.planning.get(i).getHour_start()+" -> "+MainClient.planning.get(i).getHour()
									+" : day "+MainClient.planning.get(i).getDay());
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
		
		SimpleDateFormat formater = null;
		Date now = new Date();
		formater = new SimpleDateFormat("yy/MM/dd/HH/EEEE/MMMM/MMM");
		String s = formater.format(now);
		String[] sf = s.split("/");
		
		Boolean vid = true;
		int i = 0;
		int p =0;
		
		while(vid){
			if (MainClient.videos.size()-1==i || p == 5){
				vid=false;
			}else{
				if (MainClient.videos.get(i).getYear()>Integer.parseInt(sf[0])){

				}
				else if (MainClient.videos.get(i).getMonth()>Integer.parseInt(sf[1])){
					
				}
				else if (MainClient.videos.get(i).getDay()>Integer.parseInt(sf[2])){
					
				}else{
					JPanel miniature = new MINIA("image/CLASSES/"+MainClient.videos.get(i).getVideogenre()+".png");
					miniature.setBounds(0, TotalNotifY, 165, 95);
					JLabel titre = new JLabel();
					titre.setFont(new Font("Tahoma", Font.PLAIN, 18));
					titre.setText(MainClient.videos.get(i).getName());
					titre.setForeground(Color.GRAY);
					titre.setHorizontalAlignment(JLabel.LEFT);
					titre.setBounds(182, TotalNotifY+5, (((largeur-255)-15-(largeur-255)/4))/2, 18);
					JPanel views = new MINI("image/views.png");
					views.setBounds(180,TotalNotifY+(95-(30+35)),25,25);
					JLabel nbviews = new JLabel();
					nbviews.setFont(new Font("Tahoma", Font.PLAIN, 16));
					nbviews.setText(MainClient.videos.get(i).getViews()+"");
					nbviews.setForeground(Color.GRAY);
					nbviews.setHorizontalAlignment(JLabel.LEFT);
					nbviews.setBounds(180+30, TotalNotifY+(95-(30+35))+5, (((largeur-255)-15-(largeur-255)/4))/2, 16);
					JPanel shares = new MINI("image/Shares.png");
					shares.setBounds(275,TotalNotifY+(95-(30+35)),25,25);
					JLabel nbshares = new JLabel();
					nbshares.setFont(new Font("Tahoma", Font.PLAIN, 16));
					nbshares.setText(MainClient.videos.get(i).getShare()+"");
					nbshares.setForeground(Color.GRAY);
					nbshares.setHorizontalAlignment(JLabel.LEFT);
					nbshares.setBounds(275+30, TotalNotifY+(95-(30+35))+5, (((largeur-255)-15-(largeur-255)/4))/2, 16);
					JPanel likes = new MINI("image/likes.png");
					likes.setBounds(180,TotalNotifY+(95-30),25,25);
					JLabel nblikes = new JLabel();
					nblikes.setFont(new Font("Tahoma", Font.PLAIN, 16));
					nblikes.setText(MainClient.videos.get(i).getLikes()+"");
					nblikes.setForeground(Color.GRAY);
					nblikes.setHorizontalAlignment(JLabel.LEFT);
					nblikes.setBounds(180+30, TotalNotifY+(95-30)+5, (((largeur-255)-15-(largeur-255)/4))/2, 16);
					JPanel dislikes = new MINI("image/dislikes.png");
					dislikes.setBounds(275,TotalNotifY+(95-30),25,25);
					JLabel nbdis = new JLabel();
					nbdis.setFont(new Font("Tahoma", Font.PLAIN, 16));
					nbdis.setText(MainClient.videos.get(i).getDislikes()+"");
					nbdis.setForeground(Color.GRAY);
					nbdis.setHorizontalAlignment(JLabel.LEFT);
					nbdis.setBounds(275+30, TotalNotifY+(95-30)+5, (((largeur-255)-15-(largeur-255)/4))/2, 16);
					
					c_c_vp_center.add(miniature);
					c_c_vp_center.add(titre);
					c_c_vp_center.add(nbviews);
					c_c_vp_center.add(shares);
					c_c_vp_center.add(nbshares);
					c_c_vp_center.add(nblikes);
					c_c_vp_center.add(nbdis);
					c_c_vp_center.add(views);
					c_c_vp_center.add(likes);
					c_c_vp_center.add(dislikes);
					TotalNotifY=TotalNotifY+95+15;
					p++;
				}
				i++;
			}	
		}
		int b = 1;
		
		for (int g = 0;g<MainClient.videos.size()-1;g++){
			if (g%5==0&&g!=0){
				b++;
			}
		}
		System.out.println("B: "+b+" ("+(MainClient.videos.size()-1)+") + I:"+i);
		
		c_c_vp_south.setLayout(null);
		vid_affich.setBounds(0, 0, 500, 50);
		c_c_vp_south.add(vid_affich);
		TotalNotifY=TotalNotifY+50;
		//c_c_vp_center.add(c_c_vp_south);
		c_c_vp_center.add(lab_c_c_vp_c_name);
		c_c_videospannel.setBounds((((largeur-255)-15-(largeur-255)/4))/2+15, 12+80, (((largeur-255)-15-(largeur-255)/4))/2, TotalNotifY+5);
	}
	
	public void setVideosGestionnaire(){
		int TotalNotifY=20;
		
		SimpleDateFormat formater = null;
		Date now = new Date();
		formater = new SimpleDateFormat("yy/MM/dd/HH/EEEE/MMMM/MMM");
		String s = formater.format(now);
		String[] sf = s.split("/");
		
		Boolean vid = true;
		/*
		 * A faire : calculer la hauteur pour savoir cb de vidéos peut-on afficher par page.
		 */
		int i = (videopage-1)*5;
		int p = (videopage-1)*5;
		while(vid){
			if (MainClient.videos.size()-1==i || p==videopage*5){
				vid=false;
			}else{

					JPanel miniature = new MINIA("image/CLASSES/"+MainClient.videos.get(i).getVideogenre()+".png");
					miniature.setBounds(50, TotalNotifY, 165, 95);
					JLabel titre = new JLabel();
					titre.setFont(new Font("Tahoma", Font.PLAIN, 18));
					titre.setText(MainClient.videos.get(i).getName());
					titre.setForeground(Color.DARK_GRAY);
					titre.setHorizontalAlignment(JLabel.LEFT);
					titre.setBounds(182+50, TotalNotifY+5, (((largeur-255)-15-(largeur-255)/4))/2, 18);
					JLabel publie = new JLabel();
					publie.setFont(new Font("Tahoma", Font.PLAIN, 15));
					if (!(MainClient.videos.get(i).getYear()<Integer.parseInt(sf[0])) && !(MainClient.videos.get(i).getMonth()<Integer.parseInt(sf[1]))
							&& (MainClient.videos.get(i).getDay()>Integer.parseInt(sf[2]))){
						publie.setText("<html><font color=red>PLANIFIÉE POUR LE "+Zero(MainClient.videos.get(i).getDay())+"/"+Zero(MainClient.videos.get(i).getMonth())+"/"+Zero(MainClient.videos.get(i).getYear())+"</font></html>");
					}
					else{
						publie.setText("PUBLIÉE LE "+Zero(MainClient.videos.get(i).getDay())+"/"+Zero(MainClient.videos.get(i).getMonth())+"/"+Zero(MainClient.videos.get(i).getYear()));
					}
					
					publie.setForeground(Color.GRAY);
					publie.setHorizontalAlignment(JLabel.LEFT);
					publie.setBounds(182+50, TotalNotifY+5+26, (((largeur-255)-15-(largeur-255)/4))/2, 18);
					JPanel views = new MINI("image/views.png");
					views.setBounds((largeur-225-20)-200,TotalNotifY+(95-(30+35+35)+4),25,25);
					JLabel nbviews = new JLabel();
					nbviews.setFont(new Font("Tahoma", Font.PLAIN, 16));
					nbviews.setText(MainClient.videos.get(i).getViews()+"");
					nbviews.setForeground(Color.GRAY);
					nbviews.setHorizontalAlignment(JLabel.LEFT);
					nbviews.setBounds((largeur-225-20)-170, TotalNotifY+(95-(30+35+35)+4)+5, (((largeur-255)-15-(largeur-255)/4))/2, 16);
					JPanel likes = new MINI("image/likes.png");
					likes.setBounds((largeur-225-20)-200,TotalNotifY+(95-30-35),25,25);
					JLabel nblikes = new JLabel();
					nblikes.setFont(new Font("Tahoma", Font.PLAIN, 16));
					nblikes.setText(MainClient.videos.get(i).getLikes()+"");
					nblikes.setForeground(Color.GRAY);
					nblikes.setHorizontalAlignment(JLabel.LEFT);
					nblikes.setBounds((largeur-225-20)-170, TotalNotifY+(95-30-35)+5, (((largeur-255)-15-(largeur-255)/4))/2, 16);
					JPanel dislikes = new MINI("image/dislikes.png");
					dislikes.setBounds((largeur-225-20)-115,TotalNotifY+(95-30-35),25,25);
					JLabel nbdis = new JLabel();
					nbdis.setFont(new Font("Tahoma", Font.PLAIN, 16));
					nbdis.setText(MainClient.videos.get(i).getDislikes()+"");
					nbdis.setForeground(Color.GRAY);
					nbdis.setHorizontalAlignment(JLabel.LEFT);
					nbdis.setBounds((largeur-225-20)-85, TotalNotifY+(95-30-35)+5, (((largeur-255)-15-(largeur-255)/4))/2, 16);
					JPanel shares = new MINI("image/Shares.png");
					shares.setBounds((largeur-225-20)-200,TotalNotifY+(95-34),25,25);
					JLabel nbshares = new JLabel();
					nbshares.setFont(new Font("Tahoma", Font.PLAIN, 16));
					nbshares.setText(MainClient.videos.get(i).getShare()+"");
					nbshares.setForeground(Color.GRAY);
					nbshares.setHorizontalAlignment(JLabel.LEFT);
					nbshares.setBounds((largeur-225-20)-170, TotalNotifY+(95-34)+5, (((largeur-255)-15-(largeur-255)/4))/2, 16);
					
					cv_c_south.add(miniature);
					cv_c_south.add(titre);
					cv_c_south.add(publie);
					cv_c_south.add(nbviews);
					cv_c_south.add(nblikes);
					cv_c_south.add(nbdis);
					cv_c_south.add(views);
					cv_c_south.add(likes);
					cv_c_south.add(dislikes);
					cv_c_south.add(shares);
					cv_c_south.add(nbshares);
					TotalNotifY=TotalNotifY+95+20;
					
					p++;
					
				}
				i++;
				
		}
		int b = 1;
		for (int g =0;g<MainClient.videos.size()-1;g++){
			if (g%5==0&&g!=0){
				b++;
			}
		}
		int TotalX = 50;
		for (int bu = 0;bu<b;bu++){
			JButton buttonpage = new ClassicButton(""+(bu+1));
			buttonpage.setBounds(TotalX, TotalNotifY, 40, 40);
			cv_c_south.add(buttonpage);
			TotalX=TotalX+50;
		}
	}
	
	@SuppressWarnings({ "unchecked"})
	public void setVideosCreator(Integer number_of_step){
		
		JLabel step = new JLabel();
		step.setFont(new Font("Tahoma", Font.PLAIN, 35));
		step.setText("Étape "+number_of_step+":");
		step.setForeground(Color.DARK_GRAY);
		step.setHorizontalAlignment(JLabel.LEFT);
		step.setBounds(25, 10, 150, 39);
		cv_c_south.add(step);
		
		if (number_of_step.equals(1)){
			
			JLabel titre = new JLabel();
			titre.setFont(new Font("Tahoma", Font.PLAIN, 15));
			titre.setText("Choisissez le titre: (30 caractères max)");
			titre.setForeground(Color.DARK_GRAY);
			titre.setHorizontalAlignment(JLabel.LEFT);
			titre.setBounds(25, 55, 300, 20);
			cv_c_south.add(titre);
			JPanel border = new JPanel();
			border.setBackground(Color.DARK_GRAY);
			border.setBounds(25, 55+20+5, 300, 35);
			border.setLayout(null);
			JPanel int_border = new JPanel();
			int_border.setBackground(Color.white);
			int_border.setBounds(1, 1, 300-2, 35-2);
			int_border.setLayout(null);
			enter_titre = new JTextArea();
			enter_titre.setFont(new Font("Tahoma", Font.PLAIN, 15));
			enter_titre.setBounds(0, 7, 300-2, 20);
			int_border.add(enter_titre);
			border.add(int_border);
			cv_c_south.add(border);
			JLabel lab_1 = new JLabel();
			lab_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lab_1.setText("Choisissez une catégorie:");
			lab_1.setForeground(Color.DARK_GRAY);
			lab_1.setHorizontalAlignment(JLabel.LEFT);
			lab_1.setBounds(25, 55+40+25+10, 175, 20);
			cv_c_south.add(lab_1);
			String[] Name_Of_Styles = list_categ_videos();
			categoriescombo = new JComboBox(Name_Of_Styles);
			categoriescombo.setBounds(25, 75+40+25+10, 175, 50);
			cv_c_south.add(categoriescombo);
			JLabel lab_f = new JLabel();
			lab_f.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lab_f.setText("Définissez la longueur:");
			lab_f.setForeground(Color.DARK_GRAY);
			lab_f.setHorizontalAlignment(JLabel.LEFT);
			lab_f.setBounds(25, 75+40+25+50+20, 175, 20);
			cv_c_south.add(lab_f);
			String[] Format = {"<html><b>Mini</b> (Moins de 0:30)</html>","<html><b>Très courte</b> (de 0:31 à 2:00)</html>","<html><b>Courte</b> (de 2:01 à 5:00)</html>",
					"<html><b>Moyenne</b> (de 5:01 à 10:00)</html>","<html><b>Longue</b> (de 10:01 à 30:00)</html>","<html><b>Très longue</b> (de 30:01 à 1:00:00)</html>",
					"<html><b>Enorme</b> (Plus de 1:00:01)</html>"};
			formatscombo = new JComboBox(Format);
			formatscombo.setBounds(25, 75+40+25+50+25+20, 200, 50);
			cv_c_south.add(formatscombo);
			JLabel lab_2 = new JLabel();
			lab_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lab_2.setText("Choisissez votre caméra:");
			lab_2.setForeground(Color.DARK_GRAY);
			lab_2.setHorizontalAlignment(JLabel.LEFT);
			lab_2.setBounds(25, 75+40+25+50+25+50+30, 175, 20);
			cv_c_south.add(lab_2);
			ArrayList<String> ar = new ArrayList<String>();
			ar.add("<html><font color=red>Pas de caméra</font></html>");
			for (int a = 0;a<MainClient.cameras.size();a++){		
					ar.add("<html>"+MainClient.cameras.get(a).getName()+" <hidden "+MainClient.cameras.get(a).getID()+" /> </html>");
			}
			String[] CamerasList = new String[ar.size()];
			CamerasList = ar.toArray(CamerasList);
			camerascombo = new JComboBox(CamerasList);
			camerascombo.setBounds(25, 75+40+25+50+25+25+50+30, 200, 50);
			cv_c_south.add(camerascombo);
			JLabel lab_3 = new JLabel();
			lab_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lab_3.setText("Choisissez votre micro:");
			lab_3.setForeground(Color.DARK_GRAY);
			lab_3.setHorizontalAlignment(JLabel.LEFT);
			lab_3.setBounds(25+200+50, 75+40+25+50+25+50+30, 175, 20);
			cv_c_south.add(lab_3);
			String[] MicrosList = { "<html><font color=red>Pas de micro</font></html>","Micro intégré" };
			microscombo = new JComboBox(MicrosList);
			microscombo.setBounds(25+200+50, 75+40+25+50+25+25+50+30, 200, 50);
			cv_c_south.add(microscombo);
			
			JButton valid = new JButton("Valider");
			valid.setBounds(25, 80+75*4, 80, 40);
			valid.addActionListener(new VideoCreatorSlidEvent(1));
			cv_c_south.add(valid);
			
		}
		else if (number_of_step.equals(2)){
			
			String[] name = { "Écriture","Tournage","Montage","Post-prod." } ;
			String categ="";
			for (int a = 0;a<MainClient.videos.size()-1;a++){
				if (MainClient.videos.get(a).getID()==MainClient.videos.size()-1){
					categ=MainClient.videos.get(a).getVideogenre();
				}
			}
			for (int a = 0;a<4;a++){
				JPanel color = new JPanel();
				color.setBackground(Col(ColId(a+3)));
				color.setBounds(25, 80+75*(a), 50, 50);
				cv_c_south.add(color);
				JLabel label = new JLabel();
				label.setFont(new Font("Tahoma", Font.PLAIN, 25));
				label.setText(name[a]);
				label.setForeground(Color.DARK_GRAY);
				label.setHorizontalAlignment(JLabel.LEFT);
				label.setBounds(80, 80+75*(a), 120, 29);
				cv_c_south.add(label);
				JLabel H = new JLabel();
				H.setFont(new Font("Tahoma", Font.PLAIN, 15));
				H.setText("(en h)");
				H.setForeground(Color.DARK_GRAY);
				H.setHorizontalAlignment(JLabel.LEFT);
				H.setBounds(80, 110+75*(a), 120, 19);
				cv_c_south.add(H);
				int lvl = 0;
				if (a==0){
					lvl=MainClient.player.getLvl_ecriture();
				}if (a==1){
					lvl=MainClient.Convert_Categ_Lvl(categ);
				}if (a==2){
					lvl=MainClient.player.getLvl_montage();
				}if (a==3){
					lvl=MainClient.player.getLvl_post_prod();
				}
				JLabel lvll = new JLabel();
				lvll.setFont(new Font("Tahoma", Font.PLAIN, 35));
				lvll.setText(lvl+"");
				lvll.setForeground(Color.WHITE);
				lvll.setHorizontalAlignment(JLabel.CENTER);
				color.setLayout(new BorderLayout());
				color.add(lvll,BorderLayout.CENTER);
			}
			
			ecrituretimeslid = new JSlider(JSlider.HORIZONTAL,0,MainClient.player.getLvl_ecriture(),0);
			ecrituretimeslid.setMajorTickSpacing(1);
			ecrituretimeslid.setMinorTickSpacing(1);
			ecrituretimeslid.setPaintTicks(true);
			ecrituretimeslid.setPaintLabels(true); //
			ecrituretimeslid.setBounds(80+115+10,80,MainClient.player.getLvl_ecriture()==1?60:50*MainClient.player.getLvl_ecriture(),50);
			if (MainClient.player.getLvl_ecriture()==0){
				JLabel label = new JLabel();
				label.setFont(new Font("Tahoma", Font.PLAIN, 20));
				label.setText("Vous devez être au moins level 1");
				label.setForeground(Color.GRAY);
				label.setHorizontalAlignment(JLabel.LEFT);
				label.setBounds(80+115+10, 85, 500, 45);
				cv_c_south.add(label);
			}
			tournagetimeslid = new JSlider(JSlider.HORIZONTAL,0,MainClient.Convert_Categ_Lvl(categ),0);
			tournagetimeslid.setMajorTickSpacing(1);
			tournagetimeslid.setMinorTickSpacing(1);
			tournagetimeslid.setPaintTicks(true);
			tournagetimeslid.setPaintLabels(true); //
			tournagetimeslid.setBounds(80+115+10,80+75,MainClient.Convert_Categ_Lvl(categ)==1?60:50*MainClient.Convert_Categ_Lvl(categ),50);
			montagetimeslid = new JSlider(JSlider.HORIZONTAL,0,MainClient.player.getLvl_montage(),0);
			montagetimeslid.setMajorTickSpacing(1);
			montagetimeslid.setMinorTickSpacing(1);
			montagetimeslid.setPaintTicks(true);
			montagetimeslid.setPaintLabels(true); //
			montagetimeslid.setBounds(80+115+10,80+75*2,(MainClient.player.getLvl_montage())==1?60:50*(MainClient.player.getLvl_montage()),50);
			postprodtimeslid = new JSlider(JSlider.HORIZONTAL,0,MainClient.player.getLvl_post_prod(),0);
			postprodtimeslid.setMajorTickSpacing(1);
			postprodtimeslid.setMinorTickSpacing(1);
			postprodtimeslid.setPaintTicks(true);
			postprodtimeslid.setPaintLabels(true); //
			postprodtimeslid.setBounds(80+115+10,80+75*3,MainClient.player.getLvl_post_prod()==1?60:50*MainClient.player.getLvl_post_prod(),50);
			if (MainClient.player.getLvl_post_prod()==0){	
				JLabel label = new JLabel();
				label.setFont(new Font("Tahoma", Font.PLAIN, 20));
				label.setText("Vous devez être au moins level 1");
				label.setForeground(Color.GRAY);
				label.setHorizontalAlignment(JLabel.LEFT);
				label.setBounds(80+115+10, 80+75*3+5, 500, 45);
				cv_c_south.add(label);
			}
			
			cv_c_south.add(ecrituretimeslid);
			cv_c_south.add(tournagetimeslid);
			cv_c_south.add(montagetimeslid);
			cv_c_south.add(postprodtimeslid);
			
			JButton valid = new JButton("Valider");
			valid.setBounds(25, 80+75*4, 80, 40);
			valid.addActionListener(new VideoCreatorSlidEvent(2));
			cv_c_south.add(valid);
			
		}
		cv_c_south.updateUI();
	}
	
	public static String Zero(Integer z){
		String i = z<10?"0"+z:""+z;
		return i;
	}
	
	public static void setPlanningPage(){
		for (int a = 0;a<2;a++){
			JPanel n = new BORDER_PL(1);
			JPanel s = new BORDER_PL(2);
			JPanel w = new BORDER_PL(3);
			JPanel e = new BORDER_PL(4);
			w.setPreferredSize(new Dimension(26,450));
			e.setPreferredSize(new Dimension(26,450));
			n.setPreferredSize(new Dimension(400,5));
			s.setPreferredSize(new Dimension(400,15));
			if (a==1){
				cp_c_c_c_1.add(w,BorderLayout.WEST);
				cp_c_c_c_1.add(e,BorderLayout.EAST);
				cp_c_c_c_1.add(n,BorderLayout.NORTH);
				cp_c_c_c_1.add(s,BorderLayout.SOUTH);
				cp_c_c_c_1.add(cp_c_c_c_1_center,BorderLayout.CENTER);
			}else{
				cp_c_c_c_2.add(w,BorderLayout.WEST);
				cp_c_c_c_2.add(e,BorderLayout.EAST);
				cp_c_c_c_2.add(n,BorderLayout.NORTH);
				cp_c_c_c_2.add(s,BorderLayout.SOUTH);
				cp_c_c_c_2.add(cp_c_c_c_2_center,BorderLayout.CENTER);
			}
		}
		//Label : Name
		int TotalNotifY = 0;
		Boolean encours = true;
		int d = 1;
		Integer day = 0;
		while (d!=3){
			TotalNotifY = 5;
			Boolean plan = true;
			int i = 0;
			SimpleDateFormat formater = null;
			Date now = new Date();
			Calendar cal = Calendar.getInstance(); // <-- Dans l'avenir : get seulement l'heure française.
			cal.setTime(now);
			if (d==1){
				cal.add(Calendar.DAY_OF_YEAR, 0); // <--
			}else{
				cal.add(Calendar.DAY_OF_YEAR, d-1); // <--	
			}
			Date date = cal.getTime();
			formater = new SimpleDateFormat("yy/MM/dd/HH/EEEE/MMMM/MMM");
			String s = formater.format(date);
			String[] sf = s.split("/");		
			
			JLabel jour = new JLabel();
			jour.setFont(new Font("Dominique", Font.PLAIN, 23));
			jour.setText("Aujourd'hui");
			jour.setForeground(Color.decode("#66A563"));
			jour.setHorizontalAlignment(JLabel.LEFT);
			jour.setBounds(0, 15, (((largeur-255)-15-(largeur-255)/4))/2, 23);
			JLabel dem = new JLabel();
			dem.setFont(new Font("Dominique", Font.PLAIN, 23));
			dem.setText("Demain");
			dem.setForeground(Color.DARK_GRAY);
			dem.setHorizontalAlignment(JLabel.LEFT);
			dem.setBounds(0, 15, (((largeur-255)-15-(largeur-255)/4))/2, 23);
			TotalNotifY = TotalNotifY+20+5+15;
			if (d==1){
				day=Integer.valueOf(sf[2]);
				String jour_sem = "";
				String mois = "";
				char[] stringArray = sf[4].toCharArray();
				stringArray[0] = Character.toUpperCase(stringArray[0]);
				jour_sem = new String(stringArray);
				stringArray = sf[5].toCharArray();
				stringArray[0] = Character.toUpperCase(stringArray[0]);
				mois = new String(stringArray);
				DATE_OF_DAY.setFont(new Font("Dominique", Font.PLAIN, 45));
				DATE_OF_DAY.setText(jour_sem+", "+sf[2]+" "+(mois.contains("û")?mois.replace("û", "u"):mois));
				DATE_OF_DAY.setForeground(Color.DARK_GRAY);
				DATE_OF_DAY.setHorizontalAlignment(JLabel.LEFT);
				DATE_OF_DAY.setBounds(0, 0, 600, 45);
				Agenda.setFont(new Font("Dominique", Font.PLAIN, 25));
				Agenda.setText("Mon agenda :");
				Agenda.setForeground(Color.GRAY);
				Agenda.setHorizontalAlignment(JLabel.LEFT);
				Agenda.setBounds(0, 60, 400, 30);
				cp_c_c_c_1_center.add(jour);
				while(plan){
					if (MainClient.planning.size()-1==i){
						plan=false;
					}
					else if (MainClient.planning.get(i).getHour()<=Integer.parseInt(sf[3]) && Integer.parseInt(sf[2])==MainClient.planning.get(i).getDay()){
							MainClient.planning.remove(i);
					}
					i++;
				}
				i=0;
				plan=true;
			}else{
				cp_c_c_c_2_center.add(dem);
			}
			
			/*
			 * Boucle 1 - évenement
			 */
			while(plan){
				if (MainClient.evenements.size()-1==i){
					plan=false;
				}
				else{
						if (MainClient.evenements.get(i).getDay()==Integer.parseInt(sf[2])){
							JPanel panel = new COLOR(Col(ColId(MainClient.evenements.get(i).getId())));
							panel.setBounds(0, TotalNotifY, (((largeur-255)-15-(largeur-255)/4))/2, 17);
							TotalNotifY=TotalNotifY+15+5;
							panel.setLayout(new BorderLayout());
							JPanel nordd = new COLOR(Col(ColId(MainClient.evenements.get(i).getId())));
							nordd.setPreferredSize(new Dimension(largeur,1));
							JPanel sudd = new COLOR(Col(ColId(MainClient.evenements.get(i).getId())));
							sudd.setPreferredSize(new Dimension(largeur,1));
							JPanel westt = new COLOR(Col(ColId(MainClient.evenements.get(i).getId())));
							westt.setPreferredSize(new Dimension(5,hauteur));
							JPanel centerr = new COLOR(Col(ColId(MainClient.evenements.get(i).getId())));
							//centerr.setPreferredSize(new Dimension(largeur,hauteur));
							panel.add(nordd,BorderLayout.NORTH);
							panel.add(sudd,BorderLayout.SOUTH);
							panel.add(westt,BorderLayout.WEST);
							centerr.setLayout(new BorderLayout());
							
							JLabel label = new JLabel();
							label.setFont(new Font("Tahoma", Font.PLAIN, 15));
							label.setText(ActivityId(MainClient.evenements.get(i).getId(),MainClient.evenements.get(i).getData()));
							label.setForeground(Color.WHITE);
							label.setHorizontalAlignment(JLabel.LEFT);
							
							centerr.add(label, BorderLayout.CENTER);
							panel.add(centerr,BorderLayout.CENTER);
							if (d==1){
								cp_c_c_c_1_center.add(panel);
							}else{
								cp_c_c_c_2_center.add(panel);
							}				
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
				if (MainClient.planning.size()-1==i){
					plan=false;
				}
				else{
						if (MainClient.planning.get(i).getDay()==Integer.parseInt(sf[2])){
							Color c = new Color(220,220,220,95);
							if (encours==true){
								if (MainClient.planning.get(i).getHour_start()<=Integer.valueOf(sf[3])&&MainClient.planning.get(i).getDay()==day){
									c = new Color(196,254,202,95);
								}else{
									c = new Color(251,227,105,95);
								}
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
							
							JPanel color = new COLOR(Col(ColId(MainClient.planning.get(i).getId())));
							color.setBounds(0, 0, (50-5-5)/2, (50-5-5)/2);
							
							JLabel label_name = new JLabel();
							label_name.setFont(new Font("Dominique", Font.PLAIN, 20));
							label_name.setText(ActivityId(MainClient.planning.get(i).getId(),MainClient.planning.get(i).getData()).toLowerCase());
							label_name.setForeground(Color.DARK_GRAY);
							label_name.setHorizontalAlignment(JLabel.LEFT);
							label_name.setBounds((50-5-5)/2+5, 0, largeur, (50-5-5)/2);
							
							JLabel label_hours = new JLabel();
							label_hours.setFont(new Font("Dominique", Font.PLAIN, 16));
							String HourEnd = MainClient.planning.get(i).getHour() < 22 ? ""+MainClient.planning.get(i).getHour()+":00" : "<font color=red>"+
									MainClient.planning.get(i).getHour()+":00 <i>(rique de fatigue !)</i></font>";
							label_hours.setText("<html>"+MainClient.planning.get(i).getHour_start()+":00 a "+HourEnd+"</html>");
							//label_hours.setForeground(Color.GRAY);
							label_hours.setHorizontalAlignment(JLabel.LEFT);
							label_hours.setBounds((50-5-5)/2+5, 0, largeur, (50-5-5)/2);
							
							norddd.add(color);
							norddd.add(label_name);
							suddd.add(label_hours);
							centerr.add(norddd,BorderLayout.NORTH);
							centerr.add(suddd,BorderLayout.SOUTH);
							panel.add(centerr,BorderLayout.CENTER);
							if (d==1){
								cp_c_c_c_1_center.add(panel);
							}else{
								cp_c_c_c_2_center.add(panel);
							}
						}
						i++;
					}
			}
			if (d==1){
				cp_c_c_c_1_center.setBounds(0,0,400,450);
			}else{
				cp_c_c_c_2_center.setBounds(((largeur-(255+10+10))/2/4)*3+7,0
						,400,450);
			}
			d++;
		}			
	}
	
	public void setLevelsPage(){
		int x = 0;
		int y = 0;
		for (int w = 0;w<MainClient.categ_list.length;w++){
			
			if (w%5==0&&w!=0){
				x=x+300;
				y=0;
			}
			JPanel tset = new IMAGE_(MainClient.categ_list[w].contains("/")?MainClient.categ_list[w].replace("/", "_")+"_THEME":MainClient.categ_list[w]+"_THEME",70,70);
			tset.setBounds(50+x, 50+y, 70, 70);
			JProgressBar bar  = new JProgressBar();
		    bar.setMaximum(MainClient.getExpTotalCat((int) MainClient.Convert_Categ_Lvl(MainClient.categ_list[w])));
		    bar.setMinimum(0);
		    bar.setValue((int) MainClient.Convert_Categ_Exp(MainClient.categ_list[w]));
		    bar.setBounds(50+92+x, 50+40-8+y, 150, 25);
		    JLabel cl_exp = new JLabel();
		    cl_exp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		    cl_exp.setText(MainClient.Convert_Categ_Exp(MainClient.categ_list[w])+
		    		"/"+MainClient.getExpTotalCat((int) MainClient.Convert_Categ_Lvl(MainClient.categ_list[w]))+" Exp");
		    cl_exp.setForeground(Color.darkGray);
		    cl_exp.setHorizontalAlignment(JLabel.LEFT);
		    cl_exp.setBounds(50+92+x, 50+40-3+y, 150, 17);
		    JLabel cl_name = new JLabel();
		    cl_name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		    cl_name.setText(MainClient.categ_list[w]);
		    cl_name.setForeground(Color.darkGray);
		    cl_name.setHorizontalAlignment(JLabel.LEFT);
		    cl_name.setBounds(50+92+x, 50+8+y, 200, 20);
		    JLabel cl_lvl = new JLabel();
		    cl_lvl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		    cl_lvl.setText("Lvl "+MainClient.Convert_Categ_Lvl(MainClient.categ_list[w])+"");
		    cl_lvl.setForeground(Color.darkGray);
		    cl_lvl.setHorizontalAlignment(JLabel.LEFT);
		    cl_lvl.setBounds(50+92+x+150+3, 50+40-3+y, 200, 17);
		    cl_c_center.add(bar);
			cl_c_center.add(cl_name);
			cl_c_center.add(cl_lvl);
			cl_c_center.add(cl_exp);
			cl_c_center.add(tset);
			y=y+80;
		}		
	}
	
	@SuppressWarnings({"unchecked" })
	public static void EDIT_PLAN(Integer i, Integer ID){
		Calendar cal = Calendar.getInstance(); // <-- Dans l'avenir : get seulement l'heure française.
		cal.add(Calendar.DAY_OF_YEAR, 0); // <--
		Date date = cal.getTime();
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yy");
		String s = formater.format(date);
		String[] sf = s.split("/");
		if(i==1){
			ArrayList<String> ar = new ArrayList<String>();
			ar.add("<html><font color=gray>Choix</font></html>");
			for (int a = 0;a<MainClient.planning.size();a++){
				if (a!=MainClient.planning.size()-1 && MainClient.planning.get(a).getId()!=1){
					if (MainClient.planning.get(a).getDay()>=Integer.valueOf(sf[0])&&!(MainClient.planning.get(a).getMonth()<Integer.valueOf(sf[1]))){			
						ar.add(("<html>"+ActivityId(MainClient.planning.get(a).getId(),MainClient.planning.get(a).getData())+" le "+
								Zero(MainClient.planning.get(a).getDay())+"/"+Zero(MainClient.planning.get(a).getMonth())+" de "+
								MainClient.planning.get(a).getHour_start()+"h a "+MainClient.planning.get(a).getHour()+"h <hidden "+
								MainClient.planning.get(a).getUUID()+" /> </html>").toLowerCase());
					}
				}
			}
			String[] choicesStrings = new String[ar.size()];
			choicesStrings = ar.toArray(choicesStrings);

			edit_first_choice = new JComboBox(choicesStrings);
			edit_first_choice.setSelectedIndex(0);
			edit_first_choice.setFont(new Font("Dominique", Font.PLAIN, 14));
			edit_first_choice.setBounds(0, 0, (largeur-255-10-10-15-15-810)<350?(largeur-255-10-10-15-15-810):350, 40);
			cp_c_c_c_right.add(edit_first_choice);
			
			edit_but_accept = new JButton("Suivant");
			edit_but_accept.setFont(new Font("Dominique", Font.PLAIN, 20));
			edit_but_accept.setBounds(0, 40+5, 110, 40);
			cp_c_c_c_right.add(edit_but_accept);
			edit_but_accept.addActionListener(new EditStepOne());
			
		}
		create_first_choice.setEnabled(true);
		create_but_accept.setEnabled(true);
	}
	
	@SuppressWarnings({"unchecked" })
	public static void EDIT_PLAN_STEP_2(Planning pl){

		ArrayList<String> ardate = new ArrayList<String>();
		for (int i = 0;i<=7;i++){
			Calendar cal = Calendar.getInstance(); // <-- Dans l'avenir : get seulement l'heure française.
			cal.add(Calendar.DAY_OF_YEAR, i); // <--
			Date date = cal.getTime();
			SimpleDateFormat formater = new SimpleDateFormat("dd / MM / yy");
			String s = formater.format(date);
			ardate.add(s);
		}
			ArrayList<String> ar = new ArrayList<String>();
			for (int i = 8;i<=21;i++){
				try{
					ar.add("<html> "+i+"h <hidden "+pl.getUUID()+" /> </html>");
				}catch(Exception ex){
					
				}		
			}
			ArrayList<String> arend = new ArrayList<String>();
			for (int i = 9;i<=22;i++){
				try{
					arend.add("<html> "+i+"h <hidden "+pl.getUUID()+" /> </html>");
				}catch(Exception ex){
					
				}
			}
			
			JLabel le = new JLabel("Le ");
			le.setFont(new Font("Dominique", Font.PLAIN, 35));
			le.setText("Le");
			le.setForeground(Color.DARK_GRAY);
			le.setHorizontalAlignment(JLabel.LEFT);
			le.setBounds(0, 45+35+25, 40, 40);
			cp_c_c_c_right.add(le);
			
			String[] choicesStringsDates = new String[ardate.size()];
			choicesStringsDates = ardate.toArray(choicesStringsDates);
			
			edit_date_box = new JComboBox(choicesStringsDates);
			edit_date_box.setSelectedItem(Zero(pl.getDay()) + " / " + Zero(pl.getMonth()) + " / " + Zero(pl.getYear()));
			edit_date_box.setFont(new Font("Dominique", Font.PLAIN, 14));
			edit_date_box.setBounds(0+40+5, 45+35+25, 90, 40);
			cp_c_c_c_right.add(edit_date_box);
			
			JLabel de = new JLabel("de");
			de.setFont(new Font("Dominique", Font.PLAIN, 25));
			de.setText("de");
			de.setForeground(Color.DARK_GRAY);
			de.setHorizontalAlignment(JLabel.LEFT);
			de.setBounds(0+40+5+90+1, 45+35+25, 40, 35);
			cp_c_c_c_right.add(de);
			
			String[] choicesStrings = new String[ar.size()];
			choicesStrings = ar.toArray(choicesStrings);
			String[] choicesStringsEnd = new String[arend.size()];
			choicesStringsEnd = arend.toArray(choicesStringsEnd);

			edit_hour_start = new JComboBox(choicesStrings);
			edit_hour_start.setSelectedItem("<html> "+pl.getHour_start()+"h <hidden "+pl.getUUID()+" /> </html>");
			edit_hour_start.setFont(new Font("Dominique", Font.PLAIN, 14));
			edit_hour_start.setBounds(100+15+40+5+5, 45+35+25, 45, 40);
			cp_c_c_c_right.add(edit_hour_start);
			
			JLabel a = new JLabel("a");
			a.setFont(new Font("Dominique", Font.PLAIN, 25));
			a.setText("a");
			a.setForeground(Color.DARK_GRAY);
			a.setHorizontalAlignment(JLabel.LEFT);
			a.setBounds(100+15+40+5+5+45+1, 45+35+25, 40, 35);
			cp_c_c_c_right.add(a);
			
			cp_c_c_c_right.add(de);
			edit_hour_end = new JComboBox(choicesStringsEnd);
			edit_hour_end.setSelectedItem("<html> "+pl.getHour()+"h <hidden "+pl.getUUID()+" /> </html>");
			edit_hour_end.setFont(new Font("Dominique", Font.PLAIN, 14));
			edit_hour_end.setBounds(45+10+115+40+15, 45+35+25, 45, 40);
			cp_c_c_c_right.add(edit_hour_end);
			
			JButton but_accept = new JButton("Modifier");
			but_accept.setFont(new Font("Dominique", Font.PLAIN, 20));
			but_accept.setBounds(0, 45+40+40+25, 110, 40);
			cp_c_c_c_right.add(but_accept);
			but_accept.addActionListener(new EditStepTwo());
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cp_c_c_c_right.updateUI();

	}
	
	@SuppressWarnings({"unchecked" })
	public static void CREATE_PLAN(Integer i, Integer ID){
		Calendar cal = Calendar.getInstance(); // <-- Dans l'avenir : get seulement l'heure française.
		cal.add(Calendar.DAY_OF_YEAR, 0); // <--
		Date date = cal.getTime();
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yy");
		String s = formater.format(date);
		String[] sf = s.split("/");
		if(i==1){
			String[] choicesStrings = {"<html><font color=green>█</font> video (tournage/montage/etc...)</html>",
					"<html><font color=gold>█</font> apprentissage</html>","<html><font color=red>█</font> famille, vie social</html>"};
			
			create_first_choice = new JComboBox(choicesStrings);
			create_first_choice.setSelectedIndex(0);
			create_first_choice.setFont(new Font("Dominique", Font.PLAIN, 18));
			create_first_choice.setBounds(0, 0, (largeur-255-10-10-15-15-810)<350?(largeur-255-10-10-15-15-810):350, 40);
			cp_c_c_c_right.add(create_first_choice);
			
			create_but_accept = new JButton("Suivant");
			create_but_accept.setFont(new Font("Dominique", Font.PLAIN, 20));
			create_but_accept.setBounds(0, 40+5, 110, 40);
			cp_c_c_c_right.add(create_but_accept);
			create_but_accept.addActionListener(new CreateStepOne());
			
		}
		create_first_choice.setEnabled(true);
		create_but_accept.setEnabled(true);
		cp_c_c_c_right.updateUI();
	}
	
	@SuppressWarnings({"unchecked" })
	public static void CREATE_PLAN_STEP_2(Integer i){
		Calendar cal = Calendar.getInstance(); // <-- Dans l'avenir : get seulement l'heure française.
		cal.add(Calendar.DAY_OF_YEAR, 0); // <--
		Date date = cal.getTime();
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yy");
		String s = formater.format(date);
		String[] sf = s.split("/");
		String[] choicesVideos;
		String[] choicesVie;
		if(i==1){
			int status;
			ArrayList<String> ar = new ArrayList<String>();
			ar.add("<html><font color=gray>Choix</font></html>");
			for (int a = 0;a<MainClient.videos.size();a++){
				if (a!=MainClient.videos.size()-1 && MainClient.videos.get(a).getDay()==0){
					status = getStatus(MainClient.videos.get(a));
					if (status!=6){
						ar.add(status==0?"<html><font color=yellow>█</font> ecriture: "+MainClient.videos.get(a).getName().toLowerCase()+" <hidden "+MainClient.videos.get(a).getID()+" /></html>":
							status==1?"<html><font color=green>█</font> tournage: "+MainClient.videos.get(a).getName().toLowerCase()+" <hidden "+MainClient.videos.get(a).getID()+" /></html>":
							status==2?"<html><font style=\"color:#5AEFEA\">█</font> montage: "+MainClient.videos.get(a).getName().toLowerCase()+" <hidden "+MainClient.videos.get(a).getID()+" /></html>":
							status==3?"<html><font style=\"color:#5863C3\">█</font> post-production: "+MainClient.videos.get(a).getName().toLowerCase()+" <hidden "+MainClient.videos.get(a).getID()+" /></html>":
							"<html><font color=green>█</font> planifier: "+MainClient.videos.get(a).getName().toLowerCase()+" <hidden "+MainClient.videos.get(a).getID()+" /></html>");				
					}					
				}
			}
			choicesVideos = new String[ar.size()];
			choicesVideos = ar.toArray(choicesVideos);
			
			create_2nd_choice = new JComboBox(choicesVideos);
			create_2nd_choice.setSelectedIndex(0);
			create_2nd_choice.setFont(new Font("Dominique", Font.PLAIN, 15));
			create_2nd_choice.setBounds(0, 85+10, (largeur-255-10-10-15-15-810)<350?(largeur-255-10-10-15-15-810):350, 40);
			cp_c_c_c_right.add(create_2nd_choice);
			
			create_2ndbut_accept = new JButton("Suivant");
			create_2ndbut_accept.setFont(new Font("Dominique", Font.PLAIN, 20));
			create_2ndbut_accept.setBounds(0, 95+40+5, 110, 40);
			cp_c_c_c_right.add(create_2ndbut_accept);
			create_2ndbut_accept.addActionListener(new CreateStepTwo(i));
		}if (i==2){
			
			String[] choicesApprenti = {"<html><font color=gray>Choix</font></html>","Tout seul","Avec cours"};
			
			create_2nd_choice = new JComboBox(choicesApprenti);
			create_2nd_choice.setSelectedIndex(0);
			create_2nd_choice.setFont(new Font("Dominique", Font.PLAIN, 17));
			create_2nd_choice.setBounds(0, 85+10, (largeur-255-10-10-15-15-810)<350?(largeur-255-10-10-15-15-810):350, 40);
			cp_c_c_c_right.add(create_2nd_choice);
			
			create_2ndbut_accept = new JButton("Suivant");
			create_2ndbut_accept.setFont(new Font("Dominique", Font.PLAIN, 20));
			create_2ndbut_accept.setBounds(0, 95+40+5, 110, 40);
			cp_c_c_c_right.add(create_2ndbut_accept);
			create_2ndbut_accept.addActionListener(new CreateStepTwoBis());
		}
		
		
		create_2nd_choice.setEnabled(true);
		create_2ndbut_accept.setEnabled(true);
		cp_c_c_c_right.updateUI();
	}
	
	@SuppressWarnings({"unchecked" })
	public static void CREATE_PLAN_STEP_2bis(Integer i){
		Calendar cal = Calendar.getInstance(); // <-- Dans l'avenir : get seulement l'heure française.
		cal.add(Calendar.DAY_OF_YEAR, 0); // <--
		Date date = cal.getTime();
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yy");
		String s = formater.format(date);
		String[] sf = s.split("/");
			
			create_3rd_choice = new JComboBox(MainClient.categ_list);
			create_3rd_choice.setSelectedIndex(0);
			create_3rd_choice.setFont(new Font("Tahoma", Font.PLAIN, 15));
			create_3rd_choice.setBounds(0, 140+10+40, (largeur-255-10-10-15-15-810)<350?(largeur-255-10-10-15-15-810):350, 40);
			cp_c_c_c_right.add(create_3rd_choice);
			
			create_3rdbut_accept = new JButton("Suivant");
			create_3rdbut_accept.setFont(new Font("Dominique", Font.PLAIN, 20));
			create_3rdbut_accept.setBounds(0, 140+10+45+40, 110, 40);
			cp_c_c_c_right.add(create_3rdbut_accept);
			
		
		
		create_3rdbut_accept.addActionListener(new CreateStepTwo(i));
		create_3rd_choice.setEnabled(true);
		create_3rdbut_accept.setEnabled(true);
		cp_c_c_c_right.updateUI();
	}
	
	@SuppressWarnings({"unchecked" })
	public static void CREATE_PLAN_STEP_3(Integer type, Video v, int time){

		ArrayList<String> ardate = new ArrayList<String>();
		for (int i = 0;i<=7;i++){
			Calendar cal = Calendar.getInstance(); // <-- Dans l'avenir : get seulement l'heure française.
			cal.add(Calendar.DAY_OF_YEAR, i); // <--
			Date date = cal.getTime();
			SimpleDateFormat formater = new SimpleDateFormat("dd / MM / yy");
			String s = formater.format(date);
			ardate.add(s);
		}
			ArrayList<String> ar = new ArrayList<String>();
			for (int i = 8;i<=21;i++){
				try{
					ar.add("<html> "+i+"h </html>");
				}catch(Exception ex){
					
				}		
			}
			ArrayList<String> arend = new ArrayList<String>();
			for (int i = 9;i<=22;i++){
				try{
					arend.add("<html> "+i+"h </html>");
				}catch(Exception ex){
					
				}
			}
			Integer y = type.equals(1)?140+10+40:140+10+45+40+50;
			JLabel le = new JLabel("Le ");
			le.setFont(new Font("Dominique", Font.PLAIN, 35));
			le.setText("Le");
			le.setForeground(Color.DARK_GRAY);
			le.setHorizontalAlignment(JLabel.LEFT);
			le.setBounds(0, y, 40, 40);
			cp_c_c_c_right.add(le);
			
			String[] choicesStringsDates = new String[ardate.size()];
			choicesStringsDates = ardate.toArray(choicesStringsDates);
			
			create_date_box = new JComboBox(choicesStringsDates);
			create_date_box.setSelectedItem(Zero(Integer.valueOf(ardate.get(0).split(" ")[0])) + " / " + Zero(Integer.valueOf(ardate.get(0).split(" ")[2])) 
					+ " / " + Zero(Integer.valueOf(ardate.get(0).split(" ")[4])));
			create_date_box.setFont(new Font("Dominique", Font.PLAIN, 14));
			create_date_box.setBounds(0+40+5, y, 90, 40);
			cp_c_c_c_right.add(create_date_box);
			if (time!=0 || (type==2 || type==3)){
				JLabel de = new JLabel("de");
				de.setFont(new Font("Dominique", Font.PLAIN, 25));
				de.setText("de");
				de.setForeground(Color.DARK_GRAY);
				de.setHorizontalAlignment(JLabel.LEFT);
				de.setBounds(0+40+5+90+1, y, 40, 35);
				cp_c_c_c_right.add(de);
				
				String[] choicesStrings = new String[ar.size()];
				choicesStrings = ar.toArray(choicesStrings);
				String[] choicesStringsEnd = new String[arend.size()];
				choicesStringsEnd = arend.toArray(choicesStringsEnd);

				create_hour_start = new JComboBox(choicesStrings);
				create_hour_start.setSelectedItem("<html> 8h </html>");
				create_hour_start.setFont(new Font("Dominique", Font.PLAIN, 14));
				create_hour_start.setBounds(100+15+40+5+5,y, 45, 40);
				cp_c_c_c_right.add(create_hour_start);
				
				JLabel a = new JLabel("a");
				a.setFont(new Font("Dominique", Font.PLAIN, 25));
				a.setText("a");
				a.setForeground(Color.DARK_GRAY);
				a.setHorizontalAlignment(JLabel.LEFT);
				a.setBounds(100+15+40+5+5+45+1, y, 40, 35);
				cp_c_c_c_right.add(a);
				
				cp_c_c_c_right.add(de);
				create_hour_end = new JComboBox(choicesStringsEnd);
				create_hour_end.setSelectedItem("<html> 9h </html>");
				create_hour_end.setFont(new Font("Dominique", Font.PLAIN, 14));
				create_hour_end.setBounds(45+10+115+40+15, y, 45, 40);
				cp_c_c_c_right.add(create_hour_end);
			}
			
			
			JButton but_accept = new JButton("Ajouter");
			but_accept.setFont(new Font("Dominique", Font.PLAIN, 20));
			but_accept.setBounds(0, y+45, 110, 40);
			cp_c_c_c_right.add(but_accept);
			but_accept.addActionListener(new CreateStepThree(type,v,time));
			cp_c_c_c_right.updateUI();

	}
	
	public static int getStatus(Video video){
		int status = 0;
		int boucle = 0;
		int tot = 0;
		boolean bool = true;
		while(bool){
			tot=boucle==0?video.getEcritureRemain():boucle==1?video.getTournageRemain():boucle==2?video.getMontageRemain():video.getPostprodRemain();
			if (tot!=0){
				if (tot<0){
					status=6;
				}else{
					status=boucle;
				}		
				bool=false;
			}
			if (boucle==4){
				bool=false;
				status=5;
			}
			boucle++;
		}
		return status;
	}
	
	class Music implements Runnable{   

		@SuppressWarnings("deprecation")
		public void run(){
	    	
	    	/*
			 * Music
			 */
			File son = new File("musics/MUSIC_1.wav");
			AudioClip clip = null;
			try
			{
			clip = Applet.newAudioClip(son.toURL());
			}
			catch (MalformedURLException e)
			{
			System.out.println(e.getMessage());
			}
			clip.play();

	    }   

	  }
	
	static class AllImages extends JPanel{
		
		private String path;
		private int x;
		private int y;
		
		public AllImages(String path, int x, int y){
			this.path=path;
			this.x=x;
			this.y=y;
		}
		
	     public void paintComponent(Graphics g){
	    	 try{
	    		 Graphics2D g2d = (Graphics2D) g;
	    		 BufferedImage img = ImageIO.read(new File(path));
	    		 g2d.drawImage(img, 0, 0, x, y, this);
	    	 }catch (IOException ex){
	    		 ex.printStackTrace();
	    	 }
	     }

	  }
}
