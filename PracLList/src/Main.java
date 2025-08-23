class LList{
    Node head;
    private int size;
    LList(){
        this.size=0;
    }


    class Node {
        String data;
        Node next;


        public Node(String data) {
            this.data = data;
            this.next = null;
            size++;

        }
    }
        public void addFirst(String data){
            Node newNode =new Node(data);
            if(head==null){
                head=newNode;
                return;
            }
            newNode.next=head;
            head=newNode;
        }
        public void addLast(String data){
        Node CurrentNode;
            CurrentNode=head;
            Node newNode =new Node(data);
            if(head==null){
                head=newNode;
                return;
            }
            while(CurrentNode.next != null){
                CurrentNode=CurrentNode.next;
            }
            CurrentNode.next=newNode;
        }

        public void printList(){
        Node CurrentNode;
            CurrentNode=head;
            if(head==null){

                System.out.println("Empty Lsit");
            }
            while(CurrentNode != null){
                System.out.print(CurrentNode.data+" ->");
                CurrentNode=CurrentNode.next;
            }
            System.out.println("Null");
        }
        public void DeleteFirst(){
        if(head==null){
            System.out.println("Empty List");
        }
        head=head.next;
        size--;
        }
        public void DeleteLast() {
            if (head == null) {
                System.out.println("Empty List");
            }
            size--;
            if (head.next == null) {
                head=null;
            }
            Node SecondLast = head;
            Node last = head.next;
            while (last.next != null) {
                last = last.next;
                SecondLast = SecondLast.next;

            }
            SecondLast.next = null;


        }
        public int getSize(){
        return size;
        }

    // Remove duplicates from the list
    public void removeDuplicates() {
        if (head == null) return;

        Node currentNode = head;
        while (currentNode != null && currentNode.next != null) {
            Node runner = currentNode;
            while (runner.next != null) {
                if (currentNode.data.equals(runner.next.data)) {
                    runner.next = runner.next.next; // Remove duplicate
                    size--;
                } else {
                    runner = runner.next;
                }
            }
            currentNode = currentNode.next;
        }
    }


    // Search for an element in the list
    public boolean search(String data) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }
    // Reverse the list
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }




}






public class Main {
    public static void main(String[] args) {
        LList l1=new LList();
        l1.addFirst("a");
        l1.addFirst("is");
        l1.printList();
        l1.addLast("LinkList");
        l1.addFirst("This");
        l1.printList();
        l1.DeleteFirst();
        l1.printList();
        l1.DeleteLast();
        l1.printList();
        System.out.println(l1.getSize());
    }
}

