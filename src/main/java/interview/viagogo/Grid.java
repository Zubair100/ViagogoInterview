package interview.viagogo;

import java.util.*;

/**
 * Created by zubairchowdhury on 01/10/2017.
 */
public class Grid {

    private static Grid grid;
    private Event[][] eventGrid;
    private final int HEAP_CAPACITY = 100;

    // These are all default values in accordance to the spec but can be
    // changed by instantiating the grid constructor with the relevant parameters
    private int grid_size_x;
    private int grid_size_y;

    // the transformation variable is used to transform all
    // co-ordinates into array indexes so for example
    // the co-ordinate (-10,-10) is (0,0) in the array
    private int TRANSFORMATION_X;
    private int TRANSFORMATION_Y;

    // define the length of the axis
    private int x_axis_max;
    private int x_axis_min;
    private int y_axis_max;
    private int y_axis_min;

    private Grid(int y_axis_min, int y_axis_max, int x_axis_min, int x_axis_max) {
        this.x_axis_max = x_axis_max;
        this.x_axis_min = x_axis_min;
        this.y_axis_max = y_axis_max;
        this.y_axis_min = y_axis_min;

        this.grid_size_x = x_axis_max - x_axis_min + 1;
        this.grid_size_y = y_axis_max - y_axis_min + 1;

        if (x_axis_min < 0) {
            this.TRANSFORMATION_X = Math.abs(x_axis_min);
        }

        if (y_axis_min < 0) {
            this.TRANSFORMATION_Y = Math.abs(y_axis_min);
        }

        eventGrid = new Event[grid_size_x][grid_size_y];

    }

    /*
        Using Singleton pattern to enforce one grid object only.
    */

    public static Grid getInstance(int y_axis_min,int y_axis_max, int x_axis_min, int x_axis_max) {
        if (grid == null) {
            grid = new Grid(y_axis_min, y_axis_max, x_axis_min, x_axis_max);
            grid.populateGrid();
        }

        return grid;
    }

    private void populateGrid() {

        if (grid == null) {
            throw new RuntimeException("grid has not been instantiated");
        }

        List<Event> randomEvents = Utility.createRandomEvents(this);

        for (Event e : randomEvents) {
            eventGrid[e.getXcoordinate() + TRANSFORMATION_X][e.getYcoordinate() + TRANSFORMATION_Y] = e;
        }

    }

    /*
        Return String representation of 5 closest events.
     */
    public String getFiveClosestEvents(Point start) {

        PriorityQueue<Event> eventMinHeap = new PriorityQueue<Event>(HEAP_CAPACITY, new EventComparator(start));

        // iterates over grid and populates min heap with event's with the event comparator being defined
        // to compare on manhattan distance and also price
        for (int i = 0; i < eventGrid.length; i++) {
            for (int j = 0; j < eventGrid[0].length; j++) {
                Event e = eventGrid[i][j];
                if (e != null && !e.isSoldOut()) {
                    eventMinHeap.add(e);
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        int eventCount = 0;
        // extracts the 5 closest events from the min heap, providing there are 5 different events.
        if (!eventMinHeap.isEmpty()) {
            while (!eventMinHeap.isEmpty() && eventCount < 5) {
                builder.append(eventMinHeap.poll());
                eventCount++;

            }
        } else {
            return "There are no events local to " + start.toString();
        }

        return builder.toString();
    }

    public int getX_AXIS_MAX() {
        return x_axis_max;
    }

    public int getX_AXIS_MIN() {
        return x_axis_min;
    }

    public int getY_AXIS_MAX() {
        return y_axis_max;
    }

    public int getY_AXIS_MIN() {
        return y_axis_min;
    }

}
