package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {


    public ArrayList<Tuple> merge(ArrayList<Tuple> meetings) {
        sortMeetings(meetings);
        ArrayList result = new ArrayList<>();
        for (int i = 0; i < meetings.size() - 1; i++) {
            Tuple t1 = meetings.get(i);
            Tuple t2 = meetings.get(i + 1);
            if (t1.end > t2.start) {
                result.add(new Tuple(t1.start, t1.end > t2.end ? t1.end : t2.end));
            } else {
                result.add(t1);
            }
        }
        return result;
    }

    private void sortMeetings(ArrayList meetings) {
        meetings.sort(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                return o1.start - o2.start;
            }
        });

    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        Tuple t1  = new Tuple(0, 1);
        Tuple t2  = new Tuple(3, 5);
        Tuple t3  = new Tuple(4, 8);
        Tuple t4  = new Tuple(10, 12);
        Tuple t5  = new Tuple(9, 10);

        ArrayList<Tuple> merge = mergeIntervals.merge(new ArrayList<>(Arrays.asList(t1, t2, t3, t4, t5)));
        merge.forEach(m -> {
            System.out.println("(" + m.start + " ," + m.end + ")");
        });

    }
}
