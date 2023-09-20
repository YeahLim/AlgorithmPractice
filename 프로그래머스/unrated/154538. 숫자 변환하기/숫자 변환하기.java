import java.io.*;
import java.util.*;

/**
*   PriorityQueue<int[]> : 0번째는 현재 숫자, 1번째는 count
*/

class Solution {
    int x;
    int y;
    int n;
    
    public int solution(int x, int y, int n) {
        this.x = x;
        this.y = y;
        this.n = n;
        
        return convertNumber();
    }
    
    private int convertNumber() {   
        
        int answer = -1;        
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {y, 0});

        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            
            // System.out.println(curr[0] + " "+curr[1]);
            
            if (curr[0] == x) {
                answer = curr[1];    
                break;
            }
            
            if (curr[0] < x) {
                continue;
            }
            
            if (curr[0] % 3 == 0) {
                // System.out.println("나누기 3");
                pq.offer(new int[] {curr[0]/3, curr[1]+1});
            }
            if (curr[0] % 2 == 0) {
                // System.out.println("나누기 2");
                pq.offer(new int[] {curr[0]/2, curr[1]+1});   
            }
            // System.out.println("빼기 n");
            pq.offer(new int[] {curr[0]-n, curr[1]+1});
        }
        
        return answer;
    }
}