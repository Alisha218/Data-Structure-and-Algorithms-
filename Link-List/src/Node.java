public class Node {
    int data;
    Node prev;
    Node next;
    public Node(int data){
        this.data=data;
    }
    public void display(){
        System.out.print(data+"-->");
    }
}
