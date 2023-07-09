import java.util.*;

class Solution {
    
    int N;
    int[][] computers;
    boolean[] visited;
    
    public int solution(int n, int[][] computer) {
        
        N = n;
        computers = new int[N][N];
        for (int i = 0; i < n; i++) {
            computers[i] = computer[i].clone();
        }
        visited = new boolean[computers.length];
        int answer = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i] && computers[i][j] == 1) {           
                    answer++;
                    searchComputers(i);
                    continue;
                }
            }
        }
        return answer;
    }
    
    public void searchComputers(int x) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(x);
        visited[x] = true;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            for (int i = 0; i < N; i++) {
                if (!visited[i] && computers[curr][i] == 1) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}