package lab2;
/**
 * двумерный класс точки.
 **/
public class Point2d {

    /** координата X **/
    protected double xCoord;
    /**  координата Y **/
    protected double yCoord;

    /** Конструктор инициализации **/
    public Point2d (double x,  double y) {
        xCoord = x;
        yCoord = y;
    }

    /** Конструктор по умолчанию. **/
    public Point2d () {
        //Вызовите конструктор с двумя параметрами и определите источник.
        this(0, 0);
    }
    /** Возвращение координаты X **/
    public double x () {
        return xCoord;
    }
    /** Установка значения координаты X. **/
    public void x (double val) {
        xCoord = val;
    }
    /** Возвращение координаты Y **/
    public double y () {
        return yCoord;
    }
    /**  Установка значения координаты Y. **/
    public void  y (double val) {
        yCoord = val;
    }

    public double distanceTo(Point2d p){
        double dX = Math.abs(xCoord - p.x());
        double dY = Math.abs(yCoord - p.y());
        return Math.sqrt(dX * dX + dY * dY);
    }

    public boolean equalsTo(Point2d p){
        return (xCoord == p.x() && yCoord == p.y());
    }
}
