package frames;

import Main.Fenetre;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class CENTER extends JPanel {

    public void paintComponent(Graphics g) {
        Color c = Color.decode("#D7D7D7");//Gris
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(c);
        g2d.fillRect(0, 0, Fenetre.largeur, Fenetre.hauteur);
    }

}
