#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(vector<int> answers) {
    
    vector<int> first = {1,2,3,4,5};
    vector<int> second = {2,1,2,3,2,4,2,5};
    vector<int> third = {3,3,1,1,2,2,4,4,5,5};
    
    vector<int> score(3,0);
    
    for (int i = 0; i < answers.size(); i++) {
        
        if (answers[i] == first[i % first.size()]) {
            score[0] += 1;
        }
        
        if (answers[i] == second[i % second.size()]) {
            score[1] += 1;
        }
        
        if (answers[i] == third[i % third.size()]) {
            score[2] += 1;
        }
    }
    
    int maxScore = *max_element(score.begin(), score.end());
    vector<int> answer;
    for (int i = 0; i < 3; i++) {
        if (maxScore == score[i]) {
            answer.push_back(i+1);
        }
    }
    
    return answer;
}