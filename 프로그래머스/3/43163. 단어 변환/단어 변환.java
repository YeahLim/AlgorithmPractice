import java.util.*;

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<Word> pq = new LinkedList<>();
        pq.add(new Word(begin, 0));
        boolean[] visited = new boolean[words.length];
        
        while(!pq.isEmpty()) {
            Word curr = pq.poll();
            
            if (curr.word.equals(target)) {
                answer = curr.count;
                break;
            }
            
            for (int i = 0; i < words.length; i++) {
                
                if (visited[i] || getDifferentWordNum(curr.word, words[i]) != 1) {
                    continue;
                } 
                
                visited[i] = true;
                pq.add(new Word(words[i], curr.count+1));
            }
        }
        
        return answer;
    }
    
    /* 다른 문자의 개수 반환 */
    private int getDifferentWordNum(String first, String second) {
        int count = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}

class Word {
    String word;
    int count;
    public Word(String word, int count) {
        this.word = word;
        this.count = count;
    }
}
