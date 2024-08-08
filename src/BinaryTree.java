import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    Node root;

    //cant use recursion -- because we need to remember the queue(all left and right child nodes)
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
        //traversing through tree
        //if leftChild finds null -- insert new node to leftChild,   else add leftChild to queue
        //if rightChild finds null -- insert new node to rightChild,  else add rightChild to queue
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
        //format L-D-R
        inorderTraversal(root.leftChild);
        System.out.print(" "+ root.data+ " ");
        inorderTraversal(root.rightChild);
    }

    //Performing Preorder traversal in binary tree
    public void preorderTraversal(Node root) {

        if(root == null) return;
        //format D-L-R
        System.out.print(" "+ root.data+ " ");
        preorderTraversal(root.leftChild);
        preorderTraversal(root.rightChild);
    }

    //Performing Postorder traversal in binary tree
    public void postorderTraversal(Node root) {

        if(root == null) return;
        //format L-R-D
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
            //adding left and right child to queue for continuing traversal
            queue.offer(node.leftChild);
            queue.offer(node.rightChild);
        }
    }
    
    public void levelOrdering() {
        
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        //format: in the order of nodes in same level. Eg: visit nodes in level0 then visit nodes level1, ...
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

        //once data in right or left child is found as same --> make the node as null
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

        //same as previous node in linkedlist
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
        //keyNode = node with the key, temp will be the leftest last node .. so replace keyNode with temp and make the corresponding temp to null
        if(keyNode!=null && temp!=null) {
            keyNode.data = temp.data;
            if(parent.leftChild == temp) parent.leftChild=null;
            if(parent.rightChild == temp) parent.rightChild=null;
        }

    }
}
