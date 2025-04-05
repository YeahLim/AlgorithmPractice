#include <vector>
#include <unordered_map>
using namespace std;

int solution(vector<int> nums)
{   
    unordered_map<int, int> map; 
    
    for (auto num : nums) {
        if (map.find(num) == map.end()) {
            map.insert(make_pair(num, 1));
        }
        else {
            map[num]++;
        }
    }
    
    int answer = 0;
    for (int i = 1; i <= 200000 && nums.size()/2 > answer; i++) {
        if (map.find(i) == map.end()) {
            continue;
        }
        map[i]--;
        answer++;
    }
    
    return answer;
}