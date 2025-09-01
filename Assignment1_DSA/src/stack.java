class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push.");
        } else {
            stackArray[++top] = value;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        } else {
            return stackArray[top--];
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public void printStack() {
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

    public void removeMiddle() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No middle element.");
            return;
        }
        int middleIndex = top / 2;
        for (int i = middleIndex; i < top; i++) {
            stackArray[i] = stackArray[i + 1];
        }
        top--;
    }

    public void multiPop(int n) {
        if (n > top + 1) {
            System.out.println("Position exceeds stack size.");
        } else {
            while (top >= n) {
                pop();
            }
        }
    }

    public void swap(int pos1, int pos2) {
        if (pos1 < 0 || pos2 < 0 || pos1 > top || pos2 > top) {
            System.out.println("Invalid positions for swapping.");
            return;
        }
        int temp = stackArray[pos1];
        stackArray[pos1] = stackArray[pos2];
        stackArray[pos2] = temp;
    }

    public boolean isBalanced() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return false;
        }

        int half = (top + 1) / 2;
        int sumFirstHalf = 0;
        int sumSecondHalf = 0;

        for (int i = 0; i < half; i++) {
            sumFirstHalf += stackArray[i];
        }
        for (int i = half; i <= top; i++) {
            sumSecondHalf += stackArray[i];
        }

        return sumFirstHalf == sumSecondHalf;
    }
}

