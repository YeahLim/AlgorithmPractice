import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] options = new String[n];
		
		boolean[] key = new boolean[26];
		
		for (int i = 0; i < n; i++) {
			options[i] = br.readLine();
			boolean isOption = false;
			
			// 각 단어의 첫 글자 확인
			String[] words = options[i].toLowerCase().split(" ");
			int index = 0;
			for (String word : words) {
				if (!key[word.charAt(0) - 'a']) {
					key[word.charAt(0) - 'a'] = true;
					isOption = true;
					options[i] = options[i].substring(0, index) + "[" + options[i].charAt(index) + "]" + options[i].substring(index + 1);
				}
				
				index = index + word.length() + 1;
				
				if (isOption) {
					break;
				}
			}
			
			// 알파벳 차례로 글자 확인
			if (!isOption) {
				String word = options[i].toLowerCase();
				for (index = 0; index < word.length(); index++) {
					if (word.charAt(index) != ' ' && !key[word.charAt(index) - 'a']) {
						key[word.charAt(index) - 'a'] = true;
						isOption = true;
						options[i] = options[i].substring(0, index) + "[" + options[i].charAt(index) + "]" + options[i].substring(index + 1);
						break;
					}
				}
			}
		}
		
		for (String option : options) {
			System.out.println(option);
		}
		
	}

}
