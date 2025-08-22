public class Main {
    public static void main(String[] args) {
        int slevel = 0;
        boolean waterStored = false;
        int[] arr = {3, 0, 0,2};
        int size = arr.length;


        if (arr[0] == 0 && arr[size - 1] == 0) {
            System.out.println("No water saved");
        } else {

            for (int i = 0; i < size - 1; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (arr[i] != 0 && arr[j] != 0) {
                        int NZero1 = arr[i];
                        int NZero2 = arr[j];


                        if (NZero1 < NZero2) {
                            slevel = NZero1;
                        } else {
                            slevel = NZero2;
                        }
                        waterStored = true;
                        break;
                    }
                }
                if (waterStored) {
                    break;
                }
            }


            if (waterStored) {
                System.out.println("Water level stored: " + slevel+" units");
            } else {
                System.out.println("No water stored");
            }
        }
    }
}
