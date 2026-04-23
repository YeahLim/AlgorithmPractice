import java.util.*;

class Solution {
    
    int n;
    int[][] q;
    int[] ans;
    int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;
        
        combinateAll(1, 0, new int[5]);
        
        return answer;
    }
    
    private void combinateAll(int curr, int index, int[] number) {
        
        if (index == 5) {
            // 검증
            if (checkPassword(number)) {
                answer++;
            }
            return;
        }
        
        for (int i = curr; i <= n; i++) {
            number[index] = i;
            combinateAll(i + 1, index + 1, number);
        }
    }
    
    private boolean checkPassword(int[] number) {
        
        Set<Integer> set = new HashSet<>();
        for (int num : number) {
            set.add(num);
        }
        
        for (int i = 0; i < q.length; i++) {
            
            int count = 0;
            for (int num : q[i]) {
                if (set.contains(num)) {
                    count++;
                }
            }
            
            if (count != ans[i]) {
                return false;
            }
        }
        
        return true;
    }
}