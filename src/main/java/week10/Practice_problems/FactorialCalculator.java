import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read a non-negative integer
        int n = sc.nextInt();

        long factorial = 1;

        // Calculate factorial
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        // Print result
        System.out.println(factorial);

        sc.close();
    }
}