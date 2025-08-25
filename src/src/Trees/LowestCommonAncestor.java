package Trees;

public class LowestCommonAncestor {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }

    }

    public static void main(String[] args) {

    }


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;

        TreeNode lTree = lowestCommonAncestor(root.left , p ,q);

        TreeNode rTree = lowestCommonAncestor(root.right , p ,q);

        if(lTree != null && rTree !=null )
            return root;
        else if(lTree != null)
            return lTree;
        else
            return rTree;


    }


}
