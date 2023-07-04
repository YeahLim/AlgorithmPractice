/**
*   yellow : n * m 
*   brown : (n+1)*2 + (m+1)*2
*   가로 : n + 2
    세로 : m + 2
*/


class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int i = 1; i * i <= yellow; i++) {
            int j = yellow / i;
            if (yellow % i == 0 && yellow == i * j) {
                if (brown == ((i+1) + (j+1)) * 2) {
                    answer[0] = i >= j ? i + 2 : j + 2;
                    answer[1] = i >= j ? j + 2 : i + 2;
                    break;
                }
            }
        }
        
        return answer;
    }
}