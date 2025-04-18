#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int n;
vector<vector<int>> graph; // 인접 리스트

int searchWires(vector<int> wire) {
 
    vector<bool> visited(n+1);
    visited[wire[0]] = true;
    visited[wire[1]] = true; // 해당 와이어 끊기
    queue<int> wire_q;
    wire_q.push(wire[0]);
    
    int count = 1;
    while (!wire_q.empty()) {
        int curr = wire_q.front();
        wire_q.pop();
        
        for (int next : graph[curr]) {
            if (!visited[next]) {
                visited[next] = true;
                wire_q.push(next);
                count++;
            }
        }
    }
    return count;
}


int solution(int n, vector<vector<int>> wires) {
    
    ::n = n;
    
    // 1. 인접 리스트 만들기
    graph = vector<vector<int>>(n+1);
    for (auto& wire : wires) {
        graph[wire[0]].push_back(wire[1]);
        graph[wire[1]].push_back(wire[0]);
    }
    
    int answer = n;
    for (auto& wire : wires) {
        
        // 2. bfs로 와이어 탐색
        int count = searchWires(wire);
        
        // 3. 차이 계산
        answer = min(answer, abs(n - count - count));
        
    }
    
    return answer;
}