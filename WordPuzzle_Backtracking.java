class WordPuzzle_Backtracking {

    static int[] rowDir = {-1,-1,-1,0,0,1,1,1};
    static int[] colDir = {-1,0,1,-1,1,-1,0,1};

    static boolean dfs(char[][] grid, String word,
                       int row, int col, int index, boolean[][] visited) {

        if (index == word.length())
            return true;

        if (row < 0 || col < 0 ||
            row >= grid.length || col >= grid[0].length ||
            visited[row][col] ||
            grid[row][col] != word.charAt(index))
            return false;

        visited[row][col] = true;

        for (int i = 0; i < 8; i++) {
            if (dfs(grid, word,
                    row + rowDir[i],
                    col + colDir[i],
                    index + 1, visited))
                return true;
        }

        visited[row][col] = false; // Backtrack
        return false;
    }

    static boolean exist(char[][] grid, String word) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (dfs(grid, word, i, j, 0, visited))
                    return true;

        return false;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'C','A','T','S'},
            {'O','R','E','A'},
            {'D','E','A','M'},
            {'E','L','L','S'}
        };

        System.out.println(exist(grid, "DREAM"));
    }
}
