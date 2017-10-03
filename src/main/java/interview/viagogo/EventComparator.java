package interview.viagogo;

import java.util.Comparator;

/**
 * Created by zubairchowdhury on 02/10/2017.
 */
public class EventComparator implements Comparator<Event> {

    private Point start;

    public EventComparator(Point start) {
        this.start = start;
    }


    public int compare(Event x, Event y) {
        int manhattanEventOne = x.getManhattan(start);
        int manhattanEventTwo = y.getManhattan(start);

        if (manhattanEventOne == manhattanEventTwo) {

            int xPrice = x.getCheapestAvailableTicket().getPrice();
            int yPrice = y.getCheapestAvailableTicket().getPrice();
            return xPrice - yPrice;
        }
        return manhattanEventOne - manhattanEventTwo;
    }
}
