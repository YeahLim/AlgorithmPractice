#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int n;
vector<vector<int>> computers;
vector<int> networks; // 네트워크 개수

void searchNetworks(int curr, int count) {
    
    queue<int> q; // 컴퓨터 큐
    q.push(curr);
    
    while (!q.empty()) {
        
        int curr = q.front();
        q.pop();
        networks[curr] = count;
        
        for (int i = 0; i < computers[curr].size(); i++) {
            
            // 아직 방문하지 않고 연결돼있는 경우
            if (networks[i] == 0 && computers[curr][i] == 1) {
                networks[i] = count;
                q.push(i);
            }
        }
    }
    
    
}

int solution(int n, vector<vector<int>> computers) {
    
    ::n = n;
    ::computers = computers;
    ::networks = vector<int>(n, 0);
    
    // bfs로 네트워크 탐색
    int count = 0;
    for (int i = 0; i < n; i++) {
        
        // 네트워크 탐색을 아직 안 한 경우
        if (networks[i] == 0) {
            count++;
            searchNetworks(i, count);
        }
        
    }
    
    return count;
}