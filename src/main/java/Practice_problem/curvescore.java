import java.util.Arrays;

public class curvescore {

    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        int[] scores = {78, 85, 92, 67, 88};
        int bonus = 5;

        curveScores(scores, bonus);

        System.out.println(Arrays.toString(scores));
    }
}