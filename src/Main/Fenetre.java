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
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import frames.ACC;
import frames.COLOR;
import frames.MINI;
import frames.MINIA;
import frames.NAME_ACC;
import frames.NOR;
import frames.PROF_ACC;
import frames.SUBS;
import frames.VIDEOS_NORTH;
import frames.buttons.Bouton;
import frames.buttons.ToutAfficher;

@SuppressWarnings("serial")
public class Fenetre extends JFrame{
	/*
	 * Je n'est aucune exp�rience en mise en page, je pense qu'il peut y avoir quelques am�liorations � faire.
	 */
	public static GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
    
	//get maximum window bounds
	public static Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
			
	public static int hauteur = (int) maximumWindowBounds.getHeight();
	public static int largeur = (int) maximumWindowBounds.getWidth();
	
	public JButton boutonAcc = new Bouton("Page d'accueil",1);
	public JButton boutonVideoGest = new Bouton("Gestionnaire de vid�os",2);
	public JButton boutonPlanning = new Bouton("Mon planning",3);
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
					public JButton vid_affich = new ToutAfficher("Tout afficher", 1);
	public JPanel center_videos = new JPanel();
	//public JScrollPane scroll = new JScrollPane(center_videos,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		public JPanel cv_east = new COLOR(Color.decode("#F3F3F3"));
		public JPanel cv_west = new COLOR(Color.decode("#F3F3F3"));
		public JPanel cv_north = new COLOR(Color.decode("#F3F3F3"));
		public JPanel cv_center = new NOR();
			public JPanel cv_c_north = new VIDEOS_NORTH();
				public JLabel video = new JLabel();
				public JLabel nbvideo = new JLabel();
				public JPanel nbvideopan = new COLOR(Color.GRAY);
				public JButton mettreenligne = new ClassicButton("Faire une vid�o");
			public JPanel cv_c_south = new NOR();
	public JPanel center_planning = new JPanel();
		public JPanel cp_east = new COLOR(Color.decode("#F3F3F3"));
		public JPanel cp_west = new COLOR(Color.decode("#F3F3F3"));
		public JPanel cp_north = new COLOR(Color.decode("#F3F3F3"));
		public JPanel cp_center = new NOR();
			public JPanel cp_c_north = new VIDEOS_NORTH();
				public JLabel lab_planning = new JLabel();
				public JLabel lab_planningInfo = new JLabel();
			public JPanel cp_c_center = new COLOR(Color.decode("#F3F3F3"));
				public JPanel cp_c_c_north = new COLOR(Color.decode("#F3F3F3"));
				public JPanel cp_c_c_west = new COLOR(Color.decode("#F3F3F3"));
				public JPanel cp_c_c_east = new COLOR(Color.decode("#F3F3F3"));
				public JPanel cp_c_c_center = new COLOR(Color.decode("#F3F3F3"));
					public JPanel cp_c_c_c_1 = new NOR();
					public JPanel cp_c_c_c_2 = new NOR();
					
	public Thread t;
	public int test = 0;
	public static int videopage = 1;
	
	public Fenetre() {
	
	test();
		
	this.setTitle("Youtuber Tycoon by Malimoi");
	this.setSize(1200,720);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setExtendedState(JFrame.NORMAL);
	//this.setDefaultLookAndFeelDecorated(false);    /*-> Plein �cran.*/
	//this.setExtendedState(this.MAXIMIZED_BOTH);
	this.setUndecorated(true);
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
	lab_c_n_subs.setText("Abonn�s");
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
	
	boutonAcc.addActionListener(new BoutonAccListener());
	boutonPlanning.addActionListener(new BoutonPlanningListener());
	bouton3.addActionListener(new BoutonNotifListener());
	boutonVideoGest.addActionListener(new BoutonVideosListener());
	vid_affich.addActionListener(new BoutonToutaffichListener());
	
	boutonAcc.setBounds(0, 0, 225, 35);
	boutonVideoGest.setBounds(0, 35, 225, 35);
	boutonPlanning.setBounds(0, 70, 225, 35);
	bouton3.setBounds(0, 105, 225, 35);
	
	w_center.add(boutonAcc);
	w_center.add(boutonVideoGest);
	w_center.add(boutonPlanning);
	w_center.add(bouton3);
	
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
			lab_c_c_north_subs.setText("Abonn�s");
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
			 * Vid�os
			 */
			c_c_vp_west.setPreferredSize(new Dimension(26, hauteur));
			c_c_vp_east.setPreferredSize(new Dimension(26, hauteur));
			c_c_vp_north.setPreferredSize(new Dimension(largeur, 5));
			c_c_vp_south.setPreferredSize(new Dimension(largeur, 50));
			c_c_vp_center.setLayout(null);		
			
			/*
			 * Set the planning (ChatClient page)
		       ---------------------------
			 * M�thode qui renvoi � la construction du planning avec �venements.
		     */
		    setPlanning();
		    setVideosPannel();
		
		//Planning
		c_c_notif.add(c_c_nt_west,BorderLayout.WEST);
		c_c_notif.add(c_c_nt_east,BorderLayout.EAST);
		c_c_notif.add(c_c_nt_south,BorderLayout.SOUTH);
		c_c_notif.add(c_c_nt_north,BorderLayout.NORTH);
		c_c_notif.add(c_c_nt_center,BorderLayout.CENTER);
		//vid�os
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
	 * Start Center_Vid�os
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
			video.setText("Vid�os");
			video.setForeground(Color.decode("#424242"));
			video.setHorizontalAlignment(JLabel.CENTER);
			video.setBounds(0, 22, 120, 25);
			nbvideopan.setBounds(120, 20, 45, 29);
			nbvideopan.setLayout(new BorderLayout());
			nbvideo.setFont(new Font("Tahoma", Font.PLAIN, 18));
			nbvideo.setText((ChatClient.videos.size()-1)+"");
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
			cv_center.add(cv_c_south, BorderLayout.SOUTH);
		
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
			lab_planningInfo.setText("C'est ici que vous g�rez votre emploi du temps !");
			lab_planningInfo.setForeground(Color.decode("#424242"));
			lab_planningInfo.setHorizontalAlignment(JLabel.CENTER);
			lab_planningInfo.setBounds(10, 22+50, 400, 20);
			/*
			 * Center
			 */
			cp_c_center.setLayout(new BorderLayout());
			cp_c_center.setPreferredSize(new Dimension(Fenetre.largeur-(225+10+10), hauteur-Fenetre.hauteur/7));
			cp_c_c_north.setPreferredSize(new Dimension(largeur,15));
			cp_c_c_west.setPreferredSize(new Dimension((largeur-(255+10+10))/2/4,hauteur));
			cp_c_c_east.setPreferredSize(new Dimension((largeur-(255+10+10))/2/4,hauteur));
			cp_c_c_center.setLayout(null);
				cp_c_c_c_1.setBounds(0,0,((largeur-(255+10+10))/2/4)*3-7,500);
				cp_c_c_c_1.setLayout(null);
				cp_c_c_c_2.setBounds(((largeur-(255+10+10))/2/4)*3+7,0,((largeur-(255+10+10))/2/4)*3-2,500);
				cp_c_c_c_2.setLayout(null);
				
				setPlanningPage();
				
				cp_c_c_center.add(cp_c_c_c_1);
				cp_c_c_center.add(cp_c_c_c_2);
				
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
	 * Start game
	 */
	
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
			s="Nouvelle vid�o \""+name+"\"";
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
			if (!name.contains("Faire une vid�o")){
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
				cv_center.add(cv_c_south,BorderLayout.SOUTH);
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
			/* Existe-t-il une meilleur m�thode ? */
			try{
				content.updateUI();
			}catch(Exception e){
				/* Petit test personnel pour v�rifier le bon fonctionnement */
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
			if (test==3){
				content.remove(center_planning);
			}else if (test==2){
				content.remove(center_videos);
			}
			test=1;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			content.add(center,BorderLayout.CENTER);
			/* Existe-t-il une meilleur m�thode ? */
			try{
				content.updateUI();
			}catch(Exception e){
				/* Petit test personnel pour v�rifier le bon fonctionnement */
				System.out.println("Erreur : "+test);
			}				
		}
	}
	
	class BoutonPlanningListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			boutonAcc.setEnabled(true);
			boutonPlanning.setEnabled(false);
			boutonVideoGest.setEnabled(true);
			bouton3.setEnabled(true);
			if (test==1){
				content.remove(center);
			}else if (test==2){
				content.remove(center_videos);
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
			resetPlanning();
		}
	}
	
	class BoutonNotifListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			boutonAcc.setEnabled(true);
			boutonVideoGest.setEnabled(true);
			boutonPlanning.setEnabled(true);
			bouton3.setEnabled(false);
			
			if (test==1){
				content.remove(center);
			}
			else if (test==3){
				content.remove(center_planning);
			}else if (test==2){
				content.remove(center_videos);
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
	
	class BoutonVideosListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			boutonAcc.setEnabled(true);
			boutonVideoGest.setEnabled(false);
			boutonPlanning.setEnabled(true);
			bouton3.setEnabled(true);
			
			if (test==1){
				content.remove(center);
			}
			else if (test==3){
				content.remove(center_planning);
			}
			test=2;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			content.add(center_videos,BorderLayout.CENTER);
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
				while(plan){
					if (ChatClient.planning.size()-1==i){
						plan=false;
					}
					else if (ChatClient.planning.get(i).getHour()<=Integer.parseInt(sf[3]) && Integer.parseInt(sf[2])==ChatClient.planning.get(i).getDay()){
							ChatClient.planning.remove(i);
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
			 * Boucle 1 - �venement
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
							System.out.println("(1-e) Jour �gal � l'index : day "+ChatClient.evenements.get(i).getDay());
						}
						i++;
					}
			}
			//On r�initialise
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
							label_hours.setText("<html>"+ChatClient.planning.get(i).getHour_start()+":00 � "+HourEnd+"</html>");
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
							System.out.println("(1) Jour �gal � l'index : "+ChatClient.planning.get(i).getHour_start()+" -> "+ChatClient.planning.get(i).getHour()
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
		lab_c_c_vp_c_name.setText("VID�OS");
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
			if (ChatClient.videos.size()-1==i || p == 5){
				vid=false;
			}else{
				if (ChatClient.videos.get(i).getYear()>Integer.parseInt(sf[0])){

				}
				else if (ChatClient.videos.get(i).getMonth()>Integer.parseInt(sf[1])){
					
				}
				else if (ChatClient.videos.get(i).getDay()>Integer.parseInt(sf[2])){
					
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
					JPanel shares = new MINI("image/Shares.png");
					shares.setBounds(275,TotalNotifY+(95-(30+35)),25,25);
					JLabel nbshares = new JLabel();
					nbshares.setFont(new Font("Tahoma", Font.PLAIN, 16));
					nbshares.setText(ChatClient.videos.get(i).getShare()+"");
					nbshares.setForeground(Color.GRAY);
					nbshares.setHorizontalAlignment(JLabel.LEFT);
					nbshares.setBounds(275+30, TotalNotifY+(95-(30+35))+5, (((largeur-255)-15-(largeur-255)/4))/2, 16);
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
		
		for (int g = 0;g<ChatClient.videos.size()-1;g++){
			if (g%5==0&&g!=0){
				b++;
			}
		}
		System.out.println("B: "+b+" ("+(ChatClient.videos.size()-1)+") + I:"+i);
		
		c_c_vp_south.setLayout(null);
		vid_affich.setBounds(0, 0, 500, 50);
		c_c_vp_south.add(vid_affich);
		TotalNotifY=TotalNotifY+50;
		//c_c_vp_center.add(c_c_vp_south);
		c_c_vp_center.add(lab_c_c_vp_c_name);
		c_c_videospannel.setBounds((((largeur-255)-15-(largeur-255)/4))/2+15, 12+80, (((largeur-255)-15-(largeur-255)/4))/2, TotalNotifY+5);
	}
	
	public void setVideosGestionnaire(){
		int TotalNotifY=hauteur/7-5;
		
		SimpleDateFormat formater = null;
		Date now = new Date();
		formater = new SimpleDateFormat("yy/MM/dd/HH/EEEE/MMMM/MMM");
		String s = formater.format(now);
		String[] sf = s.split("/");
		
		Boolean vid = true;
		int i = (videopage-1)*5;
		int p = (videopage-1)*5;
		while(vid){
			if (ChatClient.videos.size()-1==i || p==videopage*5){
				vid=false;
			}else{

					JPanel miniature = new MINIA("image/CLASSES/"+ChatClient.videos.get(i).getVideogenre()+".png");
					miniature.setBounds(50, TotalNotifY, 165, 95);
					JLabel titre = new JLabel();
					titre.setFont(new Font("Tahoma", Font.PLAIN, 18));
					titre.setText(ChatClient.videos.get(i).getName());
					titre.setForeground(Color.DARK_GRAY);
					titre.setHorizontalAlignment(JLabel.LEFT);
					titre.setBounds(182+50, TotalNotifY+5, (((largeur-255)-15-(largeur-255)/4))/2, 18);
					JLabel publie = new JLabel();
					publie.setFont(new Font("Tahoma", Font.PLAIN, 15));
					if (ChatClient.videos.get(i).getYear()>Integer.parseInt(sf[0]) || (ChatClient.videos.get(i).getMonth()>Integer.parseInt(sf[1]))
							|| (ChatClient.videos.get(i).getDay()>Integer.parseInt(sf[2]))){
						publie.setText("<html><font color=red>PLANIFI�E POUR LE "+Zero(ChatClient.videos.get(i).getDay())+"/"+Zero(ChatClient.videos.get(i).getMonth())+"/"+Zero(ChatClient.videos.get(i).getYear())+"</font></html>");
					}
					else{
						publie.setText("PUBLI�E LE "+Zero(ChatClient.videos.get(i).getDay())+"/"+Zero(ChatClient.videos.get(i).getMonth())+"/"+Zero(ChatClient.videos.get(i).getYear()));
					}
					
					publie.setForeground(Color.GRAY);
					publie.setHorizontalAlignment(JLabel.LEFT);
					publie.setBounds(182+50, TotalNotifY+5+26, (((largeur-255)-15-(largeur-255)/4))/2, 18);
					JPanel views = new MINI("image/views.png");
					views.setBounds((largeur-225-20)-200,TotalNotifY+(95-(30+35+35)+4),25,25);
					JLabel nbviews = new JLabel();
					nbviews.setFont(new Font("Tahoma", Font.PLAIN, 16));
					nbviews.setText(ChatClient.videos.get(i).getViews()+"");
					nbviews.setForeground(Color.GRAY);
					nbviews.setHorizontalAlignment(JLabel.LEFT);
					nbviews.setBounds((largeur-225-20)-170, TotalNotifY+(95-(30+35+35)+4)+5, (((largeur-255)-15-(largeur-255)/4))/2, 16);
					JPanel likes = new MINI("image/likes.png");
					likes.setBounds((largeur-225-20)-200,TotalNotifY+(95-30-35),25,25);
					JLabel nblikes = new JLabel();
					nblikes.setFont(new Font("Tahoma", Font.PLAIN, 16));
					nblikes.setText(ChatClient.videos.get(i).getLikes()+"");
					nblikes.setForeground(Color.GRAY);
					nblikes.setHorizontalAlignment(JLabel.LEFT);
					nblikes.setBounds((largeur-225-20)-170, TotalNotifY+(95-30-35)+5, (((largeur-255)-15-(largeur-255)/4))/2, 16);
					JPanel dislikes = new MINI("image/dislikes.png");
					dislikes.setBounds((largeur-225-20)-115,TotalNotifY+(95-30-35),25,25);
					JLabel nbdis = new JLabel();
					nbdis.setFont(new Font("Tahoma", Font.PLAIN, 16));
					nbdis.setText(ChatClient.videos.get(i).getDislikes()+"");
					nbdis.setForeground(Color.GRAY);
					nbdis.setHorizontalAlignment(JLabel.LEFT);
					nbdis.setBounds((largeur-225-20)-85, TotalNotifY+(95-30-35)+5, (((largeur-255)-15-(largeur-255)/4))/2, 16);
					JPanel shares = new MINI("image/Shares.png");
					shares.setBounds((largeur-225-20)-200,TotalNotifY+(95-34),25,25);
					JLabel nbshares = new JLabel();
					nbshares.setFont(new Font("Tahoma", Font.PLAIN, 16));
					nbshares.setText(ChatClient.videos.get(i).getShare()+"");
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
		for (int g =0;g<ChatClient.videos.size()-1;g++){
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
	public String Zero(Integer z){
		String i = z<10?"0"+z:""+z;
		
		return i;
	}
	
	public void setPlanningPage(){
		System.out.println("Execution de setPlanning");
		//Label : Name
		int TotalNotifY = 0;
		Boolean encours = true;
		int d = 1;
		while (d!=3){
			TotalNotifY = 5;
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
			
			JLabel jour = new JLabel();
			jour.setFont(new Font("Tahoma", Font.PLAIN, 18));
			jour.setText(""+sf[4].toUpperCase()+"");
			jour.setForeground(Color.RED);
			jour.setHorizontalAlignment(JLabel.LEFT);
			jour.setBounds(0, TotalNotifY, (((largeur-255)-15-(largeur-255)/4))/2, 18);
			TotalNotifY = TotalNotifY+20;
			JLabel date1 = new JLabel();
			date1.setFont(new Font("Tahoma", Font.PLAIN, 24));
			date1.setText(""+sf[2]+" "+sf[5].toUpperCase()+"");
			date1.setForeground(Color.RED);
			date1.setHorizontalAlignment(JLabel.LEFT);
			date1.setBounds(0, TotalNotifY, (((largeur-255)-15-(largeur-255)/4))/2, 24);
			TotalNotifY = TotalNotifY+26+5;
			if (d==1){
				cp_c_c_c_1.add(jour);
				cp_c_c_c_1.add(date1);
			}else{
				cp_c_c_c_2.add(jour);
				cp_c_c_c_2.add(date1);
			}
			
			/*
			 * Boucle 1 - �venement
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
							if (d==1){
								cp_c_c_c_1.add(panel);
							}else{
								cp_c_c_c_2.add(panel);
							}				
							System.out.println("(1-e) Jour �gal � l'index : day "+ChatClient.evenements.get(i).getDay());
						}
						i++;
					}
			}
			//On r�initialise
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
							label_hours.setText("<html>"+ChatClient.planning.get(i).getHour_start()+":00 � "+HourEnd+"</html>");
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
								cp_c_c_c_1.add(panel);
							}else{
								cp_c_c_c_2.add(panel);
							}
							System.out.println("(1) Jour �gal � l'index : "+ChatClient.planning.get(i).getHour_start()+" -> "+ChatClient.planning.get(i).getHour()
									+" : day "+ChatClient.planning.get(i).getDay());
						}
						i++;
					}
			}
			d++;
		}		

		c_c_notif.setBounds(0, 12+80, (((largeur-255)-15-(largeur-255)/4))/2, TotalNotifY+20);
	}
}
