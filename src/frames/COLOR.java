package frames;

import Main.Fenetre;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class COLOR extends JPanel {
    private Color c;

    public COLOR(Color c) {
        this.c = c;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(c);
        g2d.fillRect(0, 0, Fenetre.largeur, Fenetre.hauteur);
    }
}
