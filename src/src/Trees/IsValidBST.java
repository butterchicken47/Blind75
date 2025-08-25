package Trees;

public class IsValidBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }

    }

    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        return isValidBstHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBstHelper(TreeNode node, long minimum, long maximum) {
        if (node == null) return true;

        if (!(node.val > minimum && node.val < maximum)) return false;

        return isValidBstHelper(node.left, minimum, node.val) && isValidBstHelper(node.right, node.val, maximum);
    }

}
