package DP;

public class Trie {
    static class Node {
        Node[] children ;
        boolean eow; // end of word
        public Node (){
            children = new Node[26];
            eow = false;
        }
    }
//    static Node root = new Node();
public static void insert (String word , Node root){
        Node curr = root;
        for (int i = 0; i< word.length(); i ++){
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new Node();
            }
            if(i == word.length() -1 )
                curr.children[index].eow = true;
            curr = curr.children[index];
        }
    }
    public static boolean search (String word , Node root){
        Node curr =root;
        for (int i = 0; i< word.length() ; i ++){
            int index = word.charAt(i) - 'a';

            if(curr.children[index] == null){
                return false;
            }
            if(i == word.length() -1 && curr.children[index].eow == false)
                return false;

            curr = curr.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"cats" , "sand" , "butt"};
        Node root = new Node();
        for (String word : words)
            insert(word , root);

        for (String word : words) {
            System.out.println("Trying to search word : " + word + ": " + search(word, root));
        }
        String random = "random";

        System.out.println("Trying to search word : " + random + ": " + search(random, root));





    }

}
