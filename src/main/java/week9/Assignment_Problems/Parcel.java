import java.util.*;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    public Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();

    public double getTotal() {
        double insurance = 0;

        if (this instanceof Insurable) {
            insurance = ((Insurable) this).calculateInsurance();
        }

        return calculateCharge() + insurance;
    }
}

class StandardParcel extends Parcel {
    public StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    double calculateCharge() {
        return 40 + (10 * weight);
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    double calculateCharge() {
        return 80 + (15 * weight);
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    double calculateCharge() {
        return (40 + (10 * weight)) + 50;
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

public class Parcel{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            Parcel parcel = null;

            switch (type) {
                case "STANDARD":
                    parcel = new StandardParcel(weight, declaredValue);
                    break;

                case "EXPRESS":
                    parcel = new ExpressParcel(weight, declaredValue);
                    break;

                case "FRAGILE":
                    parcel = new FragileParcel(weight, declaredValue);
                    break;
            }

            double charge = parcel.calculateCharge();
            double insurance = 0;

            if (parcel instanceof Insurable) {
                insurance = ((Insurable) parcel).calculateInsurance();
            }

            double total = charge + insurance;
            grandTotal += total;

            System.out.printf(
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type, charge, insurance, total
            );
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);

        sc.close();
    }
}