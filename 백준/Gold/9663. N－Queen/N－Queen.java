import java.io.IOException;
import java.util.Scanner;

class Main {
	
	static int N;
	static int[] rowBoard;
	static int answer;

	public static void main(String[] args) throws IOException {

		// N, rowBoard 초기화
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		rowBoard = new int[N];
		
		nQueen(0);
		
		System.out.println(answer);

	}

	private static void nQueen(int depth) {
		
		if (depth == N) {
			answer++;
			return;
		}
		
		
		for (int i = 0; i < N; i++) {
			rowBoard[depth] = i;
			
			// 퀸을 놓을 수 있는지
			if (possibleQueen(depth)) {
				nQueen(depth + 1);
			}
		}
	}

	
	private static boolean possibleQueen(int col) {
		
		for (int i = 0; i < col; i++) {
			
			// 같은 행에 존재하는 경우
			if (rowBoard[col] == rowBoard[i]) {
				return false;
			}
			
			// 같은 대각선에 존재하는 경우
			else if ((col - i) == Math.abs(rowBoard[col] - rowBoard[i])) {
				return false;
			}
		}
		
		return true;
	}


}