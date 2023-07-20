import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        
        for (int top : topping) {
            map.put(top, map.getOrDefault(top, 0) + 1);
        }
        
        int answer = 0;
        for (int top : topping) {
            map.put(top, map.get(top) - 1);
            set.add(top);
            if (map.get(top) == 0) {
                map.remove(top);
            }
            if (map.size() == set.size()) {
                answer++;
            }
        }
        return answer;
    }
}