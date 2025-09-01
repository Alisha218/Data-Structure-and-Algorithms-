class CircularSinglyLinkedList {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head;
    int size;

    public CircularSinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
        size++;
    }

    public void printList() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(head)");
    }

    public void delete(int value) {
        if (head == null) return;

        Node temp = head;
        Node prev = null;

        if (head.data == value) {
            while (temp.next != head) {
                temp = temp.next;
            }
            if (head.next == head) {
                head = null;
            } else {
                temp.next = head.next;
                head = head.next;
            }
            size--;
            return;
        }

        prev = head;
        temp = head.next;

        while (temp != head && temp.data != value) {
            prev = temp;
            temp = temp.next;
        }

        if (temp.data == value) {
            prev.next = temp.next;
            size--;
        }
    }

    public int findMiddle() {
        if (head == null) return -1;
        Node slow = head;
        Node fast = head;
        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public void insertAfter(int prevData, int newData) {
        Node current = head;
        do {
            if (current.data == prevData) {
                Node newNode = new Node(newData);
                newNode.next = current.next;
                current.next = newNode;
                size++;
                return;
            }
            current = current.next;
        } while (current != head);
        System.out.println("Element " + prevData + " not found.");
    }

    public boolean isCircular() {
        if (head == null) return false;
        Node temp = head.next;
        while (temp != null && temp != head) {
            temp = temp.next;
        }
        return (temp == head);
    }
}
