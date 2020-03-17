package sorting;

public class QuickSort {


    public void sort(int[] arr, int low, int end) {
        if(low < end) {
            int pivot = partition(arr, low, end);
            sort(arr, low, pivot-1);
            sort(arr, pivot+1, end);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int pIndex = low-1;
        for(int i=low;i<high;i++) {
            if(pivot >= arr[i]) {
                pIndex++;
                swap(arr, pIndex, i);

            }
        }
        pIndex++;
        swap(arr, pIndex, high);
        return pIndex;
    }

    private void swap(int[] arr, int pIndex, int i) {
        int temp = arr[pIndex];
        arr[pIndex] = arr[i];
        arr[i] = temp;
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        QuickSort q = new QuickSort();
        q.sort(arr, 0, n-1);
        System.out.println("sorted array");
        printArray(arr);
    }
}
