//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int binarySearch(int[] a,int x ){
        int low=0;
        int high=a.length-1;
        int mid;
        while(low<=high){
            mid=(low+high) /2;
            if(a[mid]==x){
                return mid;
            }
            else if (x>a[mid]){
                low=mid+1;
            }
            else high=mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[]a={1,1,1,1,4,7,3,7,9};
        System.out.println("Item Found at index: "+binarySearch( a, 9));
    }
}