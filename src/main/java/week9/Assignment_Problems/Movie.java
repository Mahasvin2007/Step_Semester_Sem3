import java.util.*;

abstract class Ticket {
    protected int count;
    protected static final double CONVENIENCE_FEE = 20;

    public Ticket(int count) {
        this.count = count;
    }

    abstract double getTicketPrice();

    public double calculateAmount() {
        return count * (getTicketPrice() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super(count);
    }

    @Override
    double getTicketPrice() {
        return 150;
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    double getTicketPrice() {
        return 250;
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    double getTicketPrice() {
        return 400;
    }
}

public class Movie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seatType = sc.next();
            int count = sc.nextInt();

            Ticket ticket = null;

            switch (seatType) {
                case "REGULAR":
                    ticket = new RegularTicket(count);
                    break;
                case "PREMIUM":
                    ticket = new PremiumTicket(count);
                    break;
                case "RECLINER":
                    ticket = new ReclinerTicket(count);
                    break;
            }

            double amount = ticket.calculateAmount();
            total += amount;

            System.out.printf("%s: %.2f%n", seatType, amount);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}