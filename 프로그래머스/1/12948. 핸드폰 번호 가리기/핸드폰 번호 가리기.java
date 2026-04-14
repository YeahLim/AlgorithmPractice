class Solution {
    public String solution(String phone_number) {
        
        String answer = "";
        int index = 0;
        for (; index < phone_number.length() - 4; index++) {
            answer += "*";
        }
        answer += phone_number.substring(index);
        
        return answer;
    }
}