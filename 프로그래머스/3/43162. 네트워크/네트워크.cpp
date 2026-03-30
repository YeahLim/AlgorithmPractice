#include <bits/stdc++.h>

using namespace std;

vector<vector<int>> computers;

vector<bool> searchConnectedComputers(vector<bool> visited, int start) {
    queue<int> q;
    q.push(start);
    visited[start] = true;
    
    while (!q.empty()) {
        int curr = q.front();
        q.pop();
        
        for (int i = 0; i < computers[curr].size(); i++) {
            if (!visited[i] && computers[curr][i] == 1) {
                visited[i] = true;
                q.push(i);
            }
        }
    }
    
    return visited;
}

int solution(int n, vector<vector<int>> computers) {
    
    ::computers = computers;
    vector<bool> visited(n, false);
    int answer = 0;
    
    for (int i = 0; i < n; i++) {
        
        if (!visited[i]) {
            visited = searchConnectedComputers(visited, i);
            answer++;
        }
    }
    
    return answer;
}