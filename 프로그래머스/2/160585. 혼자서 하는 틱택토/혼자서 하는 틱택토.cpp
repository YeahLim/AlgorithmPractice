#include <string>
#include <vector>

using namespace std;

bool checkWinner (vector<string> board, char target) {
    
    for (int i = 0; i < 3; i++) {
        // 가로
        if (board[i][0] == target && board[i][1] == target && board[i][2] == target){
            return true;
        }
        // 세로
        if (board[0][i] == target && board[1][i] == target && board[2][i] == target){
            return true;
        }    
    }
    
    // 대각선
    if (board[0][0] == target && board[1][1] == target && board[2][2] == target) {
        return true;
    }
    
    // 대각선
    if (board[0][2] == target && board[1][1] == target && board[2][0] == target) {
        return true;
    }
    
    return false;
}

int solution(vector<string> board) {
    int answer = 1;
    
    int oCount = 0;
    int xCount = 0;
    
    for (int i = 0; i < board.size(); i++) {
        for (int j = 0; j < board.size(); j++) {
            if (board[i][j] == 'O') {
                oCount++;
            }
            else if (board[i][j] == 'X') {
                xCount++;
            }
        }
    }
    
    bool oWinner = checkWinner(board, 'O');
    bool xWinner = checkWinner(board, 'X');
    
    if (oCount != xCount && oCount != xCount + 1) {
        answer = 0;
    }
    
    if (oWinner && oCount == xCount) {
        answer = 0;
    }
    
    if (xWinner && oCount == xCount + 1) {
        answer = 0;
    }
    
    return answer;
}