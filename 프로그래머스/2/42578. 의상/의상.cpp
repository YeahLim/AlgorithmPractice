#include <string>
#include <vector>
#include <unordered_map>
#include <iostream>
using namespace std;

int solution(vector<vector<string>> clothes) {
    
    unordered_map<string, int> map;
    for (auto cloth : clothes) {
        if (map.find(cloth[1]) == map.end()) {
            map.insert(make_pair(cloth[1], 1));
        }
        else {
            map[cloth[1]]++;
        }
    }
    
    int answer = 1;
    
    for (const auto& pair : map) {
        answer *= (pair.second+1);
        cout << pair.second << endl;
    }
    
    return answer - 1;
}