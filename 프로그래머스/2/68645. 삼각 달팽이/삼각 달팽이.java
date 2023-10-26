// 0 ~ n-1 행의 0번째 열 채우기
// n-1 행의 모든 열 채우기
// n-2 ~ 2 행의 현재 행 길이의 -1 열 채우기

// 1 ~ n-2 행의 1번째 열 채우기
// n-2 행의 모든 열 채우기
// n-3 ~ 3 행의 현재 행 길이의 -2 채우기

class Solution {
 
 int[][] snail;
 int num = 0;
 int max = 0;
 
 public int[] solution(int n) {
     snail = new int[n][];
     for (int i = 0; i < n; i++) {
         max += i+1;
         snail[i] = new int[i+1];
     }
     
     for (int i = 0; num < max; i++) {

         // 상 -> 하
         topDown(i, n-i, i);
         
         // 좌 -> 우
         leftToRight(n-i-1);
            
         // 하 -> 상 
         bottomUp(n-i-2, i+1, i);
         
//         printSnail();  
     }
     
     int[] answer = new int[max];
     int index = 0;
      for (int[] sn : snail) {
          for (int s : sn) {
              answer[index++] = s;
          }
      }
     return answer;
 }
 
 private void printSnail() {
     for (int[] sn : snail) {
         for (int s : sn) {
             System.out.print(s + " ");
         }
         System.out.println();
     }
 }
 
 private void topDown(int start, int end, int col) {
     for (int i = start; i < end && num < max; i++) {
     	if (snail[i][col] != 0) {
     		continue;
     	}
         snail[i][col] = ++num;
//         System.out.println("1 : " +num);
     }
 }
 
 private void leftToRight(int row) {
     for (int i = 0; i <= row && num < max; i++) {
         if (snail[row][i] != 0) {
             continue;
         }
         snail[row][i] = ++num;
//         System.out.println("2 : " +num);
     }
 }
 
 private void bottomUp(int start, int end, int col) {
 	for (int i = start; i > end && num < max; i--) {
 		if (snail[i][i-col] != 0) {
 			return;
		}
 		snail[i][i - col] = ++num;
//         System.out.println("3 : "+ num);
     }
 }
}
