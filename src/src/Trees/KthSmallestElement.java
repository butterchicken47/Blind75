package Trees;

public class KthSmallestElement {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }

    }
    int i = 0;
    int resp = 0;
    public int kthSmallest(TreeNode root, int k) {

        if (root == null)
            return resp;

        kthSmallest(root.left , k);
        i++;
        if (i==k)
            resp = root.val;

        kthSmallest(root.right , k);
        return resp;
    }
}
