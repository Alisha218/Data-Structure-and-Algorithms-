public class TwoStacksOneArray {
    private int n;
    private int[] stack;
    int sTop1,top1;
    int sTop2,top2;
    TwoStacksOneArray(){
        n=6;
        stack=new int [n];
        sTop1=-1;top1=-1;
        sTop2=2;top2=2;
    }
    public void push1(int item){
        if(sTop1!=sTop2){
            stack[top1]=item;
            top1++;
        }
        else System.out.println("Stack Full");
    }
    public void pop1(){
        if (top1==-1){
            System.out.println("Stack Empty");
        }
        else{
            System.out.println(stack[top1]);
            top1--;
        }
    }
    public void peek1(){
        if(top1==-1){
            System.out.println("Stack Empty");
        }else System.out.println(stack[top1]);
    }
    public void push2(int item){
        if(sTop2!=stack.length-1){
            stack[top2]=item;
            top2++;
        }
        else System.out.println("Stack Full");
    }
    public void pop2(){
        if (top2==stack[2]){
            System.out.println("Stack Empty");
        }
        else{
            System.out.println(stack[top2]);
            top2--;
        }
    }
    public void peek2(){
        if(top1==stack[2]){
            System.out.println("Stack Empty");
        }else System.out.println(stack[top2]);
    }
    public boolean isEmpty() {
        return (top == -1);
    }

    public void prntStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }


}
