import java.util.*;

abstract class Transport {
    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
}

class Bus extends Transport {
    public Bus(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        double fare = 2 + (0.10 * distance);
        return Math.min(fare, 10);
    }
}

class Train extends Transport {
    public Train(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return 3 + (0.15 * distance);
    }
}

class Metro extends Transport {
    private double peakHourFactor;

    public Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    double calculateFare() {
        return (1.5 + (0.20 * distance)) * peakHourFactor;
    }
}

public class Transport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            Transport transport = null;

            if (type.equals("BUS")) {
                double distance = sc.nextDouble();
                transport = new Bus(distance);
            } else if (type.equals("TRAIN")) {
                double distance = sc.nextDouble();
                transport = new Train(distance);
            } else if (type.equals("METRO")) {
                double distance = sc.nextDouble();
                double factor = sc.nextDouble();
                transport = new Metro(distance, factor);
            }

            double fare = transport.calculateFare();
            total += fare;

            System.out.printf("%s: %.2f%n", type, fare);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}