
class AVLTREE{
private class AVLnode{
    private class Node{
      private int leftChild;
      private int rightChild;
      private int height;
      private int value;

        private Node root;

      public void AVLnode(int value){this.value=value;}
      public String toString(){return "value: "+this.value;}


        // Pre-Order Traversal
        public void preOrder (int leftChild) {
            System.out.print("Pre-Order Traversal: ");
            preOrder(root);
            System.out.println();
        }

        private void preOrder(Node node) {
            if (node != null) {
                System.out.print(node.value + " ");
                preOrder(node.leftChild);
                preOrder(node.rightChild);
            }
        }

        // In-Order Traversal
        public void inOrder(int leftChild) {
            System.out.print("In-Order Traversal: ");
            inOrder(root);
            System.out.println();
        }

        private void inOrder(Node node) {
            if (node != null) {
                inOrder(node.leftChild);
                System.out.print(node.value + " ");
                inOrder(node.rightChild);
            }
        }

        // Post-Order Traversal
        public void postOrder(int leftChild) {
            System.out.print("Post-Order Traversal: ");
            postOrder(root);
            System.out.println();
        }

        private void postOrder(Node node) {
            if (node != null) {
                postOrder(node.leftChild);
                postOrder(node.rightChild);
                System.out.print(node.value + " ");
            }
        }





        }


    }
}
public class Main {
    public static void main(String[] args) {

    }
}