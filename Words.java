import java.util.*;

public class Words {
    private static int[][] searchIndices = {{1,1}, {1,0}, {1,-1}, {-1,1}, {-1,0}, {-1,-1}, {0,1}, {0,-1}};
    //searches a grid horizontally, vertically, and diagonally for words in the input set
    public static Set <String> wordSearch(char[][] grid, Set<String> dict) {
        Set <String> ans = new HashSet<>();
        if (grid == null || dict == null || dict.size() == 0) {
            return ans;
        }

        Trie trie = new Trie();
        int numRow = grid[0].length;
        int numCol = grid.length;
        boolean[][] visited = new boolean[numRow][numCol];

        for (String word : dict) {
            trie.insert(word);
        }

        for (int row = 0; row < numRow; row++) {
            for (int col = 0; col < numCol; col++) {
                helperDFS(ans, new StringBuilder(), grid, visited, row, col, trie);
            }
        }
        return ans;
    }

    //helper method used by wordSearch(char[][], Set<string>) to search the grid recursively using DFS
    public static void helperDFS(Set<String> ans, StringBuilder current, char[][] grid, boolean[][] visited, int row, int col, Trie trie) {
        if (row < 0 || col < 0 || row >= grid[0].length || col >= grid.length) {
            return;
        }
        if (visited[row][col]) {
            return;
        }

        current.append(grid[row][col]);
        String word = current.toString();
        int currentLength = word.length();

        if (trie.find(word)) {
            ans.add(word);
        }

        if (trie.isPrefix(word)) {
            visited[row][col] = true;

            for(int i = 0; i < searchIndices.length; i++){
                helperDFS(ans, current, grid, visited, row + searchIndices[i][0], col + searchIndices[i][1], trie);
                current.setLength(currentLength);
            }
            visited[row][col] = false;
        }
    }
}
