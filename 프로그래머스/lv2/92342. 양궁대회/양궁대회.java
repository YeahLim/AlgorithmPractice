class Solution {
    final int MAX_NUM = 10;
    int[] answer = { -1 };
    int[] ryan;
    int[] apeach;
    int maxScore = 1;
    int n;
    
    public int[] solution(int n, int[] info) {
        this.ryan = new int[11];
        this.apeach = info;
        this.n = n;
        countScore(0);
        return answer;
    }
    
    public void countScore(int depth) {
        if(depth == n) {
            
            int apeachScore = 0;
            int ryanScore = 0;
            for(int i = 0; i <= MAX_NUM; i++) 
            {
                if(apeach[i] == 0 && ryan[i] == 0) {
                    continue;
                }
                if(apeach[i] < ryan[i]) {
                    ryanScore += MAX_NUM - i;
                }
                else {
                    apeachScore += MAX_NUM - i;
                }
            }
            
            if(ryanScore - apeachScore >= maxScore){
                answer = ryan.clone();
                maxScore = ryanScore - apeachScore;
            }
            
            return ;
        }
        
        for(int j = 0; j <= MAX_NUM && ryan[j] <= apeach[j]; j++) {
            ryan[j]++;
            countScore(depth+1);
            ryan[j]--;
        }
    }

}