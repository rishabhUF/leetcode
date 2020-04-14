package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 1 0 1 0 1
public class DalesQuestion {

    static List<Integer> temp = new ArrayList<>();
    static boolean lastOne = false;

    public static int getRealIndex(int[] nums, int k) {
        int[] temp = new int[nums.length];
        int i = 0;
        boolean start = true;

        Arrays.fill(nums, 0);

        while(i < nums.length) {
            if(start) {
                if(nums[i] == 1) {
                    temp[i] = 0;
                    if(i+1 < nums.length)
                        temp[i] = 0;
                    i++;
                } else if(nums[i] == 0) {
                    temp[i] = 0;
                }
                start = false;
            } else {
                if(nums[i] == 1) {
                    temp[i] += 1;
                    if(i+1 < nums.length)
                        temp[i] += 1;
                    i++;
                } else if(nums[i] == 0) {
                    temp[i] += 1;
                }
            }
            i++;
        }
        return temp[k];
    }

    public static void addElement(List<Integer> list,int n) {
        list.add(n);
    }

    public static int getRealIndex(List<Integer> list, int k) {
        int i = 0;
        int start = 0;
        int n = list.size();
        while(i < n) {
            if(lastOne) {
                temp.add(--start);
                i++;
            }
            else {
                if (list.get(i) == 1) {
                    temp.add(start);
                    i++;
                    if(i == n-1) {
                        lastOne = true;
                    } else {
                        temp.add(start);
                        i++;
                    }
                    start++;
                } else {
                    temp.add(start);
                    start++;
                    i++;
                }
            }
        }

        return temp.get(k);
    }

    public static void main(String[] args) {
        int[] nums = {1,0,0,1,0,0};
        System.out.println(getRealIndex(nums, 1));

        List<Integer> list = new ArrayList<>();
        addElement(list, 1);
        addElement(list, 0);
        addElement(list, 0);
        addElement(list, 1);
        addElement(list, 0);
        addElement(list, 0);
        System.out.println(getRealIndex(list, 2));

    }
}
