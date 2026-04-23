#include <string>
#include <vector>

using namespace std;

int answer = 0;

void combination(vector<int> number, int index, int curr, int total) {
    if (index == 3) {
        if (total == 0) {
            answer++;
        }
        return;
    }
    
    for (int i = curr; i < number.size(); i++) {
        total += number[i];
        combination(number, index + 1, i + 1, total);
        total -= number[i];
    }
}

int solution(vector<int> number) {
    
    combination(number, 0, 0, 0);
    
    return answer;
}