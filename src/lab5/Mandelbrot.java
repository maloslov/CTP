package lab5;

import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {
    public static final int MAX_ITERATIONS = 2000;
    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.height = 3;
        range.width = 3;
    }

    @Override
    public int numIterations(double x, double y) {
        int i = 0;
        double zRe = 0,
                zIm = 0;

        //Считает итерации по комплексным числам
        while(i < MAX_ITERATIONS && (zRe*zRe + zIm*zIm) < 4){
            double zReNew = zRe*zRe - zIm*zIm + x,
                zImNew = zRe*zIm*2 + y;
            zRe = zReNew;
            zIm = zImNew;
            i++;
        }
        //Возврат при превышении порога итераций
        if(i == MAX_ITERATIONS)
            return -1;

        return i;
    }

    @Override
    public String toString() {
        return "Mandelbrot";
    }
}
