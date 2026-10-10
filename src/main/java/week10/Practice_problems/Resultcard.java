import java.util.Scanner;

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    // Calculate average marks
    double calculateAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }

    // Assign grade based on average
    char assignGrade() {
        double avg = calculateAverage();

        if (avg >= 75) {
            return 'B';
        } else if (avg >= 60) {
            return 'C';
        } else if (avg >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    // Display result card
    void displayResult() {
        System.out.printf("%s: Average %.1f, Grade %c%n",
                name.toUpperCase(),
                calculateAverage(),
                assignGrade());
    }
}

public class Resultcard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.next();
        int[] marks = new int[3];

        for (int i = 0; i < 3; i++) {
            marks[i] = sc.nextInt();
        }

        Student student = new Student(name, marks);
        student.displayResult();

        sc.close();
    }
}