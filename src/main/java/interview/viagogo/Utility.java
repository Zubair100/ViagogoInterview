package interview.viagogo;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by zubairchowdhury on 01/10/2017.
 */
public class Utility {

    private static final int MIN_NO_EVENTS = 10;
    private static final int MIN_NO_TICKETS = 0;
    private static final int MAX_NO_TICKETS = 250;
    private static final int MIN_PRICE_TICKETS = 5;
    private static final int MAX_PRICE_TICKETS = 250;
    /*
        Creates list of random unique events.
     */
    public static List<Event> createRandomEvents(Grid g) {

        List<Event> events = new ArrayList<Event>();

        // Create a list of random points where events will be placed
        List<Point> points = createRandomPoints(MIN_NO_EVENTS, g.getY_AXIS_MIN(), g.getY_AXIS_MAX(), g.getX_AXIS_MIN(), g.getX_AXIS_MAX());

        int eventId = 0;
        HashMap<Integer, Ticket> tickets;

        // Create an event for each of the random points
        for (Point p : points) {
            tickets = createRandomTickets();
            events.add(new Event(eventId, p, tickets, tickets.size()));
            eventId++;
        }

        return events;
    }

    public static List<Point> createRandomPoints(int min_number, int y_axis_min, int y_axis_max, int x_axis_min, int x_axis_max) {

        HashSet<Point> seenPoints = new HashSet<Point>();
        List<Point> points = new ArrayList<Point>();

        while (min_number > 0) {

            int randomXAxis = ThreadLocalRandom.current().nextInt(x_axis_min, x_axis_max + 1);
            int randomYAxis = ThreadLocalRandom.current().nextInt(y_axis_min, y_axis_max + 1);

            Point p = new Point(randomXAxis, randomYAxis);

            if (!seenPoints.contains(p)) {
               min_number--;
                points.add(p);
            }
        }

        return points;
    }

    /*
       Creates HashMap of random number of tickets.
    */
    public static HashMap<Integer, Ticket> createRandomTickets() {

        HashMap<Integer, Ticket> tickets = new HashMap<Integer, Ticket>();

        int randomNumberOfTickets = ThreadLocalRandom.current().nextInt(MIN_NO_TICKETS, MAX_NO_TICKETS + 1);
        int ticketId = 0;
        int randomPrice;

        // generate a random number of tickets with random prices
        while (randomNumberOfTickets > 0) {
            randomPrice = ThreadLocalRandom.current().nextInt(MIN_PRICE_TICKETS, MAX_PRICE_TICKETS + 1);
            tickets.put(ticketId, new Ticket(randomPrice, ticketId));
            ticketId++;
            randomNumberOfTickets--;
        }

        return tickets;
    }

}
