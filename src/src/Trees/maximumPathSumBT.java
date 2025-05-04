package Trees;

class maximumPathSumBT {
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

//        System.out.println("Depth of binary tree is : " + Trees.depthOfBinaryTree.getDepth(tree));
    }

    public int maxPathSums(TreeNode root) {
        int sum = 0;

        
        return sum;
    }

    public int maxPathSum (TreeNode node , int maxi){
        if(node == null)
        return 0;

        int leftSum = maxPathSum(node.left , maxi);
        int rightSum = maxPathSum(node.left , maxi);

        maxi = Math.max(maxi, leftSum+rightSum+ node.val);

        return node.val + Math.max(leftSum, rightSum);

    }







}
