import java.util.*;


// 바보바보바보 왜 visited를 까먹은거야!!

class Solution {

    String numbers = "";
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    
    public int solution(String n) {
        
        numbers = n;
        visited = new boolean[numbers.length()];
        
        for (int i = 1; i <= numbers.length(); i++) {
            searchPrimeNum(i, new StringBuilder());
        }
                
        return set.size();
    }
    
    /* DFS : 소수 찾기 */
    public void searchPrimeNum(int length, StringBuilder sb) {
        
        if (sb.length() == length) {
            int number = Integer.parseInt(sb.toString());
            if (checkPrimeNum(number)) {
                System.out.println(number);
                set.add(number);
            }
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            char num = numbers.charAt(i);
            if (visited[i]) continue;
            visited[i] = true;
            sb.append(num);
            searchPrimeNum(length, sb);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }
    
    /* 소수인지 판단 */
    public boolean checkPrimeNum(int number) {
        
        if (number == 0 || number == 1) return false;
        
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}