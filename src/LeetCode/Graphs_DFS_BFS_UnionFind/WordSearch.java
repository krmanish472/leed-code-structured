package LeetCode.Graphs_DFS_BFS_UnionFind;

class WordSearch {
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int index, int row, int col) {
        // Word fully matched
        if (index == word.length()) {
            return true;
        }

        // Boundary check: if it's out of bounds or char not matching, return
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark the current cell as visited by changing to '#'
        char visited = board[row][col];
        board[row][col] = '#';

        // Visit all 4 neighboring cells (up, down, left, right)
        boolean found = dfs(board, word, index + 1, row - 1, col)
                || dfs(board, word, index + 1, row + 1, col)
                || dfs(board, word, index + 1, row, col - 1)
                || dfs(board, word, index + 1, row, col + 1);

        board[row][col] = visited;

        return found;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        if (exist(board, word)) {
            System.out.println("Exist");
        } else {
            System.out.println("Not exist");
        }
    }
}
