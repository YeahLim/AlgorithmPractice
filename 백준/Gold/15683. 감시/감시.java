import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


class Main {
	
	static int N, M;
	static int[][] map;
	static List<CCTV> CCTVs = new ArrayList<>();
	static int answer;
	
	public static void main(String[] args) throws IOException {
		
		// N, M, map, count 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				// CCTV인 경우
				if (map[i][j] > 0 && map[i][j] != 6) {
					CCTVs.add(new CCTV(i, j, map[i][j]));
				}
			}
		}
		
		
		// 가장 작은 사각지대 구하기
		answer = N * M;
		searchCCTV(0, 0);
		System.out.println(answer);
		
	}

	
	private static void searchCCTV(int depth, int index) {
		
//		printMap(map);
		
		if (depth == CCTVs.size()) {
			
			// 사각 지대의 최소 크기 구하기
			answer = Math.min(answer, getBlindSpotSize());
			
			return;
		}
		
		CCTV cctv = CCTVs.get(depth);
		
		int[][] newMap = new int[N][M];
		newMap = cloneMap(map);
		
//		System.out.println("newMap");
//		printMap(newMap);
		
		if (cctv.type == 1) {
			
			// 상
			monitorTop(cctv.x, cctv.y);
			searchCCTV(depth+1, index);
			
			// 좌			
			map = cloneMap(newMap);
			monitorLeft(cctv.x, cctv.y);
			searchCCTV(depth+1, index);
			
			// 하
			map = cloneMap(newMap);
			monitorBottom(cctv.x, cctv.y);
			searchCCTV(depth+1, index);
			
			// 우
			map = cloneMap(newMap);
			monitorRight(cctv.x, cctv.y);
			searchCCTV(depth+1, index);
		}
		
		else if (cctv.type == 2) {
			
			// 상하
			monitorTop(cctv.x, cctv.y);
			monitorBottom(cctv.x, cctv.y);
			searchCCTV(depth+1, index);
			
			// 좌우
			map = cloneMap(newMap);
			monitorLeft(cctv.x, cctv.y);
			monitorRight(cctv.x, cctv.y);
			searchCCTV(depth+1, index);

		}
		
		else if (cctv.type == 3) {
			
			// 상우
			monitorTop(cctv.x, cctv.y);
			monitorRight(cctv.x, cctv.y);
			searchCCTV(depth+1, index);
			
			// 우하
			map = cloneMap(newMap);
			monitorRight(cctv.x, cctv.y);
			monitorBottom(cctv.x, cctv.y);
			searchCCTV(depth+1, index);
			
			// 하좌
			map = cloneMap(newMap);
			monitorBottom(cctv.x, cctv.y);
			monitorLeft(cctv.x, cctv.y);
			searchCCTV(depth+1, index);

			// 좌상
			map = cloneMap(newMap);
			monitorLeft(cctv.x, cctv.y);
			monitorTop(cctv.x, cctv.y);
			searchCCTV(depth+1, index);

		}
		
		else if (cctv.type == 4) {
		
			// 상우하
			monitorTop(cctv.x, cctv.y);
			monitorRight(cctv.x, cctv.y);
			monitorBottom(cctv.x, cctv.y);
			searchCCTV(depth+1, index);		
			
			// 우하좌
			map = cloneMap(newMap);
			monitorRight(cctv.x, cctv.y);
			monitorBottom(cctv.x, cctv.y);
			monitorLeft(cctv.x, cctv.y);
			searchCCTV(depth+1, index);	
			
			// 하좌상
			map = cloneMap(newMap);
			monitorBottom(cctv.x, cctv.y);
			monitorLeft(cctv.x, cctv.y);
			monitorTop(cctv.x, cctv.y);
			searchCCTV(depth+1, index);	
			
			// 좌상우
			map = cloneMap(newMap);
			monitorLeft(cctv.x, cctv.y);
			monitorTop(cctv.x, cctv.y);
			monitorRight(cctv.x, cctv.y);
			searchCCTV(depth+1, index);	
		}
		
		else if (cctv.type == 5) {
		
			// 상좌하우
			monitorTop(cctv.x, cctv.y);
			monitorBottom(cctv.x, cctv.y);
			monitorLeft(cctv.x, cctv.y);
			monitorRight(cctv.x, cctv.y);
			searchCCTV(depth+1, index);	
			
		}
		
		
	}


	private static void printMap(int[][] map2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				System.out.print(map2[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("=============");
		
	}


	private static int[][] cloneMap(int[][] oldMap) {
		
		int[][] newMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			newMap[i] = oldMap[i].clone();
		}
		return newMap;
	}


	private static int getBlindSpotSize() {
		
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				if (map[i][j] == 0) {
					count++;
				}
			}
		}
		
		return count;
	}


	private static void monitorTop(int x, int y) {
		
		for (int i = x - 1; i >= 0; i--) {
			
			// 벽
			if (map[i][y] == 6) {
				return;
			}
			
			map[i][y] = 7;
		}
		
	}


	private static void monitorRight(int x, int y) {
		
		for (int i = y + 1; i < M; i++) {
			
			// 벽
			if (map[x][i] == 6) {
				return;
			}
			
			map[x][i] = 7;
		}
		
	}


	private static void monitorBottom(int x, int y) {
		
		for (int i = x + 1; i < N; i++) {
			
			// 벽
			if (map[i][y] == 6) {
				return;
			}
			
			map[i][y] = 7;
		}
		
	}


	private static void monitorLeft(int x, int y) {
		
		for (int i = y - 1; i >= 0; i--) {
			
			// 벽
			if (map[x][i] == 6) {
				return;
			}
			
			map[x][i] = 7;
		}
	}
}

class CCTV {
	
	int x, y;
	int type; // 1~5번
	
	public CCTV(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
}