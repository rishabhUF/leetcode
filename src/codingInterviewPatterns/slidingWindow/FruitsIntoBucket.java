package codingInterviewPatterns.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBucket {

    public static int findLength(char[] arr) {
        if (arr == null) {
            return 0;
        }

        int right = 0;
        int left = 0;
        int max = 0;
        Map<Character, Integer> hm = new HashMap<>();
        while (right < arr.length) {
            char curr = arr[right];
            if (hm.containsKey(curr)) {
                hm.put(curr, hm.get(curr) + 1);
                right++;
            } else if (hm.size() < 2) {
                hm.put(curr, 1);
                right++;
            } else {
                char currLeft = arr[left++];
                hm.put(currLeft, hm.get(currLeft) - 1);
                if (hm.get(currLeft) == 0) {
                    hm.remove(currLeft);
                }
            }
            max = Math.max(max, (right - left ));
        }
        return max;
    }


    public static int findLengthImproved(char[] arr) {

        return 0;
    }
    public static void main(String[] args) {
        char[] arr = {'A', 'B', 'C', 'B', 'B', 'C'};
        System.out.println(findLength(arr));
    }
}
