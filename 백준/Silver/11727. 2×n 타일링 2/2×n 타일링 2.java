import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {

		// N 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());

		// 2 * N 타일링 방법의 수 구하기
		int[] dp = new int[N+1];
		dp[1] = 1;
		
		if (N > 1) {
			dp[2] = 3;
		}
				
		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i-1] + dp[i-2] * 2) % 10_007;
		}
		
		System.out.println(dp[N]);
	}

}