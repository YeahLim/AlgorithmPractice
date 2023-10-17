class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int length = triangle[triangle.length - 1].length;
        
        int[][] dp = new int[length][length];
        
        // 초기값 설정
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < triangle.length; i++) {       
            for (int j = 0; j < triangle[i].length; j++) {
                
                // 맨 왼쪽
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];                    
                }
                // 맨 오른쪽
                else if (j == triangle[i].length - 1) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
                // 중간
                else {
                    dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j]);
                }
            }
        }
        

        for (int j = 0; j < dp[length-1].length; j++) {
            answer = Math.max(answer, dp[length-1][j]);
        }
        
        return answer;
    }
}