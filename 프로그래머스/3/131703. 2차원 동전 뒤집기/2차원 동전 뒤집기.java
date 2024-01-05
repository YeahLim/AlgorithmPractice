class Solution {
    
    int rowSize;
    int colSize;
    int[][] board;
    int[][] target;
    int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] beginning, int[][] target) {
        this.rowSize = beginning.length;
        this.colSize = beginning[0].length;
        this.board = beginning;
        this.target = target;
        
        dfs(0, 0);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    private void dfs(int row, int rowCount) {
        
        // 모든 행을 다 돌았을 경우
        if (row == rowSize) {
            
            int colCount = reverseCol();
            
            // 타겟과 일치하는 경우
            if (colCount != -1) {    
                // System.out.println("rowCount : " + rowCount + ", colCount : " + colCount);
                answer = Math.min(answer, rowCount + colCount); 
            }
            
            return;
        }
        
        // 행 : 뒤집지 않았을 경우
        dfs(row+1, rowCount);
        
        // 행 : 뒤집었을 경우
        reverseRow(row);
        dfs(row+1, rowCount+1);
        
        // 행 : 원래대로 되뒤집기
        reverseRow(row);
    }
    
    private void reverseRow(int row) {        
        for (int i = 0; i < colSize; i++) { // colSize만큼 돌려야하는데, rowSize만큼 돌려서 틀림... 주의주의... 이런 실수 아주 위험해!
            board[row][i] = (board[row][i] + 1) % 2;
        }
    }
    
    private int reverseCol() {
        int reversedCount = 0; // col을 reverse한 개수
        int targetCount = 0; // 타켓과 일치하는 개수
        
        for (int col = 0; col < colSize; col++) {
            
            int count = 0;
            for (int row = 0; row < rowSize; row++) {
                if (board[row][col] != target[row][col]) {
                    count++;
                }    
            }
            
            // 열을 뒤집어야하는 경우
            if (count == rowSize) {
                reversedCount++;
                targetCount++;
            }
            
            // target의 열과 일치하는 경우
            if (count == 0) {
                targetCount++;
            }
            
        }
        
        // 타겟과 일치하는 경우
        if (targetCount == colSize) {
            return reversedCount; 
        }
        
        // 아닌 경우
        return -1;
    }
    
}
