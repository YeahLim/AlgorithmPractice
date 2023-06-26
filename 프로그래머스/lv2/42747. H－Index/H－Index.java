import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        for (int i = citations.length; i >= 0; i--) {
            int biggerCount = 0, lowerCount = 0;
            for (int j = 0; j < citations.length; j++) {
                if (i >= citations[j]) {
                    lowerCount++;
                }
                if (i <= citations[j]) {
                    biggerCount++;
                }   
            }
            if (i >= lowerCount && i <= biggerCount) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}