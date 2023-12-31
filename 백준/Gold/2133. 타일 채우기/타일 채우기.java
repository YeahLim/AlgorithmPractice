import java.io.*;
import java.util.*;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if (N % 2 == 1) {
			System.out.println(0);
			return;
		}
		
		// 초기 설정
		int[] dp = new int[31];
		dp[0] = 1;
		dp[2] = 3;	
		
        // 점화식
		for (int i = 4; i <= N; i += 2) {
			dp[i] = dp[i-2] * dp[2];
			for (int j = i - 4; j >= 0; j -= 2) {
				dp[i] += dp[j] * 2;
			}
		}
		
		System.out.println(dp[N]);
		
	}
}