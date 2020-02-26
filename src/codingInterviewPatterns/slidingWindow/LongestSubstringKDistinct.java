package codingInterviewPatterns.slidingWindow;

import java.util.*;

class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        // TODO: Write your code here
        if(str == null || str.length() == 0)
            return -1;

        HashMap<Character,Integer> set = new HashMap<>();
        int windowStart=0,maxLength=0;
        for(int windowEnd=0;windowEnd<str.length();windowEnd++) {
            char c = str.charAt(windowEnd);
            if(set.containsKey(c)) {
                set.put(c, set.get(c)+1);
            } else {
                set.put(c, 1);
            }
            while(set.size() > k) {
                set.put(str.charAt(windowStart), set.get(str.charAt(windowStart))-1);
                if(set.get(c) == 0)
                    set.remove(c);
                windowStart++;
                maxLength = Math.max(maxLength, (windowEnd - windowStart+1));
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}
