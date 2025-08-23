import java.util.NoSuchElementException;

public class DoubleLinkList {
    private Node head,tail;

    public DoubleLinkList(){
        this.head=null;
        this.tail=null;
    }
    public boolean isEmpty(){ return (head ==null);}

    public void insertFirst(int data){
        Node newNode=new Node(data);
            if(head==null){
                head=newNode;
                tail=newNode;
            }
            else{
                newNode.next=head;
                head.prev=newNode;
                head=newNode;
            }
        }
    public void displayList(){
        System.out.println("link List(First Node --> Last Node");
        Node currentNode=head;
        while(currentNode!=null){
            currentNode.display();
            currentNode=currentNode.next;
        }
        System.out.println();
    }

    public Node deleteFirst(){
        Node temp=head;
        if (isEmpty()){
            throw new NoSuchElementException();
        } else if (head.next==null) {
            tail=null;
        }else{ 
            head.next.prev=null;
        }
        head=head.next;
        return temp;
    }
}
