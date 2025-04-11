#include <string>
#include <vector>
#include <cmath>
#include <queue>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    
    // 1. 기능 완성까지 걸리는 일수
    queue<int> days;
    for (int i = 0; i < progresses.size(); i++) {
        days.push(ceil((double)(100 - progresses[i]) / speeds[i]));
    }
    
    // 2. 배포
    vector<int> answer;
    int tmp = days.front();
    days.pop();
    int count = 1;
    while (!days.empty()) {
        if (days.front() <= tmp) {
            days.pop();
            count++;
        }
        else {
            answer.push_back(count);
            count = 1;
            tmp = days.front();
            days.pop();
        }
    }
    answer.push_back(count);
    
    
    return answer;
}