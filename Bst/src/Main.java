class Tree {
    private class Node {
        private int n;
        private Node leftChild;
        private Node rightChild;

        public Node(int n) {
            this.n = n;


        }


        public String toString() {
            return "Node = " + n;
        }
    }


    private Node root;


    public void insert(int n) {
        if (root == null) {
            root = new Node(n);
            return;
        }
        Node current = root;
        while (true) {
            if (n < current.n) {
                if (current.leftChild == null) {
                    current.leftChild = new Node(n);
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = new Node(n);
                    break;
                }
                current = current.rightChild;
            }
        }
    }




    public boolean search(int key) {
        Node current = root;


        while (current != null) {
            if (key < current.n) {
                current = current.leftChild;
            } else if (key > current.n) {
                current = current.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }


    public void traversePreOrder() {
        traversePreOrder(root);
    }


    private void traversePreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.n);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }




    public void traversePostOrder() {
        traversePostOrder(root);
    }


    private void traversePostOrder(Node root) {
        if (root == null) {
            return;
        }
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.n);
    }


    public void traverseInOrder() {
        traverseInOrder(root);
    }


    private void traverseInOrder(Node root) {
        if (root == null) {
            return;
        }
        traverseInOrder(root.leftChild);
        System.out.println(root.n);
        traverseInOrder(root.rightChild);
    }


    public int minNode() {
        return minNode(root);
    }


    private int minNode(Node root) {
        if (root == null)
            throw new IllegalArgumentException();
        Node current = root;
        Node last = current;




        while (current != null) {
            last = current;
            current = current.leftChild;
        }


        return last.n;




    }


    public int MaxNode() {
        return MaxNode(root);
    }


    private int MaxNode(Node root) {
        if (root == null)
            throw new IllegalArgumentException();
        Node current = root;
        Node last = current;


        while (current != null) {
            last = current;
            current = current.rightChild;
        }




        return last.n;


    }


    public boolean isEqual(Tree other) {
        if (other == null) {
            return false;
        }
        return equals(root, other.root);
    }


    private boolean equals(Node first, Node second) {
        if (first == null && second == null) {
            return true;
        }
        if (first != null && second != null)
            return first.n == second.n && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        return false;




    }


    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1; // Height of an empty tree is -1
        }
        return 1 + Math.max(height(node.leftChild), height(node.rightChild));
    }

    public boolean isBinaryTree() {
        return isBinaryTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinaryTree(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.n <= min || node.n >= max) {
            return false;
        }
        return isBinaryTree(node.leftChild, min, node.n) && isBinaryTree(node.rightChild, node.n, max);
    }







}










public class Main {
    public static void main(String[] args) {
        Tree t1=new Tree();
        t1.insert(23);
        t1.insert(43);
        t1.insert(1);
        System.out.println("Pre order: ");
        t1.traversePreOrder();


        System.out.println("Post order: ");
        t1.traversePostOrder();




        System.out.println("In order: ");
        t1.traverseInOrder();




        System.out.println("Min: "+t1.minNode());
        System.out.println("Max: "+ t1.MaxNode());








    }
}



