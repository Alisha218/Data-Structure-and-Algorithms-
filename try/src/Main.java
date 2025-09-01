class Main {
    public static void sort(int arr[], int l, int r) {
        if (l < r) {
            System.out.println("Starting of main sort ");
            // Find the middle point
            int m = l + (r - l) / 2;            System.out.println("finding mid ");

            // Sort first and second halves
            sort(arr, l, m);            System.out.println("completed sort of first half ");
            sort(arr, m + 1, r);            System.out.println("completed sort of second half ");

            // Merge the sorted halves
            merge(arr, l, m, r);            System.out.println("completed merge ");
        }
    }

    public static void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;            System.out.println("m1");
        int n2 = r - m;            System.out.println("m2");
        // Create temp arrays
        int L[] = new int[n1];            System.out.println("m3");
        int R[] = new int[n2];            System.out.println("m4");

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i) {           System.out.println("m5 For loop");
            L[i] = arr[l + i];
            System.out.println("l1c1");}
        for (int j = 0; j < n2; ++j){            System.out.println("m6 for loop 2");
            R[j] = arr[m + 1 + j];            System.out.println("l2c1");}

        // Merge the temp arrays Initial indices of 1st and 2nd subarrays
        int i = 0, j = 0;            System.out.println("m7");
        // Initial index of merged subarray array
        int k = l;            System.out.println("m8");
        while (i < n1 && j < n2) {            System.out.println("m9 while loop");
            if (L[i] <= R[j]) {            System.out.println("m10");
                arr[k] = L[i];            System.out.println("m11");
                i++;            System.out.println("m12");
            } else {            System.out.println("m13");
                arr[k] = R[j];            System.out.println("m14");
                j++;            System.out.println("m15");
            }
            k++;            System.out.println("m16");
        }
        // Copy remaining elements of L[] if any
        while (i < n1) {            System.out.println("m17");
            arr[k] = L[i];            System.out.println("m18");
            i++;            System.out.println("m19");
            k++;            System.out.println("m20");
        }
// Copy remaining elements of R[] if any
        while (j < n2) {            System.out.println("m21");
            arr[k] = R[j];            System.out.println("m22");
            j++;            System.out.println("m23");
            k++;            System.out.println("m24");
        }
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        System.out.println("a");

        System.out.println("The Array is: ");
        printArray(arr);
        System.out.println("starting recursive sort ");

        sort(arr, 0, arr.length - 1);
        System.out.println("completed recurisve sort ");

        System.out.println("\nSorted array is");
        printArray(arr);
        System.out.println("completed code");
    }
}