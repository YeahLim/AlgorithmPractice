import java.io.*;
import java.util.*;

public class Main {
	static int n, d, k, c;
	static int[] dish;
	static int[] selected;
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		
		/* 입력 및 변순 초기화 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 접시의 수
		d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		dish = new int[n];
		selected = new int[d+1];
		for(int i=0; i<n; i++) {
			dish[i] = Integer.parseInt(br.readLine());
		}
		
		selectSushi();
		
		/* 출력 */
		System.out.println(answer);
	}
	
	/* Sliding Window : 스시 선택해서 최대 가짓수 구하기  */
	private static void selectSushi() {
		int left = 0;
		int right = k;
		int count = 1; // 쿠폰 스시 포함
		
		// 쿠폰 사용
		selected[c] = 1;
		
		// 연속된 k개 스시 선택 - 초기 설정
		for(int i=left; i<right; i++) {
			if(selected[dish[i]] == 0) {
				count++;
			}
			selected[dish[i]] += 1;
		}

		// 연속된 k개 스시 선택 - 투포인터
		while(left < n) {
			selected[dish[left]] -= 1;
			
			if(selected[dish[left]] == 0) {	
				count--;
			}
			
			if(selected[dish[right]] == 0) {
				count++;
			}
			selected[dish[right]] += 1;
			
			left++;
			right++;
			if(right == n) {
				right = 0;
			}
			
			// 최대 종류 갱신
			if(answer < count) answer = count;
		
		}
	}

}