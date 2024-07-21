public class MaximumPointsYouCanObtainFromCards {
    public static int bruteForce(int[] cardsPoints, int k) {
        int maxScore = 0;

        // Try every combination of taking cards from the left and the right
        for (int i = 0; i <= k; i++) {
            int leftSum = 0, rightSum = 0;

            // Calculate the sum of the first i cards from the left
            for (int j = 0; j < i; j++) {
                leftSum += cardsPoints[j];
            }

            // Calculate the sum of the last k-i cards from the right
            for (int j = 0; j < k - i; j++) {
                rightSum += cardsPoints[cardsPoints.length - 1 - j];
            }

            // Update the maximum score
            maxScore = Math.max(maxScore, leftSum + rightSum);
        }

        return maxScore;
    }

    public static int slidingWindow(int cardPoints[], int k) {
        int leftSum = 0, rightSum = 0, maxSum;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }

        maxSum = leftSum;

        int leftIdx = k - 1, rightIdx = cardPoints.length - 1;
        while (leftIdx >= 0) {
            leftSum -= cardPoints[leftIdx--];
            rightSum += cardPoints[rightIdx--];
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }

        return maxSum;
    }

    public static int maxScore(int[] cardPoints, int k) {
        return bruteForce(cardPoints, k);
    }

    public static void main(String[] args) {
        int cardPoints1[] = { 1, 2, 3, 4, 5, 6, 1 }, k1 = 3;
        System.out.println(maxScore(cardPoints1, k1));
        int cardPoints2[] = { 2, 2, 2 }, k2 = 2;
        System.out.println(maxScore(cardPoints2, k2));
        int cardPoints[] = { 9, 7, 7, 9, 7, 7, 9 }, k = 7;
        System.out.println(maxScore(cardPoints, k));
    }
}