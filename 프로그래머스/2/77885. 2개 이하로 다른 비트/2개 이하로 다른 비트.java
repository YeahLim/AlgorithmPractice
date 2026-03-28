class Solution {
    
    public long[] solution(long[] numbers) {
        
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            
            // 짝수인 경우
            if (numbers[i] % 2 == 0) {
                // answer[i] = numbers[i] | 1;
                answer[i] = numbers[i] + 1;
            }
            
            // 홀수인 경우
            else {
                String number = Long.toBinaryString(numbers[i]);
                int index = number.lastIndexOf("0");    
                
                // 모든 바이너리 숫자가 1로 구성된 경우
                if (index == -1) {
                    number = "10" + number.substring(1);
                }
                // 바이너리 숫자 중 0이 존재하는 경우
                else {
                    number = number.substring(0, index) + "10" + number.substring(index+2);
                }
                
                answer[i] = Long.parseLong(number, 2);        
            }
        }
        
        return answer;
    }
}