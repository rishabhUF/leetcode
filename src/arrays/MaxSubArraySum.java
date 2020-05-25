package arrays;

public class MaxSubArraySum {

    static int findMaxSubArraySum(int[] arr) {
        if(arr == null || arr.length == 0)
            return 0;

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int result = Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++) {
            dp[i] = Math.max(dp[i-1], 0) + arr[i];
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    static int findMaxSubArrayNoSpaceSum(int[] arr) {
        if(arr == null || arr.length == 0)
            return 0;
        int preSum = arr[0];
        int result = Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++) {
            int currSum = Math.max(preSum, 0) + arr[i];
            preSum = currSum;
            result = Math.max(result, currSum);
        }
        return  result;
    }

    static int findMaxSubArrayCircularSum(int[] arr) {
        if(arr == null || arr.length == 0)
            return 0;
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,-2,3,-2};
        System.out.println(findMaxSubArraySum(arr));
        System.out.println(findMaxSubArrayNoSpaceSum(arr));
    }
}
