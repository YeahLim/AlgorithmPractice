import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		// M 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		Set<Integer> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int num = 0;
			
			
			
			if (cmd.equals("add")) {
				num = Integer.parseInt(st.nextToken());
				set.add(num);
			}
			
			else if (cmd.equals("remove")) {
				num = Integer.parseInt(st.nextToken());
				set.remove(num);
			}
			
			else if (cmd.equals("check")) {
				num = Integer.parseInt(st.nextToken());
				
				if (set.contains(num)) {
					sb.append(1);
				}
				else {
					sb.append(0);
				}
				
				sb.append("\n");
			}
			
			else if (cmd.equals("toggle")) {
				num = Integer.parseInt(st.nextToken());
				
				if (set.contains(num)) {
					set.remove(num);
				}
				else {
					set.add(num);
				}
			}

			else if (cmd.equals("all")) {
				for (int i = 1; i <= 20; i++) {
					set.add(i);
				}
			}
			
			else if (cmd.equals("empty")) {
				set.clear();
			}
		}
		
		System.out.println(sb);
		
	}

}