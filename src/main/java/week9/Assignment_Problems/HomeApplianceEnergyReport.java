import java.util.*;

interface SaverMode {
    double getSaverUnits(double units);
}

abstract class Appliance {
    protected double hours;
    protected static final double COST_PER_UNIT = 8.0;

    public Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPowerRating();

    public double calculateUnits() {
        return (getPowerRating() * hours) / 1000.0;
    }

    public double calculateCost(double units) {
        return units * COST_PER_UNIT;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours) {
        super(hours);
    }

    @Override
    double getPowerRating() {
        return 150;
    }
}

class AC extends Appliance implements SaverMode {
    public AC(double hours) {
        super(hours);
    }

    @Override
    double getPowerRating() {
        return 1500;
    }

    @Override
    public double getSaverUnits(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {
    public TV(double hours) {
        super(hours);
    }

    @Override
    double getPowerRating() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {
    public Washer(double hours) {
        super(hours);
    }

    @Override
    double getPowerRating() {
        return 500;
    }

    @Override
    public double getSaverUnits(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");

            String type = input[0];
            double hours = Double.parseDouble(input[1]);
            boolean saverRequested =
                    input.length == 3 && input[2].equals("SAVER");

            Appliance appliance = null;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AC(hours);
                    break;
                case "TV":
                    appliance = new TV(hours);
                    break;
                case "WASHER":
                    appliance = new Washer(hours);
                    break;
            }

            if (saverRequested && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits();

            if (saverRequested) {
                units = ((SaverMode) appliance).getSaverUnits(units);
            }

            double cost = appliance.calculateCost(units);
            totalCost += cost;

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost
            );
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);

        sc.close();
    }
}