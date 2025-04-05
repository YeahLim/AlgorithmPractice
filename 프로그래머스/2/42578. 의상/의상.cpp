#include <string>
#include <vector>
#include <unordered_map>
using namespace std;

int solution(vector<vector<string>> clothes) {
    
    unordered_map<string, int> map;
    for (auto cloth : clothes) {
        map[cloth[1]]++;
    }
    
    int answer = 1;
    
    for (const auto& pair : map) {
        answer *= (pair.second+1);
    }
    
    return answer - 1;
}