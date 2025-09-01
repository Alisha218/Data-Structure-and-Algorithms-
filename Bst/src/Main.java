class Tree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node(" + value + ")";
        }
    }

    private Node root;

    // Insert a value into BST
    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value);
        } else if (value > node.value) {
            node.rightChild = insert(node.rightChild, value);
        }
        // If value == node.value, do nothing (duplicates not allowed)

        return node;
    }

    // Search for a value
    public boolean search(int value) {
        return search(root, value);
    }

    private boolean search(Node node, int value) {
        if (node == null) {
            return false;
        }

        if (value == node.value) {
            return true;
        }

        return value < node.value ? 
               search(node.leftChild, value) : 
               search(node.rightChild, value);
    }

    // Delete a value
    public void delete(int value) {
        root = delete(root, value);
    }

    private Node delete(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.value) {
            node.leftChild = delete(node.leftChild, value);
        } else if (value > node.value) {
            node.rightChild = delete(node.rightChild, value);
        } else {
            // Node to be deleted found

            // Case 1: Node with no children
            if (node.leftChild == null && node.rightChild == null) {
                return null;
            }

            // Case 2: Node with one child
            if (node.leftChild == null) {
                return node.rightChild;
            }
            if (node.rightChild == null) {
                return node.leftChild;
            }

            // Case 3: Node with two children
            // Find inorder successor (smallest in right subtree)
            int minValue = findMin(node.rightChild);
            node.value = minValue;
            node.rightChild = delete(node.rightChild, minValue);
        }

        return node;
    }

    private int findMin(Node node) {
        while (node.leftChild != null) {
            node = node.leftChild;
        }
        return node.value;
    }

    // Traversal methods
    public void traverseInOrder() {
        traverseInOrder(root);
        System.out.println();
    }

    private void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.leftChild);
            System.out.print(node.value + " ");
            traverseInOrder(node.rightChild);
        }
    }

    public void traversePreOrder() {
        traversePreOrder(root);
        System.out.println();
    }

    private void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            traversePreOrder(node.leftChild);
            traversePreOrder(node.rightChild);
        }
    }

    public void traversePostOrder() {
        traversePostOrder(root);
        System.out.println();
    }

    private void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.leftChild);
            traversePostOrder(node.rightChild);
            System.out.print(node.value + " ");
        }
    }

    // Find minimum value
    public int min() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return min(root);
    }

    private int min(Node node) {
        while (node.leftChild != null) {
            node = node.leftChild;
        }
        return node.value;
    }

    // Find maximum value
    public int max() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return max(root);
    }

    private int max(Node node) {
        while (node.rightChild != null) {
            node = node.rightChild;
        }
        return node.value;
    }

    // Get height of tree
    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.leftChild), height(node.rightChild));
    }

    // Check if tree is empty
    public boolean isEmpty() {
        return root == null;
    }

    // Check if tree is valid BST
    public boolean isValidBST() {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(Node node, long min, long max) {
        if (node == null) {
            return true;
        }
        
        if (node.value <= min || node.value >= max) {
            return false;
        }
        
        return isValidBST(node.leftChild, min, node.value) && 
               isValidBST(node.rightChild, node.value, max);
    }

    // Count nodes
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.leftChild) + countNodes(node.rightChild);
    }

    // Check if two trees are equal
    public boolean equals(Tree other) {
        if (other == null) {
            return false;
        }
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null) {
            return true;
        }
        
        if (first != null && second != null) {
            return first.value == second.value &&
                   equals(first.leftChild, second.leftChild) &&
                   equals(first.rightChild, second.rightChild);
        }
        
        return false;
    }

    // Level order traversal (BFS)
    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value + " ");

            if (current.leftChild != null) {
                queue.add(current.leftChild);
            }
            if (current.rightChild != null) {
                queue.add(current.rightChild);
            }
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Tree bst = new Tree();

        // Insert values
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("In-order traversal:");
        bst.traverseInOrder();

        System.out.println("Pre-order traversal:");
        bst.traversePreOrder();

        System.out.println("Post-order traversal:");
        bst.traversePostOrder();

        System.out.println("Level-order traversal:");
        bst.traverseLevelOrder();

        System.out.println("Minimum value: " + bst.min());
        System.out.println("Maximum value: " + bst.max());
        System.out.println("Tree height: " + bst.height());
        System.out.println("Total nodes: " + bst.countNodes());
        System.out.println("Is valid BST: " + bst.isValidBST());

        // Search operations
        System.out.println("Search 40: " + bst.search(40));
        System.out.println("Search 100: " + bst.search(100));

        // Delete operations
        System.out.println("Deleting 20...");
        bst.delete(20);
        bst.traverseInOrder();

        System.out.println("Deleting 30...");
        bst.delete(30);
        bst.traverseInOrder();

        System.out.println("Deleting 50...");
        bst.delete(50);
        bst.traverseInOrder();

        // Test with another tree
        Tree bst2 = new Tree();
        bst2.insert(50);
        bst2.insert(30);
        bst2.insert(70);
        
        System.out.println("Trees equal: " + bst.equals(bst2));
    }
}
