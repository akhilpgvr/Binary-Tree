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


}
