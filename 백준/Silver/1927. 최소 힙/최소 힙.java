import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		// N 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b); 
		
		while (N-- > 0) {
			int num = Integer.parseInt(br.readLine());
			
			if (num == 0) {
			
				if(pq.isEmpty()) {
					System.out.println(0);
				}
				
				else {
					System.out.println(pq.poll());
				}
			}
			
			else {
				pq.offer(num);
			}
		}
	}

}