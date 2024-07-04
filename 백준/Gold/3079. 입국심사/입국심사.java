import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
        // 변수 초기화
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		long[] time = new long[N];
		for (int i = 0; i < N; i++) {
			time[i] = sc.nextInt();
		}
		
		Arrays.sort(time); // 오름차순 정렬
		
        // 이분탐색으로 최소 시간 구하기
		long start = 0;
		long end = time[N-1] * M;
		long answer = 0;
		
		while (start <= end) {
			long mid = (start + end) / 2;			
			long count = 0;
			
			for (long t : time) {
				
				if (count >= M) {
					break;
				}
				count += mid / t;
			}
			
			if (count >= M) {
				end = mid - 1;
				answer = mid;
			} else {
				start = mid + 1;
			}
		}
		
		System.out.println(answer);
	}

	

}