class Solution {
    int answer = 0;
    int N;

    public int solution(int n) {
        N = n;
        moveQueen(0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);

        return answer;
    }

    private void moveQueen(int row, boolean[] column, boolean[] leftDiagonal, boolean[] rightDiagonal) {
        if (row == N) {
            answer++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (!column[col] && !leftDiagonal[row + col] && !rightDiagonal[N - 1 + row - col]) {
                column[col] = true;
                leftDiagonal[row + col] = true;
                rightDiagonal[N - 1 + row - col] = true;
                moveQueen(row + 1, column, leftDiagonal, rightDiagonal);
                column[col] = false;
                leftDiagonal[row + col] = false;
                rightDiagonal[N - 1 + row - col] = false;
            }
        }
    }
}
