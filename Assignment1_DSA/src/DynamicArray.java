public class DynamicArray {

    public static void displayDN(int[] array) {
        System.out.println("Distinct numbers in the array:");
        for (int i = 0; i < array.length; i++) {
            boolean isDistinct = true;
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    isDistinct = false;
                    break;
                }
            }
            if (isDistinct) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    public static void displayRepeatedValues(int[] array) {
        System.out.println("Repeated values in the array:");
        for (int i = 0; i < array.length; i++) {
            boolean isRepeated = false;
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    isRepeated = true;
                    break;
                }
            }
            if (isRepeated) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    public static void displayMedian(int[] array) {
        java.util.Arrays.sort(array);
        double median;
        int middle = array.length / 2;
        if (array.length % 2 == 0) {
            median = (array[middle - 1] + array[middle]) / 2.0;
        } else {
            median = array[middle];
        }
        System.out.println("Median of the array: " + median);
    }

    public static void displaySumOfTwoMax(int[] array) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > max1) {
                max2 = max1;
                max1 = value;
            } else if (value > max2) {
                max2 = value;
            }
        }
        System.out.println("Maximum sum of any two elements: " + (max1 + max2));
    }

    public static void swapLastTwoElements(int[] array) {
        if (array.length >= 2) {
            array[array.length - 1] = array[array.length - 1] + array[array.length - 2];
            array[array.length - 2] = array[array.length - 1] - array[array.length - 2];
            array[array.length - 1] = array[array.length - 1] - array[array.length - 2];
        }
        System.out.print("Array after swapping last two elements: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void replaceWithSquare(int[] array) {
        System.out.print("Array with elements squared: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i];
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void checkPalindrome(int[] array) {
        boolean isPalindrome = true;
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - 1 - i]) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("Is the array a palindrome? " + isPalindrome);
    }

    public static void displayMode(int[] array) {
        int maxCount = 0, mode = array[0];
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == array[i]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mode = array[i];
            }
        }
        System.out.println("Mode of the array: " + mode);
    }

    public static void displayMean(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        double mean = (double) sum / array.length;
        System.out.println("Mean of the array: " + mean);
    }

}
