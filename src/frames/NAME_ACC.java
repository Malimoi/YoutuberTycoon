package frames;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class NAME_ACC extends JPanel {

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 300, 50);
    }
}
