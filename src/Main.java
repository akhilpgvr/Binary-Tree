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
        System.out.println("Inorder Traversal on binary tree");
        System.out.println("...............................");
        binaryTree.inorderTraversal(binaryTree.root);
        System.out.println();
        System.out.println("...............................");
        System.out.println("Preorder Traversal on binary tree");
        System.out.println("...............................");
        binaryTree.preorderTraversal(binaryTree.root);
        System.out.println();
        System.out.println("...............................");
        System.out.println("Postorder Traversal on binary tree");
        System.out.println("...............................");
        binaryTree.postorderTraversal(binaryTree.root);
        System.out.println();
        System.out.println("...............................");
        System.out.println("Binary tree Search");
        System.out.println("...............................");
        binaryTree.search(5);
        binaryTree.search(10);
        System.out.println("...............................");
    }
}