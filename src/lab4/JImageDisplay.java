package lab4;

import javax.swing.JComponent;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class JImageDisplay extends JComponent {

    private BufferedImage bufIm;

    public JImageDisplay(int width, int height){
        bufIm = new BufferedImage(width, height, TYPE_INT_RGB);
        setPreferredSize(new Dimension(width,height));
    }

    @Override
    protected void paintComponent(Graphics g) {//Need Testing
        super.paintComponent(g);
        g.drawImage(bufIm, 0, 0, bufIm.getWidth(), bufIm.getHeight(), null);
    }
    public void clearImage(){ //Need Testing
        bufIm.setRGB(0,0,bufIm.getWidth(), bufIm.getHeight(), null,0,0);
    }
    public void drawPixel(int x, int y, int rgbColor){
        bufIm.setRGB(x, y, rgbColor);
    }
}
