import java.util.*;

class Solution {
    
    int[] answer = new int[] {0, 0};
    
    public int[] solution(int[][] arr) {
        
        List<List<Integer>> array = new ArrayList<>();
        for (int[] ar : arr) {
            List<Integer> list = new ArrayList<>();
            for (int a : ar) {
                list.add(a);
            }
            array.add(list);
        }
        
        divide(array);
        
        return answer;
    }
    
    private void divide(List<List<Integer>> array) {
        
        // 모든 배열의 숫자가 같은 경우
        if (checkAllArray(array)) {
            answer[array.get(0).get(0)] += 1;
            return;
        }
        
        // 좌상
        List<List<Integer>> newArray = new ArrayList<>();
        for (int i = 0; i < array.size() / 2; i++) {
        	List<Integer> newArr = new ArrayList<>();
            for (int j = 0; j < array.get(i).size() / 2; j++) {
                newArr.add(array.get(i).get(j));
            }
            newArray.add(newArr);
        }
        divide(newArray);
        
        // 우상
        newArray = new ArrayList<>();
        for (int i = 0; i < array.size() / 2; i++) {
        	List<Integer> newArr = new ArrayList<>();
            for (int j = array.size() / 2; j < array.get(i).size(); j++) {
            	newArr.add(array.get(i).get(j));
            }
            newArray.add(newArr);
        }
        divide(newArray);
        
        // 좌하
        newArray = new ArrayList<>();
        for (int i = array.size() / 2; i < array.size(); i++) {
        	List<Integer> newArr = new ArrayList<>();
            for (int j = 0; j < array.get(i).size() / 2; j++) {
            	newArr.add(array.get(i).get(j)); 
            }
            newArray.add(newArr);
        }
        divide(newArray);
        
        // 우하
        newArray = new ArrayList<>();
        for (int i = array.size() / 2; i < array.size(); i++) {
        	List<Integer> newArr = new ArrayList<>();
            for (int j = array.size() / 2; j < array.get(i).size(); j++) {
            	newArr.add(array.get(i).get(j)); 
            }
            newArray.add(newArr);
        }
        divide(newArray);
    }
    
    private boolean checkAllArray(List<List<Integer>> array) {
        int firstNum = array.get(0).get(0);
        for (List<Integer> ar : array) {
            for (Integer a : ar) {
                if (firstNum != a) {
                    return false;
                }
            }
        }
        return true;
    }
}