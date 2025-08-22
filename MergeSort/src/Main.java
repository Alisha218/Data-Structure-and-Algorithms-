

import java.util.Arrays;

class Main {
    public static void sort(int arr[], int l, int r) {
        System.out.println("----------Sort Function Called------------");
        System.out.println("Given Parameters: Array, Left=0(starting) "+ l+  " , Right=ArrayLength-1(ending)"+r);
        System.out.println(Arrays.toString(arr));
        System.out.println("Checking if Left(start) is less than Right(ending)");
        System.out.println(l+"<"+r);
        System.out.println();
        if (l < r) {
            System.out.println("Finding the middle point:  middle=left+(right-left)/2 ");
            int m = l + (r - l) / 2;
            System.out.println("\t\t\t\t\t\t\t\t"+m+" ="+l +"+"+"("+r+"-"+l+")/2");
            System.out.println();
            System.out.print("BEfore REcursive call:  ");
            System.out.println(Arrays.toString(arr));
            System.out.println("Recursive Call For sort until each element is a single unit ");
            // Sort first and second halves
            System.out.println("Called Sort  for First Half with:  Array , Left = "+ l+", Right = "+ r);
            sort(arr, l, m);
            System.out.println("After sort First Half : ");
            System.out.println(Arrays.toString(arr));
            System.out.println("Called Sort  for Second  Half with:  Array , Left = "+ m+1+", Right = "+ r);
            sort(arr, m + 1, r);
            System.out.println("After sort second half: ");

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.print("Before merge : ");
            System.out.println(Arrays.toString(arr));
            System.out.println("Now merging the Arrays");
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public static void merge(int arr[], int l, int m, int r) {

        System.out.println("-------Merging The Sorted parts------------");
        // Find sizes of two subarrays to be merged
        System.out.println("N1 and N2");
        int n1 = m - l + 1;
        System.out.println(n1+ " =" + m +"-"+ l +"+ 1");
        int n2 = r - m;
        System.out.println(n2 +"=" +r +"- "+ m);
        System.out.println("Size of subArray: \n1. "+n1+" \n2. "+n2);
        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];
        System.out.print("Creating 2 new temporary arrays");
        System.out.println("copying data to temp arrays");
        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i){
            L[i] = arr[l + i];
            printArray(L);
        System.out.println("Left ");}
        for (int j = 0; j < n2; ++j){
            R[j] = arr[m + 1 + j];
            System.out.println("Right "+R[j]);
            printArray(R);
        }
        System.out.println();
        System.out.println();
        // Merge the temp arrays Initial indices of 1st and 2nd subarrays
        int i = 0, j = 0;
        System.out.println("initial index of first and second subarray = 0");
        // Initial index of merged subarray array
        System.out.println("inital index of merged subarray = "+l);
        int k = l;
        System.out.println(Arrays.toString(arr));
        while (i < n1 && j < n2) {
            System.out.println("while i is less than subarray1 and j is less than subaray2 : " +i+"<"+ n1+" &&" +j+ "<" +n2);
            System.out.println("check if left is less than or equals to right : "+L[i]+" <= " +R[j] );
            if (L[i] <= R[j]) {

                arr[k] = L[i];
                System.out.println("Add left to the new subarray"+ arr[k] +" is overwritten by " +L[i]);
                i++;
                System.out.println(" i = "+i);
            } else {
                arr[k] = R[j];
                System.out.println("Add right to new subarray "+arr[k] +" is overwritten by "+ R[j]);
                j++;
                System.out.println(" j = "+j);
            }

            k++;
            System.out.println(" k  ="+k);
        }
        System.out.println("Before copying remaining elements");
        System.out.println(Arrays.toString(arr));
        // Copy remaining elements of L[] if any

        while (i < n1) {
            System.out.println("Copy remaining elements of L[]");
            arr[k] = L[i];
            System.out.println( arr[k] +"="+ L[i]);
            i++;
            k++;
            System.out.println("i= "+i +"\nk="+k);
        }
// Copy remaining elements of R[] if any

        while (j < n2) {
            System.out.println("Copy remaining elements of R[] ");
            arr[k] = R[j];
            System.out.println(arr[k] +"="+ R[j]);
            j++;
            k++;
            System.out.println("j="+j +"\nk= "+k);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void printArray(int arr[]) {
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i] + " , ");
        }
        System.out.print("}");
        System.out.println();
    }


public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("The Array is: ");
        System.out.println(Arrays.toString(arr));
        System.out.print("!!!!!!!!");
        System.out.println("  Calling the Merge Sort Function");
        sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array is");
        System.out.println(Arrays.toString(arr));
    }
}