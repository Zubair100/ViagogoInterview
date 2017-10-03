package interview.viagogo;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zubairchowdhury on 01/10/2017.
 */
public class Event {


    private Point p;
    private int id;
    private HashMap<Integer, Ticket> tickets;
    private int ticketCount;

    // manhattan distance of Event from the given start point
    // this is set when the manhattan distance is calculated for a given point.
    private int manhattan;

    public Event(int id, Point p, HashMap<Integer, Ticket> tickets, int ticketCount) {
        this.id = id;
        this.p = p;
        this.tickets = tickets;
        this.ticketCount = ticketCount;
    }

    public boolean isSoldOut() {
        return ticketCount == 0;
    }

    public int getXcoordinate() {
        return p.getX();
    }

    public int getYcoordinate() {
        return p.getY();
    }

    public Ticket getCheapestAvailableTicket() {

        // The reason this is an exception is because it should be checked
        // if an event is sold out before attempting to retrieve the cheapest tickets.
        if (tickets.isEmpty()) {
           throw new RuntimeException("Tickets are sold out: call isSoldOut before attempting to get cheapest tickets.");
        }

        Ticket lowest = new Ticket(Integer.MAX_VALUE, -1);
        for (Ticket t : tickets.values()) {
            if (t.getPrice() < lowest.getPrice()) {
                lowest = t;
            }
        }
        return lowest;
    }

    public int getManhattan(Point start) {
        manhattan = Math.abs(p.getX() - start.getX()) + Math.abs(p.getY() - start.getY());
        return manhattan;
    }

    public String toString() {
        return "Event " + id + " - " + getCheapestAvailableTicket().toString() + ", " +
                "Distance " + manhattan + "\n";
    }


}
