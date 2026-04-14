class Solution {
    public String solution(int n) {
        String answer = "";
        
        while (answer.length() < n - 1) {
            answer += "수박";
        }
        
        if (n % 2 == 1) {
            answer += "수";
        }
        
        return answer;
    }
}