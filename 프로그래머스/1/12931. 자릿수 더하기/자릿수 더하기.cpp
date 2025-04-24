#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;

    while (n > 0) {
        answer += n % 10; // 끝자리 숫자 더하기
        n /= 10;          // 숫자 한 자리 줄이기
    }

    return answer;
}
