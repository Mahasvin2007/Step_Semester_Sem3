import java.util.Scanner;

public class EvenOddCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of elements
        int n = sc.nextInt();

        int evenCount = 0;
        int oddCount = 0;

        // Read elements and count even/odd numbers
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        // Print results
        System.out.println("Even: " + evenCount);
        System.out.println("Odd: " + oddCount);

        sc.close();
    }
}