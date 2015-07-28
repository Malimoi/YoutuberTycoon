package frames;

import Main.Fenetre;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Prog extends JPanel {
    private Integer i;

    public Prog(Integer i) {
        this.i = i;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.decode("#F3F3F3"));
        g2d.fillRect(0, 0, Fenetre.largeur, Fenetre.hauteur);
        /*
         * A faire : liste de tous les IDs.
		 */
        if (i == 1) {
            g2d.setColor(Color.GREEN);
        } else if (i == 2) {
            g2d.setColor(Color.BLUE);
        }
        g2d.fillRect(0, 0, Fenetre.largeur, Fenetre.hauteur);
    }
}
