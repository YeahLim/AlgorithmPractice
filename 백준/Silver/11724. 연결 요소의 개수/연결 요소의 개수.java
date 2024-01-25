import java.util.*;
import java.io.*;

class Main {
	
	static List<Integer>[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		// N, M 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		// graph 초기화
		graph = new List[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		
		// 연결 요소 찾기
		visited = new boolean[N+1];
		
		int answer = 0; // 연결 요소의 개수
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				searchConnected(i);
				answer++;
			}
		}
		
		
		System.out.println(answer);
	}

	private static void searchConnected(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for (int next : graph[curr]) {
				
				if (visited[next]) {
					continue;
				}
				
				visited[next] = true;
				
				q.offer(next);
			}
		}
		
	}
}