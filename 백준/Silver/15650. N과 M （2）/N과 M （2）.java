import java.util.*;
import java.io.*;

class Main {
	
	static int n = 0, m = 0;
	
	public static void main(String[] args) throws IOException {
		
		// n, m 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" "); 
		n = Integer.parseInt(info[0]);
		m = Integer.parseInt(info[1]);
		backtracking(1, 0, new StringBuilder());
		
	}

	private static void backtracking(int index, int count, StringBuilder sb) {

		if (count == m) {
			System.out.println(sb.toString());
			return;
		}
		
		
		for (int i = index; i <= n; i++) {
			sb.append(i).append(" ");
			backtracking(i + 1, count + 1, sb);
//			sb.deleteCharAt(sb.length() - 1); 	
			sb.delete(sb.length() - 2, sb.length());
		}
	}
	
}