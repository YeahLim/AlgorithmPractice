#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(vector<int> answers) {
    
    vector<int> first = {1,2,3,4,5};
    vector<int> second = {2,1,2,3,2,4,2,5};
    vector<int> third = {3,3,1,1,2,2,4,4,5,5};
    
    int firstIndex = 0;
    int secondIndex = 0;
    int thirdIndex = 0;
    
    vector<int> score(3,0);
    
    for (int i = 0; i < answers.size(); i++) {
        
        if (answers[i] == first[firstIndex]) {
            score[0] += 1;
        }
        firstIndex = (firstIndex + 1) % first.size();
        
        if (answers[i] == second[secondIndex]) {
            score[1] += 1;
        }
        secondIndex = (secondIndex + 1) % second.size();
        
        if (answers[i] == third[thirdIndex]) {
            score[2] += 1;
        }
        thirdIndex = (thirdIndex + 1) % third.size();
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