package Graphs_DFS_BFS_UnionFind;

class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int row, int col) {
        // Word fully matched
        if (index == word.length()) {
            return true;
        }

        // Out of bounds or char mismatch
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Temporarily mark the cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore all 4 directions
        boolean found = dfs(board, word, index + 1, row + 1, col)
                || dfs(board, word, index + 1, row - 1, col)
                || dfs(board, word, index + 1, row, col + 1)
                || dfs(board, word, index + 1, row, col - 1);

        // Restore the cell
        board[row][col] = temp;

        return found;
    }
}
