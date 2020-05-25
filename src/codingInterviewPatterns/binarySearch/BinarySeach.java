package codingInterviewPatterns.binarySearch;

class BinarySearch {

    public static int search(int[] arr, int key) {
        if(arr == null || arr.length == 0)
            return -1;
        boolean increasing = arr[0] < arr[arr.length-1] ? true : false;
        int res = findIndex(arr, 0, arr.length-1, key, increasing);
        return res;
    }

    public static int findIndex(int[] arr, int start, int end, int key, boolean increasing) {
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(arr[mid] == key)
                return mid;
            if(increasing) {
                if(arr[mid] < key) {
                    start = mid+1;
                } else {
                    end = mid -1;
                }
            } else {
                if(arr[mid] < key) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }
        }
        return -1;
    }

    public static int findLeftFirstOne(int[][] arr, int j, int start, int end) {
        while(start <= end) {
            int mid = (end - start)/2 + start;
            if(arr[mid][j] == 1 && ((mid > 0 && arr[mid-1][j] == 0) || mid == 0)) {
                return mid;
            } else if(arr[mid][j] == 1) {
                end = mid -1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }

    public static int findOneDiagonal(int[][] arr) {
        int i = 0, res = -1;
        int j = arr[0].length-1;
        while(i < arr.length && j >= 0) {
            if(arr[i][j] == 1) {
                j--;
                res = i;
            } else {
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {{0,1,1,1}, {0,0,1,1}, {0,1,1,1}};
        BinarySearch.findOneDiagonal(arr);
        for(int j=0;j<arr[0].length; j++) {
            int res = BinarySearch.findLeftFirstOne(arr, j, 0, arr.length-1);
            if(res != -1) {
                System.out.println("find first left " + j);
                break;
            }
        }

        System.out.println(BinarySearch.search(new int[] { 4, 6, 10 }, 10));
        System.out.println(BinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
        System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 10));
        System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 4));
    }
}