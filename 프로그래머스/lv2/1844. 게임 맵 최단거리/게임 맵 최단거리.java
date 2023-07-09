import java.util.*;

class Solution {
    
    class Current {
        int x, y;
        public Current(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[][] visited = new int[n][m];
        Deque<Current> q = new ArrayDeque<>();
        int answer = 10001;
        
        q.offer(new Current(0, 0));
        visited[0][0] = 1;
        while (!q.isEmpty()) {
            Current curr = q.poll();
            
            if (curr.x == n - 1 && curr.y == m - 1) {
                answer = Math.min(answer, visited[curr.x][curr.y]);
            }
            
            for (int i = 0; i < dx.length; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (maps[nx][ny] == 0) {
                    continue;
                }
                if (visited[nx][ny] == 0 || visited[nx][ny] > visited[curr.x][curr.y] + 1) {
                    visited[nx][ny] = visited[curr.x][curr.y] + 1;
                    q.offer(new Current(nx, ny));
                };               
                
            }
        }
        return answer == 10001 ? -1 : answer;
    }
}