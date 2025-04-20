#include <string>
#include <vector>
#include <queue>
using namespace std;

struct Point {
    int x, y;
    int count;
    
    Point(int x, int y, int count) {
        this->x = x;
        this->y = y;
        this->count = count;
    }
};

int solution(vector<vector<int>> rectangle, int characterX, int characterY, int itemX, int itemY) {
    int N = 101; // 맵 크기
    
    // 크기 두 배로 늘려 겹치는 부분 없도록
    characterX *= 2;
    characterY *= 2;
    itemX *= 2;
    itemY *= 2;
    
    // 1. 루트 구하기
    vector<vector<bool>> map(N, vector<bool>(N, false));
    for (int i = 0; i < rectangle.size(); i++) {
        
        int x1 = rectangle[i][0] * 2;
        int y1 = rectangle[i][1] * 2;
        int x2 = rectangle[i][2] * 2;
        int y2 = rectangle[i][3] * 2;
        
        // 직사각형 부분 true로 채우기
        for (int j = x1; j <= x2; j++) {
            for (int k = y1; k <= y2; k++) {
                map[j][k] = true;
            }          
        }
    }
    
    for (int i = 0; i < rectangle.size(); i++) {
        
        int x1 = rectangle[i][0] * 2;
        int y1 = rectangle[i][1] * 2;
        int x2 = rectangle[i][2] * 2;
        int y2 = rectangle[i][3] * 2;
        
        // 루트 빼고 flase로 채우기
        for (int j = x1 + 1; j < x2; j++) {
            for (int k = y1 + 1; k < y2; k++) {
                map[j][k] = false;
            }
        }
    }
    
    // 2. bfs로 아이템 찾기
    vector<int> dx = {-1, 1, 0, 0};
    vector<int> dy = {0, 0, -1, 1};
    
    queue<Point> q;
    q.push(Point(characterX, characterY, 0));
    vector<vector<bool>> visited(N, vector<bool>(N, false));
    visited[characterX][characterY] = true;
    
    while(!q.empty()) {
        Point curr = q.front();
        q.pop();
        
        if (curr.x == itemX && curr.y == itemY) {
            return curr.count / 2;
        }
        
        for (int i = 0; i < dx.size(); i++) {
            int nx = curr.x + dx[i];
            int ny = curr.y + dy[i];
            
            // 맵을 벗어나는 경우
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }
            
            // 이미 방문했거나 길이 아닌 경우
            if (visited[nx][ny] || !map[nx][ny]) {
                continue;
            }
            
            visited[nx][ny] = true;
            q.push(Point(nx, ny, curr.count+1));
        }
    }
    
    return -1;
}