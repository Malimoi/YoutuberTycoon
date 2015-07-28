package frames;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class MINI extends JPanel {
    private String path;

    public MINI(String path) {
        this.path = path;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        try {
            g2d.drawImage(ImageIO.read(new File(path)), 0, 0, 25, 25, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
