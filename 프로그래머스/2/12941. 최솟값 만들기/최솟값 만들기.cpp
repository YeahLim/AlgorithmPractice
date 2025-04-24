#include<vector>
#include<algorithm>
using namespace std;

//8:12
int solution(vector<int> A, vector<int> B)
{
    
    // A는 올림차순, B는 내림차순인 경우
    sort(A.begin(), A.end());
    sort(B.begin(), B.end(), greater<>());
    int first_sum = 0;
    for (int i = 0; i < A.size(); i++) {
        first_sum += A[i] * B[i];
    }
    
    // A는 내림차순, B는 올림차순인 경우
    sort(A.begin(), A.end(), greater<>());
    sort(B.begin(), B.end());
    int second_sum = 0;
    for (int i = 0; i < A.size(); i++) {
        second_sum += A[i] * B[i];
    }
    
    return max(first_sum, second_sum);
}