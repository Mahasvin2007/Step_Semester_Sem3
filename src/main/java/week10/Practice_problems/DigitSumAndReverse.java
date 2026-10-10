import java.util.Scanner;

public class DigitSumAndReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read a positive integer
        int num = sc.nextInt();

        int temp = num;
        int sum = 0;
        int reverse = 0;

        // Calculate sum of digits and reverse the number
        while (temp > 0) {
            int digit = temp % 10;  // Extract last digit
            sum += digit;           // Add to sum
            reverse = reverse * 10 + digit; // Build reversed number
            temp /= 10;             // Remove last digit
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);

        sc.close();
    }
}