#include<iostream>
#include<unordered_map>
using namespace std;

int main() {
    
    // 입력
    int T;
    cin >> T;

    while (T-- > 0) {

        string str;
        int K;
        cin >> str >> K;

        // 변수 초기화
        unordered_map<char, int> count;
        for (int i = 0; i < str.size(); i++) {
            count[str[i]]++;  // char의 아스키코드 이용 (a:97, b:98 ...)
        }

        
        // K개의 정수가 포함된 길이 구하기
        int short_length = 10001, long_length = -1;
        for (int i = 0; i < str.size(); i++) {
            
            // K개보다 적은 경우
            if (count[str[i]] < K) {
                continue;
            }

            int curCount = 0;
            for (int j = i; j < str.size(); j++) {

                if (str[i] == str[j]) {
                    curCount++;
                }

                // 정확히 K개일때
                if (curCount == K) {
                    short_length = min(short_length, j - i + 1);
                    long_length = max(long_length, j - i + 1);
                    break;
                }
            }

        }


        // 출력
        if (short_length == 10001) {
            cout << "-1\n";
        }
        else {
            cout << short_length << " " << long_length << "\n";
        }
    }
}