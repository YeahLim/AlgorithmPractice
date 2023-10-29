// 공약수와 서로소들의 곱

class Solution {
    public int solution(int[] arr) {
        
        if (arr.length == 1) {
            return arr[0];
        }
        
        int g = gcd(arr[0], arr[1]);
        int answer = arr[0] * arr[1] / g;
        
        for (int i = 2; i < arr.length; i++) {
            g = gcd(answer, arr[i]);
            answer = answer * arr[i] / g;
        }
        
        return answer;
    }
    
    private int gcd(int a, int b) {
        int r = a % b;
        if (r == 0) {
            return b;
        }
        return gcd(b, r);
    }
}