import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		
		// 변수 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N+1];
		boolean[] broken = new boolean[N+1];
		
		for (int i = 0; i < B; i++) {
			int num = Integer.parseInt(br.readLine());
			broken[num] = true;
		}
		
	
		// 슬라이딩 윈도우로 최소 몇 개의 신호등을 수리해야하는지 구하기
		int count = 0;
		for (int i = 1; i <= K; i++) {
			
			if (broken[i]) {
				count++;
			}			
		}
		int min = count;
		
		for (int i = K+1; i <= N; i++) {
			
			if (broken[i - K]) {
				count--;
			}
			
			if (broken[i]) {
				count++;
			}
			
			if (min > count) {
				min = count;
			}
		}
		
		System.out.println(min);
	}
}