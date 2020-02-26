package codingInterviewPatterns.slidingWindow;

public class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        // TODO: Write your code here
        if(arr == null || arr.length == 0)
            return 0;
        int minLength = Integer.MAX_VALUE;
        int windowSum = 0, windowStart = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            while(windowSum >= S) {
                minLength = Math.min((windowEnd - windowStart + 1), minLength);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return minLength;
    }

    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArray(10, new int[] { 2, 6, 4, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }
}
