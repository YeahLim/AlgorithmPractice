import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		// N, M 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 수열 초기화
		int[] array = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());  
		}
		
		// 투포인터로 M이 되는 경우 구하기
		int left = 0;
		int right = 0;
		int count = 0;
		int sum = array[right];
		
		
		while (right < N) {
			
			if (sum == M) {
				count++;
			}
			
			
			if (sum <= M) {
				right++;
				if (right != N) {
					sum += array[right];
				}
			}
			
			else if (sum > M) {
				sum -= array[left];
				left++;
				
			}
			

		}
		
		System.out.println(count);
	}
	
}