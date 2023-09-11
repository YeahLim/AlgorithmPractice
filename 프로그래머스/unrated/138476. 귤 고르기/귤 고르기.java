import java.io.*;
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int tang : tangerine) {
            map.put(tang, map.getOrDefault(tang, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, (a, b) -> b - a);
        for (int t : list) {
            System.out.println(t);
        }
    
        int count = 0;
        for (int t : list) {
            count++;
            k -= t;
            if (k <= 0) {
                break;
            }
        }
        
        return count;
    }
}