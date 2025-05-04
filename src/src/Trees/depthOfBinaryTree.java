package Trees;

class depthOfBinaryTree {
    public static int depth = 0;

    public static class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
}


    public static void main (String[] args){

        TreeNode tree ;
        tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.right = new TreeNode(6);

        System.out.println("Depth of binary tree is : " + getDepth(tree));
    }

    public static int getDepth(TreeNode root) {
        depth ++;
        if (root == null){
            return 0;
        }

    getDepth(root.left);
    depth--;
    getDepth(root.right);

    return depth;
    
    }



}
