#include<vector>
#include<algorithm>
using namespace std;

int solution(vector<int> A, vector<int> B)
{
    
    // A는 올림차순, B는 내림차순인 경우가 최소
    sort(A.begin(), A.end());
    sort(B.begin(), B.end(), greater<>());
    
    int answer = 0;
    for (int i = 0; i < A.size(); i++) {
        answer += A[i] * B[i];
    }
    
    return answer;
}