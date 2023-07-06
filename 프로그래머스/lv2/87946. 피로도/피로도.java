class Solution {
     
    int[][] dungeons;
    boolean[] visited;
    int answer = 0;
    
    public int solution(int k, int[][] DUNGEONS) {
        
        for (int i = 0; i < DUNGEONS.length; i++) {
            dungeons = DUNGEONS.clone();
        }
        visited = new boolean[dungeons.length];
        searchDungeons(0, k, 0);
        
        return answer;
    }
    
    /* DFS : 몇 개 던전 갈 수 있는지 탐색 */
    private void searchDungeons(int depth, int fatigue, int count) {        
        // 모든 던전을 다 탐색했을 때
        if (depth == dungeons.length) {
            answer = answer < count ? count : answer;
            return;
        }
        
        // 모든 던전을 갈 수 있을 때
        if (answer == dungeons.length) {
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) { 
            if (visited[i]) continue;
            visited[i] = true;
            if (fatigue >= dungeons[i][0]) {         
                searchDungeons(depth + 1, fatigue - dungeons[i][1], count + 1);
            }
            else {
                searchDungeons(depth + 1, fatigue, count);
            }
            visited[i] = false;
        }
    }
}