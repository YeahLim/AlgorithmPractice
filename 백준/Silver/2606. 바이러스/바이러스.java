import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		// N 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 컴퓨터 수
		
		// graph 초기화
		List[] graph = new List[N+1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int K = Integer.parseInt(br.readLine());
		while (K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		// 방문여부 초기화
		boolean[] visited = new boolean[N+1];
		
		// 1번 컴퓨터와 연결된 컴퓨터의 개수 구하기
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(1);
		visited[1] = true;
		int count = 0;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for (Object nxt : graph[curr]) {
				int next = (int) nxt;
				
				if (visited[next]) {
					continue;
				}
				
				visited[next] = true;
				count++;
				q.offer(next);
			}
		}
		
		System.out.println(count);

	}

}