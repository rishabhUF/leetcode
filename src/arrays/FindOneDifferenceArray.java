package arrays;

import java.util.HashSet;

public class FindOneDifferenceArray {

    public static boolean validate(int[] arr) {
        if(arr == null || arr.length == 0) {
            return false;
        }

        HashSet<Integer> set = new HashSet<>();
        int n = arr.length;
        for(int i=0;i<n;i++) {
            if(set.contains(arr[i]-1) || set.contains(arr[i] + 1)) {
                return true;
            } else {
                set.add(arr[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {5,5,5,5,5,5};
        System.out.println(validate(arr));
    }
}
