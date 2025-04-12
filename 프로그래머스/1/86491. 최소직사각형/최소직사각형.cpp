#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> sizes) {
     
    int max_row = 0;
    int max_col = 0;
    
    for (vector<int>& size : sizes) {
        if (size[0] > size[1] ) {
            if (max_row < size[0]) {
                max_row = size[0];
            }
            if (max_col < size[1]) {
                max_col = size[1];
            }
        }
        else {
            if (max_row < size[1]) {
                max_row = size[1];
            }
            if (max_col < size[0]) {
                max_col = size[0];
            }
        }
    }
    
    return max_row * max_col;
}