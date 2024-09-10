// Node Class

/**
 * Q5
 * Binary Tree construction and calculate maximum value node and depth of binart tree
 */
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTree {
    //Root of the Binary Tree
    Node root;

    // Method to find the maximum value in the tree
    static int findMax(Node node) {
        if (node == null)
            return Integer.MIN_VALUE;

        int res = node.data;
        int lres = findMax(node.left);
        int rres = findMax(node.right);

        if (lres > res)
            res = lres;
        if (rres > res)
            res = rres;
        return res;
    }

    /**
     * find max depth
     *
     * @param node
     * @return
     */
    static int maxDepth(Node node) {
        if (node == null)
            return 0;

        // compute the depth of left and right
        // subtrees
        int lDepth = maxDepth(node.left);
        int rDepth = maxDepth(node.right);

        // use the larger one
        return Math.max(lDepth, rDepth) + 1;
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(5);
        tree.root.left = new Node(3);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(10);
        tree.root.left.right = new Node(11);
        System.out.println("Maximum value in the tree: " + tree.findMax(tree.root));
        System.out.println("Maximum depth of the tree: " + tree.maxDepth(tree.root));

    }
}
