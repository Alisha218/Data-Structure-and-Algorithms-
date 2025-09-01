
class AVLNode {
    int key;
    int height;
    AVLNode left;
    AVLNode right;

    public AVLNode(int key) {
        this.key = key;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}

public class AVLTree {
    private AVLNode root;

    public AVLTree() {
        root = null;
    }

    // Get height of node
    private int height(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Get balance factor of node
    private int getBalance(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Right rotation
    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Left rotation
    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insert a key
    public void insert(int key) {
        root = insert(root, key);
    }

    private AVLNode insert(AVLNode node, int key) {
        // 1. Perform normal BST insertion
        if (node == null) {
            return new AVLNode(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            // Duplicate keys not allowed
            return node;
        }

        // 2. Update height of this ancestor node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // 3. Get the balance factor
        int balance = getBalance(node);

        // 4. If unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Delete a key
    public void delete(int key) {
        root = delete(root, key);
    }

    private AVLNode delete(AVLNode root, int key) {
        // 1. Perform standard BST delete
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            // Node with only one child or no child
            if ((root.left == null) || (root.right == null)) {
                AVLNode temp = null;
                if (temp == root.left) {
                    temp = root.right;
                } else {
                    temp = root.left;
                }

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else { // One child case
                    root = temp;
                }
            } else {
                // Node with two children: get inorder successor
                AVLNode temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = delete(root.right, temp.key);
            }
        }

        // If the tree had only one node then return
        if (root == null) {
            return root;
        }

        // 2. Update height
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // 3. Get balance factor
        int balance = getBalance(root);

        // 4. Rebalance if needed

        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // Find the node with minimum value
    private AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Search for a key
    public boolean search(int key) {
        return search(root, key);
    }

    private boolean search(AVLNode root, int key) {
        if (root == null) {
            return false;
        }

        if (root.key == key) {
            return true;
        }

        if (key < root.key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    // Inorder traversal
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    // Preorder traversal
    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(AVLNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // Postorder traversal
    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(AVLNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.key + " ");
        }
    }

    // Get tree height
    public int getTreeHeight() {
        return height(root);
    }

    // Check if tree is empty
    public boolean isEmpty() {
        return root == null;
    }

    // Clear the tree
    public void clear() {
        root = null;
    }

    // Main method for testing
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Test insertions
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        System.out.println("Inorder traversal:");
        tree.inorder();

        System.out.println("Preorder traversal:");
        tree.preorder();

        System.out.println("Tree height: " + tree.getTreeHeight());

        // Test search
        System.out.println("Search 30: " + tree.search(30));
        System.out.println("Search 100: " + tree.search(100));

        // Test deletion
        tree.delete(30);
        System.out.println("After deleting 30:");
        tree.inorder();

        // Test more operations
        tree.insert(35);
        tree.insert(5);
        tree.insert(15);

        System.out.println("Final tree:");
        tree.inorder();
        System.out.println("Tree height: " + tree.getTreeHeight());
    }
}
