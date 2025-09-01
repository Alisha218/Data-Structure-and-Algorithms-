public class Main {
    public static void main(String[] args) {
        int initialCapacity = 4;
        System.out.println("The initial capacity to store elements: " + initialCapacity);
        int size = 0;
        System.out.println("Items initially in the array: " + size);
        int[] array = new int[initialCapacity];
        System.out.println("Array created.");
        System.out.println();

        System.out.println("Adding elements in array.");
        int[] regID = {2, 3, 1, 2, 1, 0, 5};

        for (int i = 0; i < regID.length; i++) {
            System.out.println("Checking if size is equal to capacity...");
            if (size == initialCapacity) {
                System.out.println("Capacity reached. Creating a new larger array...");
                int[] newArray = new int[initialCapacity * 2];
                for (int j = 0; j < size; j++) {
                    newArray[j] = array[j];
                }
                array = newArray;
                initialCapacity *= 2;
                System.out.println("Updated capacity after resizing: " + initialCapacity);
            }

            System.out.println("Size before adding element: " + size);
            array[size] = regID[i];
            size++;
            System.out.println("New size after adding element: " + size);
            System.out.println();

            System.out.println("Elements in the array: ");
            for (int k = 0; k < size; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.println("\n");
        }
DynamicArray da=new DynamicArray();
       da.displayDN(array);
        da.displayRepeatedValues(array);
        da.displayMedian(array);
        da.displaySumOfTwoMax(array);
        da.swapLastTwoElements(array);
        da.replaceWithSquare(array);
        da.checkPalindrome(array);
        da.displayMode(array);
        da.displayMean(array);

        LList list = new LList();
        list.addFirst(2);
        list.addFirst(3);
        list.addLast(1);
        list.addLast(2);
        list.addLast(1);
        list.addLast(0);
        list.addLast(5);
        list.printList();

        int targetSum = 8;
        System.out.println("Finding pairs with sum " + targetSum + ":");
        list.findPairWithSum(targetSum);

        System.out.println("Inserting elements:");
        list.insert(1, 25);
        list.printList();
        list.insert(3, 15);
        list.printList();

        System.out.println("Implementing stack using linked list:");
        list.implementStackUsingLinkedList();
        Dlinklist dl = new Dlinklist();
        dl.addFirst("a");
        dl.addFirst("is");
        dl.printList();
        dl.addLast("LinkedList");
        dl.addFirst("This");
        dl.printList();
        dl.deleteFirst();
        dl.printList();
        dl.deleteLast();
        dl.printList();
        System.out.println("Size of the list: " + dl.getSize());

        System.out.println("\nReversing the list:");
        dl.reverse();
        dl.printList();

        System.out.println("\nDeleting alternate nodes:");
        dl.deleteAlternateNodes();
        dl.printList();

        System.out.println("\nSwapping nodes \"a\" and \"LinkedList\":");
        dl.swapNodes("a", "LinkedList");
        dl.printList();

        System.out.println("\nCounting occurrences of \"a\": " + dl.countOccurrences("a"));

        System.out.println("\nInserting \"example\" after \"is\":");
        dl.insertAt("is", "example");
        dl.printList();

        CircularSinglyLinkedList clist = new CircularSinglyLinkedList();

        int[] registrationID = {2,3,1,2,1,0,5};
        for (int i = 0; i < registrationID.length; i++) {
            clist.addLast(registrationID[i]);  
        }


        System.out.println("Original List:");
        clist.printList();

        System.out.println("\nDeleting node with value 2:");
        clist.delete(2);
        clist.printList();

        System.out.println("\nMiddle element: " + clist.findMiddle());

        System.out.println("\nInserting 5 after 1:");
        clist.insertAfter(1, 5);
        clist.printList();

        System.out.println("\nIs the list circular? " + clist.isCircular());
        Stack stack = new Stack(7);


        for (int digit : registrationID) {
            stack.push(digit);
        }

        System.out.println("Original Stack:");
        stack.printStack();

        // Remove the middle element
        stack.removeMiddle();
        System.out.println("\nAfter Removing Middle:");
        stack.printStack();

        // MultiPop to a specific position
        int nthPosition = 3;
        stack.multiPop(nthPosition);
        System.out.println("\nAfter MultiPop to position " + nthPosition + ":");
        stack.printStack();

        // Swap two elements
        stack.push(5); // Re-push some elements for testing swap
        stack.push(7);
        stack.swap(1, 2); // Swap positions 1 and 2
        System.out.println("\nAfter Swapping positions 1 and 2:");
        stack.printStack();

        // Check if stack is balanced
        System.out.println("\nIs stack balanced? " + stack.isBalanced());

    }
}

