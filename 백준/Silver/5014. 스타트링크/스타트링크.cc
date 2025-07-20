#include<iostream>
#include<queue>
#include<vector>
using namespace std;

int main() {

    int f, s, g, u, d;
    cin >> f >> s >> g >> u >> d;

    // 현재 위치가 목표 위치인 경우
    if (s == g) {
        cout << 0;
        return 0;
    }

    queue<pair<int, int>> q; // 현재 위치, 횟수
    vector<bool> visited(f+1);
    q.push({s, 0});
    visited[s] = true;

    while (!q.empty()) {
        pair<int, int> curr = q.front();
        q.pop();
        
        // 목표 위치에 도달한 경우
        if (curr.first == g) {
            cout << curr.second;
            return 0;
        }

        int next = curr.first + u;
        if (next <= f && !visited[next]) {
            q.push({next, curr.second+1});
            visited[next] = true;
        }

        next = curr.first - d;
        if (next > 0 && !visited[next]) {
            q.push({next, curr.second+1});
            visited[next] = true;
        }
        
    }

    // 엘리베이터로 갈 수 없는 경우
    cout << "use the stairs";
    
}