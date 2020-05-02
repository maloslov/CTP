package lab4;

import com.sun.xml.internal.bind.v2.TODO;

import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {

    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.height = 3;
        range.width = 3;
    }

    @Override
    public int numIterations(double x, double y) {//I dunno how to realize the method
        /** TODO: Implement. */

        if((x*x+y*y)>4)
            return 1;
        return 0;
    }
}
