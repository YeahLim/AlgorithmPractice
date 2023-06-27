import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> parenthesis = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(') {
                parenthesis.add(curr);
            }
            else {
                if (parenthesis.isEmpty()) {
                    return false;
                }
                parenthesis.pop();
            } 
        }

        if (parenthesis.isEmpty()) {
            return true;
        }
        
        return false;
    }
}