import java.util.*;

class Solution {
    
    int[] supoja1 = {1, 2, 3, 4, 5};
    int[] supoja2 = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] supoja3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        int[] count = new int[4]; // 정답 맞힌 개수
        int i = -1, j = -1, k = -1;
        int len = -1;
        while (++len < answers.length) {
            if (++i == supoja1.length) {
                i = 0;
            }
            if (++j == supoja2.length) {
                j = 0;
            }
            if (++k == supoja3.length) {
                k = 0;
            }
            
            if (answers[len] == supoja1[i]) {
                count[1]++;
            }
            if (answers[len] == supoja2[j]) {
                count[2]++;
            }
            if (answers[len] == supoja3[k]) {
                count[3]++;
            }
        }
        
        int maxCount = Arrays.stream(count).max().getAsInt();
        List<Integer> supojas = new ArrayList<>();
        for (int idx = 1; idx <= 3; idx++) {
            if (maxCount == count[idx]) {
                supojas.add(idx);
            }
        }
        
        return supojas.stream().mapToInt(x -> x.intValue()).toArray();
    }
}