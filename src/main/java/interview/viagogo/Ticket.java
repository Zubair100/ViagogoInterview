package interview.viagogo;

/**
 * Created by zubairchowdhury on 01/10/2017.
 */
public class Ticket {

    private int price;
    private int id;

    public Ticket(int price, int id) {
        this.price = price;
        this.id = id;
    }


    public int getPrice() {
        return price;
    }


    public String toString() {
        return "$" + price;
    }

}
