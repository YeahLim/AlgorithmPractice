import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		
		// 수열 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] array = new int[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp 초기화
		int[] dp = new int[n];
		dp[0] = 1;
		
		// 수열의 길이 구하기
		for (int i = 1; i < array.length; i++) {
			
			int min = 0;
			for (int j = 0; j < i; j++) {
				if (array[i] > array[j]) {
					min = Math.max(min,  dp[j]);
				}
			}
			
			dp[i] = min + 1;
		}
		
        // 가장 긴 수열 구하기
		int answer = 0;
		for (int d : dp) {
			answer = Math.max(answer,  d);
		}
		
		System.out.println(answer);
	}
}