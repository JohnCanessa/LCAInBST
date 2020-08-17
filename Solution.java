import java.util.Scanner;


/**
 * Definition of binary tree node.
 */
class TreeNode {

    // **** ****
    int			val;
    TreeNode	left;
    TreeNode	right;

    // **** ****
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}


/**
 * 
 */
public class Solution {

    /**
     * Find the LCA of the specified nodes starting at the specifieed root.
     * Recursive method.
     */
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // **** traverse left ****
        if ((p.val < root.val) && (q.val < root.val))
            return lowestCommonAncestor(root.left, p, q);

        // **** traverse right ****
        if ((p.val > root.val) && (q.val > root.val))
            return lowestCommonAncestor(root.right, p, q);

        // **** return lca ****
        return root;
    }


    /**
     * Find the LCA of the specified nodes starting at the specifieed root.
     * Iterative method.
     */
    static TreeNode lcaIterative(TreeNode root, TreeNode p, TreeNode q) {

        // **** loop until lca is found ****
        while ( ((p.val < root.val) && (q.val < root.val)) ||
                ((p.val > root.val) && (q.val > root.val))) {

            // **** traverse left ****
            if ((p.val < root.val) && (q.val < root.val))
                root = root.left;

            // **** traverse right****
            if ((p.val > root.val) && (q.val > root.val))
                root = root.right;
        }

        // **** return lca ****
        return root;
    }


    /**
     * Insert a node with the specified value into the the BST.
     * Recursive method.
     */
    static TreeNode insert(TreeNode root, int val) {

        // **** ****
        if (root == null) {
            return new TreeNode(val);
        } else {

            // **** ****
            if (val <= root.val) 
                root.left = insert(root.left, val);
            else
                root.right = insert(root.right, val);

            // **** ****
            return root;
        }
    }


    /**
     * Display the nodes performing an in-order BST traversal.
     * This is a recursive function.
     */
    static void inOrder(TreeNode root) {

        // **** check if we are done ****
        if (root == null)
            return;

        // **** visit the left child ****
        inOrder(root.left);

        // **** display the value of this node ****
        System.out.print(root.val + " ");

        // **** visit the right child ****
        inOrder(root.right);
    }


    /**
     * Find the node with the specified value.
     * This is a recursive function.
     */
    static TreeNode find(TreeNode root, int val) {

        // **** check if node was not found ****
        if (root == null)
            return null;

        // **** check if we found the desired node ****
        if (root.val == val)
            return root;

        // **** select next node ****
        if (val <= root.val)
            return find(root.left, val);
        else
            return find(root.right, val);
    }


    /**
     * Test scaffolding.
     */
    public static void main(String[] args) {

        // *** define the root of the binary tree ****
        TreeNode root = null;

        // **** open scanner ****
        Scanner sc = new Scanner(System.in);

        // **** read the number of nodes ****
        int n = sc.nextInt();

        // ???? ????
        System.out.println("main <<< n: " + n);

        // **** read the n values and populate the BST ****
        for (int i = 0; i < n; i++) {

            // **** read the value ****
            int x = sc.nextInt();

            // **** insert this value into the BST ****
            root = insert(root, x);
        }

        // **** in-order traversal of the BST ****
        System.out.print("main <<< inOrder: ");
        inOrder(root);
        System.out.println();

        // **** read the number of queries ****
        int m = sc.nextInt();

        // ???? ????
        System.out.println("main <<< m: " + m);

        // **** start output ****
        System.out.print("main <<< lca.val: ");

        // **** loop reading and processing each query ****
        for (int i = 0; i < m; i++) {

            // **** read the value for p ****
            int pVal = sc.nextInt();

            // **** read the value for q ****
            int qVal = sc.nextInt();

            // **** get the p node ****
            TreeNode p = find(root, pVal);

            // **** check if value was not found ****
            if (p == null) {
                System.out.print("? ");
                continue;
            }

            // **** get the q node ****
            TreeNode q = find(root, qVal);

            // **** check if value was not found ****
            if (q == null) {
                System.out.print("? ");
                continue;
            }

            // **** determine the lca for p and q ****
            TreeNode lca = lowestCommonAncestor(root, p, q);
            // TreeNode lca = lcaIterative(root, p, q);

            // **** display this result ****
            System.out.print(lca.val + " ");
        }

        // **** complete output ****
        System.out.println();

        // **** close scanner ****
        sc.close();
    }

}