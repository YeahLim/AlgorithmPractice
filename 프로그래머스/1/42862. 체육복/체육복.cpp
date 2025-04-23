#include <string>
#include <vector>
#include <algorithm>
#include <unordered_set>
using namespace std;

// 10:35
int solution(int n, vector<int> lost, vector<int> reserve) {
    
    int answer = n - lost.size();
    
    // 체육 복 없는 사람 체크하기
    vector<bool> hasNotClothes(n+1);
    for (int& lst : lost) {
        hasNotClothes[lst] = true;
    }
    
    // 여분의 체육복이 있는 사람 중에 체육복기 없는 경우 제외
    unordered_set<int> used;
    for (int& rsv : reserve) {

        if (hasNotClothes[rsv]) {
            hasNotClothes[rsv] = false;
            used.insert(rsv);
            answer++;
        }
    }
    
    sort(reserve.begin(), reserve.end());
    for (int& rsv : reserve) {
        
        if (used.find(rsv) != used.end()) {
            continue;
        }
        
        // 앞번호 학생이 없는 경우
        if (hasNotClothes[rsv - 1]) {
            hasNotClothes[rsv - 1] = false;
            answer++;
        } 
        // 뒷번호 학생이 없는 경우
        else if (hasNotClothes[rsv + 1]) {
            hasNotClothes[rsv + 1] = false;
            answer++;
        }
    }
    
    return answer;
}