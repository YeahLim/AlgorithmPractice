#include<iostream>
using namespace std;


int main() {

    // 입력
    string str;
    string bomb;
    cin >> str >> bomb;

    // 문자열 순회하며 폭탄 문자열 제거
    string answer = "";
    for (int i = 0; i < str.size(); i++) {
        answer += str[i];
        
        // 폭탄보다 크기가 작은 경우 스킵
        if (answer.size() < bomb.size()) {
            continue;
        }

        // 폭탄 문자열인지 확인
        if (bomb == answer.substr(answer.size() - bomb.size())) {
            answer.erase(answer.size() - bomb.size());
        }
    }

    // 남은 글자 출력
    if (answer.empty()) {
        cout << "FRULA";            
    } else {
        cout << answer;
    }
    
    
}
