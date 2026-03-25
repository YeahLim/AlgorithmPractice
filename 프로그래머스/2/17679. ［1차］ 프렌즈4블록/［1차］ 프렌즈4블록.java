import java.util.*;

// 8:14
class Solution {
    
    int m, n;
    char[][] board;
    
    public int solution(int m, int n, String[] board) {
        
        this.m = m;
        this.n = n;
        this.board = new char[m][n];
        
        // String[] -> char[][]으로 변환
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.board[i][j] = board[i].charAt(j);
            }
        }
        
        int answer = 0;
        
        while (true) {
            
            // 2x2 형태 찾기
            int count = search2x2Block();
            
            // 더 이상 내려갈 것이 없으면
            if (count == 0) {
                break;
            } 
            
            answer += count;
            
            // 빈 공간 채우기
            this.board = fillEmptySpace();
        }

        return answer;
    }
    
    private int search2x2Block() {
        
        boolean[][] removed = new boolean[m][n];
        
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                
                // 블럭이 없는 경우
                if (board[i][j] == ' ') {
                    continue;
                }
                
                // 2x2 블럭이 형성됐을 때
                if (board[i][j] == board[i][j+1] 
                    && board[i][j] == board[i+1][j]
                    && board[i][j] == board[i+1][j+1]) {
                    removed[i][j] = true;
                    removed[i][j+1] = true;
                    removed[i+1][j] = true;
                    removed[i+1][j+1] = true;
                }
            }
        }
        
        return countRemovedBlock(removed);
    }
    
    private int countRemovedBlock(boolean[][] removed) {
        
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (removed[i][j]) {
                    count++;
                    board[i][j] = ' ';
                }
            }
        }
        
        return count;
    }
    
    private char[][] fillEmptySpace() {
        
        Queue<Character>[] info = new Queue[n];
        
        // 아래에서부터 정보 추출
        for (int i = 0; i < n; i++) {    
            info[i] = new LinkedList<>();
            for (int j = m-1; j >= 0; j--) {
                
                if (board[j][i] == ' ') {
                    continue;
                }
                info[i].add(board[j][i]);
            }
        }
        
        // 블록 내리기
        char[][] newBoard = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newBoard[i][j] = ' ';
            }
        }
        
        for (int i = 0; i < n; i++) {
            
            int j = 0;
            while (!info[i].isEmpty()) {
                newBoard[m-j-1][i] = info[i].poll();
                j++;
            }
        }
        
        return newBoard;
    }
}