import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {

		// T, array, length 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[] array = new int[T];
		int length = 0;
		
		for (int i = 0; i < T; i++) {
			array[i] = Integer.parseInt(br.readLine()); 
			length = Math.max(length, array[i]);
		}
		
		
		// 파도반 수열 구하기
		long[] dp = new long[length + 1];
		dp[1] = 1;
		dp[2] = 1;
		
		for (int i = 3; i <= length; i++) {
			dp[i] = dp[i-3] + dp[i-2];
		}
		
		
		// 출력
		for (int i = 0; i < T; i++) {
			System.out.println(dp[array[i]]);
		}
	}


}