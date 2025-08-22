//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int recursiveLinearSearch(int[] array ,int i, int x){
        int n=array.length-1;
        if(i>n){
            return -1;}
        else if(array[i]==x){
            return i;
            }
        else return recursiveLinearSearch(array,i+1,x);


    }
    public static int linearSearch(int[] array,int x){
        for (int i=0;i<array.length;i++){
            if (array[i]==x){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array={1,9,1,2,1,6,9};
        System.out.println("Item found at index: "+linearSearch(array,6));
        System.out.println("Item found at index: "+recursiveLinearSearch(array,0,2));

    }
}