#include <iostream>
#include <unordered_map>
using namespace std;

int main() {

    // 입력
    int num, base;
    cin >> num >> base;

    // 10부터 알파벳 변환
    unordered_map<int, char> alphabets;
    for (int i = 10; i < 36; i++) {
        alphabets[i] = 65 + i - 10;
    }

    string tx_num = "";
    while (num >= 1) {
        
        int rest = num % base; // 나머지
        
        if (rest >= 10) {
            tx_num = alphabets[rest] + tx_num;
        }
        else {
            tx_num = to_string(rest) + tx_num;
        }

        num /= base; // 나누기
    }

    // 출력
    cout << tx_num;
}