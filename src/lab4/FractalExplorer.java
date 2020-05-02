package lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

public class FractalExplorer {
    private int windowSize;
    private JImageDisplay jid;
    private FractalGenerator fgen;
    private Rectangle2D.Double rect;

    public FractalExplorer(int ws){
        windowSize = ws;
        fgen = new Mandelbrot();
        rect = new Rectangle2D.Double();
    }

    public void createAndShowGUI(){
        JFrame frame = new JFrame("Fractal Drawer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        jid = new JImageDisplay(windowSize,windowSize);

        JButton resetButton = new JButton("Reset display");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { drawFractal(); }
        });

        contentPane.add(jid, BorderLayout.CENTER);
        contentPane.add(resetButton, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
        //frame.setResizable(false);
    }

    private void drawFractal(){
        /** TODO: Implement. */
        double xCoord = FractalGenerator.getCoord(rect.x, rect.x+rect.width,windowSize, 0);
    }


    public static void main(String[] args){
        FractalExplorer frexp = new FractalExplorer(400);
        frexp.createAndShowGUI();
        frexp.drawFractal();
    }
}
