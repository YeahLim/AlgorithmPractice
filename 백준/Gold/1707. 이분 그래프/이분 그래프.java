import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int V, E;
	static List<List<Integer>> graph;
	static int[] color; // 1, 2
	
	public static void main(String[] args) throws IOException {
		
		// 변수 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		while (K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());	
			E = Integer.parseInt(st.nextToken());
			graph = new ArrayList<List<Integer>>();
			
			for (int i = 0; i <= V; i++) {
				graph.add(new ArrayList<>());
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			
			color = new int[V+1];
			boolean bipartiteGraph = true;
			for (int i = 1; i <= V; i++) {
				if (color[i] == 0) {
					color[i] = 1;
					if (!searchGraph(i)) {
						bipartiteGraph = false;
						break;
					}
				}
			}
			
			if (bipartiteGraph) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			
		}
		
		
	}

	private static boolean searchGraph(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			
			for (int next : graph.get(curr)) {
				
				if (color[next] == color[curr]) {
					return false;
				}
				
				if (color[next] == 0) {
					color[next] = color[curr]*-1;
					q.offer(next);
				}

			}
			
		}
		
		return true;
	}

}