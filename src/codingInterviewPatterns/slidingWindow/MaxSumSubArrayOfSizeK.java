package codingInterviewPatterns.slidingWindow;

public class MaxSumSubArrayOfSizeK {

    public static int findMaxSumSubArray(int k, int[] arr) {
        if(arr == null || arr.length == 0)
            return -1;
        int left = 0, right=0, currentSum=0, maxSum = 0;
        while(right < arr.length) {
            currentSum += arr[right];
            if(right >= k-1) {
                maxSum = Math.max(maxSum, currentSum);
                currentSum -= arr[left];
                left++;
            }
            right++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] {2, 1, 5, 1, 3, 2}));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}
