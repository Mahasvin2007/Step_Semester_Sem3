import java.util.*;
public class Week1Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] options = {"Rock", "Paper", "Scissors"};
        String summary = "";
        int wins = 0, losses = 0, draws = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.print("Round " + i + " - Your move: ");
            String playerMove = sc.next();
            String computerMove = options[new Random().nextInt(3)];
            String result = playRound(playerMove, computerMove);
            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
            summary += i + "\t| " + playerMove + "\t| " + computerMove + "\t| " + result + "\n";
            System.out.println("Computer chose: " + computerMove + " -> " + result + "\n");
        }

        System.out.print(summary);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n",
                wins, losses, draws, (wins * 100.0 / 5));
    }
    public static String playRound(String p, String c) {
        if (p.equalsIgnoreCase(c)) return "Draw";
        if ((p.equalsIgnoreCase("Rock") && c.equals("Scissors")) ||
                (p.equalsIgnoreCase("Paper") && c.equals("Rock")) ||
                (p.equalsIgnoreCase("Scissors") && c.equals("Paper"))) return "Player Wins";
        return "Computer Wins";
    }
}