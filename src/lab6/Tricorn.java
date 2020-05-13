package lab6;

import java.awt.geom.Rectangle2D;

public class Tricorn extends FractalGenerator {
    public static final int MAX_ITERATIONS = 2000;
    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -2;
        range.height = 4;
        range.width = 4;
    }

    @Override
    public int numIterations(double x, double y) {
        int i = 0;
        double zRe = 0,
                zIm = 0;

        //Считает итерации по комплексным числам
        while(i < MAX_ITERATIONS && (zRe*zRe + zIm*zIm) < 4){
            double zReNew = zRe*zRe - zIm*zIm + x,
                    zImNew = zRe*zIm*-2 + y;
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
        return "Tricorn";
    }
}
