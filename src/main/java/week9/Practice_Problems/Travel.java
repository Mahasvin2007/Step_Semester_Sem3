import java.util.*;

abstract class Booking {
    protected double distance;
    protected static final double BOOKING_FEE = 50;

    public Booking(double distance) {
        this.distance = distance;
    }

    abstract double calculateBaseFare();

    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class Bus extends Booking {
    public Bus(double distance) {
        super(distance);
    }

    @Override
    double calculateBaseFare() {
        return distance * 2;
    }
}

class Train extends Booking {
    public Train(double distance) {
        super(distance);
    }

    @Override
    double calculateBaseFare() {
        return distance * 1.5;
    }
}

class Flight extends Booking {
    public Flight(double distance) {
        super(distance);
    }

    @Override
    double calculateBaseFare() {
        return 2500 + (distance * 4);
    }
}

public class Travel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            Booking booking = null;

            switch (mode) {
                case "BUS":
                    booking = new Bus(distance);
                    break;
                case "TRAIN":
                    booking = new Train(distance);
                    break;
                case "FLIGHT":
                    booking = new Flight(distance);
                    break;
            }

            System.out.printf("%s: %.2f%n",
                    mode, booking.calculateTotalFare());
        }

        sc.close();
    }
}