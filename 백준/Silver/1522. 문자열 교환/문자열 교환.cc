#include<vector>
#include<iostream>
#include<algorithm>
using namespace std;

int main() {

    // 입력
    string str;
    cin >> str;

    // a의 개수 세기
    int a_count = 0;
    for (int i = 0; i < str.size(); i++) {
        if (str[i] == 'a') {
            a_count++;
        }
    }

    // 원형이므로 str 2개 붙이기
    str += str;

    // 초기화
    int b_count = 0;
    for (int i = 0; i < a_count; i++) {
       if (str[i] == 'b') {
            b_count++;
       }
    }

    // 슬라이딩 윈도우로 b의 최소 개수 찾기
    int answer = b_count;
    for (int i = a_count; i < str.size(); i++) {
       if (str[i-a_count] == 'b') {
            b_count--;  
       }
       if (str[i] == 'b') {
            b_count++;
       }    

       answer = min(answer, b_count);
    }


    // 출력
    cout << answer;
}