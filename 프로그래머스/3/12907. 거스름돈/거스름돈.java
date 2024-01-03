class Solution {
    
    public int solution(int n, int[] money) {        
        int[][] dp = new int[money.length + 1][n+1]; // [moeny종류][n원]       
        
        // dp[0][] = 0이다, 그 전 값을 사용하기 위해 money.length가 아닌, money.length+1사용
        // 1번째 index부터 money 종류 시작
        
        for (int i = 1; i < money.length+1; i++) {
            for (int j = 0; j < n+1; j++) {
                
                // dp 초기화 : 0원일 때
                if (j == 0) {
                    dp[i][j] = 1;
                }
                
                else {
                    
                    // j - money[i-1] 음수일 때, 0 을 더한다
                    if (money[i-1] > j) {
                        dp[i][j] = dp[i-1][j];
                    }   
                    
                    else {
                        dp[i][j] = (dp[i-1][j] + dp[i][j - money[i-1]]) % 1000000007;
                    }
                }
            }
        }
        
        
        
        return dp[money.length][n];
    }
}
