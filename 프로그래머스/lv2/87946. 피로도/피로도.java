class Solution {
     
    int[][] dungeons;
    boolean[] visited;
    int answer = 0;
    
    public int solution(int k, int[][] DUNGEONS) {
        
        for (int i = 0; i < DUNGEONS.length; i++) {
            dungeons = DUNGEONS.clone();
        }
        visited = new boolean[dungeons.length];
        searchDungeons(k, 0);
        
        return answer;
    }
    
    /* DFS : 몇 개 던전 갈 수 있는지 탐색 */
    private void searchDungeons(int fatigue, int count) {        
        // 모든 던전을 다 탐색했을 때

        answer = Math.max(answer, count);

        for (int i = 0; i < dungeons.length; i++) { 
            if (visited[i]) continue;
            if (fatigue < dungeons[i][0]) continue;
            visited[i] = true;       
            searchDungeons(fatigue - dungeons[i][1], count + 1);
            visited[i] = false;
        }
    }
}