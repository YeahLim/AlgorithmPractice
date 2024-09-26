import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		
		
		System.out.println(transformToS(new StringBuilder(T), S));
	}

	private static int transformToS(StringBuilder start, String target) {
		
		while (start.length() > target.length()) {
			
			int lastIndex = start.length() - 1;
			
			// 마지막 글자가 B인 경우
			if (start.charAt(lastIndex) == 'B') {
				start.deleteCharAt(lastIndex);
				start.reverse();
			}
			
			// 마지막 글자가 A인 경우
			else {
				start.deleteCharAt(lastIndex);
			}
			
			// target으로 변환한 경우
			if (start.toString().equals(target)) {
				return 1;
			}

		}
		
		// target으로 변환 못한 경우
		return 0;
	}

}
