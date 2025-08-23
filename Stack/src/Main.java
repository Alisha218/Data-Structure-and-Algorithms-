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





class Stack {
    private int maxSize; // size of stack
    private int[] stackArray; // array to store stack elements
    private int top; // top of stack

    // Constructor
    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1; // stack is initially empty
    }

    // Push method
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push.");
        } else {
            stackArray[++top] = value; // increment top, insert value
        }
    }

    // Pop method
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1; // error code
        } else {
            return stackArray[top--]; // return top value and decrement top
        }
    }

    // Peek method
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1; // error code
        } else {
            return stackArray[top]; // return top value without removing it
        }
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Check if stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Print stack elements
    public void prntStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }

    // Cube of the minimum element in the stack
    public int cubeOfMinElement() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No minimum element.");
            return -1; // error code
        }

        int min = stackArray[0];
        for (int i = 1; i <= top; i++) {
            if (stackArray[i] < min) {
                min = stackArray[i];
            }
        }

        // Calculate and return the cube of the min element
        return min * min * min;
    }

    // Cube of odd elements
    public void cubeOfOddElements() {
        System.out.print("Cube of odd elements: ");
        boolean hasOdd = false;

        for (int i = 0; i <= top; i++) {
            if (stackArray[i] % 2 != 0) { // Check if the element is odd
                int cube = stackArray[i] * stackArray[i] * stackArray[i];
                System.out.print(cube + " ");
                hasOdd = true;
            }
        }

        if (!hasOdd) {
            System.out.println("No odd elements found.");
        } else {
            System.out.println();
        }
    }

    // Cube of even elements
    public void cubeOfEvenElements() {
        System.out.print("Cubes of even elements: ");
        boolean foundEven = false;

        for (int i = 0; i <= top; i++) {
            if (stackArray[i] % 2 == 0) { // check if the element is even
                int cube = stackArray[i] * stackArray[i] * stackArray[i];
                System.out.print(cube + " ");
                foundEven = true;
            }
        }

        if (!foundEven) {
            System.out.print("No even elements found.");
        }
        System.out.println();
    }

    // Reverse the stack using a temporary stack
    public void reverseStack() {
        Stack tempStack = new Stack(maxSize); // temporary stack of the same size
        while (!isEmpty()) {
            tempStack.push(pop()); // push elements from original stack to temp stack
        }
        // Now copy elements back to the original stack
        while (!tempStack.isEmpty()) {
            push(tempStack.pop());
        }
    }

    // Swap the top two values of the stack
    public void swapTopTwo() {
        if (top < 1) {
            System.out.println("Not enough elements to swap.");
            return;
        }

        // Pop the top two elements
        int first = pop();
        int second = pop();

        // Push them back in reverse order
        push(first);
        push(second);
    }
}

public class Main {
    public static void main(String[] args) {
//        Stack stack = new Stack(5); // create a stack of size 5
//
//        // Push elements onto the stack
//        stack.push(10);
//        stack.push(20);
//        stack.push(30);
//        stack.push(25);
//
//        //  print an error message
//        stack.push(40);
//
//        // Peek the top element
//        System.out.println("Top element: " + stack.peek());
//
//        // Pop elements from the stack
//        System.out.println("Popped: " + stack.pop());
//        System.out.println("Popped: " + stack.pop());
//
//        // Check if stack is empty
//        System.out.println("Is stack empty? " + stack.isEmpty());
//
//        // Pop remaining elements
//        System.out.println("Popped: " + stack.pop());
//        System.out.println("Popped: " + stack.pop());
//
//        // Try popping from empty stack
//        stack.pop();
//
//        // Print the current state of the stack
//        System.out.print("Current Stack: ");
//        stack.prntStack();
//
//        // Push again for further operations
//        stack.push(8);
//        stack.push(3);
//        stack.push(4);
//
//        System.out.print("Current Stack: ");
//        stack.prntStack();
//// Reverse the stack
//        stack.reverseStack();
//        System.out.print("Reversed Stack: ");
//        stack.prntStack();
//
//        // Swap the top two values (no effect since stack is empty)
//        stack.swapTopTwo();
//        System.out.print("After Swapping Top Two: ");
//        stack.prntStack();
//
//
//
//        // Display cubes of even elements
//        stack.cubeOfEvenElements();
//
//        // Display the cube of the minimum element
//        int minCube = stack.cubeOfMinElement();
//        if (minCube != -1) {
//            System.out.println("Cube of the minimum element: " + minCube);
//        }
//
//        // Display cubes of odd elements
//        stack.cubeOfOddElements();
       // StackBYlinkList stack = new StackBYlinkList();

//        // Add Reg ID as contents in the stack
//        stack.push("1");
//        stack.push("9");
//        stack.push("1");
//        stack.push("2");
//        stack.push("1");
//        stack.push("3");
//        stack.push("8");
//
//        // Print all elements in the stack
//        stack.printStack();

TwoStacksOneArray ts=new TwoStacksOneArray();
ts.push1(2);
ts.push1(4);
ts.push2(6);
ts.prntStack();
ts.peek1();
ts.pop1();
ts.push2(5);
ts.prntStack();


    }
}  // Swap two elements by their positions
// Remove the middle element from the stack

