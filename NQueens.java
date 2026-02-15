class NQueens {
    static int N = 4;
    static int[] board = new int[N];

    static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || 
               Math.abs(board[i] - col) == Math.abs(i - row))
                return false;
        }
        return true;
    }

    static void solve(int row) {
        if (row == N) {
            printBoard();
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row] = col;
                solve(row + 1);
            }
        }
    }

    static void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i] == j) System.out.print("Q ");
                else System.out.print(". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        solve(0);
    }
}
