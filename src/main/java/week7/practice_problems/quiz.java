class Scorecard {
    private boolean[] results;
    private int currentIndex;

    public Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        currentIndex = 0;
    }

    public void recordAnswer(boolean result) {
        if (currentIndex < results.length) {
            results[currentIndex] = result;
            currentIndex++;
        } else {
            System.out.println("Cannot record more answers. Scorecard is full.");
        }
    }

    public int getScore() {
        int score = 0;
        for (boolean result : results) {
            if (result) {
                score++;
            }
        }
        return score;
    }
}

public class quiz {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}