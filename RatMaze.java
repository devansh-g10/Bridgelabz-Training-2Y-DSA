class RatMaze {
    static int N = 4;

    static boolean solveMaze(int[][] maze, int x, int y) {
        if (x == N-1 && y == N-1)
            return true;

        if (x >= 0 && y >= 0 && x < N && y < N && maze[x][y] == 1) {
            maze[x][y] = 2;

            if (solveMaze(maze, x+1, y) ||
                solveMaze(maze, x, y+1))
                return true;

            maze[x][y] = 1; // Backtrack
        }
        return false;
    }
}
