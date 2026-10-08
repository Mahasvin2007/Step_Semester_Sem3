import java.util.*;

abstract class Staff {
    protected String name;

    public Staff(String name) {
        this.name = name;
    }

    abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private int hours;
    private double rate;

    public HourlyStaff(String name, int hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * rate * 1.5);
        }
    }
}

class Intern extends Staff {
    private double stipend;

    public Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    double calculatePay() {
        return stipend;
    }
}

public class Weekly {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalPayroll = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Staff staff = null;

            switch (type) {
                case "FULLTIME":
                    double salary = sc.nextDouble();
                    staff = new FullTimeStaff(name, salary);
                    break;

                case "HOURLY":
                    int hours = sc.nextInt();
                    double rate = sc.nextDouble();
                    staff = new HourlyStaff(name, hours, rate);
                    break;

                case "INTERN":
                    double stipend = sc.nextDouble();
                    staff = new Intern(name, stipend);
                    break;
            }

            double pay = staff.calculatePay();
            totalPayroll += pay;

            System.out.printf("%s: %.2f%n", name, pay);
        }

        System.out.printf("Total Payroll: %.2f%n", totalPayroll);

        sc.close();
    }
}