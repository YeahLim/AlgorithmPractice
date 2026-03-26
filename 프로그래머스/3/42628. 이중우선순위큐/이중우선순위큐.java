import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        TreeMap<Integer, Integer> pq = new TreeMap<>();
        
        for (String operation : operations) {
            
            String cmd = operation.split(" ")[0];
            int num = Integer.parseInt(operation.split(" ")[1]);
            
            // 숫자 삽입
            if (cmd.equals("I")) {
                pq.put(num, pq.getOrDefault(num, 1));
            }
            // 큐가 비어있는 경우
            else if (pq.isEmpty()) {
                continue;
            }
            // 최대값 제거
            else if (num == 1) {
                int max = pq.lastKey();
                if (pq.get(max) == 1) {
                    pq.remove(max);   
                } else {
                    pq.put(max, pq.get(max) - 1);
                }
            } 
            // 최소값 제거
            else if (num == -1) {
                int min = pq.firstKey();
                if (pq.get(min) == 1) {
                    pq.remove(min);   
                } else {
                    pq.put(min, pq.get(min) - 1);
                }
            }
        }
        
        if (pq.isEmpty()) {
            return new int[] {0, 0};
        }
        
        return new int[] {pq.lastKey(), pq.firstKey()};
    }
}