class Dlinklist {
    Node head;
    private int size;

    Dlinklist() {
        this.size = 0;
    }

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

    public void deleteFirst() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        size--;
        if (head.next == null) {
            head = null;
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.prev.next = null;
    }

    public int getSize() {
        return size;
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

    public void deleteAlternateNodes() {
        if (head == null || head.next == null) {
            return;
        }
        Node current = head;
        boolean delete = true;
        while (current != null && current.next != null) {
            if (delete) {
                Node nodeToDelete = current;
                current = current.next;
                if (nodeToDelete.prev != null) {
                    nodeToDelete.prev.next = current;
                } else {
                    head = current;
                }
                if (current != null) {
                    current.prev = nodeToDelete.prev;
                }
                size--;
            } else {
                current = current.next;
            }
            delete = !delete;
        }
    }

    public void swapNodes(String value1, String value2) {
        if (value1.equals(value2)) {
            System.out.println("Both nodes are the same, no swap needed.");
            return;
        }

        Node node1 = head;
        Node node2 = head;

        while (node1 != null && !node1.data.equals(value1)) {
            node1 = node1.next;
        }

        while (node2 != null && !node2.data.equals(value2)) {
            node2 = node2.next;
        }

        if (node1 == null || node2 == null) {
            System.out.println("One or both nodes not found, cannot swap.");
            return;
        }

        if (node1.prev != null) {
            node1.prev.next = node2;
        } else {
            head = node2;
        }

        if (node2.prev != null) {
            node2.prev.next = node1;
        } else {
            head = node1;
        }

        if (node1.next != null) {
            node1.next.prev = node2;
        }

        if (node2.next != null) {
            node2.next.prev = node1;
        }

        Node tempPrev = node1.prev;
        Node tempNext = node1.next;
        node1.prev = node2.prev;
        node1.next = node2.next;
        node2.prev = tempPrev;
        node2.next = tempNext;
    }

    public int countOccurrences(String target) {
        int count = 0;
        Node current = head;
        while (current != null) {
            if (current.data.equals(target)) {
                count++;
            }
            current = current.next;
        }
        return count;
    }

    public void insertAt(String prevData, String newData) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(prevData)) {
                Node newNode = new Node(newData);
                newNode.next = current.next;
                if (current.next != null) {
                    current.next.prev = newNode;
                }
                current.next = newNode;
                newNode.prev = current;
                return;
            }
            current = current.next;
        }
        System.out.println("Element \"" + prevData + "\" not found in the list.");
    }
}



