import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        // 그래프 초기화
        List[] graph = new List[n+1];
        for (int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        // 최대값 설정
        final int INF = 500000 * 2;
        
        // 걸리는 시간 초기화
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[destination] = 0;
        
        // 방문 여부 초기화
        boolean[] visited = new boolean[n+1];
        
        // 다익스트라로 최단 경로 구하기
        Queue<Integer> q = new LinkedList<>();
        q.offer(destination);
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            if (visited[curr]) {
                continue;
            }
            visited[curr] = true;
            
            for (Object nxt : graph[curr]) {
                int next = (int) nxt;
                if (dist[next] > dist[curr] + 1) {
                    dist[next] = dist[curr] + 1;
                    
                    q.offer(next);
                }
            }
        }
        
        // 최단거리 추출
        int[] answer = new int[sources.length];
        int idx = 0;
        for(int s : sources) {
			if(dist[s] == INF) {
                answer[idx] = -1;   
            }
			else {
                answer[idx] = dist[s];
            }
            idx++;
		}
        
        return answer;
    }
}