import java.util.*;

class ValidParenthesis {
    public static void main (String[] args){
        //This solution beats 100% according to leetcode, LOL


        String s = "()[]{}";
        String[] arr = new String[20];
        System.out.println("FINAL RESPONSE ====> " + isValid(s));

    }

    public static boolean isValid(String s) {
        List<Character> openBracketList = Arrays.asList('(' , '{' , '[');
        List<Character> closingBracketList = Arrays.asList(')' , '}' , ']');
        Stack<Character> stack = new Stack<>();
        char [] inputArr = s.toCharArray();
        // if(! s.isEmpty() && closingBracketList.contains(inputArr[0]) )
        // return false;

        for (char a : inputArr){
            if(openBracketList.contains(a))
                stack.push(a);
            else {
                if(! stack.isEmpty()){
                    if(stack.peek().equals('(') && a == ')')
                        stack.pop();
                    else if(stack.peek().equals('[') && a == ']')
                        stack.pop();
                    else if(stack.peek().equals('{') && a == '}')
                        stack.pop();
                    else
                        stack.push(a);
                }
                else
                    stack.push(a);
            }

        }
        if(stack.isEmpty())
            return true;
        else
            return false;


    }






}
