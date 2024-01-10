import java.util.*;
import java.io.*;

class Main {
	
	static int N, M, K; // 행, 열, 배추 개수
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int num;
	
	public static void main(String[] args) throws IOException {
		
		// T 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

		while (T-- > 0) {
			
			// M, N, K 초기화
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			// map 초기화
			map = new int[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				map[n][m] = -1;
			}
			
			// 배추 구역 찾기
			num = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					
					// 탐색하지않은 배추일 경우
					if (map[i][j] == -1) {
						num++;
						searchCabbage(num, i, j);
					}
					
				}
			}

			System.out.println(num);
		}
		
	

	}

	private static void searchCabbage(int num, int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		map[x][y] = num;
		
		while (!q.isEmpty()) {
			Node curr = q.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				
				if (map[nx][ny] == -1) {
					map[nx][ny] = num;
					q.offer(new Node(nx, ny));
				}
			}
		}
	}
	
}

class Node {
	int x, y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}