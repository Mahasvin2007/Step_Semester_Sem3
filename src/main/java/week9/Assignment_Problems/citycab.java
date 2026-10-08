import java.util.*;

interface NightService {
    double getNightFare(double fare);
}

abstract class Cab {
    protected double km;

    public Cab(double km) {
        this.km = km;
    }

    abstract double calculateFare();

    protected double applyMinimumFare(double fare) {
        return Math.max(fare, 100);
    }
}

class Mini extends Cab {
    public Mini(double km) {
        super(km);
    }

    @Override
    double calculateFare() {
        return applyMinimumFare(km * 10);
    }
}

class Sedan extends Cab implements NightService {
    public Sedan(double km) {
        super(km);
    }

    @Override
    double calculateFare() {
        return applyMinimumFare(km * 14);
    }

    @Override
    public double getNightFare(double fare) {
        return fare * 1.20;
    }
}

class SUV extends Cab implements NightService {
    public SUV(double km) {
        super(km);
    }

    @Override
    double calculateFare() {
        return applyMinimumFare(km * 18);
    }

    @Override
    public double getNightFare(double fare) {
        return fare * 1.20;
    }
}

public class citycab {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab = null;

            switch (type) {
                case "MINI":
                    cab = new Mini(km);
                    break;
                case "SEDAN":
                    cab = new Sedan(km);
                    break;
                case "SUV":
                    cab = new SUV(km);
                    break;
            }

            if (time.equals("NIGHT") && cab instanceof Mini) {
                System.out.println("MINI: night service not available");
                continue;
            }

            double fare = cab.calculateFare();

            if (time.equals("NIGHT") && cab instanceof NightService) {
                fare = ((NightService) cab).getNightFare(fare);
            }

            total += fare;
            System.out.printf("%s: %.2f%n", type, fare);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}