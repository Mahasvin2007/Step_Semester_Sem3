import java.util.*;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double calculateFine();
}

class Book extends LibraryItem {
    public Book(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    double calculateFine() {
        return daysLate * 2;
    }
}

class DVD extends LibraryItem {
    public DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    double calculateFine() {
        return Math.min(daysLate * 5, 50);
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    double calculateFine() {
        return daysLate;
    }
}

public class Late_Fine_Counter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalFines = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();

            LibraryItem item = null;

            switch (type) {
                case "BOOK":
                    item = new Book(title, daysLate);
                    break;

                case "DVD":
                    item = new DVD(title, daysLate);
                    break;

                case "MAGAZINE":
                    item = new Magazine(title, daysLate);
                    break;
            }

            double fine = item.calculateFine();
            totalFines += fine;

            System.out.printf("%s: %.2f%n", title, fine);
        }

        System.out.printf("Total Fines: %.2f%n", totalFines);

        sc.close();
    }
}