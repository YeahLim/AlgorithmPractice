import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        int index = 1;
        int turn = 1;
        Set<String> set = new HashSet<>();
        char lastChar = words[0].charAt(0);
        
        for (String word : words) {
            
            if (word.charAt(0) == lastChar && !set.contains(word)) {
                if (index == n) {       
                    index = 1;
                    turn++;             
                } else {
                    index++;
                }
                lastChar = word.charAt(word.length() - 1);
                set.add(word);
                continue;
            }
            
            answer[0] = index;
            answer[1] = turn;
            break;
        }

        return answer;
    }
}