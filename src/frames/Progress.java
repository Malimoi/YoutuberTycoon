package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

import Main.Fenetre;


@SuppressWarnings("serial")
public class Progress extends JFrame{

  private Thread t;

  private JProgressBar bar;
   
  public Progress(){      

    this.setSize(300, 80);

    this.setTitle("Création de votre partie");

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    this.setResizable(false);

    this.setLocationRelativeTo(null);      

      

    t = new Thread(new Traitement());
    
    t.start();

    bar  = new JProgressBar();

    bar.setMaximum(500);

    bar.setMinimum(0);

    bar.setStringPainted(true);
    
    bar.setPreferredSize(new Dimension(300,80));

    this.getContentPane().add(bar, BorderLayout.CENTER);

    this.setVisible(true);

  }

  public void Close(){
	  this.setVisible(false);
	  this.dispose();
  }

  class Traitement implements Runnable{   

    @SuppressWarnings("static-access")
	public void run(){
    	
      for(int val = 0; val <= 500; val++){

        bar.setValue(val);

        try {

          t.sleep(10);

        } catch (InterruptedException e) {

          // TODO Auto-generated catch block

        e.printStackTrace();

        }

      }

      Close();
      new Fenetre();

    }   

  }

}