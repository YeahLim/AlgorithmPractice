#include <vector>
#include <unordered_set>
using namespace std;

int solution(vector<int> nums)
{   
    unordered_set<int> set; 
    
    for (auto num : nums) {
        set.insert(num);
        
        if (set.size() == nums.size() / 2) {
            break;
        }
    }
    
    return set.size();
}