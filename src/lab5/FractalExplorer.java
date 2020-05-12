package lab5;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;

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
        JButton saveButton = new JButton("Save graphic");
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(resetButton);
        bottomPanel.add(saveButton);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        ButtonHandler resetHandler = new ButtonHandler(),
                saveHandler = new ButtonHandler();
        resetButton.addActionListener(resetHandler);
        saveButton.addActionListener(saveHandler);

        MouseHandler click = new MouseHandler();
        jid.addMouseListener(click);

        JComboBox box = new JComboBox();
        FractalGenerator mandelbrot = new Mandelbrot(),
                tricorn = new Tricorn(),
                burningShip = new BurningShip();
        box.addItem(mandelbrot);
        box.addItem(tricorn);
        box.addItem(burningShip);

        ButtonHandler chooseFractal = new ButtonHandler();
        box.addActionListener(chooseFractal);

        JPanel upperPanel = new JPanel();
        JLabel label = new JLabel("Used fractal:");
        upperPanel.add(label);
        upperPanel.add(box);
        frame.add(upperPanel,BorderLayout.NORTH);

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

            if (e.getSource() instanceof JComboBox) {
                JComboBox mySource = (JComboBox) e.getSource();
                fgen = (FractalGenerator) mySource.getSelectedItem();
                fgen.getInitialRange(range);
                drawFractal();

            }
            else if (command.equals("Reset display")) {
                fgen.getInitialRange(range);
                drawFractal();
            }
            else if (command.equals("Save graphic")) {

                JFileChooser chooser = new JFileChooser();
                FileFilter filter = new FileNameExtensionFilter("PNG Images", "png");
                chooser.setFileFilter(filter);
                chooser.setAcceptAllFileFilterUsed(false);

                int userSelection = chooser.showSaveDialog(jid);
                if (userSelection == JFileChooser.APPROVE_OPTION) {

                    File file = chooser.getSelectedFile();


                    try {
                        BufferedImage image = jid.getImage();
                        ImageIO.write(image, "png", file);
                    }
                    catch (Exception exception) {
                        JOptionPane.showMessageDialog(jid, exception.getMessage(), "Cannot Save Image", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else return;
            }
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
