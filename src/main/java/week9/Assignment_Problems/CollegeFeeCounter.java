import java.util.*;

interface BusUser {
    double TRANSPORT_FEE = 12000;

    double getTransportFee();
}

abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    abstract double calculateFee();
}

class DayScholar extends Student implements BusUser {

    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double getTransportFee() {
        return TRANSPORT_FEE;
    }

    @Override
    double calculateFee() {
        return 40000 + getTransportFee();
    }
}

class Hosteller extends Student {

    public Hosteller(String name) {
        super(name);
    }

    @Override
    double calculateFee() {
        return 40000 + 60000;
    }
}

class Scholar extends Student implements BusUser {

    public Scholar(String name) {
        super(name);
    }

    @Override
    public double getTransportFee() {
        return TRANSPORT_FEE;
    }

    @Override
    double calculateFee() {
        return 20000 + getTransportFee();
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student student = null;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;

                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;

                case "SCHOLAR":
                    student = new Scholar(name);
                    break;
            }

            double fee = student.calculateFee();
            totalCollected += fee;

            System.out.printf("%s: %.2f%n", name, fee);
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);

        sc.close();
    }
}