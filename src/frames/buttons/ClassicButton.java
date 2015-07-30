package frames.buttons;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class ClassicButton extends JButton implements MouseListener{
	private String name;
	private Color FOND;
	private Color FONT;
	
	public ClassicButton(String str){
		super(str);
		this.name = str;
		this.FOND=Color.WHITE;
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
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		this.FOND=Color.decode("#F3F3F3");	
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
