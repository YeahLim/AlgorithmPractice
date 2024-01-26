import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		// N 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());


		// graph 초기화
		List<Integer>[] graph = new List[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		
		// 부모 노드 찾기
		int[] parent = new int[N+1];
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		
		boolean[] visited = new boolean[N+1];
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for (int next : graph[curr]) {
				
				if (visited[next]) {
					continue;
				}
				
				visited[next] = true;
				
				parent[next] = curr;
				
				q.offer(next);
			}
		}
		
		
		// 출력
		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	}

}