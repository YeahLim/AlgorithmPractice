class Solution {
    public int solution(String[] board) {
        
        int oCount = 0;
        int xCount = 0;
        boolean oWinner = checkWinner(board, 'O');
        boolean xWinner = checkWinner(board, 'X');

        for (int i = 0; i < board.length; i++) {
            
            for (int j = 0; j < board.length; j++) {
                if (board[i].charAt(j) == 'O') {
                    oCount++;
                }
                else if (board[i].charAt(j) == 'X') {
                    xCount++;
                }
            }
        }
        
        if (xCount == 0 && oCount == 0) {
            return 1;
        }
        
        // X와 O의 개수가 같거나 O가 하나 더 있어야 함
        if (xCount + 1 != oCount && xCount != oCount) {
            return 0;
        }
        
        // O, X의 개수가 같음 + O가 게임에서 이김
        if (xCount == oCount && oWinner) {
            return 0;
        }
               
        // O의 개수가 1개 많음 + X가 게임에서 이김
        if (oCount == xCount + 1 && xWinner) {
            return 0;
        }

        return 1;
    }
    
    private boolean checkWinner(String[] board, char target) {
        return (
(board[0].charAt(0) == target && board[0].charAt(1) == target && board[0].charAt(2) == target) 
|| (board[1].charAt(0) == target && board[1].charAt(1) == target && board[1].charAt(2) == target)
|| (board[2].charAt(0) == target && board[2].charAt(1) == target && board[2].charAt(2) == target)
|| (board[0].charAt(0) == target && board[1].charAt(0) == target && board[2].charAt(0) == target)
|| (board[0].charAt(1) == target && board[1].charAt(1) == target && board[2].charAt(1) == target) 
|| (board[0].charAt(2) == target && board[1].charAt(2) == target && board[2].charAt(2) == target)
|| (board[0].charAt(0) == target && board[1].charAt(1) == target && board[2].charAt(2) == target)
|| (board[0].charAt(2) == target && board[1].charAt(1) == target && board[2].charAt(0) == target));
    }
}