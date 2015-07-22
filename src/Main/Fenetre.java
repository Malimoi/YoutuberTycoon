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

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame{
	/*
	 * Je n'est aucune expérience en mise en page, je pense qu'il peut y avoir quelques améliorations à faire.
	 */
	public GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();

	//get maximum window bounds
	public Rectangle maximumWindowBounds = graphicsEnvironment.getMaximumWindowBounds();

	public int hauteur = (int) maximumWindowBounds.getHeight();
	public int largeur = (int) maximumWindowBounds.getWidth();

	public JButton bouton = new Bouton("Page d'accueil", 1);
	public JButton bouton2 = new Bouton("Mon planning", 2);
	public JButton bouton3 = new Bouton("Mes notifications", 3);
	public JButton bouton4 = new Bouton("Gestionnaires de vidéos", 4);

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
	public JPanel center_planning = new JPanel();

	public JPanel delete = new DEL();

	public Thread t;
	public int test = 0;

	public Fenetre() {

        this.setTitle("Youtuber Tycoon by Malimoi");
        this.setSize(1200,720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.NORMAL);
        //this.setDefaultLookAndFeelDecorated(false);    /*Plein écran.*/
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

        /*
         * Valeurs fictives, je m'occupe uniquement de la mise en page pour le moment.
         */

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
        bouton2.setBounds(0, 35, 225, 35);
        bouton3.setBounds(0, 70, 225, 35);
        bouton4.setBounds(0, 105, 225, 35);
        w_center.add(bouton);
        w_center.add(bouton2);
        w_center.add(bouton3);
        w_center.add(bouton4);

        west.add(w_center,BorderLayout.CENTER);

        //-- CENTER
        center.setBackground(Color.decode("#D7D7D7"));
        center.setLayout(new BorderLayout());
            c_west.setPreferredSize(new Dimension(10,hauteur));
            c_west.setBackground(Color.decode("#D7D7D7"));
            c_east.setPreferredSize(new Dimension((largeur-255)/4,hauteur));
            c_east.setBackground(Color.decode("#D7D7D7"));
            c_north.setPreferredSize(new Dimension(largeur,10));
            c_north.setBackground(Color.decode("#D7D7D7"));
                c_c_north1.setPreferredSize(new Dimension(((largeur-255)/4)*2, 80));

        center.add(c_east,BorderLayout.EAST);
        center.add(c_west,BorderLayout.WEST);
        center.add(c_north,BorderLayout.NORTH);
        center.add(c_center,BorderLayout.CENTER);
        c_center.setLayout(null);
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

        /*
         * End Center
         * Start Center_Planning
         */

        center_planning.setBackground(Color.RED);

        t = new Thread(new Update());
        t.start();

        content.add(haut, BorderLayout.NORTH);
        content.add(west, BorderLayout.WEST);

        content.setPreferredSize(new Dimension(largeur, hauteur));

        this.setContentPane(content);
        this.setVisible(true);

	}

    public void center() {

    }

    class Update implements Runnable {
        public void run() {
            while (true) {
                center();
            }
        }
    }

	/*
     * Il y a beaucoup de variable inutile, je les enleverais par la suite.
	 */

    class Bouton extends JButton implements MouseListener {
        private String name;
        private Integer i;
        private Color FOND;
        private Color FONT;
        private Image img;

        public Bouton(String str, Integer i) {
            super(str);
            this.name = str;
            this.i = i;
            this.FOND = Color.WHITE;
            this.FONT = Color.decode("#424242");
            this.setBorderPainted(false);
            this.addMouseListener(this);
            try {
                if (i == 1) {
                    this.img = ImageIO.read(new File("image/Home2.png"));
                } else if (i == 2) {
                    this.img = ImageIO.read(new File("image/Planning2.png"));
                } else if (i == 3) {
                    this.img = ImageIO.read(new File("image/Notif2.png"));
                } else if (i == 4) {
                    this.img = ImageIO.read(new File("image/Video2.png"));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void paintComponent(Graphics g) {
            Color c = Color.decode("#424242");//Gris
            Color c2 = Color.decode("#4A4A4A");//Gris Foncé
            Graphics2D g2d = (Graphics2D) g;
            //GradientPaint gp = new GradientPaint(0,0,Color.WHITE,0,hauteur,c2,true);
            //g2d.setPaint(gp);
            g2d.setColor(FOND);
            g2d.fillRect(0, 0, hauteur, this.getHeight());
            g2d.setColor(FONT);
            g2d.setFont(new Font("Tahoma", Font.PLAIN, 17));
            FontMetrics fm = g2d.getFontMetrics();
            int height = fm.getHeight();
            int width = fm.stringWidth(this.name);
            g2d.setRenderingHint(
                    RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.drawString(this.name, 12 + 22 + 7, (this.getHeight() / 2) + (height / 4) + 1);
            g2d.drawImage(img, 12, this.getHeight() / 7, 22, 22, this);
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            this.FOND = Color.decode("#393939");
            this.FONT = Color.WHITE;
            try {
                if (i == 1) {
                    this.img = ImageIO.read(new File("image/Home.png"));
                } else if (i == 2) {
                    this.img = ImageIO.read(new File("image/Planning.png"));
                } else if (i == 3) {
                    this.img = ImageIO.read(new File("image/Notif.png"));
                } else if (i == 4) {
                    this.img = ImageIO.read(new File("image/Video.png"));
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            this.FOND = Color.WHITE;
            this.FONT = Color.decode("#424242");
            try {
                if (i == 1) {
                    this.img = ImageIO.read(new File("image/Home2.png"));
                } else if (i == 2) {
                    this.img = ImageIO.read(new File("image/Planning2.png"));
                } else if (i == 3) {
                    this.img = ImageIO.read(new File("image/Notif2.png"));
                } else if (i == 4) {
                    this.img = ImageIO.read(new File("image/Video2.png"));
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            this.FOND = Color.decode("#D10E00");
            this.FONT = Color.WHITE;
            try {
                if (i == 1) {
                    this.img = ImageIO.read(new File("image/Home.png"));
                } else if (i == 2) {
                    this.img = ImageIO.read(new File("image/Planning.png"));
                } else if (i == 3) {
                    this.img = ImageIO.read(new File("image/Notif.png"));
                } else if (i == 4) {
                    this.img = ImageIO.read(new File("image/Video.png"));
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

    }

    class BoutonSep extends JButton {
        private String name;

        public BoutonSep(String str) {
            super(str);
            this.name = str;
            this.setBorderPainted(false);
        }

        public void paintComponent(Graphics g) {
            Color c = Color.decode("#1C2935");//Gris
            Color c2 = Color.decode("#4A4A4A");//Gris Foncé
            Graphics2D g2d = (Graphics2D) g;
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
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON
            );

            g2d.drawString(this.name, this.getWidth() / 2 - (width / 2), (this.getHeight() / 2) + (height / 4));
            g2d.setColor(Color.decode("#454C53"));
            g2d.drawLine(0, this.getHeight() - 1, this.getWidth(), this.getHeight() - 1);

            try {
                g2d.drawImage(ImageIO.read(new File("image/Home.png")), 0, 0, 25, 25, this);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public class ACC extends JPanel {

        public ACC() {

        }

        public void paintComponent(Graphics g) {
            Color c = Color.decode("#1C2935");//Gris
            Color c2 = Color.decode("#4A4A4A");//Gris Foncé
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, largeur, 60);

            try {
                g2d.drawImage(ImageIO.read(new File("image/LogoHaut.png")), 0, 0, 225, 60, this);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public class PROF_ACC extends JPanel {

        public PROF_ACC() {

        }

        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.ORANGE);
            g2d.fillRect(0, 0, 50, 50);
        }

    }

    public class NAME_ACC extends JPanel {

        public NAME_ACC() {

        }

        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, 300, 50);
        }

    }

    public class NOR extends JPanel {
        public NOR() {

        }

        public void paintComponent(Graphics g) {
            Color c = Color.decode("#6A6A6A");//Gris
            Color c2 = Color.decode("#4A4A4A");//Gris Foncé
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, largeur, hauteur);
        }
    }

    public class SUBS extends JPanel {

        public SUBS() {

        }

        public void paintComponent(Graphics g) {
            Color c = Color.decode("#D7D7D7");//Gris
            Color c2 = Color.decode("#4A4A4A");//Gris Foncé
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, ((largeur - 255) / 8), 80);
            g2d.setColor(c);
            g2d.drawLine(((largeur - 255) / 8) - 1, 20, ((largeur - 255) / 8) - 1, 60);
        }
    }

    public class DEL extends JPanel {

        public DEL() {

        }

        public void paintComponent(Graphics g) {
            Color c = Color.decode("#D7D7D7");//Gris
            Color c2 = Color.decode("#4A4A4A");//Gris Foncé
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(c);
            g2d.fillRect(0, 0, largeur, hauteur * 5);
        }
    }

    public class CENTER extends JPanel {
        public CENTER() {

        }

        public void paintComponent(Graphics g) {
            Color c = Color.decode("#D7D7D7");//Gris
            Color c2 = Color.decode("#4A4A4A");//Gris Foncé
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(c);
            g2d.fillRect(0, 0, largeur, hauteur);
        }
    }

    class BoutonAccListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            bouton.setEnabled(false);
            bouton2.setEnabled(true);
            bouton3.setEnabled(true);
            bouton4.setEnabled(true);

            if (test == 2)
                content.remove(center_planning);

            test = 1;

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            content.add(center, BorderLayout.CENTER);
			/* Existe-t-il une meilleur méhode ? */

            try {
                content.updateUI();
            } catch (Exception e) {
				/* Petit test personnel pour vérifier le bon fonctionnement */
                System.out.println("Erreur : " + test);
            }
        }
    }

    class BoutonPlanningListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            bouton.setEnabled(true);
            bouton2.setEnabled(false);
            bouton3.setEnabled(true);
            bouton4.setEnabled(true);

            if (test == 1)
                content.remove(center);

            test = 2;

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            content.add(center_planning, BorderLayout.CENTER);

            try {
                content.updateUI();
            } catch (Exception e) {
                System.out.println("Erreur : " + test);
            }
        }
    }

    class BoutonNotifListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            bouton.setEnabled(true);
            bouton2.setEnabled(true);
            bouton3.setEnabled(false);
            bouton4.setEnabled(true);

            if (test == 1)
                content.remove(center);

            if (test == 2)
                content.remove(center_planning);

            test = 3;

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                content.updateUI();
            } catch (Exception e) {
                System.out.println("Erreur : " + test);
            }
        }
    }

    class BoutonVideosListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            bouton.setEnabled(true);
            bouton2.setEnabled(true);
            bouton3.setEnabled(true);
            bouton4.setEnabled(false);

            if (test == 1)
                content.remove(center);

            if (test == 2)
                content.remove(center_planning);

            test = 4;

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                content.updateUI();
            } catch (Exception e) {
                System.out.println("Erreur : " + test);
            }
        }
    }
}
