import java.io.*;
import java.util.*;

/***
 * 
 * 		1. 섬 별로 숫자로 나누기
 * 		2. 좌표 전체 돌려서 가장 가까운 섬 찾기
 *		주의사항 : 효율적인 방법보다 확실한 방법을 쓰자
 *              같은 섬으로 다시 돌아와도 count값 변경안되는 등 예외 케이스
 */


class Main {
	
	static int N; // map 크기
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][N];
		
		/* 숫자로 섬 구분하기 */
		int num = 1; // 섬 개수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				// 섬이 아닌 경우
				if (map[i][j] == 0) {
					continue;
				}
				
				// 이미 채워진 경우
				if (visited[i][j]) {
					continue;
				}
				
				fillNumber(num, i, j);
				num++;
			}
		}

		answer = N * N;
		
		/* 한 섬에서 다른 섬으로 다리 짓기 */
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {			
				visited = new boolean[N][N];	
				
				if (map[i][j] == 0) {
					continue;
				}
				
				// 다른 섬 찾기
				searchOtherIsland(map[i][j], i, j);
			}
		}
		
		/* 출력 */
		System.out.println(answer);
	}


	/* 다리로 연결할 다른 섬 찾기 */
	private static void searchOtherIsland(int num, int x, int y) {
		Queue<Point> pointQ = new LinkedList<>();
		pointQ.add(new Point(x, y));
		visited[x][y] = true;
		
		while (!pointQ.isEmpty()) {
			Point curr = pointQ.poll();
			
			// 현재 다리보다 길 경우
			if (answer < curr.count){
				break;
			}
			
			// 다리 연결 성공
			if (map[curr.x][curr.y] != num && map[curr.x][curr.y] != 0) {
				answer = Math.min(answer, curr.count - 1);
				break;
			}
			
			for (int i = 0; i < dx.length; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				
				if (visited[nx][ny]) {
					continue;
				}
				
				if (map[nx][ny] == num) {
					continue;
				}
				
				visited[nx][ny] = true;
				Point next = new Point(nx, ny);
				next.count = curr.count + 1;				
				
				pointQ.add(next);
				
			}
		}
	}

	private static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	/* 숫자로 섬 채우기 */
	private static void fillNumber(int num, int x, int y) {
		Queue<Point> pointQ = new LinkedList<>();
		pointQ.add(new Point(x, y));
		visited[x][y] = true;
		
		while (!pointQ.isEmpty()) {
			Point curr = pointQ.poll();
			
			// 숫자로 채우기
			map[curr.x][curr.y] = num; 
			
			for (int i = 0; i < dx.length; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				
				if (map[nx][ny] == 0 || visited[nx][ny]) {
					continue;
				}
				
				visited[nx][ny] = true;
				pointQ.add(new Point(nx, ny));
			}
		}
	}
}

class Point {
	int x, y;
	int count;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		this.count = 0;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", count=" + count + "]";
	}
	
}
