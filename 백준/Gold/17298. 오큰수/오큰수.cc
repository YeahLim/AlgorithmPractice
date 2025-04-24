#include <iostream>
#include <vector>
#include <stack>
using namespace std;

struct Number {
    int num;
    int idx;

    Number (int num, int idx) {
        this->num = num;
        this->idx = idx;
    }
};

int main() {

    // 입력
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<int> array(n);
    for (int i = 0; i < n; i++) {
        cin >> array[i];
    }


    // 스택으로 오큰수 구하기
    stack<Number> stack;
    stack.push(Number(array[0], 0));
    vector<int> answer(n, -1);

    for (int i = 1; i < array.size(); i++) {
        
        while (!stack.empty() && stack.top().num < array[i]) {
            answer[stack.top().idx] = array[i];
            stack.pop();
        }

        stack.push(Number(array[i], i));
    }


    // 출력
    for (int& ans : answer) {
        cout << ans << " ";
    }
    cout << endl;
}