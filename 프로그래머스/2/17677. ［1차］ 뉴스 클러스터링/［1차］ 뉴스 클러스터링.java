import java.util.*;

class Solution {
    public int solution(String str1, String str2) {       
        Map<String, Integer> map1 = getMap(str1);
        Map<String, Integer> map2 = getMap(str2);
        
        Map<String, Integer> intersection = new HashMap<>();
        Map<String, Integer> union = new HashMap<>();
        
        if (map1.isEmpty() && map2.isEmpty()) {
            return 65536;
        }
        
        // 합집합 구하기
        for (String word : map1.keySet()) {
            union.put(word, map1.get(word));
        }

        // 교집합 구하기
        for (String word : map2.keySet()) {
        	
            if (union.containsKey(word)) {
            	if (map1.get(word) < map2.get(word)) {
            		union.put(word, map2.get(word));
            		intersection.put(word, map1.get(word));
            	}
            	else {
            		intersection.put(word, map2.get(word));
            	}
            }
            else {
            	union.put(word, map2.get(word));
            }
            
        }
        
       if (union.isEmpty()) {
            return 65536;
        }
        
       int unionCount = 0;
       for (int count : union.values()) {
    	   unionCount += count;
       }
       
       int interCount = 0;
       for (int count : intersection.values()) {
    	   interCount += count;
       }
        
        return (int) ((double)interCount / unionCount * 65536);
    }
    
    private Map<String, Integer> getMap(String str) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < str.length() - 1; i++) {
            char first = Character.toLowerCase(str.charAt(i));
            char second = Character.toLowerCase(str.charAt(i+1));
            if (first < 97 || first > 122 || second < 97 || second > 122) {
                continue;
            } 
            String word = "" + first + second;
            map.put(word, map.getOrDefault(word, 0) + 1);
            
        }
        
        return map;
    }
}