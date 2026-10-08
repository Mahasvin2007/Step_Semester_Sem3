class PiggyBank {
    private double savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
            System.out.println("Savings = " + savings);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > savings) {
            System.out.println("Withdrawal rejected. Savings stays " + savings);
        } else if (amount > 0) {
            savings -= amount;
            System.out.println("Savings = " + savings);
        } else {
            System.out.println("Invalid withdrawal amount");
        }
    }

    public double getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }
}

public class piggybank{
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);

        System.out.println("Final Savings: " + pb.getSavings());
        System.out.println("Piggy Bank ID: " + pb.getId());
    }
}