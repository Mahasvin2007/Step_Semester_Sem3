public class SeatingClassifier {

    private static double rowAverage(int[] row) {
        int sum = 0;

        for (int score : row) {
            sum += score;
        }

        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);

            if (avg < threshold) {
                result.append("Row ")
                        .append(i + 1)
                        .append(": Quiet Zone");
            } else {
                result.append("Row ")
                        .append(i + 1)
                        .append(": Buzzing Zone");
            }

            if (i < seatingScores.length - 1) {
                result.append("\n");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] seatingScores = {
                {40, 50, 60},
                {80, 90, 85},
                {55, 60, 50}
        };

        int threshold = 65;

        System.out.println(classifyRows(seatingScores, threshold));
    }
}
