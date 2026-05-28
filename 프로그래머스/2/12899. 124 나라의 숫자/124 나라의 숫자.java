class Solution {
    public String solution(int n) {
        String answer = "";
        
        String[] nums = {"4", "1", "2"};
        
        while (n > 0) {
            int number = n % 3;
            
            if (number == 0) {
                n--;
            }
            
            answer = nums[number] + answer;
            
            n /= 3;
        }
        
        return answer;
    }
}