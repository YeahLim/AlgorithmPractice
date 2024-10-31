class Solution {
    public int[] solution(String s) {
        
        int convertCount = 0;
        int zeroCount = 0;
        
        while (!s.equals("1")) {
            
            // 1. 0 없애고, 개수 세기
            int length = s.length();
            s = s.replace("0", "");
            zeroCount += length - s.length();
            
            // 2. 길이를 구하고 이진변환   
            s = Integer.toBinaryString(s.length());
            convertCount++;
        }
        
        return new int[] {convertCount, zeroCount};
    }
}