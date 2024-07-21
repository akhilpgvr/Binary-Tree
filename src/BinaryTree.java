import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    Node root;

    public void addChild(int data) {

        //creating new node for child
        Node newChild = new Node(data);

        //checking root is null
        if(root == null) {
            root = newChild;
            return;
        }

        //queue for tracking the nodes
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if(currentNode.leftChild == null) {
                currentNode.leftChild =  newChild;
                return;
            }
            queue.offer(currentNode.leftChild);
            if(currentNode.rightChild == null) {
                currentNode.rightChild =  newChild;
                return;
            }
            queue.offer(currentNode.rightChild);
        }
    }

    //Performing Inorder traversal in binary tree
    public void inorderTraversal(Node root) {

        if(root == null) return;
        else{
            inorderTraversal(root.leftChild);
            System.out.print(" "+ root.data+ " ");
            inorderTraversal(root.rightChild);
        }
    }

    //Performing Preorder traversal in binary tree
    public void preorderTraversal(Node root) {

        if(root == null) return;
        else{
            System.out.print(" "+ root.data+ " ");
            preorderTraversal(root.leftChild);
            preorderTraversal(root.rightChild);
        }
    }

    //Performing Postorder traversal in binary tree
    public void postorderTraversal(Node root) {

        if(root == null) return;
        else{
            postorderTraversal(root.leftChild);
            postorderTraversal(root.rightChild);
            System.out.print(" "+ root.data+ " ");
        }
    }
}
