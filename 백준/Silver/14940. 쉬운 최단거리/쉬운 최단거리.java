import java.util.*;
import java.io.*;

class Main {
	
	static int[][] map;
	static int N, M;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		
		// N, M 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// map, dest 초기화
		map = new int[N][M];
		int destX = 0;
		int destY = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				// dest 설정
				if (map[i][j] == 2) {
					destX = i;
					destY = j;
				}
			}
		}
		
		
		// 최단 경로 찾기
		visited = new boolean[N][M];
		searchDest(destX, destY);
		
		
		// 출력
        StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] || map[i][j] == 0) {
					sb.append(map[i][j]).append(" ");
				}
				else {
					sb.append("-1 ");
				}
				
			}
            sb.append("\n");
		}
        System.out.println(sb);
	}

	
	private static void searchDest(int x, int y) {
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y, 0));
		
		visited[x][y] = true;
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		while (!q.isEmpty()) {
			Node curr = q.poll();
			
			map[curr.x][curr.y] = curr.count;
			

			for (int i = 0; i < dx.length; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				
				if (visited[nx][ny] || map[nx][ny] == 0) {
					continue;
				}
				
				visited[nx][ny] = true;
				q.offer(new Node(nx,  ny, curr.count+1));
			}
		}
		
	}

}

class Node {
	int x, y;
	int count;
	
	public Node(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}