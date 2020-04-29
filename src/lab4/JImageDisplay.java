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
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(image, 0, 0, image.getWidth, image.getHeight, null);
    }
    public void clearImage(){

    }
    public void drawPixel(int x, int y, int rgbColor){

    }
}
