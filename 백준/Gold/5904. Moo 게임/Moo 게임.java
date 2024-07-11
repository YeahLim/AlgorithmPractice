import java.io.IOException;
import java.util.Scanner;

public class Main {

	static char letter;
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int count = 0;
		int length = 3;
		while (N > length) {
			count++;
			length = length*2 + count + 3;
		}
		
		letter = searchLetter(N, count, length);
				
		
		
		System.out.println(letter);
	}

	private static char searchLetter(int N, int count, int length) {
		
		if (count == 0) {
            return "moo".charAt(N - 1);
        }
		
		int prevLength = (length - (count + 3)) / 2;
		
		// 앞부분
		if (N <= prevLength) {
            return searchLetter(N, count - 1, prevLength);
        } 
		
		// 중앙부분
		else if (N == prevLength + 1) {
			return 'm';
		}
		else if (N <= prevLength + count + 3) {
			return 'o';
		}
		
		// 뒷부분
		else {
			return searchLetter(N - (count + 3) - prevLength, count - 1, prevLength);
		}
	}

	

}