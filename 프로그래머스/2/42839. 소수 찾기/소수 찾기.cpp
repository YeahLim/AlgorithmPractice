#include <string>
#include <vector>
#include <unordered_set>
using namespace std;

unordered_set<int> set;
string numbers;
int answer;

bool checkPrimary(int num) {
    
    if (num <= 1) {
        return false;
    }
    
    if (num == 2) {
        return true;
    }
    
    if (num % 2 == 0) {
        return false;
    }
    
    for (int i = 3; i * i <= num; i += 2) {
        if (num % i == 0) {
            return false;
        }
    }
    
    return true;
}

void searchNumbers(int length, int depth, string num, vector<bool> visited) {
    
    if (depth == length) {
        
        int number = stoi(num);
        if (set.count(number) == 0 && checkPrimary(number)) {
            set.insert(number);
            answer++;
        }
        return;
    }
    
    for (int i = 0; i < numbers.size(); i++) {
        if (visited[i]) {
            continue;
        }
        visited[i] = true;
        num += numbers[i];
        searchNumbers(length, depth + 1, num, visited);
        num.pop_back();
        visited[i] = false;
    }
}

int solution(string numbers) {
    
    ::numbers = numbers;
    
    for (int i = 1; i <= numbers.size(); i++) {
        searchNumbers(i, 0, "", vector<bool>(numbers.size(), false));
    }

    return answer;
}