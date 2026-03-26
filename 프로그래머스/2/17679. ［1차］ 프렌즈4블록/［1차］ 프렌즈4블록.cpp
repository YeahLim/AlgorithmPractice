#include <bits/stdc++.h>

using namespace std;

int m, n;
vector<string> board;

vector<vector<bool>> search4Blocks() {
    
    vector<vector<bool>> removed(m, vector<bool>(n, false));
    
    for (int i = 0; i < m - 1; i++) {
        for (int j = 0; j < n - 1; j++) {
            
            if (board[i][j] == ' ') {
                continue;
            }
            
            if (board[i][j] == board[i][j+1] &&
                board[i][j] == board[i+1][j] &&
                board[i][j] == board[i+1][j+1]) {
                removed[i][j] = true;
                removed[i][j+1] = true;
                removed[i+1][j] = true;
                removed[i+1][j+1] = true;
            }
        }
    }
    return removed;
}

int removeBlocks(vector<vector<bool>> removed) {
    
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

vector<string> fillEmptySpace() {
    
    vector<stack<int>> info(n);
        
    for (int j = 0; j < n; j++) {
        stack<int>& st = info[j];
        for (int i = 0; i < m; i++) {
            
            // 빈 공간인 경우
            if (board[i][j] == ' ') {
                continue;
            }
            
            st.push(board[i][j]);
        }
    }
    
    vector<string> newBoard(m, string(n, ' '));
    
    for (int j = 0; j < n; j++) {
        
        stack<int>& st = info[j];
        int i = 0;
        
        while (!st.empty()) {
            newBoard[m-1-i][j] = st.top();
            st.pop();
            i++;
        }
    }
    
    return newBoard;
}

int solution(int m, int n, vector<string> board) {
    
    ::m = m;
    ::n = n;
    ::board = board;
    
    int answer = 0;
    
    while (true) {
        
        // 4블록 찾기
        vector<vector<bool>> removed = search4Blocks();    
        
        // 블록 제거
        int count = removeBlocks(removed);
                
        // 더 이상 제거할 블록이 없다면
        if (count == 0) {
            break;
        }
        
        answer += count;
        
        ::board = fillEmptySpace();
        
    }
    
    return answer;
}
