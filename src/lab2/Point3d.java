package lab2;

import java.lang.*;

/**  **/
public class Point3d extends Point2d {

    /** координата Z **/
    protected double zCoord;

    /** конструктор инициализации **/
    public Point3d(double x, double y, double z){
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }
    /** конструктор по умолчанию **/
    public Point3d(){
        this(0,0,0);
    }

    /** получение Z **/
    public double z(){
        return zCoord;
    }
    /** изменение Z **/
    public void z(double val){
        zCoord = val;
    }

    /** расстояние до другой точки **/
    public double distanceTo(Point3d p){
        /** разность по Ox **/
        double dX = Math.abs(xCoord - p.x());
        /** разность по Oy **/
        double dY = Math.abs(yCoord - p.y());
        /** разность по Oz **/
        double dZ = Math.abs(zCoord - p.z());
        /** расстояние между трехмерными точками **/
        return Math.sqrt(dZ * dZ + Math.sqrt(dY * dY + dX * dX));
    }

    /** сравнение двух трехмерных точек **/
    public boolean equalsTo(Point3d p){
        return (xCoord == p.x() && yCoord == p.y() && zCoord == p.z());
    }
}
