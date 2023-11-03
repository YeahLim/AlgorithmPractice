import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int G = Integer.parseInt(br.readLine());
    	int left = 1;
    	int right = 2;
    	int diff = 0;
    	StringBuilder answer = new StringBuilder();
    	
    	while (right * right - (right-1) * (right-1) <= G) {
		
    		
    		diff = right * right - left * left;
    		
    		if (diff < G) {
    			right++;
    		}
    		else if (diff > G) {
    			left++;
    		}
    		else {
    			answer.append(right);
    			answer.append("\n");
   				left++;
    			
    		}	
    	}
    	
    	if (answer.toString().equals("")) {
    		System.out.println(-1);
    		return;
    	}
    	
    	System.out.print(answer);
    	
    }
    
}