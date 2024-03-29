import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {
	
	static int N = 12, M = 6;
	static char[][] map;
	static boolean[][] visited;
	static boolean finished = false;
	
	public static void main(String[] args) throws IOException {
		
		// map 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String info = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = info.charAt(j);
			}
		} 
		
		
		// 뿌요 연쇄 몇번인지 구하기
		System.out.println(getPuyoChain());

		
	}

	private static int getPuyoChain() {
		
		int chain = 0;
		
		while (!finished) {
			
			// 뿌요 터뜨리기
			popPuyo();
			
			if (finished) {
				return chain;
			}
//			System.out.println("뿌요 터뜨리기");
//			printMap();
			
			// 뿌요 떨어뜨리기
			dropPuyo();
//			System.out.println("뿌요떨어뜨리기");
//			printMap();
			
			chain++;
//			System.out.println("chain : " + chain);
		}	
		
		return chain;
	}

	private static void dropPuyo() {
		
		for (int j = 0; j < M; j++) {
			
			Stack<Puyo> stack = new Stack<>();
			int bottomRow = -1;
			boolean flag = false;
			boolean needDrop = false;
			
			for (int i = 0; i < N; i++) {
				
				// 빈공간인 경우
				if (map[i][j] == '.') {
					bottomRow = i;
					
					// 뿌요 밑에 빈공간이 있는 경우
					if (flag) {
						needDrop = true;
					}
				}
				
				// 뿌요인 경우
				else {
					stack.add(new Puyo(i, j, map[i][j]));
					flag = true;
				}
			}
			
			// 뿌요 밑으로 내리기
			if (needDrop) {
				doDropPuyo(bottomRow, j, stack);
			}
		}
	}


	private static void doDropPuyo(int bottomRow, int col, Stack<Puyo> stack) {
		
		int i = bottomRow;
		
		// 뿌요 내리기
		while (!stack.isEmpty()) {
			
			Puyo curr = stack.pop();
			
			if (curr.x > bottomRow) {
				continue;
			}
			
			map[i][col] = curr.color;
			i--;
			
		}
		
		// 빈공간으로 채우기
		while (i >= 0) {
			map[i][col] = '.';
			i--;
		}
	}


	private static void printMap() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		} 
		System.out.println("--------------");
	}

	private static void popPuyo() {
		
		finished = true;
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				// 뿌요일 경우
				if (map[i][j] != '.') {
					
					visited[i][j] = true;
					
					// 터뜨릴 수 있는지 뿌요 탐색
					List<Puyo> puyoList = searchPuyo(new Puyo(i, j, map[i][j]));
					
					// 뿌요 제거하기 (연쇄 발생)
					if (puyoList != null) {
						doPopPuyo(puyoList);
						finished = false; // 게임 안 끝남
					}
				}
			}
		}
	}

	private static void doPopPuyo(List<Puyo> puyoList) {
		
		for (Puyo puyo : puyoList) {
			map[puyo.x][puyo.y] = '.';
		}
	}

	private static List<Puyo> searchPuyo(Puyo puyo) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		Queue<Puyo> q = new LinkedList<>();
		q.offer(puyo);
		
		int count = 0;
		List<Puyo> puyoList = new ArrayList<>();
		
		while (!q.isEmpty()) {
			Puyo curr = q.poll();
			
			count++;
			puyoList.add(curr);
			
			for (int i = 0; i < dx.length; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				
				// 범위 벗어났을 경우
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				
				// 방문했거나, 같은 색의 뿌요가 아닌 경우
				if (visited[nx][ny] || map[nx][ny] != puyo.color) {
					continue;
				}
				
				visited[nx][ny] = true;
				q.offer(new Puyo(nx, ny, curr.color));
			}
		}
		
		// 4개 이상의 뿌요가 같이 있는 경우
		if (count >= 4) {
			return puyoList;
		}
		
		return null;		
	}


}


class Puyo {
	int x, y;
	char color;
	
	public Puyo (int x, int y, char color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
}