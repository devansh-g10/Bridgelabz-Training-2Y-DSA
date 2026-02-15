class OptimizedNQueens {

    static int N = 8;
    static boolean[] columns = new boolean[N];
    static boolean[] diag1 = new boolean[2*N]; // row-col
    static boolean[] diag2 = new boolean[2*N]; // row+col
    static int[] board = new int[N];

    static boolean solve(int row) {
        if (row == N) {
            printBoard();
            return true; // stop after first solution
        }

        for (int col = 0; col < N; col++) {

            if (!columns[col] &&
                !diag1[row - col + N] &&
                !diag2[row + col]) {

                board[row] = col;
                columns[col] = true;
                diag1[row - col + N] = true;
                diag2[row + col] = true;

                if (solve(row + 1))
                    return true;

                // Backtrack
                columns[col] = false;
                diag1[row - col + N] = false;
                diag2[row + col] = false;
            }
        }
        return false;
    }

    static void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i] == j)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve(0);
    }
}
