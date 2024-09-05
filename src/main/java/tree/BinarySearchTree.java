package tree;

// Definition for a binary tree node.
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}

public class BinarySearchTree {

    // Function to find the lowest common ancestor of two nodes in a BST
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // If both p and q are greater than root, then LCA lies in the right
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // If both p and q are smaller than root, then LCA lies in the left
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // If one of p or q is the root, or if p and q lie on either side of the root, then root is the LCA
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Creating a sample BST
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left; // Node with value 2
        TreeNode q = root.left.right; // Node with value 8

        TreeNode lca = tree.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val);
    }

//    public static void main(String[] args){
//        BinarySearchTree bst = new BinarySearchTree();
//
//        TreeNode root = new TreeNode(2);
//
//        root.left = new TreeNode(6);
//        root.right = new TreeNode(8);
//        root.left.left = new TreeNode(12);
//        root.left.right = new TreeNode(14);
//
//        TreeNode left = root.left;
//        TreeNode right = root.right;
//
//        bst.lowestAnchestorOneMoretime(root,left,right);
//    }

    public TreeNode lowestAnchestorOneMoretime(TreeNode root,TreeNode p,TreeNode q){
        if(root == null){
            return null;
        }
        if(p.val < root.val && q.val< root.val){
           return lowestAnchestorOneMoretime(root.left,p,q);
        } else if ( p.val > root.val && q.val > root.val){
           return lowestAnchestorOneMoretime(root.right,p,q);
        } else {
            return root;
        }

    }
}
