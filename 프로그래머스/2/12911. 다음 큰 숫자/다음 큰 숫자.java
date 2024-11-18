class Solution {
    public int solution(int n) {
        
        int target = Integer.toBinaryString(n).replace("0", "").length();
        
        for (int num = n + 1; num <= 1_000_000; num++) {
            
            // 이진수 변환
            if (Integer.toBinaryString(num).replace("0", "").length() == target) {
                return num;
            }
            
        }
        
        return 0;
    }
}