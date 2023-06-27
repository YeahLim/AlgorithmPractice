import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> que = new ArrayDeque<>();
        
        for (int i = 0; i < priorities.length; i++) {
            que.add(new int[] {i, priorities[i]});
        }
        
        Integer[] sortedP = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedP, Comparator.reverseOrder());
        
        int count = 1;
        for (int i = 0; i < sortedP.length; i++) {
            System.out.println(priorities[i]+":  " + que.peek()[0] + ", " + que.peek()[1]);
            while (sortedP[i] != que.peek()[1]) {
                que.add(que.poll());
            }
            if (que.poll()[0] == location) {
                break;   
            }
            count++;
        }
        
        return count;
    }
}