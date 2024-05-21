import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static StringBuilder answer;
	
	public static void main(String[] args) throws IOException {
		
		// 변수 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String cmd;
		int N;
		String[] arr;
		
		while (T-- > 0) {
			
			cmd = br.readLine();
			N = Integer.parseInt(br.readLine());
            String input = br.readLine();
            if (N == 0) {
                arr = new String[0];
            } else {
                arr = input.substring(1, input.length() - 1).split(",");
            }
//            arr = br.readLine().substring(1, input.length() - 1).split(",");
           
            
			// 명령 실행
			answer = new StringBuilder();	
			executeCmd(cmd, arr);
			
			// 출력
			System.out.println(answer);
			
		}
	}

	private static void executeCmd(String cmd, String[] arr) {
		
		
		boolean dir = true; // true : 앞 / false : 뒤
		int start = 0, end = arr.length - 1;
		
		for (int i = 0; i < cmd.length(); i++) {
			char curr = cmd.charAt(i);
			
			// reverse
			if (curr == 'R') {
				dir = !dir;
			}
			
			// delete
			else {
                
                // error 발생
				if (start > end) {
					answer.append("error");
					return;	
				}
				
				if (dir) {
					start++;
				}
				else {
					end--;
				}
				

			}
		}
		
		answer.append("[");
		if (start <= end) {
			if (dir) {
				appendResult(arr, start, end);	
			}
			else {
				appendReversedResult(arr, end, start);
			}
		}
		answer.append("]");
		
	}

	private static void appendReversedResult(String[] arr, int end, int start) {
		for (int i = end; i >= start; i--) {
			if (i == start) {
				answer.append(arr[i]);
				return;
			}
			
			answer.append(arr[i]).append(",");
		}
		
	}

	private static void appendResult(String[] arr, int start, int end) {
		
		for (int i = start; i <= end; i++) {
			if (i == end) {
				answer.append(arr[i]);
				return;
			}
			
			answer.append(arr[i]).append(",");
		}
		
	}


}