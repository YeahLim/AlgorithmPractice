import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		// N 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 용액 개수
		
		// solution 초기화
		int[] solution = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			solution[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(solution); // 오름차순 정렬
		
		// 두 용액의 혼합이 0에 가장 가까운 경우 구하기
		int left = 0;
		int right = N - 1;
		int answerSum = Integer.MAX_VALUE;
		int[] answer = {solution[left], solution[right]};
		
		while (left < right) {
			int sum = solution[left] + solution[right];
			
			// 더 0에 가까운 경우
			if (Math.abs(answerSum) > Math.abs(sum)) {
				answerSum = sum;
				answer = new int[] {solution[left], solution[right]};
			}
			
			// 양수일때 left++
			if (sum > 0) {
				right--;
			}
			
			// 음수일때 right--
			else {
				left++;
			}
		}
		
		System.out.println(answer[0] + " " + answer[1]);
		
	}

}
