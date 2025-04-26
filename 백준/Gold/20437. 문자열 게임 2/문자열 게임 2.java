import java.io.*;
import java.util.*;

// 10:50
class Main {
	
	static int num;
	static String str;
	static int min, max;
	
	public static void main(String[] args) throws Exception {
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		while(tc-- > 0) {
			str = br.readLine();
			num = Integer.parseInt(br.readLine());
			
			getStringLength();			
			
			/* 출력 */
			if (min == Integer.MAX_VALUE) {
				System.out.println(-1);
			}
			else {
				System.out.println(min + " " + max);
			}
		}
	}
	
	/* 가장 짧은/긴 문자열 길이 구하기 */
	private static void getStringLength() {
		int[] count = getAlphabetCount();
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		for (int i = 0; i < str.length(); i++) {

			// 현재 문자의 개수가 num보다 클 때
			if (count[str.charAt(i) - 'a'] >= num) {
				int curCount = 0; // 현재 문자의 개수
				for (int j = i; j < str.length(); j++) {
					
					// 첫번째 문자와 마지막 문자가 같을때
					if (str.charAt(i) == str.charAt(j)) {
						curCount++;
						
						if (curCount == num) {
							min = Math.min(min,  j - i + 1);
							max = Math.max(max,  j - i + 1);
							break;
						}
						
					}
				}
			}			
		}
		
	}

	private static int[] getAlphabetCount() {
		int[] count = new int[26];
		
		for (char s : str.toCharArray()) {
			count[s - 'a']++;
		}
		return count;
	}
}