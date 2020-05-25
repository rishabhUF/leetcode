package design;

import java.util.HashMap;
import java.util.Map;

public class StockSpanner {
    Map<Integer, Integer> map;
    int day=0;

    public StockSpanner() {
        map = new HashMap<>();
    }

    public int next(int price) {
        int currentDay = ++day;
        int res = 0;
        while(currentDay > 0) {
            if(map.get(currentDay--) <= price) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
    }
}
