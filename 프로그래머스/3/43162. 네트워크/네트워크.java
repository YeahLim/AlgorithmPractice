import java.util.*;

class Solution {
    
    int[][] computers;
    
    public int solution(int n, int[][] computers) {
        
        this.computers = computers;
        int answer = 0;
        boolean[] visited = new boolean[computers.length];
        
        for (int i = 0; i < computers.length; i++) {
            
            if (!visited[i]) {
                visited = searchConnectedComputers(visited, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean[] searchConnectedComputers(boolean[] visited, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            for (int i = 0; i < computers[curr].length; i++) {
                
                if (!visited[i] && computers[curr][i] == 1) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        
        return visited;
    }
}