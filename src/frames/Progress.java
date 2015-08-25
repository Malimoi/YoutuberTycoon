package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import Main.Fenetre;


@SuppressWarnings("serial")
public class Progress extends JFrame{

  private Thread t;

  private JPanel bar = new Traitement();
   
  public Progress(){      

	  this.setTitle("Youtuber Tycoon by Malimoi");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.NORMAL);
		//this.setDefaultLookAndFeelDecorated(false);    /*-> Plein écran.*/
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setUndecorated(false);
		this.setResizable(true); 

      

	

    this.getContentPane().add(bar, BorderLayout.CENTER);

    this.setVisible(true);

  }

  public void Close(){
	  this.setVisible(false);
	  this.dispose();
  }

  class Traitement extends JPanel{

     public void paintComponent(Graphics g){
    	 try{
    		 Graphics2D g2d = (Graphics2D) g;
    		 BufferedImage img = ImageIO.read(new File("image/1080P Objets.png"));
    		 g2d.drawImage(img, 0, 0, Fenetre.largeur-300, (int) ((Fenetre.largeur-300)/1.77777), this);
    	 }catch (IOException ex){
    		 ex.printStackTrace();
    	 }
     }

  }

}