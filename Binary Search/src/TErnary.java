class TernarySearch {
    public static void main(String args[]) {
         int arr[] = { 2, 3, 4, 10, 40 };
        int x = 10;
        int low = 0, high = arr.length - 1; // low and high initialized

        while (low <= high) { // low kum hai high sey
            // 2 mids niklaingy so it will be 3 parts out of 1 array
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;

            // if x is at one of the both mids
            if (arr[mid1] == x) {
                System.out.println("Element is present at index " + mid1);
                return;
            }
            if (arr[mid2] == x) {
                System.out.println("Element is present at index " + mid2);
                return;
            }

            if (x < arr[mid1]) {        // ager x low hai mid1 sey we move left and baaqi sb cancel
                high = mid1 - 1;        //mid1 k pehly wlay ko high bandaingy
            } else if (x > arr[mid2]) { // agr x bara hai mid 2 sey tw left part cancel
                low = mid2 + 1;             //mid2 k baad waly ko low krdaingy
            } else {                    // warna middle part mai hai
                low = mid1 + 1;            // low ko mid1 k baad lekr ao
                high = mid2 - 1;            // high ko mid2 k pehly lekr ao to come in btw
            }
        }

        // if element not found
        System.out.println("Element is not present in array");
    }
}
