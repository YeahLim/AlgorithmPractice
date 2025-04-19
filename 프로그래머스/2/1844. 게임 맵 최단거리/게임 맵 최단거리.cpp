#include<vector>
#include<queue>
using namespace std;

struct Point {
    
    int x, y;
    int count;
    
    Point(int x, int y, int count) {
        this-> x = x;
        this-> y = y;
        this-> count = count;
    }
};

// 1:01
int solution(vector<vector<int> > maps)
{
    int N = maps.size();
    int M = maps[0].size();
    
    // 방향 벡터
    vector<int> dx = {-1, 1, 0, 0};
    vector<int> dy = {0, 0, -1, 1};
    
    queue<Point> q;
    q.push(Point(0,0,1));
    vector<vector<bool>> visited(N, vector<bool>(M, false));
    visited[0][0] = true;
    
    // bfs로 길 탐색
    while (!q.empty()) {
        Point curr = q.front();
        q.pop();
        
        // 상대 팀 진영에 도착한 경우
        if (curr.x == N-1 && curr.y == M-1) {
            return curr.count;
        }
        
        for (int i = 0; i < dx.size(); i++) {
            int nx = curr.x + dx[i];
            int ny = curr.y + dy[i];
            
            // 지도에 벗어나는 경우
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }
            
            // 이미 방문하거나 벽이 있는 경우
            if (visited[nx][ny] || maps[nx][ny] == 0) {
                continue;
            }
            
            visited[nx][ny] = true;
            q.push(Point(nx, ny, curr.count+1));
        }
    }
    
    return -1;
}