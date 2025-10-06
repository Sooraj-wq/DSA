// Class to represent a node in the binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeDepth {
  
    public int getNodeDepth(TreeNode root, int targetValue) {
        return findDepth(root, targetValue, 0);
    }
    private int findDepth(TreeNode node, int target, int currentDepth) {
        // Base case 1: The tree or subtree is empty.
        if (node == null) {
            return -1;
        }

        // Base case 2: The target node is found.
        if (node.val == target) {
            return currentDepth;
        }

        // Recursive step: Search in the left subtree.
        int leftDepth = findDepth(node.left, target, currentDepth + 1);

        // If found in the left subtree, return its depth.
        if (leftDepth != -1) {
            return leftDepth;
        }

        // Otherwise, search in the right subtree.
        return findDepth(node.right, target, currentDepth + 1);
    }

    // Main method for demonstration
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeDepth btd = new BinaryTreeDepth();

        System.out.println("Depth of node 3: " + btd.getNodeDepth(root, 3));   
        System.out.println("Depth of node 20: " + btd.getNodeDepth(root, 20)); 
        System.out.println("Depth of node 7: " + btd.getNodeDepth(root, 7));   
        System.out.println("Depth of node 99: " + btd.getNodeDepth(root, 99)); 
    }
}
