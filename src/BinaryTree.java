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
        inorderTraversal(root.leftChild);
        System.out.print(" "+ root.data+ " ");
        inorderTraversal(root.rightChild);
    }

    //Performing Preorder traversal in binary tree
    public void preorderTraversal(Node root) {

        if(root == null) return;
        System.out.print(" "+ root.data+ " ");
        preorderTraversal(root.leftChild);
        preorderTraversal(root.rightChild);
    }

    //Performing Postorder traversal in binary tree
    public void postorderTraversal(Node root) {

        if(root == null) return;
        postorderTraversal(root.leftChild);
        postorderTraversal(root.rightChild);
        System.out.print(" "+ root.data+ " ");

    }

    public void search(int data) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        //traversing using queue
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            //checks until the node becomes null/empty
            if(node == null) {
                System.out.println("Element NotFound");
                return;
            }
            if(node.data == data) {
                System.out.println("Element Found");
                return;
            }
            queue.offer(node.leftChild);
            queue.offer(node.rightChild);
        }
    }
    
    public void levelOrdering() {
        
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(" "+ node.data+ " ");
            if(node.leftChild != null) queue.offer(node.leftChild);
            if(node.rightChild != null) queue.offer(node.rightChild);
        }
    }

    public void deleteDeepest(Node key) {

        if(root==null) return;

        //checking root is null
        if(root.leftChild==null && root.rightChild==null) if(root==key) root=null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {

            Node node = queue.poll();
            if(node.leftChild!=null){
                if(node.leftChild==key) {
                    node.leftChild=null;
                    return;
                }
                else{
                    queue.offer(node.leftChild);
                }
            }
            if(node.rightChild!=null){
                if(node.rightChild==key) {
                    node.rightChild=null;
                    return;
                }
                else{
                    queue.offer(node.rightChild);
                }
            }
        }
    }
    public void deleteNode(int key) {

        Node temp = null;
        Node keyNode = null;
        Node parent = null;
        if(root == null) {
            System.out.println("Tree is Empty");
            return;
        }
        if(root.leftChild==null && root.rightChild==null) {
            if(root.data == key) root=null;
            else return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {

            Node node = queue.poll();
            if(node.data == key) {
                 keyNode = node;
            }
            if(node.leftChild!=null) {
                parent=node;
                temp=node.leftChild;
                queue.offer(temp);
            }
            if(node.rightChild!=null) {
                parent=node;
                temp=node.rightChild;
                queue.offer(temp);
            }
        }
        if(keyNode!=null && temp!=null) {
            keyNode.data = temp.data;
            if(parent.leftChild == temp) parent.leftChild=null;
            if(parent.rightChild == temp) parent.rightChild=null;
        }

    }
}
