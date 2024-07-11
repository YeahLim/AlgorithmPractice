import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] heights;
	static boolean[][] visited;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		heights = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				heights[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][M];
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && heights[i][j] != 0) {
					answer += searchHeights(i, j);
				}
			}
		}
		
		System.out.println(answer);
	}

	private static int searchHeights(int x, int y) {		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		boolean peak = true;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];
			
			for (int i = 0; i < dx.length; i++) {
				int nx = dx[i] + cx;
				int ny = dy[i] + cy;
				
				// 범위 벗어날때
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				
				// 더 높은 봉우리가 나타난 경우
				if (heights[nx][ny] > heights[cx][cy]) {
					peak = false;
				}

				// 이미 방문했거나 크기가 0일때
				if (!visited[nx][ny] && heights[nx][ny] == heights[cx][cy]) {
					visited[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
				
			}
		}
		
		return peak ? 1 : 0;
	}

}
