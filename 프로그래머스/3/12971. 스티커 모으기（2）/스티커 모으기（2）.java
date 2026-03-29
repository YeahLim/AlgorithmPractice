class Solution {
    public int solution(int sticker[]) {
        
        if (sticker.length == 1) {
            return sticker[0];
        } else if (sticker.length == 2) {
            return Math.max(sticker[0], sticker[1]);
        }
        
        // 1. 첫번째 뜯고, 마지막 안뜯는 경우
        int[] dp1 = new int[sticker.length - 1];
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        
        for (int i = 2; i < sticker.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 2] + sticker[i], dp1[i-1]);
        }
        
        // 2. 첫번째 안뜯고, 마지막 뜯는 경우
        int[] dp2 = new int[sticker.length];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        
        for (int i = 2; i < sticker.length; i++) {
            dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i-1]);
        }
        
        
        return Math.max(dp1[sticker.length - 2], dp2[sticker.length - 1]);
    }
}