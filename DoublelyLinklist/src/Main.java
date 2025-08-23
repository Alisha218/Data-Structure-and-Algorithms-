class DoublyLinkedList {
    Node head;
    private int size;

    DoublyLinkedList() {
        this.size = 0;
    }

    // Inner class for the Node
    class Node {
        String data;
        Node next;
        Node prev;

        public Node(String data) {
            this.data = data;
            this.next = null;
            this.prev = null;
            size++;
        }
    }

    // Add a node at the beginning of the list
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Add a node at the end of the list
    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        newNode.prev = currentNode;
    }

    // Print the list from head to end
    public void printList() {
        Node currentNode = head;
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        while (currentNode != null) {
            System.out.print(currentNode.data + " <-> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

    // Delete the first node
    public void deleteFirst() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        if (head.next == null) { // Only one element
            head = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    // Delete the last node
    public void deleteLast() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        size--;
        if (head.next == null) { // Only one element
            head = null;
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.prev.next = null;
    }

    // Get the size of the list
    public int getSize() {
        return size;
    }

    // Swap nodes with given data values
    public void swapNodes(String value1, String value2) {
        if (value1.equals(value2)) {
            System.out.println("Both nodes are the same, no swap needed.");
            return;
        }

        // Find the two nodes
        Node node1 = head;
        Node node2 = head;

        while (node1 != null && !node1.data.equals(value1)) {
            node1 = node1.next;
        }

        while (node2 != null && !node2.data.equals(value2)) {
            node2 = node2.next;
        }

        // If either node is not found, cannot swap
        if (node1 == null || node2 == null) {
            System.out.println("One or both nodes not found, cannot swap.");
            return;
        }

        // Swap the prev pointers
        if (node1.prev != null) {
            node1.prev.next = node2;
        } else {
            head = node2; // Update head if node1 was the head
        }

        if (node2.prev != null) {
            node2.prev.next = node1;
        } else {
            head = node1; // Update head if node2 was the head
        }

        // Swap the next pointers
        if (node1.next != null) {
            node1.next.prev = node2;
        }

        if (node2.next != null) {
            node2.next.prev = node1;
        }

        // Swap node1 and node2's own prev and next pointers
        Node tempPrev = node1.prev;
        Node tempNext = node1.next;
        node1.prev = node2.prev;
        node1.next = node2.next;
        node2.prev = tempPrev;
        node2.next = tempNext;
    }

    // Method to count occurrences of a specific element
    public int countOccurrences(String target) {
        int count = 0;
        Node current = head;

        // Traverse the list
        while (current != null) {
            if (current.data.equals(target)) {
                count++;
            }
            current = current.next;
        }

        return count;
    }

    // Method to insert a new element after a specific element
    public void insertAt(String prevData, String newData) {
        Node current = head;

        // Traverse the list to find the node with prevData
        while (current != null) {
            if (current.data.equals(prevData)) { // Use equals() for string comparison
                Node newNode = new Node(newData);
                newNode.next = current.next; // New node's next is current's next node

                if (current.next != null) {
                    current.next.prev = newNode; // Update the previous node of current.next
                }

                current.next = newNode; // Insert new node after the current node
                newNode.prev = current; // Set the previous pointer of the new node
                return;
            }
            current = current.next;
        }

        System.out.println("Element \"" + prevData + "\" not found in the list.");
    }

    public void deleteAlternateNodes() {
        if (head == null || head.next == null) {
            // If the list is empty or has only one node, no alternates to delete
            return;
        }

        Node current = head;
        boolean delete = true; // Start by deleting the first node

        // Traverse the list
        while (current != null && current.next != null) {
            if (delete) {
                // Delete the current node
                Node nodeToDelete = current;
                current = current.next; // Move to the next node before deletion

                if (nodeToDelete.prev != null) {
                    nodeToDelete.prev.next = current; // Update the next pointer of previous node
                } else {
                    head = current; // If deleting the head, update the head
                }

                if (current != null) {
                    current.prev = nodeToDelete.prev; // Update the prev pointer of the new head
                }

                size--; // Decrease the size of the list
            } else {
                current = current.next; // Move to the next node if not deleting
            }

            delete = !delete; // Alternate the delete flag
        }
    }

    public void reverse() {
        Node currentNode = head;
        Node temp = null;
        while (currentNode != null) {
            temp = currentNode.prev;
            currentNode.prev = currentNode.next;
            currentNode.next = temp;
            currentNode = currentNode.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }

}

    public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();
        dl.addFirst("a");
        dl.addFirst("is");
        dl.printList();
        dl.addLast("LinkedList");
        dl.addFirst("This");
        dl.printList();



        //System.out.println("Size of the list: " + dl.getSize());
        //System.out.println("Occurrences of Is: " + dl.countOccurrences("is"));



        System.out.println("After alternate deleting: ");
        dl.deleteAlternateNodes();
        dl.printList();
    }
}
