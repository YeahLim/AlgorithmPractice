#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> sizes) {
     
    int max_row = 0;
    int max_col = 0;
    
    for (vector<int>& size : sizes) {
        
        max_row = max(max_row, max(size[0], size[1]));
        max_col = max(max_col, min(size[0], size[1]));
    }
    
    return max_row * max_col;
}