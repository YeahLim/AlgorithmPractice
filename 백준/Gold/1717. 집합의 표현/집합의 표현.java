import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		
		// 변수 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// union
			if (cmd == 0) {
				union(a, b);
			}
			
			// 같은 집합인지
			else {
				if (findParent(a) == findParent(b)) {
					sb.append("YES\n");
				}
				else {
					sb.append("NO\n");
				}
			}
		}
		
		
		System.out.println(sb);
	}

	private static int findParent(int a) {
		
		if (parent[a] == a) {
			return a;
		}
		
		return parent[a] = findParent(parent[a]);
	}

	private static void union(int a, int b) {
		
		a = findParent(a);
		b = findParent(b);

		if (a == b) {
			return;
		}
		
		if (a < b) {
			parent[b] = a;
		}
		else {
			parent[a] = b;
		}
		
		
	}
}