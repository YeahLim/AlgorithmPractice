class Solution {
    public int solution(int[] a) {
        int answer = a.length;
        
        int leftMin = a[0];
        int[] rightMin = new int[a.length];
        rightMin[a.length - 1] = a[a.length - 1];
        
        for (int i = a.length - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i+1], a[i]);
        }
        
        for (int i = 0; i < a.length; i++) {
            if (a[i] > leftMin && a[i] > rightMin[i]) {
                answer--;
            }
            // System.out.println("leftMin : " + leftMin + " a[i] : " + a[i] + " rightMin : " + rightMin[i]);
            leftMin = Math.min(leftMin, a[i]);
        }
        
        return answer;
    }
}