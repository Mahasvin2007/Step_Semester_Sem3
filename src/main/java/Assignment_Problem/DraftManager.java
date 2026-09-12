package Assignment_Problem;
import java.util.Arrays;

class Player implements Comparable<Player> {
    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Established player rule
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // New player rule
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }
}

public class DraftManager {

    static String draftAndRank(Player[] players) {
        Player[] draftable = new Player[players.length];
        int count = 0;

        for (Player p : players) {
            if (Player.isDraftable(p.matchesPlayed) ||
                    Player.isDraftable(p.matchesPlayed, p.injured)) {
                draftable[count++] = p;
            }
        }

        Player[] ranked = Arrays.copyOf(draftable, count);
        Arrays.sort(ranked);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < ranked.length; i++) {
            result.append(i + 1).append(". ").append(ranked[i].name);

            if (i < ranked.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}