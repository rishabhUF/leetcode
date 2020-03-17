package sorting;

public class InsertionSort {

    public void sort(int[] arr) {
        for(int i = 1; i<arr.length; i++) {
            int j = i-1;
            int key = arr[i];
            while(j>=0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
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

        InsertionSort q = new InsertionSort();
        q.sort(arr);
        System.out.println("sorted array");
        printArray(arr);
    }
}
