package lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

/**
 * This class stores the basic state necessary for the A* algorithm to compute a
 * path across a map.  This state includes a collection of "open waypoints" and
 * another collection of "closed waypoints."  In addition, this class provides
 * the basic operations that the A* pathfinding algorithm needs to perform its
 * processing.
 *
 * Этот класс содержит основное состояние, необходимое алгоритму А* для подсчета
 * пути по карте. Это состояние включает набор "открытых вершин" и другой
 * набор "закрытых вершин". Вдобавок, этот класс обеспечивает основные
 * операции, необходимые поисковому алгоритму А* для выполнения своей обработки.
 **/
public class AStarState
{
    /** This is a reference to the map that the A* algorithm is navigating.
     *
     * Это ссылка на карту, которая наводит алгоритм А*.
     **/
    private Map2D map;

    private HashMap<Location,Waypoint> openVerticles, closedVerticles;

    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     *
     * Инициализация нового состояния объекта для поисковика пути алгоритма А*.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
        openVerticles = new HashMap<>();
        closedVerticles = new HashMap<>();
    }

    /** Returns the map that the A* pathfinder is navigating.
     *
     * Возвращает карту для навигации поисковика пути алгоритма А*.
     **/
    public Map2D getMap()
    {
        return map;
    }

    /** Returns the current number of open waypoints.
     *
     * Возвращает текущее число открытых вершин
     **/
    public int numOpenWaypoints()
    {
        /** Done **/
        return openVerticles.size();
    }

    /**
     * This method scans through all open waypoints, and returns the waypoint
     * with the minimum total cost.  If there are no open waypoints, this method
     * returns <code>null</code>.
     *
     * Этот метод сканирует все открытые вершины и возвращает вершину
     * с наименьшей общей стоимостью. Иначе возвращает нуль.
     **/
    public Waypoint getMinOpenWaypoint()
    {
        /** DONE: Implement. **/
        if (!openVerticles.isEmpty()) {
            ArrayList<Waypoint> w = new ArrayList<>(openVerticles.values());
            Waypoint minCost = w.get(0);
            for (int i = 0; i < w.size(); i++) {
                if (minCost.getTotalCost() > w.get(i).getTotalCost())
                    minCost = w.get(i);
            }
            return minCost;
        }
        return null;
    }

    /**
     * This method adds a waypoint to (or potentially updates a waypoint already
     * in) the "open waypoints" collection.  If there is not already an open
     * waypoint at the new waypoint's location then the new waypoint is simply
     * added to the collection.  However, if there is already a waypoint at the
     * new waypoint's location, the new waypoint replaces the old one <em>only
     * if</em> the new waypoint's "previous cost" value is less than the current
     * waypoint's "previous cost" value.
     *
     * Этот метод добавляет вершины (или возможные обновления вершины) в набор
     * открытых вершин. Если
     **/
    public boolean addOpenWaypoint(Waypoint newWP)
    {
        /** DONE:  Implement. **/
        if (!openVerticles.containsKey(newWP.loc) || openVerticles.get(newWP.loc).getPreviousCost() > newWP.getPreviousCost()) {
            openVerticles.put(newWP.loc,newWP);
        }
        return false;
    }

    /**
     * Returns true if the collection of closed waypoints contains a waypoint
     * for the specified location.
     *
     * Возвращает 1 если набор закрытых вершин содержит вершину
     * для заданного местоположения.
     **/
    public boolean isLocationClosed(Location loc)
    {
        /** DONE: Implement. **/
        if(closedVerticles.containsKey(loc))
            return true;
        return false;
    }

    /**
     * This method moves the waypoint at the specified location from the
     * open list to the closed list.
     *
     * Этот метод передвигают вершину на заданное место из списка
     * открытых вершин в список закрытых.
     **/
    public void closeWaypoint(Location loc)
    {
        /** DONE: Implement. **/
        closedVerticles.put(loc,openVerticles.get(loc));
        openVerticles.remove(loc);
    }

}

