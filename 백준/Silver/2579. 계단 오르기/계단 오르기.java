import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		// N 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 계단 개수
		
		// stair 초기화
		int[] stair = new int[N+1];
		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		// dp 초기화
		int[] dp = new int[N+1];
		dp[1] = stair[1];
		
		if (N >= 2) {
			dp[2] = stair[1] + stair[2];	
		}
		
		// 계단 오르는 최대값 구하기
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-2], stair[i-1] + dp[i-3]) + stair[i];
		}
		
		System.out.println(dp[N]);
	}

}