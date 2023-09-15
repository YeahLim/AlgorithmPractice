import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        Queue<String> cache = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int answer = 0;
        for (String city : cities) {
            city = city.toLowerCase();
            // 캐시에 존재할때
            if (cache.remove(city)) {
                answer += 1;
            }
            // 캐시에 존재하지 않을때
            else {
                if (set.size() == cacheSize) {
                    set.remove(cache.poll());
                }
                set.add(city);
                answer += 5;
            }
            cache.add(city);
        }
        return answer;
    }
}