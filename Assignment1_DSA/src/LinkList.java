class LList {
    Node head;
    private int size;

    LList() {
        this.size = 0;
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node currentNode = head;
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }

    public void printList() {
        Node currentNode = head;
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("Null");
    }

    public void findPairWithSum(int target) {
        Node current1 = head;
        boolean found = false;

        while (current1 != null) {
            Node current2 = current1.next;
            while (current2 != null) {
                if (current1.data + current2.data == target) {
                    System.out.println("Pair found: (" + current1.data + ", " + current2.data + ")");
                    found = true;
                }
                current2 = current2.next;
            }
            current1 = current1.next;
        }

        if (!found) {
            System.out.println("No pair found with the sum " + target);
        }
    }

    public void insert(int prevData, int newData) {
        Node currentNode = head;
        while (currentNode != null && currentNode.data != prevData) {
            currentNode = currentNode.next;
        }

        if (currentNode != null) {
            Node newNode = new Node(newData);
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            System.out.println("Inserted " + newData + " after " + prevData);
        } else {
            System.out.println("Element " + prevData + " not found in the list.");
        }
    }

    public void implementStackUsingLinkedList() {
        StackBYlinkList stack = new StackBYlinkList();
        stack.push("1");
        stack.push("9");
        stack.push("1");
        stack.push("2");
        stack.push("1");
        stack.push("3");
        stack.push("8");

        stack.printStack();
    }
}

class StackBYlinkList {
    Node top;

    class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(String data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public String pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return null;
        }
        String data = top.data;
        top = top.next;
        return data;
    }

    public void printStack() {
        Node currentNode = top;
        if (top == null) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack contents: ");
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("Null");
    }
}

