#include <string>
#include <vector>
#include <algorithm>
using namespace std;

// 5:41
vector<string> dictionary;
vector<char> alphabets = {'A', 'E', 'I', 'O' ,'U'};

void makeDictionary(string word) {
    
    if (word.size() == alphabets.size() + 1) {
        return;
    }
    
    dictionary.push_back(word);
    
    for (int i = 0; i < alphabets.size(); i++) {
        makeDictionary(word + alphabets[i]);
    }
}

int solution(string word) {
    
    // 중복순열로 모음사전 구하기
    makeDictionary("");
    
    // 몇번째에 속하는지 구하기
    int answer = 0;
    for (string& curr : dictionary) {
        answer++;
        if (curr == word) {
            break;
        }
    }
    
    return answer - 1;
}