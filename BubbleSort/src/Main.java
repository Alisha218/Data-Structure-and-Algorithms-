import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int temp;
        System.out.print("Original Array: ");
        int [] array={1,6,3,7,2,8,5};
        System.out.println(Arrays.toString(array));
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-i-1;j++){
            if(array[j]>array[j+1]){
                temp=array[j];
                array[j]=array[j+1];
                array[j+1]=temp;
            }
        }}
        System.out.print("Sorted Array:   ");
        System.out.println(Arrays.toString(array));





    }
}