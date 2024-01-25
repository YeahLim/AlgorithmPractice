import java.util.*;
import java.io.*;

class Main {
	
	static int[][] paper;
	static int white, blue;
	
	public static void main(String[] args) throws IOException {
		
		// N, paper 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		// 색종이 개수 찾기
		searchPaperNum(N, 0, 0);

		
		// 출력
		System.out.println(white + "\n" + blue);
	}

	private static void searchPaperNum(int length, int x, int y) {
		
		// 모두 같은 색일 경우
		if (checkSameColor(length, x, y)) {
			
			if (paper[x][y] == 0) {
				white++;
			}
			
			else {
				blue++;
			}
			
			return;
		}
		
		
		// 좌상
		searchPaperNum(length/2, x, y);
		
		// 우상
		searchPaperNum(length/2, x, y + length/2);
		
		// 좌하
		searchPaperNum(length/2, x + length/2, y);
		
		// 우하
		searchPaperNum(length/2, x + length/2, y + length/2);
		
	}

	private static boolean checkSameColor(int length, int x, int y) {
		
		int color = paper[x][y];
		
		for (int i = x; i < x + length; i++) {
			for (int j = y; j < y + length; j++) {
				
				if (color != paper[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
}