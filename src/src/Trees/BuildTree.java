package Trees;

import java.util.*;
class BuildTree {
    public static int depth = 0;

    public static class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }

}

    public static void main (String[] args){

        int [] preorder = {3,9,20,15,7};
        int [] inorder = {9,3,15,20,7};
        TreeNode a = buildTree(preorder , inorder);

        System.out.println("Root of tree node is " + a.val);
        
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode();
        root.val = preorder[0];

        Map <Integer , TreeNode> valueToNodeMap = new HashMap<>();
        valueToNodeMap.put(preorder[0], root);

        for ( int i = 0 ; i < preorder.length ; i++){
            //First node is the root node for sure
        

        }

        for ( int i = 0 ; i < inorder.length ; i++){
            //Till the value of rootNode we can say left contains left subtree and right contains right subtree
            
        

        }

        return root;   
    }

//    public static void print(TreeNode root)
//    {
//        List<List<String>> lines = new ArrayList<List<String>>();
//
//        List<TreeNode> level = new ArrayList<TreeNode>();
//        List<TreeNode> next = new ArrayList<TreeNode>();
//
//        level.add(root);
//        int nn = 1;
//
//        int widest = 0;
//
//        while (nn != 0) {
//            List<String> line = new ArrayList<String>();
//
//            nn = 0;
//
//            for (TreeNode n : level) {
//                if (n == null) {
//                    line.add(null);
//
//                    next.add(null);
//                    next.add(null);
//                } else {
//                    String aa = n.getText();
//                    line.add(aa);
//                    if (aa.length() > widest) widest = aa.length();
//
//                    next.add(n.getLeft());
//                    next.add(n.getRight());
//
//                    if (n.getLeft() != null) nn++;
//                    if (n.getRight() != null) nn++;
//                }
//            }
//
//            if (widest % 2 == 1) widest++;
//
//            lines.add(line);
//
//            List<TreeNode> tmp = level;
//            level = next;
//            next = tmp;
//            next.clear();
//        }
//
//        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
//        for (int i = 0; i < lines.size(); i++) {
//            List<String> line = lines.get(i);
//            int hpw = (int) Math.floor(perpiece / 2f) - 1;
//
//            if (i > 0) {
//                for (int j = 0; j < line.size(); j++) {
//
//                    // split node
//                    char c = ' ';
//                    if (j % 2 == 1) {
//                        if (line.get(j - 1) != null) {
//                            c = (line.get(j) != null) ? '┴' : '┘';
//                        } else {
//                            if (j < line.size() && line.get(j) != null) c = '└';
//                        }
//                    }
//                    System.out.print(c);
//
//                    // lines and spaces
//                    if (line.get(j) == null) {
//                        for (int k = 0; k < perpiece - 1; k++) {
//                            System.out.print(" ");
//                        }
//                    } else {
//
//                        for (int k = 0; k < hpw; k++) {
//                            System.out.print(j % 2 == 0 ? " " : "─");
//                        }
//                        System.out.print(j % 2 == 0 ? "┌" : "┐");
//                        for (int k = 0; k < hpw; k++) {
//                            System.out.print(j % 2 == 0 ? "─" : " ");
//                        }
//                    }
//                }
//                System.out.println();
//            }
//
//            // print line of numbers
//            for (int j = 0; j < line.size(); j++) {
//
//                String f = line.get(j);
//                if (f == null) f = "";
//                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
//                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);
//
//                // a number
//                for (int k = 0; k < gap1; k++) {
//                    System.out.print(" ");
//                }
//                System.out.print(f);
//                for (int k = 0; k < gap2; k++) {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//
//            perpiece /= 2;
//        }
//    }



}
