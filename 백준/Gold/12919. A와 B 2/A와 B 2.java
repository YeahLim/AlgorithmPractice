import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		
		int answer = 0;
		
		Queue<String> q = new LinkedList<>();
		q.add(T);
		
		Set<String> set = new HashSet<>();
		
		while (!q.isEmpty()) {
			String curr = q.poll();
			
			// 처음값과 같은 경우
			if (curr.equals(S)) {
				answer = 1;
				break;
			}
			
			if (curr.length() == S.length()) {
				continue;
			}

			String newCurr;
			
			// 문자열의 마지막이 A인 경우 제거
			if (curr.charAt(curr.length() - 1) == 'A') {
				newCurr = curr.substring(0, curr.length() - 1); 
				
				if (!set.contains(newCurr)) {
					q.add(newCurr);
					set.add(newCurr);
				}
			}
			
			// 문자열의 첫번째가 B인 경우 뒤집고 마지막 B 제거
			if (curr.charAt(0) == 'B') {
				newCurr = new StringBuilder(curr).reverse().substring(0, curr.length() - 1).toString(); 
				
				if (!set.contains(newCurr)) {
					q.add(newCurr);
					set.add(newCurr);
				}
			} 
			
//			System.out.println(curr);
			
		}
		
		System.out.println(answer);
	}

}
