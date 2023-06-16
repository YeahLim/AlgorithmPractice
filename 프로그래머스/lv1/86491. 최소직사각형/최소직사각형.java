import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int[] maxSize = new int[sizes.length];
        int[] minSize = new int[sizes.length];
        
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] >= sizes[i][1]) {
                maxSize[i] = sizes[i][0];
                minSize[i] = sizes[i][1];
            }
            else {
                maxSize[i] = sizes[i][1];
                minSize[i] = sizes[i][0];
            }
        }
        
        Arrays.sort(maxSize);
        Arrays.sort(minSize);
    
        return maxSize[sizes.length-1] * minSize[sizes.length-1];
    }
}