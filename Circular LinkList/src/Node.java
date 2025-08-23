public class CircularLL {

    public Node head;
    public Node tail;


    public CircularLL(){
        this.head=null;
        this.tail=null;
    }
    public boolean isEmpty(){
        return (head==null);
    }


    public void insertAtFirst(){
        Node newnode=new Node(7);
        if(isEmpty()){
            head=newnode;
            tail=newnode;
            tail.next=head;
        }
        else{
            newnode.next=head;
            head=newnode;
            tail.next=head;
        }
    }
    public void insertAtLast(){
        Node newnode = new Node(8);
        if (isEmpty()) {
            head = newnode;
            tail = newnode;
            tail.next = head;
        } else {
            tail.next = newnode;
            tail = newnode;
            tail.next = head;
        }
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head); // Stop when we reach the head again (circular structure)

        System.out.println("(head)");
    }

    public void deleteAtFirst() {
        if (isEmpty()) {
            System.out.println("The list is empty, nothing to delete.");
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
    }

    public void deleteAtLast() {
        if (isEmpty()) {
            System.out.println("The list is empty, nothing to delete.");
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node temp = head;

            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = head;
            tail = temp;
        }
    }







}


public class Node {
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
    public void display(){
        System.out.print(data+"-->");
    }
}



