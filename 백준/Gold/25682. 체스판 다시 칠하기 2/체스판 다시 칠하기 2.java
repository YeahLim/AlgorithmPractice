import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		
		// 변수 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[N+1][M+1];
	
		for (int i = 1; i <= N; i++) {
			String info = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j+1] = info.charAt(j);
			}
		}
		
		
		// 블랙 기준으로 체크판인지 확인
		int[][] array = new int[N+1][M+1];
		boolean black = true; 
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (black) {
					array[i][j] = board[i][j] == 'B' ? 0 : 1;
				}
				else {
					array[i][j] = board[i][j] == 'W' ? 0 : 1;
				}
				black = !black;
			}
			
			if (M % 2 == 0) {
				black = !black;
			}
		}
		
		// 누적합 구하기
		for (int i = 0; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				array[i][j] += array[i][j-1];
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				array[i][j] += array[i-1][j];
			}
		}
		
		// K * K 체스판에서 최소값,최대값 구하기
		int min = K*K;
		int max = 0;
		for (int i = K; i <= N; i++) {
			for (int j = K; j <= M; j++) {
				int curr = array[i][j] - array[i-K][j] - array[i][j-K] + array[i-K][j-K];
				
				min = Math.min(min, curr);
				max = Math.max(max, curr);
			}
		}
		
		// 블랙 : 최소값, 화이트 : K*K - 최대값
		int whiteMin = K*K - max;
		System.out.println(Math.min(min, whiteMin));
	}
}
