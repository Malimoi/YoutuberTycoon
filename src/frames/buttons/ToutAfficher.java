package frames.buttons;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import Main.Fenetre;

@SuppressWarnings("serial")
public class ToutAfficher extends JButton implements MouseListener{
	private Integer i; //On s'en servira plus tard ;)
	private Color FOND;
	private JLabel lab;
	
	public ToutAfficher(String str, Integer i){
		super(str);
		this.setLayout(new BorderLayout());
		this.i = i;
		this.FOND=Color.WHITE;
		this.setBorderPainted(false);
		this.addMouseListener(this);
		this.lab=new JLabel();
	}
	public void paintComponent(Graphics g){
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(FOND);
		g2d.fillRect(0, 0, Fenetre.hauteur, this.getHeight());
		g2d.setRenderingHint(
		        RenderingHints.KEY_TEXT_ANTIALIASING,
		        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		lab.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lab.setForeground(Color.decode("#296EF9"));
		lab.setText("Tout afficher");
		lab.setHorizontalAlignment(JLabel.CENTER);
		this.add(lab,BorderLayout.CENTER);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		this.FOND=Color.decode("#E3E3E3");	
	}
	@Override
	public void mouseExited(MouseEvent e) {
		this.FOND=Color.WHITE;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		this.FOND=Color.decode("#E3E3E3");	
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
