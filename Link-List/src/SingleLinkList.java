
class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Singly Linked List class
public class SingleLinkedList {
    private Node head;
    private int size;
    
    // Constructor
    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }
    
    // Get the size of the list
    public int getSize() {
        return size;
    }
    
    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        
        if (isEmpty()) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    
    // Insert at specific position
    public void insertAtPosition(int data, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position!");
            return;
        }
        
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }
        
        if (position == size) {
            insertAtEnd(data);
            return;
        }
        
        Node newNode = new Node(data);
        Node current = head;
        
        for (int i = 1; i < position; i++) {
            current = current.next;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }
    
    // Delete from beginning
    public void deleteFromBeginning() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        
        head = head.next;
        size--;
    }
    
    // Delete from end
    public void deleteFromEnd() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        
        if (size == 1) {
            head = null;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        size--;
    }
    
    // Delete from specific position
    public void deleteFromPosition(int position) {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        
        if (position < 0 || position >= size) {
            System.out.println("Invalid position!");
            return;
        }
        
        if (position == 0) {
            deleteFromBeginning();
            return;
        }
        
        Node current = head;
        for (int i = 1; i < position; i++) {
            current = current.next;
        }
        
        current.next = current.next.next;
        size--;
    }
    
    // Search for an element
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // Get element at specific position
    public int get(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position!");
        }
        
        Node current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        
        return current.data;
    }
    
    // Reverse the linked list
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
    
    // Display the linked list
    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        
        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    // Main method for testing
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        
        // Test operations
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtBeginning(5);
        list.insertAtPosition(15, 2);
        
        list.display(); // Output: 5 -> 10 -> 15 -> 20 -> null
        
        System.out.println("Size: " + list.getSize()); // Output: 4
        System.out.println("Search 15: " + list.search(15)); // Output: true
        
        list.deleteFromPosition(2);
        list.display(); // Output: 5 -> 10 -> 20 -> null
        
        list.reverse();
        list.display(); // Output: 20 -> 10 -> 5 -> null
        
        list.deleteFromBeginning();
        list.deleteFromEnd();
        list.display(); // Output: 10 -> null
    }
}
