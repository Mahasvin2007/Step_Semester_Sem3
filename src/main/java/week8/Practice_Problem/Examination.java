import java.util.*;
import java.util.regex.*;

abstract class Question {
    protected String correctAnswer;
    protected String studentAnswer;
    protected int points;

    public Question(String correctAnswer, String studentAnswer, int points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double evaluate();
}

class MCQQuestion extends Question {
    public MCQQuestion(String correctAnswer, String studentAnswer, int points) {
        super(correctAnswer, studentAnswer, points);
    }

    @Override
    double evaluate() {
        return correctAnswer.equals(studentAnswer) ? points : 0;
    }
}

class TFQuestion extends Question {
    public TFQuestion(String correctAnswer, String studentAnswer, int points) {
        super(correctAnswer, studentAnswer, points);
    }

    @Override
    double evaluate() {
        return correctAnswer.equals(studentAnswer) ? points : 0;
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String correctAnswer, String studentAnswer, int points) {
        super(correctAnswer, studentAnswer, points);
    }

    @Override
    double evaluate() {
        String[] keywords = correctAnswer.split(",");
        int count = 0;

        String answer = studentAnswer.toLowerCase();

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }
}

public class Examination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double totalScore = 0;

        Pattern pattern = Pattern.compile("\"([^\"]*)\"");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            String type = line.split(" ")[0];

            Matcher matcher = pattern.matcher(line);
            ArrayList<String> fields = new ArrayList<>();

            while (matcher.find()) {
                fields.add(matcher.group(1));
            }

            int points = Integer.parseInt(
                    line.substring(line.lastIndexOf(" ") + 1));

            Question q = null;

            if (type.equals("MCQ")) {
                q = new MCQQuestion(fields.get(1), fields.get(2), points);
            } else if (type.equals("TF")) {
                q = new TFQuestion(fields.get(1), fields.get(2), points);
            } else if (type.equals("ESSAY")) {
                q = new EssayQuestion(fields.get(1), fields.get(2), points);
            }

            double score = q.evaluate();
            totalScore += score;

            System.out.printf("%s: %.2f%n", type, score);
        }

        System.out.printf("Total Score: %.2f%n", totalScore);

        sc.close();
    }
}