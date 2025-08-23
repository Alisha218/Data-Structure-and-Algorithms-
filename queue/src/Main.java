class LinearQueue {
    private int[] arr;    // Array to store queue elements
    private int front, rear, maxSize;

    public LinearQueue(int capacity) {
        maxSize = capacity;
        arr = new int[maxSize];
        front = 0;  // Initially, front is set to 0
        rear = -1;  // No elements added yet
    }

    // Enqueue operation
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + data);
            return;
        }
        rear++;
        arr[rear] = data;  // Add element at the rear
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Error code
        }
        int data = arr[front];
        if(front>=rear){
            front=0;
            rear=-1;

        }
        front++;
        return data;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to peek.");
            return -1; // Error code
        }
        return arr[front];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front > rear;
    }

    // Check if the queue is full
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // Display the queue
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue contents: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    // Function to find the maximum element in the queue
    public int findMax() {
        int max = arr[front];
        int i = front;

        while (!isEmpty()) {

            if (arr[i] > max) {
                max = arr[i];
            }
            dequeue();
        }
        return max;
    }

    // Function to find the minimum element in the queue
    public int findMin() {
        int min = arr[front];
        int i = front;

        while(!isEmpty()) {
            if (arr[i] < min) {
                min = arr[i];
            }
            dequeue();
        }
        return min;
    }


}

public class Main {
    public static void main(String[] args) {
        LinearQueue queue = new LinearQueue(5); // Create a linear queue of size 5

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println(  "MAX "+ queue.findMax());
        System.out.println(  "MIN "+queue.findMin());
        // enqueue when the queue is full
        queue.enqueue(60);

        // Display
        queue.displayQueue();

        // Dequeue elements
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        //  after dequeue
        queue.displayQueue();

        //  more elements will fail since linear queue cannot reuse space
        queue.enqueue(60);

        // after enqueue
        queue.displayQueue();

        // Peek
        System.out.println("Peek: " + queue.peek());

        // Dequeue all elements
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }

        //dequeueing from an empty queue
        System.out.println("Dequeued: " + queue.dequeue());
    }
}
