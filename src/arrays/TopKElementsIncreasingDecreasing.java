package arrays;


// 1,2,3, flip, 40, 30, 20, 10 flip 6, 7, 8, 9 flip 90, 80, 70, 60

import java.util.ArrayList;
import java.util.List;

public class TopKElementsIncreasingDecreasing {

    public static int[] findTopKElements(int[] arr, int k) {
        int i = 0;
        int count = 0;
        final int flip = -999;
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        List<Integer> merged = new ArrayList<>();
        while(i < arr.length) {
            if(arr[i] == flip) {
                count++;
                i++;
                continue;
            }
            if(count == 0) {
                arr1.add(arr[i]);
            } else if(count == 1) {
                arr2.add(arr[i]);
            } else {
                //merge the list here.
                int l=0, n = 0, m = 0;
                while(l < arr1.size() || n < arr2.size()) {
                    if(l < arr1.size() && n < arr2.size()) {
                        if(arr1.get(l) < arr2.get(arr2.size()-1-n)) {
                            merged.add(arr1.get(l));
                            l++;
                        } else {
                            merged.add(arr2.get(arr2.size() - 1 - n));
                            n++;
                        }
                    } else if(l > arr1.size()-1) {
                        merged.add(arr2.get(arr2.size() - 1 - n));
                        n++;
                    } else {
                        merged.add(arr1.get(l));
                        l++;
                    }
                }
                arr1 = new ArrayList<>();
                for(int v=0;v<k;v++) {
                    arr1.add(merged.get(merged.size() - k + v));
                }
                arr2 = new ArrayList<>();
                count = 1;
                continue;
            }
            i++;
        }

        int[] res = new int[k];
        for(int t=0;t<k;t++) {
            res[t] = arr1.get(t);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] temp = new int[] {1,2,3,4, -999, 60, 40, 30, -999, 4,5,100 , -999, 90, 55, 45};
        int[] res = findTopKElements(temp, 4);
        System.out.println(res.toString());
    }
}
