#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    
    for (auto &cmd : commands) {
        vector<int> sub_array(array.begin() + cmd[0] - 1, array.begin() + cmd[1]);
        sort(sub_array.begin(), sub_array.end());
        answer.push_back(sub_array[cmd[2] - 1]);
    }
    
    return answer;
}