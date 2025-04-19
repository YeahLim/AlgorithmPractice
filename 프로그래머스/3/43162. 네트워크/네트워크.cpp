#include <string>
#include <vector>
#include <queue>
using namespace std;

int n;
vector<vector<int>> computers;
vector<bool> visited; 

void searchNetworks(int curr, int count) {
    
    queue<int> q; // 컴퓨터 큐
    q.push(curr);
    visited[curr] = true;
    
    while (!q.empty()) {
        
        int curr = q.front();
        q.pop();
        
        for (int i = 0; i < computers[curr].size(); i++) {
            
            // 아직 방문하지 않고 연결돼있는 경우
            if (!visited[i] && computers[curr][i] == 1) {
                visited[i] = true;
                q.push(i);
            }
        }
    }
    
    
}

int solution(int n, vector<vector<int>> computers) {
    
    ::n = n;
    ::computers = computers;
    ::visited = vector<bool>(n, false);
    
    // bfs로 네트워크 탐색
    int count = 0;
    for (int i = 0; i < n; i++) {
        
        // 네트워크 탐색을 아직 안 한 경우
        if (visited[i] == 0) {
            count++;
            searchNetworks(i, count);
        }
        
    }
    
    return count;
}