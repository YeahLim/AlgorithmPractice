#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int n;
vector<vector<int>> graph;

int searchWires() {
 
    vector<bool> visited(n+1);
    visited[1] = true;    
    queue<int> wire_q;
    wire_q.push(1);
    
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
        
        // 2. 연결 끊기
        graph[wire[0]].erase(remove(graph[wire[0]].begin(), graph[wire[0]].end(), wire[1]), graph[wire[0]].end());
        graph[wire[1]].erase(remove(graph[wire[1]].begin(), graph[wire[1]].end(), wire[0]), graph[wire[1]].end());
        
        // 3. bfs로 와이어 탐색
        int count = searchWires();
        answer = min(answer, abs(n - count - count));
        
        // 4. 연결 복구
        graph[wire[0]].push_back(wire[1]);
        graph[wire[1]].push_back(wire[0]);
    }
    
    return answer;
}