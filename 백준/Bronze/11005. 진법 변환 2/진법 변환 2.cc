#include <iostream>
#include <unordered_map>
using namespace std;

int main() {

    // 입력
    int num, base;
    cin >> num >> base;

    string digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    string tx_num = "";
    while (num > 0) {    
        tx_num = digits[num % base] + tx_num;
        num /= base; // 나누기
    }

    // 출력
    cout << tx_num;
}