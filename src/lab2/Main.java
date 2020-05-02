package lab2;

import java.util.Scanner;

public class
Main {
    // вычисление площади треугольника
    public static double computeArea(Point3d p1, Point3d p2, Point3d p3){
        double a = p1.distanceTo(p2);
        double b =  p1.distanceTo(p3);
        double c = p2.distanceTo(p3);
        double p = (a + b + c)/2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        double x, y, z;

        Point2d myPoint = new Point2d ();//создает точку (0,0)
        Point2d myOtherPoint = new Point2d (5,3);//создает точку (5,3)
        Point2d aThirdPoint = new Point2d ();

        System.out.println(myPoint.equalsTo(myOtherPoint));
        System.out.println(myPoint.equalsTo(aThirdPoint));
        System.out.println(myOtherPoint.equalsTo(aThirdPoint));

        x = read.nextDouble();
        y = read.nextDouble();
        z = read.nextDouble();
        Point3d p1 = new Point3d(x, y, z);

        x = read.nextDouble();
        y = read.nextDouble();
        z = read.nextDouble();
        Point3d p2 = new Point3d(x, y, z);

        x = read.nextDouble();
        y = read.nextDouble();
        z = read.nextDouble();
        Point3d p3 = new Point3d(x, y, z);

        if (!p1.equalsTo(p2))
            if (!p1.equalsTo(p3))
                if (!p2.equalsTo(p3)) {
                    double square = computeArea(p1, p2, p3);
                    System.out.println("Triangle square is " + square);
                } else System.out.println("p2 = p3, triangle doesn't exist");
            else System.out.println("p1 = p3, triangle doesn't exist");
        else System.out.println("p1 = p2, triangle doesn't exist");
    }
}
