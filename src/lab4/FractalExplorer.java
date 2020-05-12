package lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class FractalExplorer {
    private int windowSize;
    private JImageDisplay jid;
    private FractalGenerator fgen;
    private Rectangle2D.Double range;

    public FractalExplorer(int wSize){
        windowSize = wSize;
        fgen = new Mandelbrot();
        range = new Rectangle2D.Double();
        fgen.getInitialRange(range);
        jid = new JImageDisplay(windowSize,windowSize);
    }

    public void createAndShowGUI(){
        jid.setLayout(new BorderLayout());
        JFrame frame = new JFrame("Fractal Drawer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(jid, BorderLayout.CENTER);
        JButton resetButton = new JButton("Reset display");

        ButtonHandler resetHandler = new ButtonHandler();
        resetButton.addActionListener(resetHandler);

        MouseHandler click = new MouseHandler();
        jid.addMouseListener(click);

        frame.add(resetButton, BorderLayout.SOUTH);


        //contentPane.add(jid, BorderLayout.CENTER);
        //contentPane.add(resetButton, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void drawFractal(){

        for (int x = 0; x < windowSize; x++) {
            for (int y = 0; y < windowSize; y++) {
                double xCoord = fgen.getCoord(range.x, range.x + range.width, windowSize, x),
                        yCoord = fgen.getCoord(range.y, range.y + range.height, windowSize, y);
                int i = fgen.numIterations(xCoord, yCoord);
                if (i == -1)
                    jid.drawPixel(x, y, 0);
                else {
                    float hue = 0.7f + (float) i / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    jid.drawPixel(x, y, rgbColor);
                }
            }

        }

        jid.repaint();
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();

            fgen.getInitialRange(range);
            drawFractal();
        }
    }
    private class MouseHandler extends MouseAdapter {
        public void mouseClicked(MouseEvent e){
            int x = e.getX(),
                    y = e.getY();
            double xCoord = fgen.getCoord(range.x,range.x + range.width, windowSize,x),
                    yCoord = fgen.getCoord(range.y,range.y + range.height, windowSize,y);
            fgen.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            drawFractal();
        }
    }

    public static void main(String[] args){
        FractalExplorer frexp = new FractalExplorer(500);
        frexp.createAndShowGUI();
        frexp.drawFractal();
    }
}
