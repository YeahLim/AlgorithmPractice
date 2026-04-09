import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        
        int answer = 0;
        for (int i = 0; i <= 9; i++) answer += i;
        
        for (int num : numbers) {
            answer -= num;
        }
        return answer;
    }
}