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
		
		if (convertTtoS(T, S, new HashSet<>())) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
		
	}

	private static boolean convertTtoS(String curr, String target, Set<String> set) {
		
		// 목표값과 같은 경우
		if (curr.equals(target)) {
			return true;
		}
		
		if (curr.length() == target.length()) {
			return false;
		}
		
		// 마지막이 A로 끝나는 경우 제거
		if (curr.charAt(curr.length() - 1) == 'A') {
			String next = curr.substring(0, curr.length() - 1);
			
			if (!set.contains(next)) {
				set.add(next);
				if (convertTtoS(next, target, set)) return true;
			}
		}
		
		// 첫번째가 B로 끝나는 경우, 뒤집고 마지막 제거
		if (curr.charAt(0) == 'B') {
			String next = new StringBuilder(curr).reverse().substring(0, curr.length() - 1);
			
			if (!set.contains(next)) {
				set.add(next);
				if (convertTtoS(next, target, set)) return true;
			}
		}
		
		return false;
	}

}
