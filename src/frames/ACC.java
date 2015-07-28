package frames;

import Main.Fenetre;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class ACC extends JPanel {

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, Fenetre.largeur, 60);
        try {
            g2d.drawImage(ImageIO.read(new File("image/LogoHaut.png")), 0, 0, 225, 60, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
