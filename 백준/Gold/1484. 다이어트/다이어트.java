import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int G = Integer.parseInt(br.readLine());
    	int left = 1;
    	int right = 2;
    	int diff = 0;
    	List<Integer> answer = new ArrayList<>();
//    	System.out.println((right * right - left * left) % 1);
    	
    	while (right * right - (right-1) * (right-1) <= G) {
    		
//    		
    		
    		diff = right * right - left * left;
    		
    		if (diff < G) {
    			right++;
    		}
    		else if (diff > G) {
    			left++;
    		}
    		else {
    			answer.add(right);
    			
    			if (left + 1 == right) {
    				right++;
    			}
    			else {
    				left++;
    			}
    		}	
    	}
    	
    	if (answer.isEmpty()) {
    		System.out.println(-1);
    		return;
    	}
    	
    	Collections.sort(answer);
    	for (int a : answer) {
    		System.out.println(a);
    	}
    	
    }
    
}