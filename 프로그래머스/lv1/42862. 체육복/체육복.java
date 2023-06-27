import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        int[] clothesCnt = new int[n+1];
        
        Arrays.fill(clothesCnt, 1);
        clothesCnt[0] = 0;
        
        for (int l : lost) {
            clothesCnt[l]--;
        }
        for (int r : reserve) {
            clothesCnt[r]++;
        }
        
        for (int i = 1; i <= n; i++) {
            
            // 옷이 있는 경우
            if (clothesCnt[i] >= 1) continue;
            
            // 옷이 없는 경우
            if (clothesCnt[i-1] == 2) {
                clothesCnt[i-1]--;
                clothesCnt[i]++;
            }
            else if (i != n && clothesCnt[i+1] == 2) {
                clothesCnt[i]++;
                clothesCnt[i+1]--;
            }
            
        }

        int answer = 0;
        for (int cnt : clothesCnt) {
            if (cnt != 0) {
                answer++;
            }
        }
        return answer;

    }
}