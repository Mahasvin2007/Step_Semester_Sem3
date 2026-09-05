public class TrafficSignalStreakAnalyzer {

    public static void findLongestStreak(String signalLog) {
        char maxColor = signalLog.charAt(0);
        int maxLength = 1;

        char currentColor = signalLog.charAt(0);
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                currentLength++;
            } else {
                currentColor = signalLog.charAt(i);
                currentLength = 1;
            }

            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '" + maxColor +
                "' repeated " + maxLength + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
    }
}