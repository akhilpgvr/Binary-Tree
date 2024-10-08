import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println("...............................");
        System.out.println("creating binary tree");
        System.out.println("...............................");
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addChild(1);
        binaryTree.addChild(2);
        binaryTree.addChild(3);
        binaryTree.addChild(4);
        binaryTree.addChild(5);
        binaryTree.addChild(6);
        binaryTree.addChild(7);
        binaryTree.addChild(8);
        binaryTree.addChild(9);
        System.out.println("...............................");
        System.out.println("In order Traversal on binary tree");
        System.out.println("...............................");
        binaryTree.inorderTraversal(binaryTree.root);
        System.out.println();
        System.out.println("...............................");
        System.out.println("Pre order Traversal on binary tree");
        System.out.println("...............................");
        binaryTree.preorderTraversal(binaryTree.root);
        System.out.println();
        System.out.println("...............................");
        System.out.println("Post order Traversal on binary tree");
        System.out.println("...............................");
        binaryTree.postorderTraversal(binaryTree.root);
        System.out.println();
        System.out.println("...............................");
        System.out.println("Binary tree Search");
        System.out.println("...............................");
        binaryTree.search(5);
        binaryTree.search(10);
        System.out.println("...............................");
        System.out.println("Level order Traversal on binary tree");
        System.out.println("...............................");
        binaryTree.levelOrdering();
        System.out.println();
        System.out.println("...............................");
        System.out.println("Deletion on binary tree");
        System.out.println("...............................");
        binaryTree.deleteNode(3);
        binaryTree.deleteNode(1);
        binaryTree.levelOrdering();
        System.out.println();
        System.out.println("...............................");
        System.out.println("Deletion of deepest element on binary tree");
        System.out.println("...............................");
        Node node =null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(binaryTree.root);
        while(!queue.isEmpty()) {
            node = queue.poll();
            if(node.leftChild != null) queue.offer(node.leftChild);
            if(node.rightChild != null) queue.offer(node.rightChild);
        }
        binaryTree.deleteDeepest(node);
        binaryTree.levelOrdering();
        System.out.println();
        System.out.println("...............................");

        /*
        Output:

        ...............................
        creating binary tree
        ...............................
        ...............................
        In order Traversal on binary tree
        ...............................
         8  4  9  2  5  1  6  3  7
        ...............................
        Pre order Traversal on binary tree
        ...............................
         1  2  4  8  9  5  3  6  7
        ...............................
        Post order Traversal on binary tree
        ...............................
         8  9  4  5  2  6  7  3  1
        ...............................
        Binary tree Search
        ...............................
        Element Found
        Element NotFound
        ...............................
        Level order Traversal on binary tree
        ...............................
         1  2  3  4  5  6  7  8  9
        ...............................
        Deletion on binary tree
        ...............................
         8  2  9  4  5  6  7
        ...............................
        Deletion of deepest element on binary tree
        ...............................
         8  2  9  4  5  6
        ...............................
        */
    }
}