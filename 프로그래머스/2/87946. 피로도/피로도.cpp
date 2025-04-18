#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(int k, vector<vector<int>> dungeons) { 
    
    int answer = 0;
    do {
        
        int curr = k; // 현재 피로도
        int count = 0; // 탐험한 던전 개수
        for (auto& dungeon : dungeons) {
            
            // 던전에 탐험이 가능한 경우
            if (curr >= dungeon[0]) {
                count++;
                curr -= dungeon[1];
            }
        }
        
        answer = max(answer, count);
        
    } while (next_permutation(dungeons.begin(), dungeons.end()));
    
    return answer;
}