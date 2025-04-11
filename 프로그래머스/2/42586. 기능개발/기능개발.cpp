#include <string>
#include <vector>
#include <iostream>
#include <cmath>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    
    // 1. 기능 완성까지 걸리는 일수
    vector<int> days;
    for (int i = 0; i < progresses.size(); i++) {
        days.push_back(ceil((double)(100 - progresses[i]) / speeds[i]));
    }
    
    // 2. 배포
    vector<int> answer;
    int tmp = days[0];
    int count = 1;
    for (int i = 1; i < days.size(); i++) {
        if (tmp >= days[i]) {
            count++;
        }
        else {
            answer.push_back(count);
            tmp = days[i];
            count = 1;
        }
    }
    answer.push_back(count);
    
    return answer;
}