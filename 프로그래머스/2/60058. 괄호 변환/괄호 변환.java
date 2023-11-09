import java.util.*;


// 올바른 괄호 만들기(문자열){
//     String u,v = 균형잡힌 괄호 문자열 찾기;
    
//     String 결과 문자열;
    
//     if(u == 올바른 괄호 문자열){
//         결과 문자열 = u + 올바른 괄호 만들기(v)
//     }else if(u != 올바른 괄호 문자열이 아닌경우){
//         결과 문자열 += '(';
//         결과 문자열 += 올바른 괄호 만들기(v);
//         결과 문자열 +=')';
//         u = 첫번째와 마지막 문자 제거(u);
//         뒤집힌 u = 괄호 뒤집기(u);
//         결과 문자열 += 뒤집힌 u;
//     }
    
//     return 결과 문자열;
// }
// 올바른 괄호 문자열(u){
//     if(올바른 문자열인 경우){
//         return true
//     }else if(올바른 문자열이 아닌 경우){
//         return false;
//     }
// }

class Solution {
    
    public String solution(String p) {    
        return searchAnswer(p);
    }
    
    private String searchAnswer(String p) {
        String result = "";
        
        // 빈 문자열인 경우
        if (p.equals("")) {
            return result;
        }
        
        // U, V로 분리
        int index = findBalancedParantheses(p);
        String U = p.substring(0, index);
        String V = index == p.length() ? "" : p.substring(index, p.length());
        
        // U가 올바른 괄호 문자열인지 확인
        boolean corrected = checkCorrectParantheses(U);
        
        // 올바르면
        if (corrected) {
            result += U + searchAnswer(V);
        }
        
        // 올바르지 않으면
        else {
            result += "(";
            result += searchAnswer(V);
            result += ")";
            U = U.substring(1, U.length() - 1);
            result += reversedString(U); 
        }
        
        return result;
    }
    
    private String reversedString(String str) {
        String newStr = "";
        for (Character c : str.toCharArray()) {
            if (c == '(') {
                newStr += ')';
            }
            else {
                newStr += '(';
            }
        }
        
        return newStr;
    }
    
    
    private boolean checkCorrectParantheses(String parantheses) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        
        if(parantheses.charAt(i) == ')') {
            return false;
        }
        
        stack.add(parantheses.charAt(i++));
        
        while (!stack.isEmpty() && i < parantheses.length()) {
            
            if (parantheses.charAt(i) == '(') {
                stack.add(parantheses.charAt(i));
            }
            else {
                stack.pop();
            }
            i++;
        }
        
        if (stack.isEmpty() && i == parantheses.length()) {
            return true;
        }
        
        return false;
    }
    
    private int findBalancedParantheses(String str) {
        int left = 0; // 왼쪽 괄호 개수
        int right = 0; // 오른쪽 괄호 개수
        int index = 0;
        
        
        for (; index < str.length(); index++) {
            
            if (str.charAt(index) == '(') {
                left++;
            }
            else {
                right++;
            }
            
            if (left == right) {
                break;
            }
        }
        
        return index+1;
    }
}