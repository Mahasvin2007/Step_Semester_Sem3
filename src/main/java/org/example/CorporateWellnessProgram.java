import java.util.Random;

public class CorporateWellnessProgram {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.printf("%-10s %-12s %-12s %-10s %-15s%n",
                "Person", "Height(m)", "Weight(kg)", "BMI", "Status");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);

            System.out.printf("%-10s %-12.2f %-12.2f %-10.2f %-15s%n",
                    "Person " + (i + 1),
                    heights[i],
                    weights[i],
                    bmi,
                    status);
        }
    }

    public static void main(String[] args) {
        int n = 10;

        double[] heights = new double[n];
        double[] weights = new double[n];

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            heights[i] = 1.50 + (random.nextDouble() * 0.50);
            weights[i] = 45 + (random.nextDouble() * 55);
        }

        printWellnessReport(heights, weights);
    }
}