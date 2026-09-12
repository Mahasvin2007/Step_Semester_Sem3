public class findTopThreeScores {

    static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score > first) {
                third = second;
                second = first;
                first = score;
            } else if (score > second) {
                third = second;
                second = score;
            } else if (score > third) {
                third = score;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 99, 88, 95};

        int[] topThree = findTopThreeScores(scores);

        System.out.println("Top 3 Scores: "
                + topThree[0] + ", "
                + topThree[1] + ", "
                + topThree[2]);
    }
}