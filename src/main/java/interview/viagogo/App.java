package interview.viagogo;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Grid grid = Grid.getInstance(-10, 10, -10, 10);

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Please input co-ordinates in the following formi : \"num1,num2\"");
            String line = scan.nextLine();
            String[] numbers = line.split(",");
            Integer num1 = Integer.parseInt(numbers[0]);
            Integer num2 = Integer.parseInt(numbers[1]);
            Point start = new Point(num1, num2);

            System.out.println("Closest events to " + line + ":");
            System.out.println(grid.getFiveClosestEvents(start));
        }



    }
}
