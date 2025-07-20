#include<iostream>
#include<vector>
using namespace std;

int target;
vector<vector<int>> graph;
vector<bool> visited;
int answer = -1;

void dfs(int curr, int depth, int count) {

    if (curr == target) {
        answer = count;
        return;
    }

    for (int next : graph[curr]) {
        if (!visited[next]) {
            visited[next] = true;
            dfs(next, depth+1, count+1);
        }
    }
}

int main() {
    
    int n;
    cin >> n;

    int start;
    cin >> start >> target;

    int m;
    cin >> m;

    graph.resize(n+1);
    visited.resize(n+1);
    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;

        graph[a].push_back(b);
        graph[b].push_back(a);
    }

    dfs(start, 0, 0);

    cout << answer;
}