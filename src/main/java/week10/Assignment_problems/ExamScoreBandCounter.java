public class ExamScoreBandCounter {

    // Find first index where value >= target
    public static int lowerBound(int[] scores, int target) {
        int left = 0, right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // Count scores in the range [low, high]
    public static int countInBand(int[] scores, int low, int high) {
        int start = lowerBound(scores, low);
        int end = lowerBound(scores, high + 1);

        return end - start;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};

        System.out.println(countInBand(scores, 42, 58));
        System.out.println(countInBand(scores, 90, 100));
    }
}