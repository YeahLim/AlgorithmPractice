#include <string>
#include <vector>
#include <set>

using namespace std;

int answer = 0;
int n;
vector<vector<int>> q;
vector<int> ans;

bool checkPassword(vector<int> number) {
    
    set<int> numSet;
    for (int num : number) {
        numSet.insert(num);
    }
    
    for (int i = 0; i < q.size(); i++) {
        int count = 0;
        for (int num : q[i]) {
            if (numSet.count(num) > 0) {
                count++;
            }
        }
        
        if (count != ans[i]) {
            return false;
        }
    }
    return true;
}

void combinateAll(int index, int curr, vector<int> number) {
    
    if (index == 5) {
        if (checkPassword(number)) {
            answer++;
        }
        return;
    }
    
    for (int i = curr; i <= n; i++) {
        number[index] = i;
        combinateAll(index + 1, i + 1, number);
    }
}

int solution(int n, vector<vector<int>> q, vector<int> ans) {
    ::n = n;
    ::q = q;
    ::ans = ans;
    
    combinateAll(0, 1, vector<int>(5));
    
    return answer;
}